package com.example.djcustomerapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.djcustomerapp.ui.djlist.DjListData;

public class DjbookListAdapter extends RecyclerView.Adapter<DjbookListAdapter.ViewHolder> {
    View listItem;
    private DjbookListData[] listdata;
    public static  int pos=0;


    public DjbookListAdapter(DjbookListData[] listdata) {
        this.listdata = listdata;

    }

    @NonNull
    @Override
    public DjbookListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        listItem = layoutInflater.inflate(R.layout.dj_booklist_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final DjbookListAdapter.ViewHolder holder, final int position) {
        final DjbookListData myListData = listdata[position];
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


                //  Intent intent=new Intent(v.getContext(), AppleList.class);
              // v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView shopnsme,djname,price,location;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            this.imageView = (ImageView) itemView.findViewById(R.id.android_gridview_image);
            this.linearLayout = (LinearLayout)itemView.findViewById(R.id.relativeLayout);

            this.shopnsme = (TextView) itemView.findViewById(R.id.shopname);
            this.djname = (TextView) itemView.findViewById(R.id.djname);
            this.price = (TextView) itemView.findViewById(R.id.price);
            this.location = (TextView) itemView.findViewById(R.id.location);



        }
    }
}
