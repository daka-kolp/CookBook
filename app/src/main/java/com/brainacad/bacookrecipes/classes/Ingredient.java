package com.brainacad.bacookrecipes.classes;

import java.util.UUID;

import io.realm.RealmObject;

public class Ingredient extends RealmObject {

    private String idIngredient;
    private String nameAndAmountIngredient;
    private boolean isIngredient;

    public Ingredient() {
        this.idIngredient = UUID.randomUUID().toString();
    }

    public Ingredient(String nameAndAmountIngredient) {
        this();
        this.nameAndAmountIngredient = nameAndAmountIngredient;
    }

    public String getNameAndAmountIngredient() {
        return nameAndAmountIngredient;
    }

    public void setNameAndAmountIngredient(String nameAndAmountIngredient) {
        this.nameAndAmountIngredient = nameAndAmountIngredient;
    }

    public String getIdIngredient() {
        return idIngredient;
    }

    public boolean isIngredient() {
        return isIngredient;
    }

    public void setBoolIngredient(boolean ingredient) {
        isIngredient = ingredient;
    }

    @Override
    public String toString() {
        return "\t" + nameAndAmountIngredient;
    }

    //for log
    public String toBoolString() {
        return "\t" + nameAndAmountIngredient + " " + isIngredient;
    }
    /**/
}
