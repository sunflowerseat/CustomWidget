package com.fancy.customwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class TestActivity extends AppCompatActivity {
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        imageview = (ImageView) findViewById(R.id.imageview);
        Glide.with(this)
                .load(getResources()
                        .getIdentifier("error_image","drawable",getPackageName()))
                .into(imageview);
    }
}
