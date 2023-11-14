package com.example.cnpmnangcaoriu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cnpmnangcaoriu.APIservices;
import com.example.cnpmnangcaoriu.Models.RegisterRequest;
import com.example.cnpmnangcaoriu.Models.ResigterResponse;
import com.example.cnpmnangcaoriu.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private ImageView imgRegister;
    private EditText edtEmail, edtPassword, edtRepassword;
    private TextView dangNhap;
    private Button btnRegister;

    private LinearLayout layoutLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initUi();
        initListener();
    }

    private void initUi() {
        imgRegister = findViewById(R.id.img_register);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtRepassword = findViewById(R.id.edtRepassword);
        btnRegister = findViewById(R.id.btnRegister);
        dangNhap = findViewById(R.id.dangNhap);
        layoutLogin = findViewById(R.id.layoutDangNhap);
    }
    private void initListener() {
        layoutLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailValue = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                String repasswordValue = edtRepassword.getText().toString().trim();

                if (TextUtils.isEmpty(emailValue) || TextUtils.isEmpty(password) ||  TextUtils.isEmpty(repasswordValue)) {
                    Toast.makeText(getApplicationContext(),"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                } else {
                    RegisterRequest registerRequest = new RegisterRequest(emailValue,password,repasswordValue);
                    Call<ResigterResponse> responseCall = APIservices.myapi.register(registerRequest);
                    responseCall.enqueue(new Callback<ResigterResponse>() {
                        @Override
                        public void onResponse(Call<ResigterResponse> call, Response<ResigterResponse> response) {
                            ResigterResponse resigterResponse = response.body();
                            if (response.isSuccessful()&& "OK".equals(resigterResponse.getStatus())){
                                Toast.makeText(RegisterActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(RegisterActivity.this, resigterResponse.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResigterResponse> call, Throwable t) {

                        }
                    });
                    /*Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);*/
                }
            }
        });

    }
}