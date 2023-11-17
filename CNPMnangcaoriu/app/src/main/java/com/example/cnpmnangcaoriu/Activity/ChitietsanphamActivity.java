package com.example.cnpmnangcaoriu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cnpmnangcaoriu.APIservices;
import com.example.cnpmnangcaoriu.Models.ProductDetail;
import com.example.cnpmnangcaoriu.Models.ProductModel;
import com.example.cnpmnangcaoriu.R;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChitietsanphamActivity extends AppCompatActivity {
    private String id;
    TextView detail_name,Rating,detail_description,detail_price;
    Button BTN_giohang,BTN_muangay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietsanpham);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        Log.d("TAG", "Id:" + id);
        Call<ProductDetail> call = APIservices.myapi.getDetails(id);
        call.enqueue(new Callback<ProductDetail>() {
            @Override
            public void onResponse(Call<ProductDetail> call, Response<ProductDetail> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(ChitietsanphamActivity.this, "Call thành công", Toast.LENGTH_SHORT).show();
                    Log.d("API_SUCCESS", "API Response: " + response.body().toString());
                    ProductDetail productDetail = response.body();
                    detail_name.setText(productDetail.getName());
                }
                else {
                    Log.e("TAG", "onResponse:" +response.errorBody() );
                }
            }

            @Override
            public void onFailure(Call<ProductDetail> call, Throwable t) {

            }
        });
        KhaiBao();
    }

    private void KhaiBao(){
        detail_name = findViewById(R.id.detail_name);
        Rating = findViewById(R.id.rating);
        detail_description = findViewById(R.id.detail_description);
        detail_price = findViewById(R.id.detail_price);
        BTN_giohang = findViewById(R.id.add_to_cart);
        BTN_muangay = findViewById(R.id.buy_now);
    }
}