package com.example.cnpmnangcaoriu.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.cnpmnangcaoriu.APIservices;
import com.example.cnpmnangcaoriu.Adapter.ProductAdapter;
import com.example.cnpmnangcaoriu.Models.ProductModel;
import com.example.cnpmnangcaoriu.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewManHinhChinh;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Thực hiện cuộc gọi API
        Call<ProductModel> call = APIservices.myapi.Getdata();
        //đã gọi dc thành công nhưng response bị rỗng nên không chạy dc ae tìm hiểu giúp tui
        call.enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                if (response != null && response.isSuccessful() && response.body() != null) {
                    ProductModel productModel= response.body();
                    ProductAdapter productAdapter = new ProductAdapter(productModel, MainActivity.this);
                    recyclerViewManHinhChinh.setAdapter(productAdapter);
                } else {
                    int errorcode =response.code();
                    Log.e("APIerror" , "Error code" + errorcode);
                    Toast.makeText(MainActivity.this, "Dữ liệu không hợp lệ hoặc rỗng", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "call fail", Toast.LENGTH_SHORT).show();
            }
        });

        KhaiBao();
        ActionBar();
        ActionViewFilpper();
    }
    //chi tiết về glide Ae có thể tham khảo ở đây
    //https://github.com/bumptech/glide/blob/master/README.md
    //xài anim để có hiệu ứng chút nhá
    private void ActionViewFilpper(){
        List<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://intphcm.com/data/upload/banner-la-gi.jpg");
        mangquangcao.add("https://intphcm.com/data/upload/mau-banner-noi-bat.jpg");
        mangquangcao.add("https://intphcm.com/data/upload/mau-banner-logo-dep.jpg");
        for (int i=0;i<mangquangcao.size();i++){
            ImageView imageView =new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(slide_in);
        viewFlipper.setOutAnimation(slide_out);
    }
    private void ActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    private void KhaiBao(){
        toolbar = findViewById(R.id.Toolbarmanhinhchinh);
        viewFlipper = findViewById(R.id.ViewFlipper);
        recyclerViewManHinhChinh = findViewById(R.id.RecyclerView);
        navigationView = findViewById(R.id.navigationview);
        listViewmanhinhchinh = findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = findViewById(R.id.drawerLayout);
        recyclerViewManHinhChinh.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}