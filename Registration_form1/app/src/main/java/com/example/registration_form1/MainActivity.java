package com.example.registration_form1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText emailAddr;
    private EditText password;
    private Button loginBtn;
    private Button register;
    private ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailAddr = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginbtn);
        register = findViewById(R.id.signupbtn);
        progressBar = findViewById(R.id.progressbar1);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                String email = emailAddr.getText().toString();
                String pass = password.getText().toString();


                    String actualpass = Registrationform.database.myDao().getPassword(email);
                    progressBar.setVisibility(View.VISIBLE);






                    if(pass.contentEquals(actualpass)){

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(v.getContext(),"Login successful",Toast.LENGTH_SHORT).show();
                                //Toast.makeText(v.getContext(),"Login successful",Toast.LENGTH_SHORT).show();

                                progressBar.setVisibility(View.GONE);

                            }
                        },3000);




                    }
                    else {
                        Toast.makeText(v.getContext(),"Invalid details",Toast.LENGTH_SHORT).show();
                    }
                }


        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Registrationform.class);
                startActivity(intent);
            }
        });



    }
}
