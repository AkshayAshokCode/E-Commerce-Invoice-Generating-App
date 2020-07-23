package com.example.sanvi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class Main4Activity extends AppCompatActivity {
    Button share, help;
    TextView t1,t2,t3,t5,t6,t7,date;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
       t1=findViewById((R.id.t1));
        t2=findViewById((R.id.t2));
        t3=findViewById((R.id.t3));
        t5=findViewById((R.id.t5));
        t6=findViewById((R.id.t6));
        t7=findViewById((R.id.t7));
        date=findViewById(R.id.date);
        share=findViewById(R.id.share);
        help=findViewById(R.id.help);

       Intent i=getIntent();
       Bundle b=i.getExtras();
       userID=b.getString("userID");

          /*    Intent intent = getIntent();
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("sign");
        viewBitmap.setImageBitmap(bitmap);
    */

       final DocumentReference documentReference=fStore.collection("Users").document(userID);
       documentReference.addSnapshotListener(this,new EventListener<DocumentSnapshot>() {
           @Override
           public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
               date.setText(documentSnapshot.getString("date"));
               t1.setText(documentSnapshot.getString("Customer Store"));
               t2.setText(documentSnapshot.getString("Customer Contact Name"));
               t3.setText(documentSnapshot.getString("Sales Member Name"));
               t5.setText(documentSnapshot.getString("amount"));
               t6.setText(documentSnapshot.getString("Customer Mobile"));
               t7.setText(documentSnapshot.getString("Customer Email"));
           }
       });

       share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Shared",Toast.LENGTH_SHORT).show();
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Sanvireadymix"));
                startActivity(i);

            }
        });
    }
}
