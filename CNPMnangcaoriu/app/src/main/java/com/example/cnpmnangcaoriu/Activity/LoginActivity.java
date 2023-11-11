package com.example.cnpmnangcaoriu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cnpmnangcaoriu.R;

public class LoginActivity extends AppCompatActivity {
    private EditText edtLoginEmail, edtLoginPasword;
    private TextView edtTaotaikhoan;
    private Button btnLogin;
    private LinearLayout layoutRegister;

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
    }
    private void initListener() {
        layoutRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneValue = edtLoginEmail.getText().toString().trim();
                String password = edtLoginPasword.getText().toString().trim();

                if (TextUtils.isEmpty(phoneValue) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(),"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}