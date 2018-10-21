package com.brainacad.bacookrecipes.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.brainacad.bacookrecipes.R;
import com.brainacad.bacookrecipes.classes.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<Category> listCategory;

    public List<Category> getListCategory() {
        return listCategory;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_category_list, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Category cat = listCategory.get(position);
        holder.imageCat.setImageResource(cat.getImageCategory());
        holder.nameCat.setText(cat.getNameCategory());

    }

    @Override
    public int getItemCount() {
        return listCategory.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageCat;
        private TextView nameCat;

        public ViewHolder(View itemView) {
            super(itemView);
            imageCat = itemView.findViewById(R.id.image_category);
            nameCat = itemView.findViewById(R.id.name_category);
        }
    }
}
