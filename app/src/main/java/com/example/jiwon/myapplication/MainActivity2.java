package com.example.jiwon.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity2 extends AppCompatActivity {
    public EditText edit_name;
    public Button bnt_print;
    public Button bnt_clear;
    public TextView view_print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);
        init();
    }

    public void init() {
        //call the widgets
        edit_name = (EditText)findViewById(R.id.ediName);
        bnt_print = (Button)findViewById(R.id.print);
        bnt_clear = (Button)findViewById(R.id.clear);
        view_print = (TextView)findViewById(R.id.printArea);
    }

    public void clearClicked(View v) {
        //if clear button clicked, set empty.
        edit_name.setText("");
    }

    public void printClicked(View v) {
        //if print button clicked, print the text.
        String text = "";
        text = edit_name.getText().toString();
       view_print.setText(text);
    }
}
