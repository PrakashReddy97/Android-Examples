package com.example.prakash.retrofitexample;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Namechange_activity extends AppCompatActivity {
    public EditText namechange;
    public Button savebtn;
    public static MyDatabase database;
    Heromodel hero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namechange_activity);

        namechange = (EditText) findViewById(R.id.editname);
        savebtn = (Button) findViewById(R.id.savebtn1);

        final Intent intent = getIntent();
        final Heromodel model = intent.getParcelableExtra("model");
        namechange.setText(model.getName());
        database = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "userdb").allowMainThreadQueries().build();
        Log.d("TAG", "Inside on click : " + model.getName());
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = database.myDao().updateUser(model.getName(), namechange.getText().toString());
                Log.d("TAG", "Inside on click : " + id);
                finish();
            }
        });


    }


}
