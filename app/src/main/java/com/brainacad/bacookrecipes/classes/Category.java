package com.brainacad.bacookrecipes.classes;

import java.io.Serializable;
import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Category extends RealmObject implements Serializable{

    private String idCategory;
    private int imageCategory;
    private String nameCategory;
    private RealmList<Recipe> recipesCategory;

    public Category() {
        this.idCategory = UUID.randomUUID().toString();
    }

    public Category(int imageCategory, String nameCategory, RealmList<Recipe> recipesCategory) {
        this();
        this.imageCategory = imageCategory;
        this.nameCategory = nameCategory;
        this.recipesCategory = recipesCategory;
    }

    public int getImageCategory() {
        return imageCategory;
    }

    public void setImageCategory(int imageCategory) {
        this.imageCategory = imageCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public void setRecipeCategory(Recipe recipe) {
        if(this.recipesCategory == null) {
            this.recipesCategory = new RealmList<Recipe>();
        }
        this.recipesCategory.add(recipe);
    }

    public RealmList<Recipe> getRecipesCategory() {
        return recipesCategory;
    }

    public void setRecipesCategory(RealmList<Recipe> recipesCategory) {
        this.recipesCategory = recipesCategory;
    }

    public String getIdCategory() {
        return idCategory;
    }
}
