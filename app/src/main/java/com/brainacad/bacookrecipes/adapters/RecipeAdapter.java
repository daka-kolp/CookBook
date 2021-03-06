package com.brainacad.bacookrecipes.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.brainacad.bacookrecipes.R;
import com.brainacad.bacookrecipes.classes.Recipe;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    //the interface is implemented in RecipeFragment
    public interface OnRecipeClickListener {
        void onItemRecipeClick(int position);
    }

    /**/
    private List<Recipe> recipeList;
    private OnRecipeClickListener listener;

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public void setRecipeListener(OnRecipeClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecipeAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_recipe_list, null);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.RecipeViewHolder holder, int position) {

        Recipe recipe = recipeList.get(position);
        holder.imageRecipe.setImageResource(recipe.getImageRecipe());
        holder.nameRecipe.setText(recipe.getNameRecipe());
        holder.timeRecipe.setText(String.valueOf(recipe.getTimeCookingMinRecipe()));
        holder.calorieRecipe.setText(String.valueOf(recipe.getCaloriesRecipe()));

    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder {

        private CardView cardRecipe;
        private ImageView imageRecipe;
        private TextView nameRecipe;
        private TextView timeRecipe;
        private TextView calorieRecipe;

        public RecipeViewHolder(View itemView) {
            super(itemView);

            cardRecipe = itemView.findViewById(R.id.recipes_card);
            imageRecipe = itemView.findViewById(R.id.recipe_image);
            nameRecipe = itemView.findViewById(R.id.recipe_name);
            timeRecipe = itemView.findViewById(R.id.recipe_time);
            calorieRecipe = itemView.findViewById(R.id.recipe_calorie);

            cardRecipe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemRecipeClick(getAdapterPosition());
                }
            });
        }
    }
}
