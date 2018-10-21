package com.brainacad.bacookrecipes.dbrealm;

import com.brainacad.bacookrecipes.R;
import com.brainacad.bacookrecipes.classes.Category;
import com.brainacad.bacookrecipes.classes.Ingredient;
import com.brainacad.bacookrecipes.classes.Recipe;


import java.util.ResourceBundle;

import io.realm.Realm;
import io.realm.RealmList;

public class TransactionCookBook implements Realm.Transaction {
    @Override
    public void execute(Realm realm) {


        Category category = new Category();
        category.setImageCategory(R.drawable.if_favour);
        category.setNameCategory("Favourites recipe");
        realm.insert(category);

        category = new Category();
        category.setImageCategory(R.drawable.ic_all_recipes);
        category.setNameCategory("All recipes");
        realm.insert(category);

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

        Recipe recipe1 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                50,
                1500);
        Recipe recipe2 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                50,
                1500);
        Recipe recipe3 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                50,
                1500);
        Recipe recipe4 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                50,
                1500);


        RealmList<Recipe> recipes = new RealmList<Recipe>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe4);

        category = new Category();
        category.setImageCategory(R.drawable.if_soup);
        category.setNameCategory("Soups");
        category.setRecipesCategory(recipes);
        realm.insert(category);

        recipe1 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                2000);
        recipe2 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                2000);
        recipe3 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                2000);
        recipe4 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                5000);

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

        recipe1 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                1000);
        recipe2 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                1000);
        recipe3 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                1000);
        recipe4 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                1000);

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

        recipe1 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                500);
        recipe2 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                10,
                500);
        recipe3 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                200);
        recipe4 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                500);

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

        recipe1 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                500);
        recipe2 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                10,
                500);
        recipe3 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                200);
        recipe4 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                500);

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

        recipe1 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                500);
        recipe2 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                10,
                500);
        recipe3 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                200);
        recipe4 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                500);

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

        recipe1 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                500);
        recipe2 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                10,
                500);
        recipe3 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                200);
        recipe4 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                500);

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

        recipe1 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                500);
        recipe2 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                10,
                500);
        recipe3 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                200);
        recipe4 = new Recipe(R.drawable.pasta,
                "A recipe",
                ingredients,
                "\tSome steps1\n\tSome steps2\n\tSome steps3\n\tSome steps4" +
                        "\n\tSome steps5\n\tSome steps6\n\tSome steps7\n\tSome steps8" +
                        "\n\tSome steps9\n\tSome steps10\n\tSome steps11\n\tSome steps12\n\tSome steps13",
                20,
                500);

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
