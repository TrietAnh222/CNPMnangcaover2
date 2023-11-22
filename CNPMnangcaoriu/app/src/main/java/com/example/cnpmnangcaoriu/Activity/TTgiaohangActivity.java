package com.example.cnpmnangcaoriu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cnpmnangcaoriu.APIservices;
import com.example.cnpmnangcaoriu.Models.LoginRequest;
import com.example.cnpmnangcaoriu.Models.OrderRequest;
import com.example.cnpmnangcaoriu.Models.OrderResponse;
import com.example.cnpmnangcaoriu.Models.UserModel;
import com.example.cnpmnangcaoriu.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TTgiaohangActivity extends AppCompatActivity {
    EditText editname,editcity,editphone,editaddress;
    Button btncancel,btnok;
    OrderRequest orderRequest;
    String paymentmethod = "";
    UserModel userModel;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttgiaohang);
        Call<UserModel> call = APIservices.myapi.getDetailsUser(LoginActivity.id);
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(response.isSuccessful()){
                    userModel = response.body();
                    if(userModel.getUser().getName()!=null)
                        editname.setText(userModel.getUser().getName());
                    if(userModel.getUser().getPhone()!=null)
                        editphone.setText(String.valueOf(userModel.getUser().getPhone()));
                    if(userModel.getUser().getCity()!=null)
                        editcity.setText(userModel.getUser().getCity());
                    if(userModel.getUser().getAddress()!=null)
                        editaddress.setText(userModel.getUser().getAddress());
                    email = userModel.getUser().getEmail();
                }
            }
            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
            }
        });
        initui();
        xulydonhang();
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<OrderResponse> callOrder = APIservices.myapi.createOrder(orderRequest,LoginActivity.id);
                callOrder.enqueue(new Callback<OrderResponse>() {
                    @Override
                    public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                        OrderResponse orderResponse= response.body();
                        if(response.isSuccessful()&& "OK".equals(orderResponse.getStatus())){
                            Toast.makeText(TTgiaohangActivity.this, "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(TTgiaohangActivity.this, orderResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<OrderResponse> call, Throwable t) {
                    }
                });
            }
        });
    }

    private void initui(){
        editname=findViewById(R.id.editName);
        editcity = findViewById(R.id.editCity);
        editaddress= findViewById(R.id.editAdress);
        editphone = findViewById(R.id.editPhone);
        btncancel = findViewById(R.id.btncancel);
        btnok = findViewById(R.id.BTNok);
    }
    private void xulydonhang(){
        orderRequest = new OrderRequest();
        List<OrderRequest.Orderproduct> list = new ArrayList<>();
        if(MainActivity.giohang!=null){
            for(int i=0;i<MainActivity.giohang.size();i++){
                OrderRequest.Orderproduct orderproduct = new OrderRequest.Orderproduct();
                orderproduct.setAmount(MainActivity.giohang.get(i).getSoluong());
                orderproduct.setName(MainActivity.giohang.get(i).getDetail().getName());
                orderproduct.setImage(MainActivity.giohang.get(i).getDetail().getImage());
                orderproduct.setPrice(MainActivity.giohang.get(i).getDetail().getPrice().intValue());
                orderproduct.setDiscount(MainActivity.giohang.get(i).getDetail().getDiscount().intValue());
                orderproduct.setProductid(MainActivity.giohang.get(i).getDetail().getId());
                list.add(orderproduct);
            }
        }
        orderRequest.setOrderItems(list);
        orderRequest.setPaymentMethod(paymentmethod);
        orderRequest.setItemsPrice(GioHangActivity.giatritongcong);
        orderRequest.setShippingPrice(10000);
        orderRequest.setTotalPrice(GioHangActivity.giatritongcong+orderRequest.getShippingPrice());
        orderRequest.setFullname(editname.getText().toString());
        orderRequest.setCity(editcity.getText().toString());
        orderRequest.setIduser(LoginActivity.id);
        orderRequest.setPaid(false);
        if (orderRequest.isPaid()==false){
            orderRequest.setPaidAt("");
        }
        orderRequest.setEmail(email);
    }
}