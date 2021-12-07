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
        categoryList.add(new Category(1,"Text"));
        categoryList.add(new Category(2,"Text"));
        categoryList.add(new Category(3,"Text"));
        categoryList.add(new Category(4,"Text"));
        categoryList.add(new Category(5,"Text"));
        categoryList.add(new Category(6,"Text"));
        setCategoryRecycler(categoryList);

        List<MenuDishes> dishList = new ArrayList<>();
        dishList.add(new MenuDishes(1, "salad1", "Light salad","A salad that contains red onions,\ntomatoes, cabbage, a boiled egg.\nSuitable for a light snack.", "150 gram", "27 645 UZS","#F58F56"));
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