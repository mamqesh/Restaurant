package com.hfad.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hfad.myapplication.model.MenuDishes;
import com.hfad.myapplication.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView orders_list = findViewById(R.id.orders_list);

        List<String> dishesTitle = new ArrayList<>();
        for(MenuDishes a: MainActivity.fullDishesList){
        if(Order.items_id.contains(a.getId()))
            dishesTitle.add(a.getTitle());
        }
        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishesTitle));

    }
}