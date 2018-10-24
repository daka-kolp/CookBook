package com.brainacad.bacookrecipes.dbrealm;

import com.brainacad.bacookrecipes.R;
import com.brainacad.bacookrecipes.classes.Category;
import com.brainacad.bacookrecipes.classes.Ingredient;
import com.brainacad.bacookrecipes.classes.Step;
import com.brainacad.bacookrecipes.classes.Recipe;


import io.realm.Realm;
import io.realm.RealmList;

public class TransactionCookBook implements Realm.Transaction {
    @Override
    public void execute(Realm realm) {

        RealmList<Step> step = new RealmList<>(
                new Step("Some steps1"),
                new Step("Some steps2"),
                new Step("Some steps3"),
                new Step("Some steps4"),
                new Step("Some steps5"),
                new Step("Some steps6"),
                new Step("Some steps7"),
                new Step("Some steps8"),
                new Step("Some steps9"),
                new Step("Some steps10")
        );

        RealmList<Ingredient> ingredients = new RealmList<Ingredient>(
                new Ingredient("an ingredient1"),
                new Ingredient("an ingredient2"),
                new Ingredient("an ingredient3"),
                new Ingredient("an ingredient4"),
                new Ingredient("an ingredient5"),
                new Ingredient("an ingredient6"),
                new Ingredient("an ingredient7"),
                new Ingredient("an ingredient8"),
                new Ingredient("an ingredient9")
        );

        Recipe recipe1 = new Recipe(R.drawable.if_soup,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        Recipe recipe2 = new Recipe(R.drawable.if_soup,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        Recipe recipe3 = new Recipe(R.drawable.if_soup,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        Recipe recipe4 = new Recipe(R.drawable.if_soup,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);


        RealmList<Recipe> recipes = new RealmList<Recipe>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe4);

        Category category = new Category();
        category.setImageCategory(R.drawable.if_soup);
        category.setNameCategory("Soups");
        category.setRecipesCategory(recipes);
        realm.insert(category);

        recipe1 = new Recipe(R.drawable.if_rice,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe2 = new Recipe(R.drawable.if_rice,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe3 = new Recipe(R.drawable.if_rice,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe4 = new Recipe(R.drawable.if_rice,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);

        recipes = new RealmList<Recipe>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe4);

        category = new Category();
        category.setImageCategory(R.drawable.if_rice);
        category.setNameCategory("Rice dishes");
        category.setRecipesCategory(recipes);
        realm.insert(category);

        recipe1 = new Recipe(R.drawable.if_meat,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe2 = new Recipe(R.drawable.if_meat,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe3 = new Recipe(R.drawable.if_meat,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe4 = new Recipe(R.drawable.if_meat,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);

        recipes = new RealmList<Recipe>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe4);

        category = new Category();
        category.setImageCategory(R.drawable.if_meat);
        category.setNameCategory("Meat dishes");
        category.setRecipesCategory(recipes);
        realm.insert(category);

        recipe1 = new Recipe(R.drawable.if_fish,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe2 = new Recipe(R.drawable.if_fish,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe3 = new Recipe(R.drawable.if_fish,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe4 = new Recipe(R.drawable.if_fish,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);

        recipes = new RealmList<Recipe>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe4);

        category = new Category();
        category.setImageCategory(R.drawable.if_fish);
        category.setNameCategory("Fish dishes");
        category.setRecipesCategory(recipes);
        realm.insert(category);

        recipe1 = new Recipe(R.drawable.if_vegetarian,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe2 = new Recipe(R.drawable.if_vegetarian,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe3 = new Recipe(R.drawable.if_vegetarian,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe4 = new Recipe(R.drawable.if_vegetarian,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);

        recipes = new RealmList<Recipe>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe4);

        category = new Category();
        category.setImageCategory(R.drawable.if_vegetarian);
        category.setNameCategory("Vegetarian food");
        category.setRecipesCategory(recipes);
        realm.insert(category);

        recipe1 = new Recipe(R.drawable.if_dessert,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe2 = new Recipe(R.drawable.if_dessert,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe3 = new Recipe(R.drawable.if_dessert,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe4 = new Recipe(R.drawable.if_dessert,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);

        recipes = new RealmList<Recipe>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe4);

        category = new Category();
        category.setImageCategory(R.drawable.if_dessert);
        category.setNameCategory("Desserts");
        category.setRecipesCategory(recipes);
        realm.insert(category);

        recipe1 = new Recipe(R.drawable.if_drink,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe2 = new Recipe(R.drawable.if_drink,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe3 = new Recipe(R.drawable.if_drink,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe4 = new Recipe(R.drawable.if_drink,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);

        recipes = new RealmList<Recipe>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe4);

        category = new Category();
        category.setImageCategory(R.drawable.if_drink);
        category.setNameCategory("Drinks");
        category.setRecipesCategory(recipes);
        realm.insert(category);

        recipe1 = new Recipe(R.drawable.if_starter,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe2 = new Recipe(R.drawable.if_starter,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe3 = new Recipe(R.drawable.if_starter,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);
        recipe4 = new Recipe(R.drawable.if_starter,
                "A recipe",
                ingredients,
                step,
                50,
                1500,
                4);

        recipes = new RealmList<Recipe>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe4);

        category = new Category();
        category.setImageCategory(R.drawable.if_starter);
        category.setNameCategory("Starters");
        category.setRecipesCategory(recipes);
        realm.insert(category);
    }
}
