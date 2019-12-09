package com.example.foodbasket.util;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodbasket.R;
import com.example.foodbasket.model.Dish;

import java.util.List;

public class DishesAdapter extends RecyclerView.Adapter<DishesAdapter.ViewHolder> {

    private List<Dish> mDishes;

    public DishesAdapter(List<Dish> dishes) {
        mDishes = dishes;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public DishesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View dishesView = inflater.inflate(R.layout.layout_dishdetails, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(dishesView);
        return viewHolder;

    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(DishesAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Dish dish = mDishes.get(position);
        // Set item views based on your views and data model
        TextView textViewDishName = viewHolder.txtDishName;
        textViewDishName.setText(dish.getName());

        TextView textViewDescription = viewHolder.txtDescription;
        textViewDescription.setText(dish.getDescription());

        TextView textViewOrderby = viewHolder.txtOrderby;
        textViewOrderby.setText(textViewOrderby.getText() + " " + dish.getOrderByDate());

        TextView textViewQtyLeft = viewHolder.txtQtyLeft;
        textViewQtyLeft.setText(dish.getMaximumQuantity() + " " + textViewQtyLeft.getText());

        TextView textViewPrice = viewHolder.txtPrice;
        textViewPrice.setText("Rs." + dish.getPrice());

        TextView textViewSeller = viewHolder.txtSellername;
        textViewSeller.setText(textViewSeller.getText() + " " + dish.getSeller().getFullname());

        TextView textViewReadyby = viewHolder.txtReadyby;
        textViewReadyby.setText(textViewReadyby.getText() + " " + dish.getReadyDateTime());
        if (dish.getDishImage() != null) {
            Log.d("DishesAdapter", "image url:"+dish.getDishImage().toString());
            ImageView imageViewDishImage = viewHolder.imgDish;
            imageViewDishImage.setImageURI(dish.getDishImage());
        }
        TextView hiddenDishId = viewHolder.hidDishId;
        hiddenDishId.setText(dish.getDishid().toString());
        ;
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mDishes.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView txtOrderby;
        public TextView txtDishName;
        public TextView txtDescription;
        public TextView txtQtyLeft;
        public TextView txtPrice;
        public TextView txtSellername;
        public TextView txtReadyby;
        public ImageView imgDish;
        public TextView hidDishId;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            txtOrderby = (TextView) itemView.findViewById(R.id.lbl_DishDetails_OrderBy);
            txtDishName = (TextView) itemView.findViewById(R.id.lbl_DishDetails_Dishname);
            txtDescription = (TextView) itemView.findViewById(R.id.lbl_DishDetails_Description);
            txtQtyLeft = (TextView) itemView.findViewById(R.id.lbl_DishDetails_QtyLeft);
            txtPrice = (TextView) itemView.findViewById(R.id.lbl_DishDetails_Price);
            txtSellername = (TextView) itemView.findViewById(R.id.lbl_DishDetails_Seller);
            txtReadyby = (TextView) itemView.findViewById(R.id.lbl_DishDetails_ReadyDate);
            imgDish = (ImageView) itemView.findViewById(R.id.img_DishDetails_DishImage);
            hidDishId=(TextView)itemView.findViewById(R.id.hid_DishDetails_dishid);

        }
    }
}
