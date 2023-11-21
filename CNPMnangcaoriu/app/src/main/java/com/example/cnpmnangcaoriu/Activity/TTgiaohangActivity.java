package com.example.cnpmnangcaoriu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.cnpmnangcaoriu.APIservices;
import com.example.cnpmnangcaoriu.Models.UserModel;
import com.example.cnpmnangcaoriu.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TTgiaohangActivity extends AppCompatActivity {
    EditText editname,editcity,editphone,editaddress;
    Button btncancel,btnok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttgiaohang);
        Call<UserModel> call = APIservices.myapi.getDetailsUser(LoginActivity.id);
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(response.isSuccessful()){
                    UserModel userModel = response.body();
                    if(userModel.getUser().getName()!=null)
                        editname.setText(userModel.getUser().getName());
                    if(userModel.getUser().getPhone()!=null)
                        editphone.setText(String.valueOf(userModel.getUser().getPhone()));
                    if(userModel.getUser().getCity()!=null)
                        editcity.setText(userModel.getUser().getCity());
                    if(userModel.getUser().getAddress()!=null)
                        editaddress.setText(userModel.getUser().getAddress());
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });
        initui();
    }

    private void initui(){
        editname=findViewById(R.id.editName);
        editcity = findViewById(R.id.editCity);
        editaddress= findViewById(R.id.editAdress);
        editphone = findViewById(R.id.editPhone);
        btncancel = findViewById(R.id.btncancel);
        btnok = findViewById(R.id.BTNok);
    }
}