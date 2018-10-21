package com.brainacad.bacookrecipes.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
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
import com.brainacad.bacookrecipes.dbrealm.RecipeDbRealm;
import com.brainacad.bacookrecipes.fragments.RecipesFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private RecipeDbRealm cookbookRealm;

    private RecipesFragment recipesFragment;

    private DrawerLayout mainDrawerList;
    private ListView categoryListView;

    private List<String> namesCategories;
    private List<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cookbookRealm = new RecipeDbRealm();

        //settings drawerList
        mainDrawerList = findViewById(R.id.main_drawer_layout);
        categoryListView = findViewById(R.id.list_view_category);
        categoryListView.setOnItemClickListener(new DrawerItemClickListener());
        /**/

        //fill drawerList by categories' names
        namesCategories = new ArrayList<String>();
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

        if (savedInstanceState == null) {
            selectItem(1);
        }
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
        mainDrawerList.closeDrawer(categoryListView);
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
