package com.brainacad.bacookrecipes.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import com.brainacad.bacookrecipes.R;
import com.brainacad.bacookrecipes.adapters.IngredientAdapter;
import com.brainacad.bacookrecipes.classes.Recipe;
import com.brainacad.bacookrecipes.dbrealm.RecipeDbRealm;

public class ShowRecipeActivity extends Activity {

    private ShareActionProvider shareActionProvider;

    private RecyclerView ingredientsRecyclerShow;
    private RecipeDbRealm cookbookRealm;
    private IngredientAdapter ingredientAdapterShow;

    private ImageView photoRecipeShow;
    private TextView descriptionRecipeShow;
    private TextView timeRecipeShow;
    private TextView caloriesRecipeShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_recipe);

        cookbookRealm = new RecipeDbRealm();

        Recipe recipe = cookbookRealm.getRecipeByName("A recipe");

        photoRecipeShow = findViewById(R.id.show_image_recipe);
        photoRecipeShow.setImageResource(recipe.getImageRecipe());

        timeRecipeShow = findViewById(R.id.show_time_recipe);
        timeRecipeShow.setText(String.valueOf(recipe.getTimeCookingMinRecipe()));

        caloriesRecipeShow = findViewById(R.id.show_calorie_recipe);
        caloriesRecipeShow.setText(String.valueOf(recipe.getCaloriesRecipe()));

        descriptionRecipeShow = findViewById(R.id.show_steps_recipe);
        descriptionRecipeShow.setText(recipe.getDescriptionRecipe());

        ingredientsRecyclerShow = findViewById(R.id.show_recycler_ingredients);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        ingredientsRecyclerShow.setLayoutManager(layoutManager);
        ingredientAdapterShow = new IngredientAdapter();
        ingredientAdapterShow.setIngredientList(recipe.getIngredientsRecipe());
        ingredientsRecyclerShow.setAdapter(ingredientAdapterShow);

        Log.d("SHOW_ACTIVITY", "onCreate: Name " + recipe.getNameRecipe());
        Log.d("SHOW_ACTIVITY", "onCreate: Ingredients " + recipe.getIngredientsRecipe());
        Log.d("SHOW_ACTIVITY", "onCreate: Description " + recipe.getDescriptionRecipe());
        Log.d("SHOW_ACTIVITY", "onCreate: Time " + recipe.getTimeCookingMinRecipe());

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
        setShareActionProviderIntent("Some text");
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionProviderIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share_recipe:

                return true;
            case R.id.action_edit_recipe:

                return true;
            case R.id.action_delete_recipe:

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
