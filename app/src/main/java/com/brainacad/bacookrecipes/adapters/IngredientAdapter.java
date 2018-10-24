package com.brainacad.bacookrecipes.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.brainacad.bacookrecipes.R;
import com.brainacad.bacookrecipes.classes.Ingredient;
import com.brainacad.bacookrecipes.classes.Recipe;
import com.brainacad.bacookrecipes.dbrealm.RecipeDbRealm;

import io.realm.RealmList;
import io.realm.RealmObject;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder>{

    private RealmList<Ingredient> ingredientList;

    public void setIngredientList(RealmList<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_ingredient_list, null);
        return new IngredientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final IngredientViewHolder holder, int position) {
        Ingredient ingredient = ingredientList.get(position);
        holder.nameIngredient.setText(ingredient.getNameAndAmountIngredient());
        holder.checkIngredient.setChecked(ingredient.isIngredient());

    }

    @Override
    public int getItemCount() {
        return ingredientList.size();
    }

    class IngredientViewHolder extends RecyclerView.ViewHolder {
        private TextView nameIngredient;
        private CheckBox checkIngredient;

        public IngredientViewHolder(View itemView) {
            super(itemView);
            checkIngredient = itemView.findViewById(R.id.ingredient_check_product);
            nameIngredient = itemView.findViewById(R.id.ingredient_name_product);
            checkIngredient.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Ingredient ingredient = ingredientList.get(getAdapterPosition());
                    RecipeDbRealm recipeDbRealm = new RecipeDbRealm();
                    recipeDbRealm.setIsIngredient(ingredient, isChecked);
                    recipeDbRealm.close();
                }
            });
        }
    }

}
