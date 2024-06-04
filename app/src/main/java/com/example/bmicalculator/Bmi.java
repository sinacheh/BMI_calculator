package com.example.bmicalculator;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Bmi extends AppCompatActivity {


    Button btn_cal;
    EditText edt_name, edt_height, edt_weight;
    RadioButton radio_miss,radio_mr;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
//        //for to display actionbar
//        ActionBar actionBar = getSupportActionBar();
//        assert actionBar != null;
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        //setTitle("محاسبه BMI شما");

        btn_cal=findViewById(R.id.btn_cal);

        edt_name=findViewById(R.id.edt_name);
        edt_height=findViewById(R.id.edt_height);
        edt_weight=findViewById(R.id.edt_weight);

        radio_miss=findViewById(R.id.radio_miss);
        radio_mr=findViewById(R.id.radio_mr);



        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=edt_name.getText().toString();
                String height=edt_height.getText().toString();
                String weight=edt_weight.getText().toString();


                if(TextUtils.isEmpty(name)||TextUtils.isEmpty(height)||TextUtils.isEmpty(weight)){
                    String errorMessage = "لطفا اطلاعات خود را به صورت کامل وارد کنید!";
                     int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(Bmi.this, errorMessage, Toast.LENGTH_LONG);
                    toast.show();
                } else {

                    int vweight =Integer.parseInt( edt_weight.getText().toString());
                    int vheight =Integer.parseInt( edt_height.getText().toString());

                    float heightM=(float) vheight / 100;
                    heightM = (float) Math.pow(heightM,2);

                    float result= vweight / heightM;

                    if (radio_miss.isChecked()){
                        result = result --;
                    }

                    int weightM = (int) (24 * heightM);
                    int properweight= vweight - weightM;
                    int pweight = weightM - vweight;

                    if (result<16.5){
                        AlertDialog.Builder View = new AlertDialog.Builder(Bmi.this);

                        View.setIcon(R.drawable.weighter);

                        // Set Alert Title
                        View.setTitle(name + " عزیز ");

                        // Set the message show for the Alert time
                        View.setMessage("شما حدود " + pweight + " کیلو کمبود وزن شدید دارید...");

                        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                        View.setCancelable(false);

                        View.setNegativeButton("باشه", (DialogInterface.OnClickListener) (dialog, which) -> {
                            // If user click no then dialog box is canceled.
                            dialog.cancel();
                        });

                        // Create the Alert dialog
                        AlertDialog alertDialog = View.create();
                        // Show the Alert Dialog box
                        alertDialog.show();
                    } else if (result >= 16.5 && result < 18.4){
                        AlertDialog.Builder View = new AlertDialog.Builder(Bmi.this);

                        View.setIcon(R.drawable.weighter);

                        // Set Alert Title
                        View.setTitle(name + " عزیز ");

                        // Set the message show for the Alert time
                        View.setMessage("شما حدود " + pweight + " کیلو کمبود وزن دارید...");

                        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                        View.setCancelable(false);

                        View.setNegativeButton("باشه", (DialogInterface.OnClickListener) (dialog, which) -> {
                            // If user click no then dialog box is canceled.
                            dialog.cancel();
                        });

                        // Create the Alert dialog
                        AlertDialog alertDialog = View.create();
                        // Show the Alert Dialog box
                        alertDialog.show();
                    }  else if (result >= 18.4 && result < 25){
                        AlertDialog.Builder View = new AlertDialog.Builder(Bmi.this);

                        View.setIcon(R.drawable.weighter);

                        // Set Alert Title
                        View.setTitle(name + " عزیز ");

                        // Set the message show for the Alert time
                        View.setMessage("شما قد و وزن مناسبی دارید...");

                        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                        View.setCancelable(false);

                        View.setNegativeButton("باشه", (DialogInterface.OnClickListener) (dialog, which) -> {
                            // If user click no then dialog box is canceled.
                            dialog.cancel();
                        });

                        // Create the Alert dialog
                        AlertDialog alertDialog = View.create();
                        // Show the Alert Dialog box
                        alertDialog.show();
                    } else if (result >= 25 && result < 30){
                        AlertDialog.Builder View = new AlertDialog.Builder(Bmi.this);

                        View.setIcon(R.drawable.weighter);

                        // Set Alert Title
                        View.setTitle(name + " عزیز ");

                        // Set the message show for the Alert time
                        View.setMessage("شما حدود " + properweight + " کیلو اضافه وزن دارید...");

                        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                        View.setCancelable(false);

                        View.setNegativeButton("باشه", (DialogInterface.OnClickListener) (dialog, which) -> {
                            // If user click no then dialog box is canceled.
                            dialog.cancel();
                        });

                        // Create the Alert dialog
                        AlertDialog alertDialog = View.create();
                        // Show the Alert Dialog box
                        alertDialog.show();
                    }else if (result >= 30 && result < 35){
                        AlertDialog.Builder View = new AlertDialog.Builder(Bmi.this);

                        View.setIcon(R.drawable.weighter);

                        // Set Alert Title
                        View.setTitle(name + " عزیز ");

                        // Set the message show for the Alert time
                        View.setMessage("شما حدود " + properweight + " کیلو اضافه وزن دارید... و دچار چاقی نوع اول هستید ");

                        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                        View.setCancelable(false);

                        View.setNegativeButton("باشه", (DialogInterface.OnClickListener) (dialog, which) -> {
                            // If user click no then dialog box is canceled.
                            dialog.cancel();
                        });

                        // Create the Alert dialog
                        AlertDialog alertDialog = View.create();
                        // Show the Alert Dialog box
                        alertDialog.show();
                    }else if (result >= 35 && result < 40){
                        AlertDialog.Builder View = new AlertDialog.Builder(Bmi.this);

                        View.setIcon(R.drawable.weighter);

                        // Set Alert Title
                        View.setTitle(name + " عزیز ");

                        // Set the message show for the Alert time
                        View.setMessage("شما حدود " + properweight + " کیلو اضافه وزن دارید... و دچار چاقی نوع دوم هستید ");

                        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                        View.setCancelable(false);

                        View.setNegativeButton("باشه", (DialogInterface.OnClickListener) (dialog, which) -> {
                            // If user click no then dialog box is canceled.
                            dialog.cancel();
                        });

                        // Create the Alert dialog
                        AlertDialog alertDialog = View.create();
                        // Show the Alert Dialog box
                        alertDialog.show();
                    }else if (result >= 40){
                        AlertDialog.Builder View = new AlertDialog.Builder(Bmi.this);

                        View.setIcon(R.drawable.weighter);

                        // Set Alert Title
                        View.setTitle(name + " عزیز ");

                        // Set the message show for the Alert time
                        View.setMessage("شما حدود " + properweight + " کیلو اضافه وزن دارید... و دچار چاقی نوع سوم هستید ");

                        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                        View.setCancelable(false);

                        View.setNegativeButton("باشه", (DialogInterface.OnClickListener) (dialog, which) -> {
                            // If user click no then dialog box is canceled.
                            dialog.cancel();
                        });

                        // Create the Alert dialog
                        AlertDialog alertDialog = View.create();
                        // Show the Alert Dialog box
                        alertDialog.show();
                    }


                }


            }
        });


    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()){
//            case android.R.id.home:
//                this.finish();
//                return true;
//
//        }
//        return super.onOptionsItemSelected(item);
//    }
}