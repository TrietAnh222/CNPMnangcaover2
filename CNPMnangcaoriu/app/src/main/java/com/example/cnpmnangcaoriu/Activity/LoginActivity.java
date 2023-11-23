package com.example.cnpmnangcaoriu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cnpmnangcaoriu.APIservices;
import com.example.cnpmnangcaoriu.Models.LogInResponse;
import com.example.cnpmnangcaoriu.Models.LoginRequest;
import com.example.cnpmnangcaoriu.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class
LoginActivity extends AppCompatActivity {
    private EditText edtLoginEmail, edtLoginPasword;
    private TextView edtTaotaikhoan;
    private Button btnLogin;
    private LinearLayout layoutRegister;
    public static String id;
     TextView btnbacktrangchu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUi();
        initListener();
    }
    private void initUi() {
        edtLoginEmail = findViewById(R.id.edtLoginEmail);
        edtLoginPasword = findViewById(R.id.edtLoginPasword);
        btnLogin = findViewById(R.id.btnLogin);
        layoutRegister = findViewById(R.id.layout_sign_up);
        edtTaotaikhoan = findViewById(R.id.edtTaotaikhoan);
        btnbacktrangchu = findViewById(R.id.buttonBacktangchu);
    }
    private void initListener() {
        layoutRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
         btnbacktrangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginRequest loginRequest = new LoginRequest(edtLoginEmail.getText().toString(),edtLoginPasword.getText().toString());
                Call<LogInResponse> logincall = APIservices.myapi.login(loginRequest);
                logincall.enqueue(new Callback<LogInResponse>() {
                    @Override
                    public void onResponse(Call<LogInResponse> call, Response<LogInResponse> response) {
                        LogInResponse logInResponse = response.body();
                        if(response.isSuccessful()&& "OK".equals(logInResponse.getStatus()))
                        {
                            id = logInResponse.getId();
                            Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(LoginActivity.this, logInResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<LogInResponse> call, Throwable t) {
                    }
                });
            }
        });
    }
    private void xulydangnhap(){

    }
}
