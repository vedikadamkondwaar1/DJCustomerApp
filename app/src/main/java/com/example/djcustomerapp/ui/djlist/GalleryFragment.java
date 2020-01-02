package com.example.djcustomerapp.ui.djlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.djcustomerapp.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);

        DjListData[] myListData= new DjListData[]{
                new DjListData("shop1","sagar","price:5000","akurdi,Pune",R.drawable.logindj),
                new DjListData("shop2","prathmesh","price:5000","akurdi,Pune",R.drawable.logindj),
                new DjListData("shop3","soham","price:5000","akurdi,Pune",R.drawable.logindj),
                new DjListData("shop4","ashwinidj","price:5000","akurdi,Pune",R.drawable.logindj),
                new DjListData("shop5","anjumdj","price:5000","akurdi,Pune",R.drawable.logindj),

        };

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.dj_recycler_view);
        DjListAdapter adapter = new DjListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        recyclerView.setAdapter(adapter);



        return v;
    }
}