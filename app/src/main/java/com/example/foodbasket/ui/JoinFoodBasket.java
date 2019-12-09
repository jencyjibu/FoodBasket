package com.example.foodbasket.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodbasket.R;

public class JoinFoodBasket extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_foodbasket);
    }

    public void processJoinFoodBasket(View v) {
        Intent intent = new Intent(JoinFoodBasket.this, PersonalDetailsRegistration.class);
        startActivity(intent);
    }
}
