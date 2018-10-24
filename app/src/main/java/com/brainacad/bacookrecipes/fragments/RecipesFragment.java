package com.brainacad.bacookrecipes.fragments;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brainacad.bacookrecipes.R;
import com.brainacad.bacookrecipes.adapters.RecipeAdapter;
import com.brainacad.bacookrecipes.classes.Recipe;
import com.brainacad.bacookrecipes.dbrealm.RecipeDbRealm;

import java.util.List;

public class RecipesFragment extends Fragment {

    // vars for getting category
    private static final String ID_CATEGORY = "id category";
    private String idCategory;
    /**/

    private OnRecipeFragmentListener mListener;

    //empty fragment's constructor
    public RecipesFragment() {
    }
    /**/

    //create new fragment in activity with args == idCategory
    public static RecipesFragment newInstance(String idCat) {
        RecipesFragment fragment = new RecipesFragment();
        Bundle args = new Bundle();
        args.putString(ID_CATEGORY, idCat);
        fragment.setArguments(args);
        return fragment;
    }
    /**/


    //create new fragment with args
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cookbookRealm = new RecipeDbRealm();
        if (getArguments() != null) {
            idCategory = getArguments().getString(ID_CATEGORY);
        }
    }
    /**/

    //create recycler view and adapter for recipes
    private RecipeAdapter recipeAdapter;
    private RecyclerView recipeRecyclerView;
    private List<Recipe> recipes;
    /**/

    //open realmDb
    private RecipeDbRealm cookbookRealm;
    /**/

    public static final String ID_FAVOURITE_RECIPE = "Favourite";

    //settings recipe's adapter
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recipes, container, false);

        recipeRecyclerView = view.findViewById(R.id.recipe_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recipeRecyclerView.setLayoutManager(layoutManager);

        if (getArguments() != null) {
            if ((getArguments().getString(ID_CATEGORY)).equals(ID_FAVOURITE_RECIPE)) {
                recipes = cookbookRealm.getFavouriteResipes();
            } else
                recipes = cookbookRealm.getAllRecipesInCategory(idCategory);
            Log.d(ID_CATEGORY, "onCreateView: " + getArguments().getString(ID_CATEGORY));
        } else {
            recipes = cookbookRealm.getAllRecipes();
        }


        recipeAdapter = new RecipeAdapter();
        recipeAdapter.setRecipeList(recipes);
        recipeAdapter.setRecipeListener(recipeClickListener);

        recipeRecyclerView.setAdapter(recipeAdapter);

        return view;
    }
    /**/

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Recipe recipe) {
        if (mListener != null) {
            mListener.onRecipeClick(recipe);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRecipeFragmentListener) {
            mListener = (OnRecipeFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnRecipeFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        //close realmDb
        cookbookRealm.close();
        /**/
    }

    //the interface is implemented in MainActivity
    public interface OnRecipeFragmentListener {
        void onRecipeClick(Recipe recipe);
    }
    /**/

    //listener between RecipeAdapter and RecipeFragment
    private RecipeAdapter.OnRecipeClickListener recipeClickListener = new RecipeAdapter.OnRecipeClickListener() {
        @Override
        public void onItemRecipeClick(int position) {
            mListener.onRecipeClick(recipes.get(position));
        }
    };
    /**/
}
