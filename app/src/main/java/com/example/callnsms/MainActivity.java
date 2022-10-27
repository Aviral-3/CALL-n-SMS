package com.example.callnsms
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText phone,sms;
    Button button;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone=findViewById(R.id.edit1);

        sms=findViewById(R.id.mssg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SmsManager smsManager= SmsManager.getDefault();
                    smsManager.sendTextMessage(phone.getText().toString(),null,sms.getText().toString(),null,null);
                    Toast.makeText(getApplicationContext(),"SMS send succesfully",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"sms not send", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button=findViewById(R.id.button);
        imageView=findViewById(R.id.imageButton);

        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

               if (phone.getText().toString().length()==10){
                   String number=phone.getText().toString();
                   String dial = "tel:" + number;
                   startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
               }
               else {
                   phone.setText("");
                   Toast.makeText(getApplicationContext(),"Enter Valid Number", Toast.LENGTH_LONG).show();
               }
            }
        });
    }
}