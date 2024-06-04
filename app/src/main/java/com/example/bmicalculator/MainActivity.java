package com.example.bmicalculator;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_about,btn_bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn_bmi=findViewById(R.id.btn_bmi);
        btn_about=findViewById(R.id.btn_about);

        btn_about.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                AlertDialog.Builder View;
                View = new AlertDialog.Builder(MainActivity.this);

                 View.setIcon(R.drawable.creater);
                // Set the message show for the Alert time
                View.setMessage("درصورت وجود انتقاد یا پیشنهاد با آیدی sina_cheh در تلگرام ارتباط بگیرید... " );

                // Set Alert Title
                View.setTitle("تهیه شده توسط: \n محمدسعید چهرقانی");

                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                View.setCancelable(false);

                // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
                View.setNegativeButton("باشه", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // If user click no then dialog box is canceled.
                    dialog.cancel();
                });
                // Set text alignment
//                View.setView(Gravity.CENTER);

                // Create the Alert dialog
                AlertDialog alertDialog = View.create();
                // Show the Alert Dialog box
                alertDialog.show();
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
            }
        });

        btn_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this , Bmi.class);
                startActivities(new Intent[]{myIntent});
            }
        });
    }
}