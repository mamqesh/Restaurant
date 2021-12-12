package com.hfad.myapplication;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DishPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_page);
        ConstraintLayout dishBackground = findViewById(R.id.dishPageBackground);
        ImageView dishImage = findViewById(R.id.dishPageImage);
        TextView dishTitle = findViewById(R.id.dishPageTitle);
        TextView dishWeight = findViewById(R.id.dishPageWeight);
        TextView dishPrice = findViewById(R.id.dishPagePrice);
        TextView dishDescription = findViewById(R.id.dishPageDiscription);

        dishBackground.setBackgroundColor(getIntent().getIntExtra("dishBackground",0));
        dishImage.setImageResource(getIntent().getIntExtra("dishImage",0));
        dishTitle.setText(getIntent().getStringExtra("dishTitle"));
        dishWeight.setText(getIntent().getStringExtra("weightDish"));
        dishPrice.setText(getIntent().getStringExtra("priceDish"));
        dishDescription.setText(getIntent().getStringExtra("descriptionDish"));
    }
}