package com.example.weather_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather_app.Activity.DetailActivity;
import com.example.weather_app.R;
import com.example.weather_app.control.DataDescription;
import com.example.weather_app.model.DataDetail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<DataDetail> dataDetail;

    public RecyclerViewAdapter(Context mContext, ArrayList<DataDetail> dataDetail) {
        this.mContext = mContext;
        this.dataDetail = dataDetail;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataDetail itemData = dataDetail.get(position);
        holder.txtItemTemp.setText(String.format("%s%s", itemData.getdTemp(), mContext.getString(R.string.celsius)));
        holder.txtItemHour.setText(itemData.getdHour());
        holder.txtItemDescription.setText(mContext.getString(DataDescription.idDescription(itemData.getId())));
        Picasso.get().load(itemData.getdImgUrl()).into(holder.imgItemIcon);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("data_detail", (Parcelable) itemData);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataDetail.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imgItemIcon;
        TextView txtItemTemp, txtItemHour, txtItemDescription;
        LinearLayout parentLayout;
        ViewHolder(View itemView) {
            super(itemView);
            imgItemIcon = itemView.findViewById(R.id.ivItemIcon);
            txtItemTemp = itemView.findViewById(R.id.tvItemTemp);
            txtItemHour = itemView.findViewById(R.id.tvItemHour);
            txtItemDescription = itemView.findViewById(R.id.tvItemDescription);
            parentLayout = itemView.findViewById(R.id.ln_Item);
        }
    }
}

