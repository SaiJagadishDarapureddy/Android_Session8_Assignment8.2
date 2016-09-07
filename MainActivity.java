package com.example.admin.formsharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edittextname;
    EditText edittextage;
    EditText edittextphone;
    EditText edittextcity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittextname = (EditText) findViewById(R.id.edit_name);
        edittextage = (EditText) findViewById(R.id.edit_age);
        edittextphone = (EditText) findViewById(R.id.edit_phone);
        edittextcity = (EditText) findViewById(R.id.edit_city);

        Button savebutton = (Button) findViewById(R.id.button_save);
        Button showbutton = (Button) findViewById(R.id.button_show);

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences =getSharedPreferences("prefs",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("myname",edittextname.getText().toString());
                editor.putString("myage",edittextage.getText().toString());
                editor.putString("myphone",edittextphone.getText().toString());
                editor.putString("mycity",edittextcity.getText().toString());

                editor.commit();

            }
        });
        showbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences =getSharedPreferences("prefs",MODE_PRIVATE);
                String username = sharedPreferences.getString("myname","No value found");
                String userage=sharedPreferences.getString("myage","No age found");
                String userphone=sharedPreferences.getString("myphone","No phone found");
                String usercity=sharedPreferences.getString("mycity","No city found");

                Toast.makeText(MainActivity.this,"Name : "+username+" Age : "+userage+" Phone : "+userphone+" City : "+usercity,Toast.LENGTH_SHORT).show();
            }
        });

    }


}