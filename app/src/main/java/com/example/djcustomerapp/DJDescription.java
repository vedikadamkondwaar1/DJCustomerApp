package com.example.djcustomerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DJDescription extends AppCompatActivity {

    ImageView img;
    TextView shopname, name, price, address;
    Spinner spinner;
    Button addbutton,nextbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_djdescription);

        addbutton=findViewById(R.id.addbt);
        nextbt=findViewById(R.id.nextbt);
        img=findViewById(R.id.imageViewX);
        shopname = findViewById(R.id.shopname);
        name=findViewById(R.id.djname);
        price=findViewById(R.id.price);
        address=findViewById(R.id.address);

       shopname.setText(DjbookListData.getCurrentDJList()[DjbookListAdapter.pos].getShopname());
       name.setText(DjbookListData.getCurrentDJList()[DjbookListAdapter.pos].getDjname());
      price.setText(DjbookListData.getCurrentDJList()[DjbookListAdapter.pos].getPrice());
        address.setText(DjbookListData.getCurrentDJList()[DjbookListAdapter.pos].getLocation());
        img.setImageResource(DjbookListData.getCurrentDJList()[DjbookListAdapter.pos].getImgId());

        nextbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DJDescription.this,PaymentActivity.class);
                startActivity(intent);

            }
        });
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(DJDescription.this, "Item Added Successfully", Toast.LENGTH_SHORT).show();

            }
        });




        //   ============================ spinner==================

        spinner=findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }
}
