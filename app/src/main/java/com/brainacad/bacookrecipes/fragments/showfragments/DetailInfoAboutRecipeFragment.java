package com.brainacad.bacookrecipes.fragments.showfragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.brainacad.bacookrecipes.R;
import com.brainacad.bacookrecipes.activities.ShowRecipeActivity;
import com.brainacad.bacookrecipes.classes.Recipe;
import com.brainacad.bacookrecipes.dbrealm.RecipeDbRealm;


public class DetailInfoAboutRecipeFragment extends Fragment {

    private ImageView photoRecipeShow;
    private TextView timeRecipeShow;
    private TextView caloriesRecipeShow;
    private TextView numPortionShow;
    private CheckBox checkBoxFavouriteShow;

    private RecipeDbRealm cookbookRealm;

    private Recipe recipe;

    public DetailInfoAboutRecipeFragment() {

    }

    public static DetailInfoAboutRecipeFragment newInstance(String idRecipe) {
        DetailInfoAboutRecipeFragment fragment = new DetailInfoAboutRecipeFragment();
        Bundle args = new Bundle();
        args.putString(ShowRecipeActivity.ID_RECIPE, idRecipe);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cookbookRealm = new RecipeDbRealm();
        recipe = null;
        if (getArguments() != null) {
            String idRecipe = getArguments().getString(ShowRecipeActivity.ID_RECIPE);
            recipe = cookbookRealm.getRecipeById(idRecipe);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_info_about_recipe, container, false);
        photoRecipeShow = view.findViewById(R.id.show_image_recipe);
        photoRecipeShow.setImageResource(recipe.getImageRecipe());

        timeRecipeShow = view.findViewById(R.id.show_time_recipe);
        timeRecipeShow.setText(String.valueOf(recipe.getTimeCookingMinRecipe()));

        caloriesRecipeShow = view.findViewById(R.id.show_calorie_recipe);
        caloriesRecipeShow.setText(String.valueOf(recipe.getCaloriesRecipe()));

        numPortionShow = view.findViewById(R.id.show_portion_recipe);
        numPortionShow.setText(String.valueOf(recipe.getNumPortionRecipe()));

        checkBoxFavouriteShow = view.findViewById(R.id.show_is_favourite_recipe);
        checkBoxFavouriteShow.setChecked(recipe.isFavouriteRecipe());
        checkBoxFavouriteShow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cookbookRealm.setIsFavourite(recipe, isChecked);
            }
        });
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        cookbookRealm.close();
    }
}
