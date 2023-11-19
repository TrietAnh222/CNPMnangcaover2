package com.example.cnpmnangcaoriu.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cnpmnangcaoriu.APIservices;
import com.example.cnpmnangcaoriu.Models.ProductModel;
import com.example.cnpmnangcaoriu.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GioHangActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_cart);

        // Gọi API để lấy dữ liệu giỏ hàng
        Call<ProductModel> call = APIservices.myapi.Getdata();
        call.enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                if (response != null && response.isSuccessful() && response.body() != null) {
                    // Xử lý dữ liệu thành công
                    ProductModel productModel = response.body();
                    // TODO: Xử lý dữ liệu từ productModel, ví dụ: hiển thị danh sách sản phẩm trong giỏ hàng
                } else {
                    int errorCode = response.code();
                    Log.e("GioHangActivity", "API Error code: " + errorCode);
                    Toast.makeText(GioHangActivity.this, "Dữ liệu không hợp lệ hoặc rỗng", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {

            }
        });
    }
}
