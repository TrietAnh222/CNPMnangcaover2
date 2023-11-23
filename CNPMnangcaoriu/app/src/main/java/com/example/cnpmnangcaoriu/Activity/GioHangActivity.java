package com.example.cnpmnangcaoriu.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cnpmnangcaoriu.APIservices;
import com.example.cnpmnangcaoriu.Adapter.Cartadapter;
import com.example.cnpmnangcaoriu.Models.DetailTest;
import com.example.cnpmnangcaoriu.Models.Eventbus.TinhTongevent;
import com.example.cnpmnangcaoriu.Models.ProductModel;
import com.example.cnpmnangcaoriu.R;
import com.example.cnpmnangcaoriu.SwipeToDeleteCallback;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GioHangActivity extends AppCompatActivity {
    RecyclerView rcbill;
    TextView txttongcong;
    Cartadapter cartadapter;
    Button thanhtoan;
    ImageButton btnbackcart;
    public static int giatritongcong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_cart);
        // Gọi API để lấy dữ liệu giỏ hàng
        // Xử lý dữ liệu thành công
        // TODO: Xử lý dữ liệu từ productModel, ví dụ: hiển thị danh sách sản phẩm trong giỏ hàng
        khaibao();
    }
    private void khaibao() {
        rcbill = findViewById(R.id.rcvBill);
        rcbill.setLayoutManager(new LinearLayoutManager(GioHangActivity.this));
        cartadapter = new Cartadapter(MainActivity.giohang, GioHangActivity.this);
        rcbill.setAdapter(cartadapter);
        txttongcong = findViewById(R.id.txt_amount);
        txttongcong.setText(String.valueOf(giatritongcong));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToDeleteCallback(cartadapter));
        itemTouchHelper.attachToRecyclerView(rcbill);
        thanhtoan = findViewById(R.id.btnthanhtoan);
        btnbackcart = findViewById(R.id.btnBackcart);
          btnbackcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GioHangActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        thanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.giohang!=null&&LoginActivity.id!=null){
                    Intent intent = new Intent(GioHangActivity.this,TTgiaohangActivity.class);
                    startActivity(intent);
                }else if (MainActivity.giohang==null){
                    Toast.makeText(GioHangActivity.this, "Thêm sản phẩm vào giỏ", Toast.LENGTH_SHORT).show();
                }else if (LoginActivity.id==null){
                    Toast.makeText(GioHangActivity.this, "Đăng nhập trước khi thanh toán", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void Eventtinhtien(TinhTongevent event){
        giatritongcong=0;
        if(event!=null){
            for(int i=0 ; i<MainActivity.giohang.size();i++) {
                giatritongcong = MainActivity.giohang.get(i).getDetail().getPrice().intValue() * MainActivity.giohang.get(i).getSoluong().intValue() + giatritongcong;
                txttongcong.setText(String.valueOf(giatritongcong-(10*giatritongcong/100)));
            }
            giatritongcong = giatritongcong - (10*giatritongcong/100);
        }
    }
}
