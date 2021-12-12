package com.hfad.myapplication.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.hfad.myapplication.DishPage;
import com.hfad.myapplication.R;
import com.hfad.myapplication.model.MenuDishes;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    Context context;
    List<MenuDishes> menuDishes;

    public MenuAdapter(Context context, List<MenuDishes> menuDishes) {
        this.context = context;
        this.menuDishes = menuDishes;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View menuItems = LayoutInflater.from(context).inflate(R.layout.menu_item, viewGroup,false);
        return new MenuAdapter.MenuViewHolder(menuItems);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MenuViewHolder menuViewHolder, int i) {

        menuViewHolder.dishBackground.setCardBackgroundColor(Color.parseColor(menuDishes.get(i).getColor()));

        int imageId=context.getResources().getIdentifier("ic_"+ menuDishes.get(i).getImg(),"drawable", context.getPackageName());
        menuViewHolder.dishImage.setImageResource(imageId);

        menuViewHolder.dishTitle.setText(menuDishes.get(i).getTitle());
        menuViewHolder.descriptionDish.setText(menuDishes.get(i).getDescription());
        menuViewHolder.weightDish.setText(menuDishes.get(i).getWeight());
        menuViewHolder.priceDish.setText(menuDishes.get(i).getPrice());

        menuViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DishPage.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity) context,
                        new Pair<View, String>(menuViewHolder.dishImage,"dishImage")
                );

                intent.putExtra("dishBackground", Color.parseColor(menuDishes.get(i).getColor()));
                intent.putExtra("dishImage", imageId);
                intent.putExtra("dishTitle", menuDishes.get(i).getTitle());
                intent.putExtra("descriptionDish", menuDishes.get(i).getDescription());
                intent.putExtra("weightDish", menuDishes.get(i).getWeight());
                intent.putExtra("priceDish", menuDishes.get(i).getPrice());
                intent.putExtra("textDish", menuDishes.get(i).getText());

                context.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuDishes.size();
    }

    public static final class MenuViewHolder extends RecyclerView.ViewHolder{

        CardView dishBackground;
        ImageView dishImage;
        TextView dishTitle, descriptionDish, weightDish, priceDish;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            dishBackground = itemView.findViewById(R.id.dishBackground);
            dishImage = itemView.findViewById(R.id.dishImage);
            dishTitle= itemView.findViewById(R.id.dishTitle);
            descriptionDish = itemView.findViewById(R.id.descriptionDish);
            weightDish = itemView.findViewById(R.id.weightDish);
            priceDish = itemView.findViewById(R.id.priceDish);
        }
    }
}
