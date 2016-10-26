package com.example.goku.swe_main;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    ImageView send_info, send_alert;
    Button police_staion,danger_zone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        send_alert =  (ImageView) findViewById(R.id.panic);

        send_info = (ImageView) findViewById(R.id.inform);
        send_alert.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                send_alert_SMS();
            }
        });
        send_info.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                send_info_SMS();
            }
        });
        police_staion = (Button) findViewById(R.id.police_staion);
        police_staion.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                Toast.makeText(Home.this, "Showing the Police station..", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Home.this, Danger_Zone.class);
                startActivity ( intent );
            }
        });
        danger_zone = (Button) findViewById(R.id.danger);
        danger_zone.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                Toast.makeText(Home.this, "Showing the danger zone.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Home.this, Danger_Zone.class);
                startActivity ( intent );

            }
        });
    }

    protected void send_alert_SMS(){
        Log.i("Send SMS","");
        Contacts contacts = new Contacts(getApplicationContext());

        Message msg = new Message(getApplicationContext());

        String contact1 =contacts.getContact1();
        String contact2 =contacts.getContact2();
        String contact3 =contacts.getContact3();
        String contact4 =contacts.getContact4();
        String alert_msg = msg.getAlert_msg();


        try{
            SmsManager smsManager =SmsManager.getDefault();
            smsManager.sendTextMessage(contact1 ,null,alert_msg,null,null);
            smsManager.sendTextMessage(contact2 ,null,alert_msg,null,null);
            smsManager.sendTextMessage(contact3 ,null,alert_msg,null,null);
            smsManager.sendTextMessage(contact4 ,null,alert_msg,null,null);
            Toast.makeText(getApplicationContext(),"Alert Message send ...",Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"SMS failed :/",Toast.LENGTH_LONG).show();
        }
    }

    protected void send_info_SMS(){
        Log.i("Send SMS","");
        Contacts contacts = new Contacts(getApplicationContext());
        Message msg = new Message(getApplicationContext());
        String contact1 =contacts.getContact1();
        String contact2 =contacts.getContact2();
        String contact3 =contacts.getContact3();
        String contact4 =contacts.getContact4();
        String informa_msg = msg.getInformation_msg();

        try{
            SmsManager smsManager =SmsManager.getDefault();
            smsManager.sendTextMessage(contact1 ,null,informa_msg ,null,null);
            smsManager.sendTextMessage(contact2 ,null,informa_msg,null,null);
            smsManager.sendTextMessage(contact3 ,null,informa_msg,null,null);
            smsManager.sendTextMessage(contact4 ,null,informa_msg,null,null);
            Toast.makeText(getApplicationContext(),"Inform message has been send ... ",Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"SMS failed :/",Toast.LENGTH_LONG).show();
        }
    }
}

