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
    private RealmList<Step> descriptionsRecipe;
    private int timeCookingMinRecipe;
    private int caloriesRecipe;
    private int numPortionRecipe;

    public Recipe() {
        this.idRecipe = UUID.randomUUID().toString();
    }

    public static Recipe copyRecipe(Recipe recipe) {
        Recipe copy = new Recipe();
        copy.setNameRecipe(recipe.getNameRecipe());
        copy.setIngredientsRecipe(recipe.getIngredientsRecipe());
        copy.setDescriptionsRecipe(recipe.getDescriptionsRecipe());
        copy.setTimeCookingMinRecipe(recipe.getTimeCookingMinRecipe());
        copy.setCaloriesRecipe(recipe.getCaloriesRecipe());
        copy.setImageRecipe(recipe.getImageRecipe());
        copy.setNumPortionRecipe(recipe.getNumPortionRecipe());
        return copy;
    }

    public Recipe(int imageRecipe,
                  String nameRecipe,
                  RealmList<Ingredient> ingredientsRecipe,
                  RealmList<Step> descriptionsRecipe,
                  int timeCookingMinRecipe,
                  int caloriesRecipe,
                  int numPortionRecipe) {
        this();
        this.imageRecipe = imageRecipe;
        this.nameRecipe = nameRecipe;
        this.ingredientsRecipe = ingredientsRecipe;
        this.descriptionsRecipe = descriptionsRecipe;
        this.timeCookingMinRecipe = timeCookingMinRecipe;
        this.caloriesRecipe = caloriesRecipe;
        this.numPortionRecipe = numPortionRecipe;
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

    public RealmList<Step> getDescriptionsRecipe() {
        return descriptionsRecipe;
    }

    public void setDescriptionsRecipe(RealmList<Step> descriptionsRecipe) {
        this.descriptionsRecipe = descriptionsRecipe;
    }


    public void setDescriptionRecipe(Step description) {
        if (this.descriptionsRecipe == null) {
            this.descriptionsRecipe = new RealmList<Step>();
        }
        this.descriptionsRecipe.add(description);
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

    public int getNumPortionRecipe() {
        return numPortionRecipe;
    }

    public void setNumPortionRecipe(int numPortionRecipe) {
        this.numPortionRecipe = numPortionRecipe;
    }
}
