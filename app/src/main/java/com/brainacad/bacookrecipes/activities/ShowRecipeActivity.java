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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import com.brainacad.bacookrecipes.R;
import com.brainacad.bacookrecipes.adapters.IngredientAdapter;
import com.brainacad.bacookrecipes.adapters.StepAdapter;
import com.brainacad.bacookrecipes.classes.Recipe;
import com.brainacad.bacookrecipes.dbrealm.RecipeDbRealm;

public class ShowRecipeActivity extends Activity {

    private ShareActionProvider shareActionProvider;

    private RecyclerView ingredientsRecyclerShow;
    private RecyclerView stepRecyclerShow;
    private RecipeDbRealm cookbookRealm;
    private IngredientAdapter ingredientAdapterShow;
    private StepAdapter stepAdapterShow;

    private ImageView photoRecipeShow;
    private TextView timeRecipeShow;
    private TextView caloriesRecipeShow;
    private TextView numPortionShow;
    private CheckBox checkBoxFavouriteShow;


    public static final String ID_RECIPE = "idRecipe";
    private Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_recipe);

        cookbookRealm = new RecipeDbRealm();

        Intent intent = getIntent();
        recipe = cookbookRealm.getRecipeById(intent.getStringExtra(MainActivity.RECIPE_FOR_SHOW));

        photoRecipeShow = findViewById(R.id.show_image_recipe);
        photoRecipeShow.setImageResource(recipe.getImageRecipe());

        timeRecipeShow = findViewById(R.id.show_time_recipe);
        timeRecipeShow.setText(String.valueOf(recipe.getTimeCookingMinRecipe()));

        caloriesRecipeShow = findViewById(R.id.show_calorie_recipe);
        caloriesRecipeShow.setText(String.valueOf(recipe.getCaloriesRecipe()));

        numPortionShow = findViewById(R.id.show_portion_recipe);
        numPortionShow.setText(String.valueOf(recipe.getNumPortionRecipe()));

        checkBoxFavouriteShow = findViewById(R.id.show_is_favourite_recipe);
        checkBoxFavouriteShow.setChecked(recipe.isFavouriteRecipe());
        checkBoxFavouriteShow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cookbookRealm.setIsFavourite(recipe, isChecked);
            }
        });

        stepRecyclerShow = findViewById(R.id.show_recycler_steps);
        LinearLayoutManager layoutManagerSteps = new LinearLayoutManager(this);
        stepRecyclerShow.setLayoutManager(layoutManagerSteps);
        stepAdapterShow = new StepAdapter();
        stepAdapterShow.setSteps(recipe.getDescriptionsRecipe());
        stepRecyclerShow.setAdapter(stepAdapterShow);

        ingredientsRecyclerShow = findViewById(R.id.show_recycler_ingredients);
        LinearLayoutManager layoutManagerIngr = new LinearLayoutManager(this);
        ingredientsRecyclerShow.setLayoutManager(layoutManagerIngr);
        ingredientAdapterShow = new IngredientAdapter();
        ingredientAdapterShow.setIngredientList(recipe.getIngredientsRecipe());
        ingredientsRecyclerShow.setAdapter(ingredientAdapterShow);

        Log.d("SHOW_ACTIVITY", "onCreate: Name " + recipe.getNameRecipe());
        Log.d("SHOW_ACTIVITY", "onCreate: Ingredients " + recipe.ingredientBoolToString());
        Log.d("SHOW_ACTIVITY", "onCreate: Description " + recipe.getDescriptionsRecipe());
        Log.d("SHOW_ACTIVITY", "onCreate: Time " + recipe.getTimeCookingMinRecipe());
        Log.d("SHOW_ACTIVITY", "onCreate: Calories " + recipe.getCaloriesRecipe());
        Log.d("SHOW_ACTIVITY", "onCreate: Potions " + recipe.getNumPortionRecipe());
        Log.d("SHOW_ACTIVITY", "onCreate: isFavourite " + recipe.isFavouriteRecipe());

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
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, recipe.getNameRecipe());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(recipe.ingredientToString());
        stringBuilder.append(recipe.descriptionToString());
        intent.putExtra(Intent.EXTRA_TEXT, stringBuilder.toString());
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
