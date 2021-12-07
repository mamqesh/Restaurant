package com.hfad.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.hfad.myapplication.R;
import java.util.List;
import com.hfad.myapplication.model.MenuDishes;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    Context context;
    List<Menu> dishes;

    public MenuAdapter(Context context, List<Menu> dishes) {
        this.context = context;
        this.dishes = dishes;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View menuItems = LayoutInflater.from(context).inflate(R.layout.menu_item, viewGroup,false);
        return new MenuAdapter.MenuViewHolder(menuItems);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MenuViewHolder menuViewHolder, int i) {

        menuViewHolder.dishBackground.setCardBackgroundColor(Color.parseColor(dishes.get(i).getColor()));
        int imageId=context.getResources().getIdentifier("ic_"+dishes.get(i).getImg(),"drawable", context.getPackageName());
        menuViewHolder.dishImage.setImageResource(imageId);
        menuViewHolder.dishTitle.setText(dishes.get(i).getTitile());
        menuViewHolder.descriptionDish.setText(dishes.get(i).getDescription());
        menuViewHolder.weightDish.setText(dishes.get(i).getDish());
        menuViewHolder.priceDish.setText(dishes.get(i).getPrice());
    }

    @Override
    public int getItemCount() {
        return dishes.size();
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