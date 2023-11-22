package com.example.cnpmnangcaoriu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cnpmnangcaoriu.APIservices;
import com.example.cnpmnangcaoriu.Models.UpdateuserRequest;
import com.example.cnpmnangcaoriu.Models.UpdateuserResponse;
import com.example.cnpmnangcaoriu.Models.UserModel;
import com.example.cnpmnangcaoriu.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TTnguoidungActivity extends AppCompatActivity {
    EditText edtname,edtemail,edtphone,edtdiachi;
    Button btncapnhat;
    UpdateuserRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttnguoidung);
        Call<UserModel> call = APIservices.myapi.getDetailsUser(LoginActivity.id);
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                UserModel userModel = response.body();
                edtname.setText(userModel.getUser().getName());
                edtemail.setText(userModel.getUser().getEmail());
                edtphone.setText(String.valueOf(userModel.getUser().getPhone()));
                edtdiachi.setText(userModel.getUser().getAddress());
            }
            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });
        initUI();
        btncapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                request = xulyuser();
                Call<UpdateuserResponse> callupdate = APIservices.myapi.updateuser(request,LoginActivity.id);
                callupdate.enqueue(new Callback<UpdateuserResponse>() {
                    @Override
                    public void onResponse(Call<UpdateuserResponse> call, Response<UpdateuserResponse> response) {
                        UpdateuserResponse response1 = response.body();
                        if(response.isSuccessful()&&"OK".equals(response1.getStatus())){
                            Toast.makeText(TTnguoidungActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(TTnguoidungActivity.this, "cập nhật thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UpdateuserResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
    private void initUI(){
        edtname = findViewById(R.id.editTextName);
        edtemail = findViewById(R.id.editTextEmail);
        edtphone = findViewById(R.id.editTextPhone);
        edtdiachi = findViewById(R.id.editTextAddress);
        btncapnhat = findViewById(R.id.buttonUpdate);
    }
    private UpdateuserRequest xulyuser(){
     request = new UpdateuserRequest();
     request.setName(edtname.getText().toString());
     request.setEmail(edtname.getText().toString());
     request.setSdt(Integer.parseInt(edtphone.getText().toString()));
     request.setDiachi(edtdiachi.getText().toString());
     return request;
    }
}