package com.example.foodbasket.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodbasket.R;
import com.example.foodbasket.business.DishBO;
import com.example.foodbasket.model.Dish;
import com.example.foodbasket.util.DishesAdapter;

import java.util.ArrayList;

public class BuyerOrderFood extends AppCompatActivity {

    ArrayList<Dish> dishes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_buyer_orderfood);

        setTitle("Your location:");
        // Lookup the recyclerview in activity layout
        RecyclerView rvDishes = (RecyclerView) findViewById(R.id.rvOrderDishes);
        dishes = getAllDishesInBasket();
        Log.d("BuyerOrderFood","All Dishes size:" + dishes.size());

        // Set layout manager to position the items
        rvDishes.setLayoutManager(new LinearLayoutManager(this));

        // Create adapter passing in the sample dishes data
        DishesAdapter adapter = new DishesAdapter(dishes);
        rvDishes.setAdapter(adapter);


    }
    public void processAddToCart(View v){
        EditText txtQuantity = v.findViewById(R.id.txt_DishDetails_Quantity);
       EditText hidDishId =  v.findViewById(R.id.hid_DishDetails_dishid);
       String dishId= hidDishId.getText().toString();
    }

    private ArrayList<Dish> getAllDishesInBasket() {
        DishBO dishBO = new DishBO();
        return dishBO.getAllDishesInBasket();
    }
}
