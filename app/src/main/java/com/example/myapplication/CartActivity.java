package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Adapter.CartAdapter;
import com.example.myapplication.Helper.ManagementCart;

public class CartActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;

    private RecyclerView view22;

    private ManagementCart managementCart;

    private TextView totalFeeTxt,taxTxt,deliveryTxt,totalTxt,emptyTxt;

    private double tax;

    private ScrollView scrollView22;

    private ImageView backBtn;

    private ImageView backBtn2;

    private Button orderBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        managementCart = new ManagementCart(this);

        initView();
        setVariable();
        calculateCart();
        initList();
    }

    private void initList() {
        if(managementCart.getListCart().isEmpty())
        {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView22.setVisibility(View.GONE);
            backBtn2.setVisibility(View.VISIBLE);

        }
        else {
            emptyTxt.setVisibility(View.GONE);
            scrollView22.setVisibility(View.VISIBLE);
            backBtn2.setVisibility(View.GONE);



        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        view22.setLayoutManager(linearLayoutManager);

        adapter = new CartAdapter(managementCart.getListCart(), this, () -> calculateCart());
        view22.setAdapter(adapter);
    }

    private void calculateCart() {
        double percentTax =0.02;
        double delivery =10;
        tax = Math.round(managementCart.getTotalFee()*percentTax*100.0)/100.0;

        double total = Math.round(managementCart.getTotalFee()+tax+delivery)*100/100;
        double itemTotal =Math.round(managementCart.getTotalFee()*100/100);

        totalFeeTxt.setText("$"+ itemTotal);
        taxTxt.setText("$"+tax);
        deliveryTxt.setText("$"+delivery);
        totalTxt.setText("$"+total);
    }

    private void setVariable() {

        backBtn.setOnClickListener(v -> finish());

        backBtn2.setOnClickListener(v -> finish());

        orderBtn.setOnClickListener(v -> {

            clearCart();
            Toast.makeText(CartActivity.this, "Your order have been placed successfully", Toast.LENGTH_SHORT).show();

        });
    }

    private void clearCart()
    {
        managementCart.clearCart();
        initList();
        calculateCart();
    }



    private void initView() {
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt =findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        view22 =findViewById(R.id.view22);
        scrollView22 = findViewById(R.id.scrollView22);
        backBtn = findViewById(R.id.backBtn);
        backBtn2 = findViewById(R.id.backBtn2);
        emptyTxt = findViewById(R.id.emptyTxt);
        orderBtn = findViewById(R.id.orderBtn);

    }
}