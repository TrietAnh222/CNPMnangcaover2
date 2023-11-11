package com.example.cnpmnangcaoriu;


import com.example.cnpmnangcaoriu.Models.ProductModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface APIservices {
    Gson gson =new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    //goi retrofit
    //lưu ý tìm ip wifi của chính mình r gắn đuôi localhost vô mới chạy được nhen
    //vd: http://192.168.1.103:đuôi localhost http://192.168.1.12:3000/
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.1.3:3001/").addConverterFactory(GsonConverterFactory.create())
            .build();
    // Khởi tạo Retrofit Service
    APIservices myapi= retrofit.create(APIservices.class);
    @GET("/api/product/get-all")
    Call<ProductModel> Getdata();
}
