package com.example.djcustomerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.djcustomerapp.ui.djlist.DjListAdapter;
import com.example.djcustomerapp.ui.djlist.DjListData;

public class DJBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_djbook);

        DjbookListData[] myListData= new DjbookListData[]{
                new DjbookListData("shop1","sagar","price:5000","akurdi,Pune",R.drawable.djlogin),
                new DjbookListData("shop2","prathmesh","price:5000","akurdi,Pune",R.drawable.dj3),
                new DjbookListData("shop3","soham","price:5000","akurdi,Pune",R.drawable.djlogin),
                new DjbookListData("shop4","ashwinidj","price:5000","akurdi,Pune",R.drawable.logindj),

        };

        DjbookListData.setCurrentDJList(myListData);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.sales_recycler_view);
        DjbookListAdapter adapter = new DjbookListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }
}
