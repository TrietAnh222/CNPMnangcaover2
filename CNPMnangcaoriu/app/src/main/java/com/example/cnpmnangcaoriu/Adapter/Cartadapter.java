package com.example.cnpmnangcaoriu.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cnpmnangcaoriu.Activity.ChitietsanphamActivity;
import com.example.cnpmnangcaoriu.Models.DetailTest;
import com.example.cnpmnangcaoriu.Models.ProductModel;
import com.example.cnpmnangcaoriu.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cartadapter extends RecyclerView.Adapter<Cartadapter.ViewHolder> {
  private ArrayList<DetailTest> Cartlist;
  private Context context;

    public Cartadapter(ArrayList<DetailTest> cartlist, Context context) {
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
        else
        {
            DetailTest.ProductDetail detail = Cartlist.get(position).getDetail();
            holder.TXTname.setText(detail.getName());
            holder.TXTprice.setText(detail.getPrice().toString());
            Glide.with(context).load(detail.getImage()).into(holder.imageView);
            holder.TXTsoluong.setText(String.valueOf(ChitietsanphamActivity.quantity));
            holder.BTNtang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int soluong = Integer.parseInt(holder.TXTsoluong.getText().toString());
                    if (soluong < detail.getCountInStock().intValue()) {
                        soluong = soluong + 1;
                        holder.TXTsoluong.setText(String.valueOf(soluong));
                    }
                }
            });
            holder.BTNgiam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int soluong = Integer.parseInt(holder.TXTsoluong.getText().toString());
                    if (soluong > 1) {
                        soluong = soluong - 1;
                        holder.TXTsoluong.setText(String.valueOf(soluong));
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(Cartlist==null){
            return 0;
        }
        else
        return Cartlist.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TXTname,TXTprice,TXTsoluong;
        ImageButton BTNtang,BTNgiam;
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
            itemView.setOnClickListener(view -> {
                checkBox.setChecked(!checkBox.isChecked());
            });
        }
    }

}
