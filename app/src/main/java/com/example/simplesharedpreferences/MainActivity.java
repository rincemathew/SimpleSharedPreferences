package com.example.simplesharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name,number;
    Button save,retrieve,clear,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        number=findViewById(R.id.number);
        save=findViewById(R.id.save);
        retrieve=findViewById(R.id.retrieve);
        clear=findViewById(R.id.clear);
        delete=findViewById(R.id.delete);

        final String Name = "nameKey";
        final String Number = "numberKey";

       // Initialization

        final SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        final SharedPreferences.Editor editor = pref.edit();



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Storing Data
                String n = name.getText().toString();
                String e = number.getText().toString();

                editor.putString(Name, n);
                editor.putString(Number, e);
                editor.commit();
            }
        });
        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Retrieving Data
                name.setText(pref.getString(Name, ""));
                number.setText(pref.getString(Number, ""));
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Clearing the TextView
                name.setText("");
                number.setText("");
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Clearing or Deleting Data


//                editor.clear();
//                editor.commit();

                //or

                editor.remove("nameKey");
                editor.remove("numberKey");
                editor.commit();

            }
        });


    }
}
