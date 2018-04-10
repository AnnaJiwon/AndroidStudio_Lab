package com.example.jiwon.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Myactivity extends AppCompatActivity {
    EditText Name;
    EditText Age;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Name = (EditText) findViewById(R.id.editText1);
        Age = (EditText) findViewById(R.id.editText2);
        button1 = (Button) findViewById(R.id.addButton);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserName = Name.getText().toString();
                String UserAge = Age.getText().toString();

                Intent intent = new Intent (getApplicationContext(), NewActivity.class);
                intent.putExtra("loginName", UserName);
                intent.putExtra("loginAge", UserAge);
                startActivity(intent);
            }
        });
    }
}
