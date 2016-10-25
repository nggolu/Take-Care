package com.example.goku.swe_main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class Add_message extends AppCompatActivity {

    EditText info_msg,alert_msg;
    Button add_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_message);

        info_msg = (EditText) findViewById(R.id.info_msg);
        alert_msg = (EditText) findViewById(R.id.alert_msg);
        add_msg = (Button) findViewById(R.id.add_msg);

        final Firebase fire = new Firebase("https://swemain-de53c.firebaseio.com/message/");

        add_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg = new Message();

                msg.setInformation_msg(info_msg.getText().toString());
                msg.setAlert_msg(alert_msg.getText().toString());
                Intent intent = getIntent();
                String username = intent.getExtras().getString("username");
                String email = intent.getExtras().getString("email");
                String Name = intent.getExtras().getString("name");
                String password = intent.getExtras().getString("password");
                System.out.println("Username: "+  username + "password : " + password);

                fire.child(username).setValue(msg);


               msg.setAlert_msg(alert_msg.getText().toString());
                msg.setInformation_msg(info_msg.getText().toString());
                Intent intent1 = new Intent(Add_message.this,Add_contacts.class);
                startActivity(intent1);
            }


        });

    }
}
