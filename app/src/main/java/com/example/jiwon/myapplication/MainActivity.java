package com.example.jiwon.myapplication;

import android.content.Context;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout container;
    ImageView imageView;
    ImageView imageView2;
    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //call the image.
        imageView = (ImageView)findViewById(R.id.image1);
        imageView2 = (ImageView)findViewById(R.id.image2);
    }

    public void onButton1Clicked(View v) {
        //if button clicked, change the image.
        changedImage();
    }

    private void changedImage() {
        if(imageView2.getVisibility() == View.VISIBLE) { // if background is image2, change to image1.
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
        }
        else if(imageView.getVisibility() == View.VISIBLE) { // if background is image1, change to image2.
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);

        }
    }
}

