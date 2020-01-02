package com.example.djcustomerapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DjHistoryListAdapter extends RecyclerView.Adapter<DjHistoryListAdapter.ViewHolder> {
    View listItem;
    private DjHistoryListData[] listdata;
    public static  int pos=0;


    public DjHistoryListAdapter(DjHistoryListData[] listdata) {
        this.listdata = listdata;

    }

    @NonNull
    @Override
    public DjHistoryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        listItem = layoutInflater.inflate(R.layout.djhistory_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final DjHistoryListAdapter.ViewHolder holder, final int position) {
        final DjHistoryListData myListData = listdata[position];
        holder.shopnsme.setText(listdata[position].getShopname());
        holder.djname.setText(listdata[position].getDjname());
        holder.price.setText(listdata[position].getPrice());
        holder.location.setText(listdata[position].getLocation());

        holder.imageView.setImageResource(listdata[position].getImgId());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = position;
              Intent i = new Intent(holder.linearLayout.getContext(),DJDescription.class);
              v.getContext().startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView,deleteview;
        public TextView shopnsme,djname,price,location,datentime;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            this.imageView = (ImageView) itemView.findViewById(R.id.android_image);
            this.deleteview = (ImageView) itemView.findViewById(R.id.delete_history) ;
            this.linearLayout = (LinearLayout)itemView.findViewById(R.id.add_dj_click);

            this.shopnsme = (TextView) itemView.findViewById(R.id.android_gridview_shopname);
            this.djname = (TextView) itemView.findViewById(R.id.android_gridview_djname);
            this.price = (TextView) itemView.findViewById(R.id.android_gridview_price);
            this.location = (TextView) itemView.findViewById(R.id.dj_address);
            this.datentime = (TextView) itemView.findViewById(R.id.android_gridview_date);

        }
    }
}
