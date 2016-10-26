package com.example.goku.swe_main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class Add_contacts extends AppCompatActivity {

    EditText number1,number2,number3,number4,name1,name2,name3,name4;
    Button Add_contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);
        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);
        number3 = (EditText) findViewById(R.id.number3);
        number4 = (EditText) findViewById(R.id.number4);
        name1 = (EditText) findViewById(R.id.name1);
        name2 = (EditText) findViewById(R.id.name2);
        name3 = (EditText) findViewById(R.id.name3);
        name4 = (EditText) findViewById(R.id.name4);
        Add_contacts = (Button) findViewById(R.id.add_contacts);


        Add_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contacts contacts = new Contacts(getApplicationContext());
                final Firebase fire = new Firebase("https://swemain-de53c.firebaseio.com/contacts/");
                contacts.setContact1(number1.getText().toString());
                contacts.setContact2(number2.getText().toString());
                contacts.setContact3(number3.getText().toString());
                contacts.setContact4(number4.getText().toString());
                contacts.setPerson1(name1.getText().toString());
                contacts.setPerson2(name2.getText().toString());
                contacts.setPerson3(name3.getText().toString());
                contacts.setPerson4(name4.getText().toString());
                User user = new User(getApplicationContext());
                final String UserName = user.getUsername();
                System.out.println("Username :" +UserName);

                if (contacts.getContact1().length() ==10)
                {
                    if (contacts.getContact2().length() ==10)
                    {
                        if (contacts.getContact3().length() ==10)
                        {
                            if (contacts.getContact4().length() ==10)
                            {
                                fire.child(UserName).setValue(contacts);

                                System.out.println("Username :" +UserName);


                                Intent intent1 = new Intent(Add_contacts.this,Home.class);

                                startActivity(intent1);
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Enter correct contact 4 number",Toast.LENGTH_LONG).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Enter correct contact 3 number",Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Enter correct contact 2 number",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Enter correct contact 1 number",Toast.LENGTH_LONG).show();
                }

            }


        });



    }
}
