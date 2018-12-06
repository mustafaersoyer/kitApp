package com.example.mstfa.kitapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PaylasimAdapter extends RecyclerView.Adapter<PaylasimAdapter.MyViewHolder>{
    ArrayList<Paylasim> mDataList;

    LayoutInflater inflater;

    public PaylasimAdapter(Context context, ArrayList<Paylasim> data){
        inflater=LayoutInflater.from(context);
        this.mDataList=data;
    }
    @Override
    final public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.paylasim_list,parent,false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    final public void onBindViewHolder(MyViewHolder holder, int position) {
        Paylasim tiklanilanPaylasim = mDataList.get(position);
        holder.setData(tiklanilanPaylasim,position);
    }

    @Override
    final public int getItemCount() {
        return mDataList.size();
    }


    class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView baslik,aciklama,kitap;
        public MyViewHolder(View itemView) {
            super(itemView);
            baslik = (TextView) itemView.findViewById(R.id.baslik);
            aciklama = (TextView) itemView.findViewById(R.id.aciklama);
            kitap = (TextView) itemView.findViewById(R.id.kitapadi);

        }

        final public void setData(Paylasim tiklanilanPaylasim, int position) {
            this.baslik.setText(tiklanilanPaylasim.getBaslik());
            this.aciklama.setText(tiklanilanPaylasim.getAciklama());
            this.kitap.setText(tiklanilanPaylasim.getKitap());
        }
    }
}
