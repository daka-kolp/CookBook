package com.brainacad.bacookrecipes.dbrealm;

import com.brainacad.bacookrecipes.classes.Category;
import com.brainacad.bacookrecipes.classes.Recipe;

import java.util.List;

import io.realm.Realm;

public class RecipeDbRealm {

    public static final String ID_CATEGORY = "idCategory";
    public static final String ID_RECIPE = "idRecipe";
    public static final String ID_INGEDIENT = "idIngredient";
    public static final String ID_PRODUCT = "idProduct";

    public static final String NAME_PRODUCT = "nameRecipe";
    public static final String NAME_CATEGORY = "nameCategory";

    private Realm realmDb;

    public RecipeDbRealm() {
        this.realmDb = Realm.getDefaultInstance();
    }

    public void insertRecipeToCategory(Category category, Recipe recipe) {
        realmDb.beginTransaction();
        Recipe copyRecipe = Recipe.copyRecipe(recipe);
        if (category != null) {
            category.setRecipeCategory(copyRecipe);
        }
        realmDb.commitTransaction();
    }

    public void deleteRecipeFromCategory(Recipe recipe) {
        realmDb.beginTransaction();

        if (recipe != null)
            recipe.deleteFromRealm();

        realmDb.commitTransaction();

    }

    public void insertCategory(Category category) {
        realmDb.beginTransaction();
        realmDb.insert(category);
        realmDb.commitTransaction();
    }

    public Recipe getRecipeByName(String name) {
        realmDb.beginTransaction();
        Recipe recipe = realmDb
                .where(Recipe.class)//table
                .equalTo(NAME_PRODUCT, name)
                .findFirst();
        realmDb.commitTransaction();
        return recipe;
    }

    public List<Category> getAllCategories() {
        realmDb.beginTransaction();
        List<Category> categoryList = realmDb
                .where(Category.class)
                .findAll();
        realmDb.commitTransaction();
        return categoryList;
    }

    public List<Recipe> getAllRecipes() {
        realmDb.beginTransaction();
        List<Recipe> resList = realmDb
                .where(Recipe.class)
                .findAll();
        realmDb.commitTransaction();
        return resList;
    }

    public List<Recipe> getAllRecipesInCategory(String idCategory) {

        Category category = getCategoryById(idCategory);
        if (category != null) {
            realmDb.beginTransaction();
            List<Recipe> recipeList = null;
            recipeList = category.getRecipesCategory();
            realmDb.commitTransaction();
            return recipeList;
        }
        return null;
    }

    public Category getCategoryById(String idCategory) {
        realmDb.beginTransaction();
        Category category = realmDb
                .where(Category.class)
                .equalTo(ID_CATEGORY, idCategory)
                .findFirst();
        realmDb.commitTransaction();
        return category;
    }

    public Category getCategoryByName(String name) {
        realmDb.beginTransaction();
        Category category = realmDb
                .where(Category.class)
                .equalTo(NAME_CATEGORY, name)
                .findFirst();
        realmDb.commitTransaction();
        return category;
    }


    public void updateCategory(final Category category, final String name, final Recipe recipe) {
        realmDb.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (category != null) {
                    category.setNameCategory(name);
                    category.setRecipeCategory(recipe);
                }
            }
        });
    }


    public void deleteCategoryById(String idCategory) {
        realmDb.beginTransaction();

        Category category = realmDb.where(Category.class)
                .equalTo(ID_CATEGORY, idCategory)
                .findFirst();
        if (category != null)
            category.deleteFromRealm();

        realmDb.commitTransaction();
    }

    public void deleteAll() {
        realmDb.beginTransaction();
        realmDb.deleteAll();
        realmDb.commitTransaction();
    }

    public void close() {
        realmDb.close();
    }

}
