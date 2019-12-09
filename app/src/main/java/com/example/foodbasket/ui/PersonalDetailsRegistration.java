package com.example.foodbasket.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.foodbasket.R;

public class PersonalDetailsRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_personaldetails);

        setTitle("Personal Details");

        final EditText txtFullName = findViewById(R.id.txt_Register_Fullname);
        final EditText txtEmail = findViewById(R.id.txt_Register_Email);
        final EditText txtPassword = findViewById(R.id.txt_Register_Password);

        Button btnProceed = (Button)findViewById(R.id.btn_PersonalDetails_Proceed);
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v != null)
                    Log.println(Log.INFO, "PersonalDetails", "Inside view");
                else
                    Log.println(Log.INFO, "PersonalDetails", "View is null");
                /**  Log.println(Log.INFO,"PersonalDetails", v.toString());
                 String fullName = txtFullName.getText().toString();
                 String emailAddress = txtEmail.getText().toString();
                 String password = txtPassword.getText().toString();
                 **/
                //TODO Validation

                //TODO Insert to DB

                Intent intent = new Intent(PersonalDetailsRegistration.this, AddressDetailsRegistration.class);
                startActivity(intent);
            }
        });
    }

}
