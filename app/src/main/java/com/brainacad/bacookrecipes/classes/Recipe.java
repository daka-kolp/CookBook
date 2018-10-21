package com.brainacad.bacookrecipes.classes;

import java.io.Serializable;
import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Recipe extends RealmObject implements Serializable {

    private String idRecipe;
    private int imageRecipe;
    private String nameRecipe;
    private RealmList<Ingredient> ingredientsRecipe;
    private String descriptionRecipe;
    private int timeCookingMinRecipe;
    private int caloriesRecipe;

    public Recipe() {
        this.idRecipe = UUID.randomUUID().toString();
    }

    public static Recipe copyRecipe(Recipe recipe) {
        Recipe copy = new Recipe();
        copy.setNameRecipe(recipe.getNameRecipe());
        copy.setIngredientsRecipe(recipe.getIngredientsRecipe());
        copy.setDescriptionRecipe(recipe.getDescriptionRecipe());
        copy.setTimeCookingMinRecipe(recipe.getTimeCookingMinRecipe());
        copy.setCaloriesRecipe(recipe.getCaloriesRecipe());
        copy.setImageRecipe(recipe.getImageRecipe());
        return copy;
    }

    public Recipe(int imageRecipe,
                  String nameRecipe,
                  RealmList<Ingredient> ingredientsRecipe,
                  String descriptionRecipe,
                  int timeCookingMinRecipe,
                  int caloriesRecipe) {
        this();
        this.imageRecipe = imageRecipe;
        this.nameRecipe = nameRecipe;
        this.ingredientsRecipe = ingredientsRecipe;
        this.descriptionRecipe = descriptionRecipe;
        this.timeCookingMinRecipe = timeCookingMinRecipe;
        this.caloriesRecipe = caloriesRecipe;
    }

    public String getNameRecipe() {
        return nameRecipe;
    }

    public void setNameRecipe(String nameRecipe) {
        this.nameRecipe = nameRecipe;
    }

    public RealmList<Ingredient> getIngredientsRecipe() {
        return ingredientsRecipe;
    }

    public void setIngredientRecipe(Ingredient ingredient) {
        if (this.ingredientsRecipe == null) {
            this.ingredientsRecipe = new RealmList<Ingredient>();
        }
        this.ingredientsRecipe.add(ingredient);
    }

    public String getDescriptionRecipe() {
        return descriptionRecipe;
    }

    public void setDescriptionRecipe(String descriptionRecipe) {
        this.descriptionRecipe = descriptionRecipe;
    }

    public int getTimeCookingMinRecipe() {
        return timeCookingMinRecipe;
    }

    public void setTimeCookingMinRecipe(int timeCookingMinRecipe) {
        this.timeCookingMinRecipe = timeCookingMinRecipe;
    }

    public int getCaloriesRecipe() {
        return caloriesRecipe;
    }

    public void setCaloriesRecipe(int caloriesRecipe) {
        this.caloriesRecipe = caloriesRecipe;
    }

    public int getImageRecipe() {
        return imageRecipe;
    }

    public void setImageRecipe(int imageRecipe) {
        this.imageRecipe = imageRecipe;
    }

    public void setIngredientsRecipe(RealmList<Ingredient> ingredientsRecipe) {
        this.ingredientsRecipe = ingredientsRecipe;
    }
}
