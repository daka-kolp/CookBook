package com.brainacad.bacookrecipes.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.brainacad.bacookrecipes.R;
import com.brainacad.bacookrecipes.classes.Category;
import com.brainacad.bacookrecipes.classes.Recipe;
import com.brainacad.bacookrecipes.dbrealm.RecipeDbRealm;
import com.brainacad.bacookrecipes.fragments.RecipesFragment;
import com.brainacad.bacookrecipes.fragments.dialogs.CloseDialogFragment;
import com.brainacad.bacookrecipes.interfaces.OnDialogExitClickListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements RecipesFragment.OnRecipeFragmentListener {
    //for log
    private static final String MAIN_ACTIVITY = "MAIN_ACTIVITY";
    /**/
    private RecipeDbRealm cookbookRealm;

    private RecipesFragment fragment;

    private DrawerLayout mainDrawerLayout;
    private ActionBarDrawerToggle mainToggle;
    private ListView categoryListView;

    //for ListView to fill categories' names
    private List<String> namesCategories;
    private List<Category> categories;
    /**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadSharedPreference();

        cookbookRealm = new RecipeDbRealm();

        //settings drawerLayout
        mainDrawerLayout = findViewById(R.id.main_drawer_layout);
        categoryListView = findViewById(R.id.list_view_category);
        categoryListView.setOnItemClickListener(new DrawerItemClickListener());

        fillCategoryList();

        categoryListView.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_activated_1,
                namesCategories
        ));
        /**/

        //settings for drawerListener(creating ActionbarDrawerToggle)
        mainToggle = new ActionBarDrawerToggle(this, mainDrawerLayout, R.string.open_drawer, R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();//the method invokes onPrepareOptionsMenu()

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();//the method invokes onPrepareOptionsMenu()

            }
        };
        mainDrawerLayout.setDrawerListener(mainToggle);
        /**/

        //create button "Up" for actionBar + listView
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        /**/

        selectItem(currentPosition);
    }

    //fill ArrayList by categories
    private void fillCategoryList() {
        namesCategories = new ArrayList<String>();
        namesCategories.add(getResources().getString(R.string.favourite_recipes));
        namesCategories.add(getResources().getString(R.string.all_recipes));
        categories = cookbookRealm.getAllCategories();
        for (Category c : categories) {
            namesCategories.add(c.getNameCategory());
        }
        //for log
        for(String c : namesCategories){
            Log.d(MAIN_ACTIVITY, "fillCategoryList: " + c);
        }
        /**/
    }
    /**/

    //SharedPreference for changing of fragments
    public static final String CURRENT_FRAG_POSITION = "current position";
    private int currentPosition;

    private void saveSharedPreference() {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(CURRENT_FRAG_POSITION, currentPosition);
        editor.apply();
    }

    private void loadSharedPreference() {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        currentPosition = sharedPreferences.getInt(CURRENT_FRAG_POSITION, 1);
    }
    /**/

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mainToggle.syncState();//to change state of icon of button "Up" when drawerLayout is opened or closed
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mainToggle.onConfigurationChanged(newConfig);//every changes of device config send to ActionBarDrawerToggle
    }

    //class-listener for listView
    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }
    /**/

    //chooser for listView
    private void selectItem(int position) {
        Category category;
        switch (position) {
            case 0:
                fragment = RecipesFragment.newInstance(RecipesFragment.ID_FAVOURITE_RECIPE);
                break;
            case 1:
                fragment = new RecipesFragment();
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                String nameCat = (String) categoryListView.getItemAtPosition(position);
                category = cookbookRealm.getCategoryByName(nameCat);
                fragment = RecipesFragment.newInstance(category.getIdCategory());

                Log.d(MAIN_ACTIVITY, "nameCategory in List: " + nameCat);
                Log.d(MAIN_ACTIVITY, "nameCategory: " + category.getNameCategory());

                break;
        }
        currentPosition = position;
        //for android 5
//        fragment.setListener(this);
        /**/
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container_recipes, fragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
        setActionBarTitle(position);
        mainDrawerLayout.closeDrawer(categoryListView);
    }
    /**/

    //set title for fragments
    private void setActionBarTitle(int position) {
        String title = namesCategories.get(position);
        getActionBar().setTitle(title);
    }
    /**/


    //create options menu for main activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //actionBarDrawerToggle "listens" clicks on listViews' items
        if (mainToggle.onOptionsItemSelected(item)) {
            return true;
        }
        /**/
        switch (item.getItemId()) {

            case R.id.action_cooktimer:

                return true;
            case R.id.action_calories_calc:

                return true;

        }
        return super.onOptionsItemSelected(item);
    }
    /**/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveSharedPreference();
        cookbookRealm.close();
    }

    //close app
    OnDialogExitClickListener dialogExitClickListener = new OnDialogExitClickListener() {
        @Override
        public void onClickCancel() {
        }

        @Override
        public void onClickExit() {
            finish();
        }
    };

    @Override
    public void onBackPressed() {

        CloseDialogFragment dialogFragment = new CloseDialogFragment();
        dialogFragment.setListener(dialogExitClickListener);
        dialogFragment.show(getFragmentManager(), null);
    }

    /**/
    //listener for cardRecipe
    public static final String RECIPE_FOR_SHOW = "show recipe";

    @Override
    public void onRecipeClick(Recipe recipe) {
        Intent intent = new Intent(MainActivity.this, ShowRecipeActivity.class);
        intent.putExtra(RECIPE_FOR_SHOW, recipe.getIdRecipe());
        startActivity(intent);
    }
    /**/


}
