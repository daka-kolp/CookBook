package com.brainacad.bacookrecipes.fragments;

import android.net.Uri;
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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecipesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecipesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipesFragment extends Fragment {

    // vars for getting category
    private static final String ID_CATEGORY = "id category";
    private String idCategory;
    /**/

    private OnFragmentInteractionListener mListener;

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
    /**/

    //open realmDb
    private RecipeDbRealm cookbookRealm;
    /**/

    //settings recipes' adapter
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recipes, container, false);

        recipeRecyclerView = view.findViewById(R.id.recipe_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recipeRecyclerView.setLayoutManager(layoutManager);
        List<Recipe> recipes = null;

        if (getArguments() != null) {
            recipes = cookbookRealm.getAllRecipesInCategory(idCategory);
            Log.d(ID_CATEGORY, "onCreateView: " + getArguments().getString(ID_CATEGORY));
        } else
            recipes = cookbookRealm.getAllRecipes();


        recipeAdapter = new RecipeAdapter();
        recipeAdapter.setRecipeList(recipes);

        recipeRecyclerView.setAdapter(recipeAdapter);

        return view;
    }
    /**/

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        //close realmDb
        cookbookRealm.close();
        /**/
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
