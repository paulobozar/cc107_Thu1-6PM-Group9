package com.example.libraryapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class PDFAdapter extends RecyclerView.Adapter<PDFAdapter.MyViewHolder> {
    Context context;
    List<ListValue> list;


    public PDFAdapter(Context context, List<ListValue>list ){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pdf_item,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int size) {

        holder.Name.setText(list.get(size).getCodename());
//        holder.Text.setText(list.get(size).getDl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Position "+size, Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    private List<ListValue> listValue;
    public PDFAdapter(List<ListValue> lv) {
        listValue = lv;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Name;
        ImageView Text;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.pdf_file_name);
            Text = itemView.findViewById(R.id.dl_button);


        }

    }

}
