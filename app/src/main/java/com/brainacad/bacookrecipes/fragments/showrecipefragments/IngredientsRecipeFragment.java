package com.brainacad.bacookrecipes.fragments.showrecipefragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brainacad.bacookrecipes.R;
import com.brainacad.bacookrecipes.activities.ShowRecipeActivity;
import com.brainacad.bacookrecipes.adapters.IngredientAdapter;
import com.brainacad.bacookrecipes.classes.Recipe;
import com.brainacad.bacookrecipes.dbrealm.RecipeDbRealm;

public class IngredientsRecipeFragment extends Fragment {

    private RecyclerView ingredientsRecyclerShow;
    private IngredientAdapter ingredientAdapterShow;

    private RecipeDbRealm cookbookRealm;

    private Recipe recipe;

    public IngredientsRecipeFragment() {
        // Required empty public constructor
    }

    public static IngredientsRecipeFragment newInstance(String idRecipe){
        IngredientsRecipeFragment fragment = new IngredientsRecipeFragment();
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

        View view = inflater.inflate(R.layout.fragment_ingerdients_recipe, container, false);
        ingredientsRecyclerShow = view.findViewById(R.id.show_recycler_ingredients);
        LinearLayoutManager layoutManagerIngr = new LinearLayoutManager(getActivity());
        ingredientsRecyclerShow.setLayoutManager(layoutManagerIngr);
        ingredientAdapterShow = new IngredientAdapter();
        ingredientAdapterShow.setIngredientList(recipe.getIngredientsRecipe());
        ingredientsRecyclerShow.setAdapter(ingredientAdapterShow);
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        cookbookRealm.close();
    }
}
