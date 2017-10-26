package com.example.samim.to_do_application;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.media.audiofx.AudioEffect;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import static android.R.attr.dial;
import static android.provider.MediaStore.Files.FileColumns.TITLE;
import static android.provider.MediaStore.Video.VideoColumns.DESCRIPTION;
import static java.util.Calendar.DATE;

public class MainActivity extends AppCompatActivity {



   private DataBase dataBase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dataBase=new DataBase(this);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

   @Override
   public boolean onOptionsItemSelected(MenuItem item){
       switch (item.getItemId()){
           case R.id.add:
               final Dialog dialog=new Dialog(MainActivity.this);
               dialog.setContentView(R.layout.dilog);
               dialog.show();

               Button save=(Button)dialog.findViewById(R.id.btnSave);
               Button cancel=(Button)dialog.findViewById(R.id.btnCancel);

               final EditText Description=(EditText)dialog.findViewById(R.id.edDescription);
               final EditText Titel=(EditText)dialog.findViewById(R.id.edTitel);
               final DatePicker datePicker=(DatePicker)dialog.findViewById(R.id.datePicker);
               int day=datePicker.getDayOfMonth();
               int month=datePicker.getMonth();
               int year=datePicker.getYear();
               String DATE=day+" / "+month+" / "+year;



               save.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                      boolean result= dataBase.insertDeta
                              (Description.getText().toString(),DATE.getText().toString);


                       if(result) {

                           Toast.makeText(getApplicationContext(),"Add Item", Toast.LENGTH_SHORT).show();
                           dialog.dismiss();
                       }else {
                           Toast.makeText(getApplicationContext(),"Add is failed",Toast.LENGTH_SHORT).show();
                       }
                   }

               });

               cancel.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                   }
               });



return true;

       }

       return super.onOptionsItemSelected(item);
   }




}
