package com.example.sanvi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3,e6;
Button next;
EditText mobile;
    String number;
    String c1,c2,c3,c4,c6;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        next= findViewById(R.id.help);
        mobile=findViewById(R.id.editText5);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        e3=findViewById(R.id.editText3);
        e6=findViewById(R.id.editText6);



        final HashMap<String,String> user= new HashMap<>();


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1=e1.getText().toString();
                c2=e2.getText().toString();
                c3=e3.getText().toString();
                c6=e6.getText().toString();
                number = mobile.getText().toString();
       /*         if(TextUtils.isEmpty(c1) || TextUtils.isEmpty(c2) ||
                        TextUtils.isEmpty(c3) || TextUtils.isEmpty(c4) || TextUtils.isEmpty(number) ||
                        TextUtils.isEmpty(c6))
                    Toast.makeText(getApplicationContext(), "All Fields are Mandatory", Toast.LENGTH_SHORT).show();
                 else if(number.length()!=13)
                    Toast.makeText(getApplicationContext(), "Invalid Number", Toast.LENGTH_SHORT).show();
                else */{
                    user.put("Customer Store",c1);
                    user.put("Sales Member Name",c2);
                    user.put("Customer Contact Name",c3);
                    user.put("Customer Mobile",number);
                    user.put("Customer Email",c6);
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    i.putExtra("number", number);
                   i.putExtra("data", user);
                    startActivity(i);
                }
            }
        });

    }

}
