package com.example.cnpmnangcaoriu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.cnpmnangcaoriu.APIservices;
import com.example.cnpmnangcaoriu.Adapter.Cartadapter;
import com.example.cnpmnangcaoriu.Models.DetailTest;
import com.example.cnpmnangcaoriu.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChitietsanphamActivity extends AppCompatActivity {
    DetailTest detailTest;
    private String id;
    public static int quantity;
    TextView detail_name,Rating,detail_description,detail_price,detail_quantity;
    Button BTN_giohang,BTN_muangay;
    ImageView imgviewchitiet,BTNtang,BTNgiam;

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
                    detailTest = response.body();
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
        XulyButton();
    }

    private void KhaiBao(){
        detail_name = findViewById(R.id.detail_name);
        Rating = findViewById(R.id.rating);
        detail_description = findViewById(R.id.detail_description);
        detail_price = findViewById(R.id.detail_price);
        BTN_giohang = findViewById(R.id.add_to_cart);
        imgviewchitiet = findViewById(R.id.imageViewChiTiet);
        BTNtang = findViewById(R.id.addItem);
        BTNgiam = findViewById(R.id.removeItem);
        detail_quantity = findViewById(R.id.quantity);
    }
    //xử lý button
    private void XulyButton(){
        BTNtang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = Integer.parseInt(detail_quantity.getText().toString());
                if(quantity<detailTest.getDetail().getCountInStock().intValue()) {
                    quantity = quantity + 1;
                    detail_quantity.setText(String.valueOf(quantity));
                }
            }
        });
        BTNgiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = Integer.parseInt(detail_quantity.getText().toString());
                if(quantity>1) {
                    quantity = quantity - 1;
                    detail_quantity.setText(String.valueOf(quantity));
                }
            }
        });
        BTN_giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<DetailTest> call = APIservices.myapi.getDetails(id);
                call.enqueue(new Callback<DetailTest>() {
                    @Override
                    public void onResponse(Call<DetailTest> call, Response<DetailTest> response) {
                        if(response.isSuccessful()){
                            detailTest = response.body();
                            MainActivity.giohang.add(detailTest);
                            quantity = 1;
                            //phần sau làm tiếp
                            Intent intentdetail = new Intent(ChitietsanphamActivity.this , MainActivity.class);
                            intentdetail.putExtra("quantity" , detail_quantity.getText());
                            startActivity(intentdetail);
                        }
                    }

                    @Override
                    public void onFailure(Call<DetailTest> call, Throwable t) {

                    }
                });

            }
        });
    }
}