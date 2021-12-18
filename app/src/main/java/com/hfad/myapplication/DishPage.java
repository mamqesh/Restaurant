package com.hfad.myapplication;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.myapplication.model.Order;

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

    public void addToCart(View view){
        int item_id = getIntent().getIntExtra("dishID",0);
        Order.items_id.add(item_id);
        Toast.makeText(this,"Dish has been added to your cart!", Toast.LENGTH_LONG).show();

    }

}