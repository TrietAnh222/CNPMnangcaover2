package com.example.cnpmnangcaoriu.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cnpmnangcaoriu.Activity.ChitietsanphamActivity;
import com.example.cnpmnangcaoriu.Models.DetailTest;
import com.example.cnpmnangcaoriu.Models.ProductModel;
import com.example.cnpmnangcaoriu.R;

import java.util.List;

public class Cartadapter extends RecyclerView.Adapter<Cartadapter.ViewHolder> {
  public List<DetailTest> Cartlist;
  public Context context;

    public Cartadapter(List<DetailTest> cartlist, Context context) {
        Cartlist = cartlist;
        this.context = context;
    }

    @NonNull
    @Override
    public Cartadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_gio_hang, parent, false);
        return new Cartadapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Cartadapter.ViewHolder holder, int position) {
        if(Cartlist==null){
            Toast.makeText(context, "Thêm sản phẩm vào giỏ hàng", Toast.LENGTH_SHORT).show();
        }
        else {
            DetailTest.ProductDetail detail = Cartlist.get(position).getDetail();
            holder.TXTname.setText(detail.getName());
            holder.TXTprice.setText(detail.getPrice().toString());
        }
    }

    @Override
    public int getItemCount() {
        return Cartlist.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TXTname,TXTprice,TXTsoluong;
        Button BTNtang,BTNgiam;
        ImageView imageView;
        CheckBox checkBox;
        public ViewHolder(View itemView) {
            super(itemView);
            TXTname = itemView.findViewById(R.id.txttensp);
            TXTprice=itemView.findViewById(R.id.txtgiatien);
            TXTsoluong = itemView.findViewById(R.id.txtsoluong);
            BTNgiam = itemView.findViewById(R.id.btnback);
            BTNtang = itemView.findViewById(R.id.btn_increase);
            imageView = itemView.findViewById(R.id.hinhanh);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }
}
