package com.brainacad.bacookrecipes.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.brainacad.bacookrecipes.R;
import com.brainacad.bacookrecipes.classes.Category;
import com.brainacad.bacookrecipes.dbrealm.RecipeDbRealm;
import com.brainacad.bacookrecipes.fragments.RecipesFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private RecipeDbRealm cookbookRealm;

    private RecipesFragment recipesFragment;

    private DrawerLayout mainDrawerLayout;
    private ActionBarDrawerToggle mainToggle;
    private ListView categoryListView;

    //for ListView to fill categories' names
    private List<String> namesCategories = new ArrayList<String>();
    private List<Category> categories;
    /**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cookbookRealm = new RecipeDbRealm();

        //settings drawerLayout
        mainDrawerLayout = findViewById(R.id.main_drawer_layout);
        categoryListView = findViewById(R.id.list_view_category);
        categoryListView.setOnItemClickListener(new DrawerItemClickListener());

        categories = cookbookRealm.getAllCategories();
        for (Category c : categories) {
            namesCategories.add(c.getNameCategory());
        }
        categoryListView.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_activated_1,
                namesCategories
        ));
        /**/

        //settings for drawerListener(creating ActionbarDrawerToggle)
        mainToggle = new ActionBarDrawerToggle(this, mainDrawerLayout, R.string.open_drawer, R.string.close_drawer){
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

        if (savedInstanceState == null) {
            selectItem(1);
        }
    }

//    //main menu is visible if drawerLayout is closed or not if is opened
//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        boolean isDrawerOpen = mainDrawerLayout.isDrawerOpen(categoryListView);
//        menu.findItem(R.id.action_share_recipe).setVisible(!isDrawerOpen);
//        return super.onPrepareOptionsMenu(menu);
//    }
//    /**/

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
            case 1:
                recipesFragment = new RecipesFragment();
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
                recipesFragment = RecipesFragment.newInstance(category.getIdCategory());
                break;
        }
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container_recipes, recipesFragment)
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
        if(mainToggle.onOptionsItemSelected(item)) {
            return true;
        }
        /**/
        switch (item.getItemId()) {
            case R.id.action_settings:

                return true;

        }
        return super.onOptionsItemSelected(item);
    }
    /**/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cookbookRealm.close();
    }
}
