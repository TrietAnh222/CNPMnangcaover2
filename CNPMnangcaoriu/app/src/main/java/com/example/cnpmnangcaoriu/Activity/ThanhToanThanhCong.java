package com.example.cnpmnangcaoriu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cnpmnangcaoriu.R;

public class ThanhToanThanhCong extends AppCompatActivity {
    Button quaylai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan_thanh_cong);
        quaylai = findViewById(R.id.btnBackToHome);
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThanhToanThanhCong.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}