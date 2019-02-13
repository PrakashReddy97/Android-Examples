package com.example.registration_form1;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrationform extends AppCompatActivity {

    private EditText nameEntered;
    private EditText emailEntered;
    private EditText passEntered;
    private Button createbtn;
    private Button loginbtn1;

    public static MyDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationform);

        nameEntered = findViewById(R.id.nameentered);
        emailEntered = findViewById(R.id.emailentered);
        passEntered = findViewById(R.id.passwordentered);

        createbtn = findViewById(R.id.createbtn);
        loginbtn1 = findViewById(R.id.loginbtn1);

        database = Room.databaseBuilder(this,MyDatabase.class,"userdb").allowMainThreadQueries().build();

        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = nameEntered.getText().toString();
                String email = emailEntered.getText().toString();
                String password = passEntered.getText().toString();

                User user = new User();
                user.setName(username);
                user.setEmailaddress(email);
                user.setPassword(password);

                database.myDao().addUser(user);

                Toast.makeText(getApplicationContext(),"Registered",Toast.LENGTH_SHORT).show();





            }
        });
        loginbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
