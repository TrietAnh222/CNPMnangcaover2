package com.example.cnpmnangcaoriu;


import com.example.cnpmnangcaoriu.Models.DetailTest;
import com.example.cnpmnangcaoriu.Models.LogInResponse;
import com.example.cnpmnangcaoriu.Models.LoginRequest;
import com.example.cnpmnangcaoriu.Models.OrderRequest;
import com.example.cnpmnangcaoriu.Models.OrderResponse;
import com.example.cnpmnangcaoriu.Models.ProductModel;
import com.example.cnpmnangcaoriu.Models.RegisterRequest;
import com.example.cnpmnangcaoriu.Models.ResigterResponse;
import com.example.cnpmnangcaoriu.Models.UpdateuserRequest;
import com.example.cnpmnangcaoriu.Models.UpdateuserResponse;
import com.example.cnpmnangcaoriu.Models.UserModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIservices {
    Gson gson =new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    //goi retrofit
    //lưu ý tìm ip wifi của chính mình r gắn đuôi localhost vô mới chạy được nhen
    //vd: http://192.168.1.103:đuôi localhost http://192.168.1.12:3000/
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://172.16.0.2:3001/").addConverterFactory(GsonConverterFactory.create())
            .build();
    // Khởi tạo Retrofit Service
    APIservices myapi= retrofit.create(APIservices.class);
    @GET("/api/product/get-all")
    Call<ProductModel> Getdata();
    @POST("/api/user/sign-in")
    Call<LogInResponse> login(@Body LoginRequest loginRequest);
    @POST("/api/user/sign-up")
    Call<ResigterResponse> register (@Body RegisterRequest registerRequest);
    @GET("/api/product/get-details/{id}")
    Call<DetailTest> getDetails(@Path("id") String id);
    @GET("/api/user/get-details/{id}")
    Call<UserModel> getDetailsUser(@Path("id") String id);
    @POST("/api/order/create/{id}")
    Call<OrderResponse> createOrder(@Body OrderRequest orderRequest,
                                    @Path("id") String id);
    @PUT("/api/user/update-user/{id}")
    Call<UpdateuserResponse> updateuser(@Body UpdateuserRequest updateuserRequest,
                                        @Path("id") String id);
}
