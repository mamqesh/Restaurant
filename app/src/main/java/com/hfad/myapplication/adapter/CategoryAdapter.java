package com.hfad.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.hfad.myapplication.MainActivity;
import com.hfad.myapplication.R;
import com.hfad.myapplication.model.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    List <Category> categories;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View categoryItems = LayoutInflater.from(context).inflate(R.layout.category_item, viewGroup,false);
        return new CategoryViewHolder(categoryItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {

    categoryViewHolder.categoryTitle.setText(categories.get(i).getTitle());
    categoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity.showCoursesByCategory(categories.get(i).getId());
        }
    });
    }

    @Override
    public int getItemCount() {
        return categories.size();

    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{

        TextView categoryTitle;
        public CategoryViewHolder(@NonNull View itemView) {

            super(itemView);
            categoryTitle=itemView.findViewById(R.id.categoryTitle);
        }
    }

}
