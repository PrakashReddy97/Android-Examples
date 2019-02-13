package com.example.prakash.firstexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
    }

    public void sendMessage(View view){

        et1 = (EditText)findViewById(R.id.editText1);

        et2 = (EditText)findViewById(R.id.editText2);

        btn = (Button)findViewById(R.id.button1);

                int num1 = Integer.parseInt(et1.getText().toString());
                int num2 = Integer.parseInt(et2.getText().toString());

                int sum = num1 + num2;
                String result = String.valueOf(sum);
                Intent intent = new Intent(this,Main2Activity.class);


                intent.putExtra("EXTRA_MESSAGE",result);
                startActivity(intent);



            }


    }


