package com.example.foodbasket.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodbasket.R;
import com.example.foodbasket.services.FCMPushNotificationService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class AddressDetailsRegistration extends AppCompatActivity {

    private static final String TAG = "AddressRegistration";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_addressdetails);

       final EditText txtHouseName = findViewById(R.id.txt_Register_HouseName);
        final EditText txtDoorNo = findViewById(R.id.txt_Register_DoorNo);
        final EditText txtStreet = findViewById(R.id.txt_Register_Street);
        final EditText txtLandmark = findViewById(R.id.txt_Register_Landmark);
        final EditText txtLocality = findViewById(R.id.txt_Register_Locality);
        final EditText txtPinCode = findViewById(R.id.txt_Register_Pincode);

        Button btnProceed = findViewById(R.id.btn_AddressDetails_Register);
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String houseName = txtHouseName.getText().toString();
                String doorNo = txtDoorNo.getText().toString();
                String street = txtStreet.getText().toString();
                String landmark = txtLandmark.getText().toString();
                String locality = txtLocality.getText().toString();
                String pincode = txtPinCode.getText().toString();


                //TODO Validation

                //TODO Insert to DB

                //Register to firebase to a group i

                FirebaseMessaging.getInstance()
                        .subscribeToTopic("backtowork")
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()) {
                                    Log.d(TAG, "Successfull suscribed to FCM Topic");
                                } else {
                                    Log.d(TAG, "Error subscribing to FCM Topic");
                                }
                            }
                        });

                Intent intent = new Intent(AddressDetailsRegistration.this, BuyOrSell.class);
                startActivity(intent);
            }
        });

    }
}
