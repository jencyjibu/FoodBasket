package com.example.foodbasket.business;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;

import androidx.annotation.AnyRes;
import androidx.annotation.NonNull;

import com.example.foodbasket.R;
import com.example.foodbasket.model.Dish;
import com.example.foodbasket.model.User;

import java.util.ArrayList;

public class DishBO {
    public ArrayList<Dish> getAllDishesInBasket() {
        ArrayList<Dish> allDishes = new ArrayList<Dish>(2);
        Dish dish = new Dish();
        dish.setDishid(2);
        dish.setName("Chapathi");
        dish.setDescription("Soft chapathis made from whole wheat");
        dish.setMaximumQuantity(12);
        dish.setOrderByDate("3/2/20");
        dish.setReadyDateTime("4/2/20");
        dish.setPrice(5);
        User usr = new User();
        dish.setSeller(usr);
        dish.getSeller().setFullname("Liya Maria");
      //  Uri myUri = getUriToResource(, R.drawable.cutlet);

      //  dish.setDishImage(myUri);
        allDishes.add(dish);

        Dish dish2 = new Dish();
        dish2.setDishid(2);
        dish2.setName("Chicken cutlet");
        dish2.setDescription("Hot and Cruncy chicken cutlets");
        dish2.setMaximumQuantity(10);
        dish2.setOrderByDate("2/2/20");
        dish2.setReadyDateTime("3/2/20");
        dish2.setPrice(15);
        Uri myUri2 = Uri.parse("@drawable/sellfood");
        dish2.setDishImage(myUri2);
        User usr2 = new User();
        dish2.setSeller(usr2);
        dish2.getSeller().setFullname("Rita Maria");
        allDishes.add(dish2);

        Dish dish3 = new Dish();
        dish2.setDishid(3);
        dish3.setName("Chicken cutlet");
        dish3.setDescription("Hot and Cruncy chicken cutlets");
        dish3.setMaximumQuantity(10);
        dish3.setOrderByDate("2/2/20");
        dish3.setReadyDateTime("3/2/20");
        dish3.setPrice(15);
        User usr3 = new User();
        dish3.setSeller(usr3);
        dish3.getSeller().setFullname("Divya Krishnan");
        allDishes.add(dish3);
        return allDishes;
    }
    public static final Uri getUriToResource(@NonNull Context context,
                                             @AnyRes int resId)
            throws Resources.NotFoundException {
        /** Return a Resources instance for your application's package. */
        Resources res = context.getResources();
        /**
         * Creates a Uri which parses the given encoded URI string.
         * @param uriString an RFC 2396-compliant, encoded URI
         * @throws NullPointerException if uriString is null
         * @return Uri for this given uri string
         */
        Uri resUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + res.getResourcePackageName(resId)
                + '/' + res.getResourceTypeName(resId)
                + '/' + res.getResourceEntryName(resId));
        /** return uri */
        return resUri;
    }
}
