package com.hfad.myapplication;

import android.content.Intent;
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
    static MenuAdapter menuAdapter;
    static List<MenuDishes> dishList = new ArrayList<>();
    static List<MenuDishes> fullDishesList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Potato"));
        categoryList.add(new Category(2,"Pizza"));
        categoryList.add(new Category(3,"Burgers"));
        categoryList.add(new Category(4,"Desserts"));
        categoryList.add(new Category(5,"Drinks"));
        setCategoryRecycler(categoryList);


        dishList.add(new MenuDishes(1, "potatofree", "French fries","Potato sticks, 1 cm sections, fried in hot oil.", "180 gram", "1.2$","#FDE8CB", "Text", 1));
        dishList.add(new MenuDishes(2, "pizza", "Pizza","Pizza with pieces of sausage, mushrooms, lettuce and olives.", "250 gram", "1$","#FDE8CB", "Text",2));
        dishList.add(new MenuDishes(3, "pizza1", "Pizza","Pizza with pieces of sausage, tomatoes and herbs.", "220 gram", "0.8$","#FDE8CB", "Text",2));
        dishList.add(new MenuDishes(4, "pizza2", "Pizza","Pizza with cheese, pieces of sausage and olives.", "260 gram", "1.4$","#FDE8CB", "Text",2));
        dishList.add(new MenuDishes(5, "burger1", "Litle burger","A light burger for a quick bite.", "120 gram", "0.9$","#FDE8CB", "Text",3));
        dishList.add(new MenuDishes(6, "burger2", "Big burger","Great burger for a hearty snack.", "250 gram", "1.8$","#FDE8CB", "Text",3));
        dishList.add(new MenuDishes(8, "sandwich", "Sandwich","A sandwich consisting of two slices of bread with a filling in between.", "150 gram", "0.8$","#FDE8CB", "Text",3));
        dishList.add(new MenuDishes(9, "taco", "Taco","Tortilla with meat and vegetables, seasoned with aromatic spices.", "160 gram", "0.9$","#FDE8CB", "Text",3));
        dishList.add(new MenuDishes(10, "icecream", "Ice cream","Vanilla ice cream in a waffle cone", "70 gram", "0.6$","#FDE8CB", "Text",4));
        dishList.add(new MenuDishes(11, "cake", "Strawberry cake","Piece of fresh strawberry cake.", "150 gram", "1.2$","#FDE8CB", "Text",4));
        dishList.add(new MenuDishes(12, "cake1", "Cherry cake","Piece of fresh cake with cherries.", "150 gram", "1.2$","#FDE8CB", "Text",4));
        dishList.add(new MenuDishes(13, "cake2", "Chocolate muffin","Fresh, hot chocolate muffin.", "90 gram", "0.6$","#FDE8CB", "Text",4));
        dishList.add(new MenuDishes(14, "coffe", "Coffe","A tonic non-alcoholic drink prepared on the basis of roasted coffee beans.", "150 gram", "1.2$","#FDE8CB", "Text",5));
        dishList.add(new MenuDishes(15, "cherrydrink", "Cherry carbonated drink","Cherry-flavored carbonated drink.", "400 gram", "1$","#FDE8CB", "Text",5));
        dishList.add(new MenuDishes(16, "lemondrink", "Lemon carbonated drink","Lemon flavored carbonated drink.", "400 gram", "1$","#FDE8CB", "Text",5));
        dishList.add(new MenuDishes(17, "pineappledrink", "Pineapple carbonated drink","Pineapple flavored carbonated drink.", "400 gram", "1$","#FDE8CB", "Text",5));

        fullDishesList.addAll(dishList);
        setDishRecycler(dishList);
    }

    public void openShoopingCart(View view){

        Intent intent = new Intent(this,OrderPage.class);
        startActivity(intent);

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

    public static void showCoursesByCategory(int category){

        dishList.clear();
        dishList.addAll(fullDishesList);
    List<MenuDishes> filterDishes=new ArrayList<>();

    for (MenuDishes d: dishList) {
        if (d.getDish() == category)
            filterDishes.add(d);
    }
        dishList.clear();
        dishList.addAll(filterDishes);

        menuAdapter.notifyDataSetChanged();
    }


}