package com.hfad.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hfad.myapplication.adapter.CategoryAdapter;
import com.hfad.myapplication.adapter.MenuAdapter;
import com.hfad.myapplication.model.Category;
import com.hfad.myapplication.model.MenuDishes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, menuRecycler;
    CategoryAdapter categoryAdapter;
    MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Pizza"));
        categoryList.add(new Category(2,"Potato"));
        categoryList.add(new Category(3,"Drinks"));
        categoryList.add(new Category(4,"Desserts"));
        categoryList.add(new Category(5,"Burgers"));
        setCategoryRecycler(categoryList);

        List<MenuDishes> dishList = new ArrayList<>();
        dishList.add(new MenuDishes(1, "potatofree", "French fries","Potato sticks, 1 cm sections, fried in hot oil.", "180 gram", "1.2$","#F58F56", "Text"));
        dishList.add(new MenuDishes(2, "pizza", "Pizza","A dish in the form of a thin round flatbread baked with tomato sauce filling, slices of cheese and sausage.", "250 gram", "1$","#F58F56", "Text"));
        dishList.add(new MenuDishes(3, "sandwich", "Sandwich","A sandwich consisting of two slices of bread with a filling in between.", "150 gram", "0.8$","#F58F56", "Text"));
        dishList.add(new MenuDishes(4, "coffe", "Coffe","A tonic non-alcoholic drink prepared on the basis of roasted coffee beans", "200 gram", "1.2$","#F58F56", "Text"));
        setDishRecycler(dishList);
    }

    private void setDishRecycler(List<MenuDishes> dishList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
        menuRecycler=findViewById(R.id.menuRecycler);
        menuRecycler.setLayoutManager(layoutManager);
        menuAdapter=new MenuAdapter(this,dishList);
        menuRecycler.setAdapter(menuAdapter);
    }


    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
        categoryRecycler=findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }


    public void btnmap(View view) {
    }

    public void btnaccount(View view) {
    }

    public void btnorder(View view) {
    }

    public void btnsettings(View view) {
    }

    public void btnwatch(View view) {
    }
}