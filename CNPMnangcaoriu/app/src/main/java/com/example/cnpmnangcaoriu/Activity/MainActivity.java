package com.example.cnpmnangcaoriu.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.cnpmnangcaoriu.APIservices;
import com.example.cnpmnangcaoriu.Adapter.ProductAdapter;
import com.example.cnpmnangcaoriu.Models.DetailTest;
import com.example.cnpmnangcaoriu.Models.ProductModel;
import com.example.cnpmnangcaoriu.R;
import com.example.cnpmnangcaoriu.fragment.CategoryFragment;
import com.example.cnpmnangcaoriu.fragment.HistoryFragment;
import com.example.cnpmnangcaoriu.fragment.HomeFragment;
import com.example.cnpmnangcaoriu.fragment.OtherFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    List<ProductModel.Product> productList;
    ProductModel loclist;
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewManHinhChinh;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    TextView txtiphone,txtsamsung,txtxiaomi;
    public static ArrayList<DetailTest> giohang;

    private static final int FRAGMENT_HOME = 0;
    private static final int TTnguoidung = 1;
    private static final int FRAGMENT_HISTORY = 2;
    private static final int FRAGMENT_OTHER = 3;
    private int mCurrentFragment = FRAGMENT_HOME;
    private DrawerLayout mdrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Thực hiện cuộc gọi API
        Call<ProductModel> call = APIservices.myapi.Getdata();
        call.enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                if (response != null && response.isSuccessful() && response.body() != null) {
                    loclist= response.body();
                    ProductAdapter productAdapter = new ProductAdapter(loclist, MainActivity.this);
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
        Log.e("TAG","id"+ LoginActivity.id);
        KhaiBao();
        ActionBar();
        ActionViewFilpper();
        txtiphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Xulyloc("Apple");
            }
        });
        txtxiaomi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Xulyloc("Xiaomi");
            }
        });
        txtsamsung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Xulyloc("SamSung");
            }
        });
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
//        navigationView = findViewById(R.id.navigationview);
//        listViewmanhinhchinh = findViewById(R.id.listviewmanhinhchinh);
         navigationView = findViewById(R.id.navigation_view);
         navigationView.setNavigationItemSelectedListener(this);
        drawerLayout = findViewById(R.id.drawerLayout);
        recyclerViewManHinhChinh.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        if(giohang==null){
            giohang = new ArrayList<>();
        }
        txtiphone = findViewById(R.id.TXTiphone);
        txtsamsung = findViewById(R.id.TXTsamsung);
        txtxiaomi = findViewById(R.id.TXTxiaomi);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.nav_home) {
            if (mCurrentFragment != FRAGMENT_HOME) {
                replaceFragment(new HomeFragment());
                mCurrentFragment = FRAGMENT_HOME;
            }
        } else if (id==R.id.nav_category) {
            if (mCurrentFragment != TTnguoidung) {
                if(LoginActivity.id!=null) {
                    Intent intent = new Intent(MainActivity.this, TTnguoidungActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(this, "vui long đăng nhập", Toast.LENGTH_SHORT).show();
                }
            }
        } else if (id==R.id.nav_history) {
            if (mCurrentFragment != FRAGMENT_HISTORY) {
                if(LoginActivity.id!=null) {
                    giohang.clear();
                    LoginActivity.id = null;
                    Toast.makeText(this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Đăng xuất thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        } else if (id==R.id.nav_other) {
            if (mCurrentFragment != FRAGMENT_OTHER) {
                replaceFragment(new OtherFragment());
                mCurrentFragment = FRAGMENT_OTHER;
            }
        } else if (id==R.id.nav_login) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
        } else if (id == R.id.btnGioHang) {
            // Mở GioHangActivity khi nhấn vào "Giỏ hàng"
            Intent gioHangIntent = new Intent(MainActivity.this, GioHangActivity.class);
            startActivity(gioHangIntent);
        }
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.RecyclerView,fragment);
        transaction.commit();
    }
    private void Xulyloc(String thucanloc){
        Call<ProductModel> call = APIservices.myapi.Getdata();
        call.enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                if (response != null && response.isSuccessful() && response.body() != null) {
                    loclist= response.body();
                    List<ProductModel.Product> productList = loclist.getData();
                    List<ProductModel.Product> filteredList = new ArrayList<>();
                    for (ProductModel.Product product : productList) {
                        if (thucanloc.equals(product.getType().toString())) {
                            filteredList.add(product);
                        }
                    }
                    if(filteredList!=null) {
                        ProductAdapter productAdapter = new ProductAdapter(new ProductModel(filteredList), MainActivity.this);
                        recyclerViewManHinhChinh.setAdapter(productAdapter);
                    }
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
    }
}