package com.example.foodbasket.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodbasket.R;

public class BuyOrSell extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyorsell);
    }

    public void processOrderFood(View v) {
        Intent intent = new Intent(BuyOrSell.this, BuyerOrderFood.class);
        startActivity(intent);
    }

    public void processSellFood(){
        Intent intent = new Intent(BuyOrSell.this, SellerAddDishes.class);
        startActivity(intent);
    }
}
