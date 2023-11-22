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
import com.example.cnpmnangcaoriu.IImageclicklistener;
import com.example.cnpmnangcaoriu.Models.DetailTest;
import com.example.cnpmnangcaoriu.Models.Eventbus.TinhTongevent;
import com.example.cnpmnangcaoriu.Models.ProductModel;
import com.example.cnpmnangcaoriu.R;

import org.greenrobot.eventbus.EventBus;

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
            holder.TXTsoluong.setText(String.valueOf(Cartlist.get(position).getSoluong().intValue()));
            holder.setListener(new IImageclicklistener() {
                @Override
                public void onImageclick(View view, int pos, int giatri) {
                    if(giatri==1) {
                        if (Cartlist.get(pos).getSoluong().intValue() > 1) {
                            int soluongmoi = Cartlist.get(pos).getSoluong().intValue() - 1;
                            Cartlist.get(pos).setSoluong(soluongmoi);
                        }
                    } else if (giatri==2) {
                        if (Cartlist.get(pos).getSoluong().intValue() <Cartlist.get(pos).getDetail().getCountInStock().intValue()) {
                            int soluongmoi = Cartlist.get(pos).getSoluong().intValue() + 1;
                            Cartlist.get(pos).setSoluong(soluongmoi);
                        }
                    }
                    holder.TXTsoluong.setText(String.valueOf(Cartlist.get(pos).getSoluong()));
                    EventBus.getDefault().postSticky(new TinhTongevent());
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
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView TXTname,TXTprice,TXTsoluong;
        ImageButton BTNtang,BTNgiam;
        ImageView imageView;
        CheckBox checkBox;
        IImageclicklistener listener;
        public ViewHolder(View itemView) {
            super(itemView);
            TXTname = itemView.findViewById(R.id.txttensp);
            TXTprice=itemView.findViewById(R.id.txtgiatien);
            TXTsoluong = itemView.findViewById(R.id.txtsoluong);
            BTNgiam = itemView.findViewById(R.id.btnback);
            BTNtang = itemView.findViewById(R.id.btn_increase);
            imageView = itemView.findViewById(R.id.hinhanh);
            checkBox = itemView.findViewById(R.id.checkBox);
            BTNtang.setOnClickListener(this);
            BTNgiam.setOnClickListener(this);
        }
        public void setListener(IImageclicklistener listener){
            this.listener = listener;
        }

        @Override
        public void onClick(View view) {
            if(view==BTNgiam){
                listener.onImageclick(view,getAdapterPosition(),1);
            } else if (view==BTNtang) {
                listener.onImageclick(view,getAdapterPosition(),2);
            }
        }
    }

}
