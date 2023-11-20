package com.example.cnpmnangcaoriu.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cnpmnangcaoriu.APIservices;
import com.example.cnpmnangcaoriu.Adapter.Cartadapter;
import com.example.cnpmnangcaoriu.Models.DetailTest;
import com.example.cnpmnangcaoriu.Models.ProductModel;
import com.example.cnpmnangcaoriu.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GioHangActivity extends AppCompatActivity {
    RecyclerView rcbill;
    TextView txttongcong;
    Cartadapter cartadapter;
    int giatritongcong;
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
        txttongcong = findViewById(R.id.txt_amount);
        for(DetailTest detailTest:MainActivity.giohang){
            giatritongcong += detailTest.getDetail().getPrice().intValue() * ChitietsanphamActivity.quantity;
        }
        txttongcong.setText(String.valueOf(giatritongcong));
    }
}
