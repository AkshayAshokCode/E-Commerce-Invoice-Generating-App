package com.example.sanvi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.gcacace.signaturepad.views.SignaturePad;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

public class Main3bActivity extends AppCompatActivity {
    Button next;
    Button back;
    SignaturePad signaturePad;
    Button saveButton, clearButton;
    Bitmap signature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3b);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        next=findViewById(R.id.next2);
        back=findViewById(R.id.back2);
        signaturePad = findViewById(R.id.signaturePad);
        saveButton = findViewById(R.id.saveButton);
        clearButton = findViewById(R.id.clearButton);
        saveButton.setEnabled(false);
        clearButton.setEnabled(false);
        signaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {

            @Override
            public void onStartSigning() {
            }

            @Override
            public void onSigned() {
                saveButton.setEnabled(true);
                clearButton.setEnabled(true);
            }

            @Override
            public void onClear() {
                saveButton.setEnabled(false);
                clearButton.setEnabled(false);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signature=signaturePad.getSignatureBitmap();
                Toast.makeText(getApplicationContext(), "Signature Saved", Toast.LENGTH_SHORT).show();

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signaturePad.clear();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signature=signaturePad.getSignatureBitmap();
                Intent i = new Intent(Main3bActivity.this, Main4bActivity.class);
           //    i.putExtra("sign",signature);
                startActivity(i);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main3bActivity.this, Main2Activity.class);
                startActivity(i);

            }
        });
    }
}
