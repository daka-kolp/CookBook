package com.brainacad.bacookrecipes.fragments.showfragments;


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
import com.brainacad.bacookrecipes.adapters.StepAdapter;
import com.brainacad.bacookrecipes.classes.Recipe;
import com.brainacad.bacookrecipes.dbrealm.RecipeDbRealm;


public class StepsRecipeFragment extends Fragment {

    private RecyclerView stepRecyclerShow;
    private RecipeDbRealm cookbookRealm;
    private StepAdapter stepAdapterShow;

    private Recipe recipe;

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

    public StepsRecipeFragment() {
    }

    public static StepsRecipeFragment newInstance(String idRecipe){
        StepsRecipeFragment fragment = new StepsRecipeFragment();
        Bundle args = new Bundle();
        args.putString(ShowRecipeActivity.ID_RECIPE, idRecipe);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_steps_recipe, container, false);
        stepRecyclerShow = view.findViewById(R.id.show_recycler_steps);
        LinearLayoutManager layoutManagerSteps = new LinearLayoutManager(getActivity());
        stepRecyclerShow.setLayoutManager(layoutManagerSteps);
        stepAdapterShow = new StepAdapter();
        stepAdapterShow.setSteps(recipe.getDescriptionsRecipe());
        stepRecyclerShow.setAdapter(stepAdapterShow);
        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        cookbookRealm.close();
    }
}
