package com.example.foodbasket.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodbasket.R;

public class SellerAddDishes extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dishes);


    }

    public void processUploadDishImage(View v) {

        final int REQUEST_GALLERY=0;
        String[] mimeTypes= {"image/jpeg", "image/png"};
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        galleryIntent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);

        startActivityForResult(galleryIntent, REQUEST_GALLERY);
    }

    public void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode== Activity.RESULT_OK) {
            switch (requestCode){
                case 0:
                    Uri selectedImage = data.getData();
                    ImageView pic = findViewById(R.id.img_AddDish_DishImage);
                    pic.setImageURI(selectedImage);
                    break;
            }
        }
    }
}
