package com.brainacad.bacookrecipes.activities;


import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.app.ActionBar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

import com.brainacad.bacookrecipes.R;
import com.brainacad.bacookrecipes.classes.Recipe;
import com.brainacad.bacookrecipes.dbrealm.RecipeDbRealm;
import com.brainacad.bacookrecipes.fragments.showrecipefragments.DetailInfoAboutRecipeFragment;
import com.brainacad.bacookrecipes.fragments.showrecipefragments.IngredientsRecipeFragment;
import com.brainacad.bacookrecipes.fragments.showrecipefragments.StepsRecipeFragment;

public class ShowRecipeActivity extends Activity {
    //for log
    private static final String SHOW_ACTIVITY = "SHOW_ACTIVITY";
    /**/
    private ShareActionProvider shareActionProvider;

    private RecipeDbRealm cookbookRealm;

    private DetailInfoAboutRecipeFragment fragmentDetail;
    private IngredientsRecipeFragment fragmentIngredient;
    private StepsRecipeFragment fragmentStep;


    public static final String ID_RECIPE = "idRecipe";
    private Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        cookbookRealm = new RecipeDbRealm();

        Intent intent = getIntent();
        recipe = cookbookRealm.getRecipeById(intent.getStringExtra(MainActivity.RECIPE_FOR_SHOW));

        fragmentDetail = DetailInfoAboutRecipeFragment.newInstance(recipe.getIdRecipe());
        fragmentIngredient = IngredientsRecipeFragment.newInstance(recipe.getIdRecipe());
        fragmentStep = StepsRecipeFragment.newInstance(recipe.getIdRecipe());

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.detail_info_fragment, fragmentDetail)
                .replace(R.id.ingredients_recipe_fragment, fragmentIngredient)
                .replace(R.id.steps_recipe_fragment, fragmentStep)
                .commit();

        Log.d(SHOW_ACTIVITY, "onCreate: Name " + recipe.getNameRecipe());
        Log.d(SHOW_ACTIVITY, "onCreate: Description " + recipe.getIngredientsRecipe());
        Log.d(SHOW_ACTIVITY, "onCreate: Ingredients " + recipe.ingredientBoolToString());
        Log.d(SHOW_ACTIVITY, "onCreate: Description " + recipe.getDescriptionsRecipe());
        Log.d(SHOW_ACTIVITY, "onCreate: Time " + recipe.getTimeCookingMinRecipe());
        Log.d(SHOW_ACTIVITY, "onCreate: Calories " + recipe.getCaloriesRecipe());
        Log.d(SHOW_ACTIVITY, "onCreate: Potions " + recipe.getNumPortionRecipe());
        Log.d(SHOW_ACTIVITY, "onCreate: isFavourite " + recipe.isFavouriteRecipe());

        //add button "Up" and title to action bar
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(recipe.getNameRecipe());
        }
        /**/

    }

    //create options menu for recipe activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recipe_option_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share_recipe);
        shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        setShareActionProviderIntent();
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionProviderIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(recipe.getNameRecipe())
                .append("\n")
                .append(recipe.ingredientToString())
                .append(recipe.descriptionToString());
        intent.putExtra(Intent.EXTRA_TEXT, stringBuilder.toString());
        intent.setType("text/plain");
        shareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share_recipe:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    /**/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cookbookRealm.close();
    }
}
