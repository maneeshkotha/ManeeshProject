package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.PupolarAdapter;
import com.example.myapplication.CartActivity;
import com.example.myapplication.Domain.PopularDomain;
import com.example.myapplication.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterpupolar;
    private RecyclerView recyclerViewpupolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initRecyclerView();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout profileBtn = findViewById(R.id.profileBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this,HomeActivity.class)));
        cartBtn.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, CartActivity.class)));
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(HomeActivity.this,ProfileActivity.class));
            }
        });
    }

    private void initRecyclerView()
    {
        ArrayList<PopularDomain> items= new ArrayList<>();
        items.add(new PopularDomain("T-Shirt black","A black shirt is a type of clothing item that is typically made from various materials, including cotton, polyester, or a blend of fabrics. The key characteristic of a black shirt is its color, which is solid black, devoid of patterns or additional colors. Black shirts are popular for both casual and formal occasions, offering versatility and a classic aesthetic.\n" +
                "finish blend seamlessly with and decor","item_1",15,4,50));
        items.add(new PopularDomain("Smart watch","it  is a wearable electronic device designed to provide various functionalities beyond timekeeping. It combines the traditional features of a wristwatch with advanced technology, offering a range of capabilities that go beyond simply telling the time. "
                ,"item_2",20,4.5,450));
        items.add(new PopularDomain("iphone 14","Immerse yourself in a world of vibrant visuals and immersive\n" +
                "sound with the VisionX Pro LED TV.\n" +
                "Its cutting edge LED Technology brings every scene\n" +
                " to life with striking clarity and rich colors with seamless\n" +
                "Integration and a sleek, modern design,\n" +
                "finish blend seamlessly with and decor","item_3",15,4.3,800));
        items.add(new PopularDomain("visionX LED TV","Immerse yourself in a world of vibrant visuals and immersive\n" +
                "sound with the VisionX Pro LED TV.\n" +
                "Its cutting edge LED Technology brings every scene\n" +
                " to life with striking clarity and rich colors with seamless\n" +
                "Integration and a sleek, modern design,\n" +
                "finish blend seamlessly with and decor ","item_4",18,4.0,1500));

        recyclerViewpupolar=findViewById(R.id.view1);
        recyclerViewpupolar.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterpupolar = new PupolarAdapter(items);
        recyclerViewpupolar.setAdapter(adapterpupolar);
    }
}

