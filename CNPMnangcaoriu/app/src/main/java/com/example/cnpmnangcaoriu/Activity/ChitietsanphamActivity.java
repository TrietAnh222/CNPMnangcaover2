package com.example.cnpmnangcaoriu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.cnpmnangcaoriu.APIservices;
import com.example.cnpmnangcaoriu.Models.DetailTest;
import com.example.cnpmnangcaoriu.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChitietsanphamActivity extends AppCompatActivity {
    private String id;
    TextView detail_name,Rating,detail_description,detail_price;
    Button BTN_giohang,BTN_muangay;
    ImageView imgviewchitiet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietsanpham);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        Log.d("TAG", "Id:" + id);
        Call<DetailTest> call = APIservices.myapi.getDetails(id);
        call.enqueue(new Callback<DetailTest>() {
            @Override
            public void onResponse(Call<DetailTest> call, Response<DetailTest> response) {
                if(response.isSuccessful()){
                    DetailTest detailTest = response.body();
                    detail_name.setText(detailTest.getDetail().getName());
                    detail_description.setText(detailTest.getDetail().getDescription());
                    detail_price.setText(detailTest.getDetail().getPrice().toString());
                    Rating.setText(detailTest.getDetail().getRating().toString());
                    Glide.with(getApplicationContext()).load(detailTest.getDetail().getImage()).into(imgviewchitiet);
                }
            }

            @Override
            public void onFailure(Call<DetailTest> call, Throwable t) {

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
        imgviewchitiet = findViewById(R.id.imageViewChiTiet);
    }
}