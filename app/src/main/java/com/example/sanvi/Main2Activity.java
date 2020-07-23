package com.example.sanvi;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG ="TAG";
    EditText e7;
    Button back;
    Button next;
    ImageButton dateButton;
    TextView dateText;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    String phoneNumber;
    Spinner mySpinner;
    String type;
    String date;
    String amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        back=findViewById(R.id.back2);
        next=findViewById(R.id.next2);
        dateButton=findViewById(R.id.dateButton);
        dateText=findViewById(R.id.dateText);
        e7=findViewById(R.id.editText7);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        phoneNumber=b.getString("number");
        final HashMap<String, String> user = (HashMap<String, String>)i.getSerializableExtra("data");


        dateButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                calendar=Calendar.getInstance();
                year=calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog=new DatePickerDialog(Main2Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateText.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },year,month,dayOfMonth);
                datePickerDialog.show();

            }
        });


        mySpinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(Main2Activity.this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.vertification));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(i);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount=e7.getText().toString();
                date=dateText.getText().toString();

                      if (TextUtils.isEmpty(amount) || TextUtils.isEmpty(date))
                Toast.makeText(getApplicationContext(),"All Fields are Mandatory",Toast.LENGTH_SHORT).show();
        else {
                    type = mySpinner.getSelectedItem().toString();
                    user.put("date",date);
                    user.put("amount", amount);

                  if (type.equals("Mobile OTP")) {
                        Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                        i.putExtra("number", phoneNumber);
                        i.putExtra("data",user);
                        startActivity(i);

                    }
                }
            }
        });



    }
}
