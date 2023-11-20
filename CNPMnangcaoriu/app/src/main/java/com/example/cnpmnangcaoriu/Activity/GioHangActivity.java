package com.example.cnpmnangcaoriu.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cnpmnangcaoriu.APIservices;
import com.example.cnpmnangcaoriu.Adapter.Cartadapter;
import com.example.cnpmnangcaoriu.Models.ProductModel;
import com.example.cnpmnangcaoriu.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GioHangActivity extends AppCompatActivity {
    RecyclerView rcbill;
    public Cartadapter cartadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_cart);
        // Gọi API để lấy dữ liệu giỏ hàng
        // Xử lý dữ liệu thành công
        // TODO: Xử lý dữ liệu từ productModel, ví dụ: hiển thị danh sách sản phẩm trong giỏ hàng
        khaibao();
    }
    private void khaibao(){
        rcbill = findViewById(R.id.rcvBill);
        rcbill.setLayoutManager(new LinearLayoutManager(GioHangActivity.this));
        cartadapter = new Cartadapter(MainActivity.giohang,GioHangActivity.this);
        rcbill.setAdapter(cartadapter);
    }
}
