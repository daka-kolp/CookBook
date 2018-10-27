package com.brainacad.bacookrecipes.dbrealm;

import android.support.annotation.NonNull;

import com.brainacad.bacookrecipes.R;
import com.brainacad.bacookrecipes.classes.Category;
import com.brainacad.bacookrecipes.classes.Ingredient;
import com.brainacad.bacookrecipes.classes.Step;
import com.brainacad.bacookrecipes.classes.Recipe;


import io.realm.Realm;
import io.realm.RealmList;

public class TransactionCookBook implements Realm.Transaction {
    @Override
    public void execute(@NonNull Realm realm) {

        RealmList<Step> step = new RealmList<>(
                new Step("Heat a large saucepan and dry-fry 2 tsp cumin seeds and a pinch of chilli flakes for 1 min, or until they start to jump around the pan and release their aromas."),
                new Step("Scoop out about half with a spoon and set aside. Add 2 tbsp olive oil, 600g coarsely grated carrots, 140g split red lentils, 1l hot vegetable stock and 125ml milk to the pan and bring to the boil."),
                new Step("Simmer for 15 mins until the lentils have swollen and softened."),
                new Step("Whizz the soup with a stick blender or in a food processor until smooth (or leave it chunky if you prefer)."),
                new Step("Season to taste and finish with a dollop of plain yogurt and a sprinkling of the reserved toasted spices. Serve with warmed naan breads.")
        );

        RealmList<Ingredient> ingredients = new RealmList<Ingredient>(
                new Ingredient("2 tsp cumin seeds"),
                new Ingredient("pinch chilli flakes"),
                new Ingredient("2 tbsp olive oil"),
                new Ingredient("600g carrots"),
                new Ingredient("140g split red lentils"),
                new Ingredient("1l hot vegetable stock"),
                new Ingredient("125ml milk"),
                new Ingredient("plain yogurt and naan bread")
        );

        Recipe recipe1 = new Recipe(R.drawable.soup_spiced_carrot_and_lentil_soup,
                "Spiced carrot & lentil soup",
                ingredients,
                step,
                25,
                238,
                4);

        step = new RealmList<>(
                new Step("Heat 2 tbsp olive oil in a large saucepan, then gently cook 2 finely chopped onions for 5 mins, until soft but not coloured."),
                new Step("Add 1kg pumpkin or squash, cut into chunks, to the pan, then carry on cooking for 8-10 mins, stirring occasionally until it starts to soften and turn golden."),
                new Step("Pour 700ml vegetable or chicken stock into the pan and season with salt and pepper. Bring to the boil, then simmer for 10 mins until the squash is very soft."),
                new Step("Pour 150ml double cream into the pan, bring back to the boil, then purée with a hand blender. For an extra-velvety consistency you can pour the soup through a fine sieve. The soup can now be frozen for up to 2 months."),
                new Step("To make the croutons: cut 4 slices wholemeal seeded bread into small squares."),
                new Step("Heat 2 tbsp olive oil in a frying pan, then fry the bread until it starts to become crisp."),
                new Step("Add a handful of pumpkin seeds to the pan, then cook for a few mins more until they are toasted. These can be made a day ahead and stored in an airtight container."),
                new Step("Reheat the soup if needed, taste for seasoning, then serve scattered with croutons and seeds and drizzled with more olive oil, if you want.")
        );

        ingredients = new RealmList<Ingredient>(
                new Ingredient("2 tbsp olive oil"),
                new Ingredient("2 onions, finely chopped"),
                new Ingredient("1kg pumpkin or squash"),
                new Ingredient("700ml vegetable stock or chicken stock"),
                new Ingredient("150ml double cream"),
                new Ingredient("2 tbsp olive oil"),
                new Ingredient("4 slices wholemeal seeded bread"),
                new Ingredient("handful pumpkin seeds")
        );
        Recipe recipe2 = new Recipe(R.drawable.soup_pumpkin_soup,
                "Pumpkin soup",
                ingredients,
                step,
                45,
                317,
                4);
        step = new RealmList<>(
                new Step("Heat the oil in a large pan and fry the leeks for a few mins to soften. Add the courgettes, then cover the pan and cook for 5 mins more. Pour in the stock, cover and cook for about 7 mins."),
                new Step("Add the spinach, then cover the pan and cook for 5 mins so that it wilts. Take off the heat and blitz until really smooth with a hand blender. Add the goat’s cheese and basil, then blitz again."),
                new Step("If you're making this recipe as part of our two-person Summer Healthy Diet Plan, spoon half the soup into two bowls or large flasks, then cool and chill the remainder for another day. Reheat in a pan or microwave to serve. If serving in bowls, scatter with some extra basil leaves and the seeds, and eat with the rye bread.")
        );

        ingredients = new RealmList<Ingredient>(
                new Ingredient("1 tbsp rapeseed oil"),
                new Ingredient("400g leeks, well washed and sliced"),
                new Ingredient("450g courgettes, sliced"),
                new Ingredient("3 tsp vegetable bouillon powder, made up to 1 litre with boiling water"),
                new Ingredient("400g spinach"),
                new Ingredient("150g tub soft vegetarian goat's cheese"),
                new Ingredient("15g basil, plus a few leaves to serve"),
                new Ingredient("8 tsp omega seed mix (see tip)"),
                new Ingredient("4 x 25g portions wholegrain rye bread")
        );
        Recipe recipe3 = new Recipe(R.drawable.soup_courgette,
                "Courgette, leek & goat’s cheese soup",
                ingredients,
                step,
                25,
                304,
                4);

        step = new RealmList<>(
                new Step("Heat oil in a pan. Fry the carrots and onion for 5 mins until starting to soften. Add the stock and tomatoes, then simmer for 10 mins. Add the peas and beans with 5 mins to go."),
                new Step("Once veg is tender, stir in the pasta. Return to the boil and simmer for 2 mins until the pasta is just cooked. Stir in the basil, if using. Season, then serve in bowls topped with a sprinkling of Parmesan and slices of garlic bread.")
        );

        ingredients = new RealmList<Ingredient>(
                new Ingredient("1 tbsp olive oil"),
                new Ingredient("2 carrots, chopped"),
                new Ingredient("1 large onion, finely chopped"),
                new Ingredient("1l vegetable stock"),
                new Ingredient("400g can chopped tomato"),
                new Ingredient("200g frozen mixed pea and beans"),
                new Ingredient("250g pack fresh filled tortellini"),
                new Ingredient("handful of basil leaves"),
                new Ingredient("grated parmesan")
        );
        Recipe recipe4 = new Recipe(R.drawable.soup_hearty_pasta_soup,
                "Hearty pasta soup",
                ingredients,
                step,
                30,
                286,
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

        step = new RealmList<>(
                new Step("Cook the rice following pack instructions, then drain, spread it out to steam-dry and set aside."),
                new Step("Heat 2 tbsp of the oil in a large wok over a high heat, then add the onion and fry until lightly browned, around 5 mins. Add the rice, stir and toast for about 3 mins, then move to the side of the pan."),
                new Step("Add the remaining oil, then tip in the egg mixture. Leave to cook a little, then mix in with the rice – stir vigorously to coat the grains or, if you prefer the egg chunkier, allow to set for a little longer before breaking up and stirring through. Tip into a serving bowl and scatter over the spring onion to serve.")
                );
        ingredients = new RealmList<Ingredient>(
                new Ingredient("250g long grain rice"),
                new Ingredient("3 tbsp vegetable oil"),
                new Ingredient("1 onion, finely chopped"),
                new Ingredient("4 eggs, beaten"),
                new Ingredient("2 spring onions")
                );

        recipe1 = new Recipe(R.drawable.rice_egg_fried_rice,
                "Egg fried rice",
                ingredients,
                step,
                20,
                387,
                4);

        step = new RealmList<>(
                new Step("Rinsing and soaking your rice is key to achieving the perfect texture. Measure the rice into a bowl, cover with cold water, then use your fingers to massage the grains of rice – the water will become cloudy. Drain and rinse again with fresh water. Repeat five more times until the water stays clear."),
                new Step("Tip the rinsed rice into a saucepan with 400ml water, or 200ml dashi and 200ml water, bring to the boil, then turn down the heat to a low simmer, cover with a tight-fitting lid with a steam hole and cook for 15 mins. Remove from the heat and leave to sit for another 15 mins, then stir through the mirin. Remove the lid and give it a good stir. Serve with any or all of the optional toppings.")
        );
        ingredients = new RealmList<Ingredient>(
                new Ingredient("300g sushi rice"),
                new Ingredient("200ml dashi"),
                new Ingredient("1 tbsp mirin")
        );
        recipe2 = new Recipe(R.drawable.rice_japanese_ricegohan,
                "Japanese rice/gohan",
                ingredients,
                step,
                35,
                259,
                4);

        step = new RealmList<>(
                new Step("Melt half the butter in a frying pan with a lid. Fry the shallot for a couple of minutes, then add the chicken and carrot. Fry the veg until starting to brown, then add the cinnamon and lemon, and season well. Stir in the rice and raisins, then add the stock and bring to a simmer."),
                new Step("Scatter the chickpeas on top, then cover with the lid. Cook for 15 mins over a low heat until the rice has absorbed all the stock – if the rice is still firm, add 50ml water. Stand for 5 mins, then fluff up the rice. Dot over the remaining butter, then serve.")
        );
        ingredients = new RealmList<Ingredient>(
                new Ingredient("25g butter"),
                new Ingredient("1 shallot, finely chopped"),
                new Ingredient("1 skinless chicken breast"),
                new Ingredient("1 carrot (about 100g)"),
                new Ingredient("1 cinnamon stick"),
                new Ingredient("1 strip lemon zest"),
                new Ingredient("125g basmati rice"),
                new Ingredient("2 heaped tbsp raisins or sultanas"),
                new Ingredient("250ml chicken stock"),
                new Ingredient("215g can chickpea")
        );
        recipe3 = new Recipe(R.drawable.rice_chicken_chickpea_rice,
                "Chicken & chickpea rice",
                ingredients,
                step,
                40,
                417,
                4);

        recipes = new RealmList<Recipe>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);

        category = new Category();
        category.setImageCategory(R.drawable.if_rice);
        category.setNameCategory("Rice dishes");
        category.setRecipesCategory(recipes);
        realm.insert(category);

        step = new RealmList<>(
                new Step("Arrange the salami on a large platter. Loosely drape the prosciutto in a separate pile. Put the black olives in a bowl, in the centre. Serve with thick slices of the warmed bread, drizzled with olive oil and sprinkled with cracked black pepper.")
        );
        ingredients = new RealmList<Ingredient>(
                new Ingredient("3 different types of salami"),
                new Ingredient("6 thin slices of prosciutto"),
                new Ingredient("black olives"),
                new Ingredient("Italian rustic bread, warmed"),
                new Ingredient("olive oil, to drizzle"),
                new Ingredient("cracked black pepper, to sprinkle")
        );
        recipe1 = new Recipe(R.drawable.meat_parmesan_spring_chichen,
                "Parmesan spring chicken",
                ingredients,
                step,
                20,
                339,
                4);


        recipes = new RealmList<Recipe>();
        recipes.add(recipe1);

        category = new Category();
        category.setImageCategory(R.drawable.if_meat);
        category.setNameCategory("Meat dishes");
        category.setRecipesCategory(recipes);
        realm.insert(category);

        step = new RealmList<>(
                new Step("Nestle the fish fillets side by side on a large square of foil and scatter the ginger, garlic, chilli and lime zest over them. Drizzle the lime juice on top and then scatter the pieces of pak choi around and on top of the fish. Pour the soy sauce over the pak choi and loosely seal the foil to make a package, making sure you leave space at the top for the steam to circulate as the fish cooks."),
                new Step("Steam for 15 minutes. (If you haven’t got a steamer, put the parcel on a heatproof plate over a pan of gently simmering water, cover with a lid and steam.)")
        );
        ingredients = new RealmList<Ingredient>(
                new Ingredient("2 trout fillets, each weighing about 140g/5oz"),
                new Ingredient("a small knob of fresh root ginger, peeled and chopped"),
                new Ingredient("1 small garlic clove, chopped"),
                new Ingredient("1 small red chilli"),
                new Ingredient("grated zest and juice of 1 lime"),
                new Ingredient("3 baby pak choi,"),
                new Ingredient("2 tbsp soy sauce")
        );

        recipe1 = new Recipe(R.drawable.fish_streamed_fish,
                "Thai-style steamed fish",
                ingredients,
                step,
                25,
                200,
                4);

        step = new RealmList<>(
                new Step("Heat oven to 220C/200C fan/gas 7. Space the goujons apart on a baking sheet and bake for 12-15 mins, following pack instructions, until crispy. Meanwhile, mix the chipotle or harissa into the mayo, and warm the tortillas – they are best warmed over a gas flame."),
                new Step("To make the salad, toss the cabbage, coriander and onion with the lime juice and some salt."),
                new Step("Spread the tortillas with a little spicy mayo, then place the salad and fish down the centre. Top with a little more mayo, then fold and eat with your fingers. Serve with lime wedges, if you like.")
        );
        ingredients = new RealmList<Ingredient>(
                new Ingredient("220g pack lemon sole goujons"),
                new Ingredient("1 tsp chipotle paste or harissa"),
                new Ingredient("6 tbsp mayonnaise"),
                new Ingredient("4 soft corn tortillas"),
                new Ingredient("175g white cabbage, finely shreddedgood handful chopped coriander"),
                new Ingredient("1 small red onion, finely chopped or sliced"),
                new Ingredient("juice 1 small lime, plus wedges")
        );
        recipe2 = new Recipe(R.drawable.fish_tacos,
                "Fish tacos",
                ingredients,
                step,
                50,
                259,
                4);


        recipes = new RealmList<Recipe>();
        recipes.add(recipe1);
        recipes.add(recipe2);

        category = new Category();
        category.setImageCategory(R.drawable.if_fish);
        category.setNameCategory("Fish dishes");
        category.setRecipesCategory(recipes);
        realm.insert(category);

        step = new RealmList<>(
                new Step("Heat oven to 180C/160C fan/gas 4. Grease and line the base of two 18cm sandwich tins."),
                new Step("Sieve 175g self-raising flour, 2 tbsp cocoa powder and 1 tsp bicarbonate of soda into a bowl. Add 150g caster sugar and mix well."),
                new Step("Make a well in the centre and add 2 tbsp golden syrup, 2 lightly beaten large eggs, 150ml sunflower oil and 150ml semi-skimmed milk. Beat well with an electric whisk until smooth."),
                new Step("Pour the mixture into the two tins and bake for 25-30 mins until risen and firm to the touch. Remove from oven, leave to cool for 10 mins before turning out onto a cooling rack."),
                new Step("To make your butter icing, place 100g unsalted butter in a bowl and beat until soft."),
                new Step("Gradually sieve and beat in 225g icing sugar and 40g cocoa powder then add enough milk to make the icing fluffy and spreadable – around 2.5 tbsp."),
                new Step("Sandwich the two cakes together with the butter icing and cover the sides and the top of the cake with more butter icing.")
        );
        ingredients = new RealmList<Ingredient>(
                new Ingredient("175g self-raising flour"),
                new Ingredient("2 tbsp cocoa powder"),
                new Ingredient("1 tsp bicarbonate of soda"),
                new Ingredient("150g caster sugar"),
                new Ingredient("2 tbsp golden syrup"),
                new Ingredient("2 large eggs, lightly beaten"),
                new Ingredient("150ml sunflower oil, plus extra to grease"),
                new Ingredient("150ml semi-skimmed milk"),
                new Ingredient("100g unsalted butter"),
                new Ingredient("225g icing sugar"),
                new Ingredient("40g cocoa powder"),
                new Ingredient("2,5 tbsp mil")
        );

        recipe1 = new Recipe(R.drawable.dessert_chocolate_fudge_cake,
                "Easy chocolate fudge cake",
                ingredients,
                step,
                55,
                608,
                4);
        step = new RealmList<>(
                new Step("Place the biscotti biscuits in a plastic bag and crush them lightly with the end of a rolling pin, leaving them slightly chunky. Tip the crushed biscuits into a bowl, drizzle over the Vin Santo and give it a stir. In small bowl, use a fork to slightly mash half of the strawberries with the sugar."),
                new Step("Whip the mascarpone in a medium bowl, then fold into the whipped cream. If the mixture appears too thick fold through a little milk. In a 1-litre glass bowl, spread half of the soaked biscotti. Top with half of the mashed strawberries and then half of the mascarpone mixture. Repeat until you have used up everything. Slice the remaining strawberries and scatter over the top. Refrigerate, then pack into a cooler as this dessert should be served chilled.")
        );
        ingredients = new RealmList<Ingredient>(
                new Ingredient("250g box biscotti biscuits"),
                new Ingredient("100ml Vin Santo or other sweet dessert wine"),
                new Ingredient("400g punnet strawberries, hulled and halved"),
                new Ingredient("50g golden caster sugar"),
                new Ingredient("250g tub mascarpone"),
                new Ingredient("284ml carton double cream, softly whipped")
        );

        recipe2 = new Recipe(R.drawable.dessert_strawberry_parfait,
                "Strawberry parfait with Vin Santo",
                ingredients,
                step,
                30,
                660,
                4);
        step = new RealmList<>(
                new Step("Heat oven to 180C/fan 160C/gas 4. Line the bottom of a 23cm springform tin with greaseproof paper. Tip the biscuits and melted butter into a food processor, then blitz to make fine crumbs. Press into the tin and chill."),
                new Step("Whisk all the other ingredients in a large bowl until completely combined, pour into the tin, then bake for 35-40 mins until the cheesecake has a uniform wobble"),
                new Step("Turn off the oven and leave the cake inside until cool. When it is completely cooled, remove from the tin and top with soured cream. Swirl lemon curd over the top and decorate with raspberries, if you like")
        );
        ingredients = new RealmList<Ingredient>(
                new Ingredient("225g digestive biscuit"),
                new Ingredient("100g butter, melted"),
                new Ingredient("250g tub mascarpone"),
                new Ingredient("600g soft cheese"),
                new Ingredient("2 eggs, plus 2 yolks"),
                new Ingredient("zest 3 lemons, juice of 1"),
                new Ingredient("4 tbsp plain flour"),
                new Ingredient("175g caster sugar"),
                new Ingredient("0.5 a 284ml pot soured cream"),
                new Ingredient("3 tbsp lemon curd"),
                new Ingredient("handful raspberries")
        );
        recipe3 = new Recipe(R.drawable.dessert_luscious_cake,
                "Luscious lemon baked cheesecake",
                ingredients,
                step,
                50,
                750,
                4);



        recipes = new RealmList<Recipe>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);

        category = new Category();
        category.setImageCategory(R.drawable.if_dessert);
        category.setNameCategory("Desserts");
        category.setRecipesCategory(recipes);
        realm.insert(category);
        step = new RealmList<>(
                new Step("Make up a small jug of really good-quality drinking chocolate (I use Charbonnel & Walker, which is quite expensive, but tastes fantastic). Make some strong espresso. Third-fill two glasses with the coffee, adding sugar to taste. Add another third of chocolate. Whisk some single cream until frothy, pour over the mocha so that it sits on the top. Drink and enjoy.")
        );
        ingredients = new RealmList<Ingredient>(
                new Ingredient("small jug of really good quality drinking chocolate"),
                new Ingredient("strong espresso"),
                new Ingredient("sugar, to taste"),
                new Ingredient("single cream")
        );

        recipe1 = new Recipe(R.drawable.drink_bicerin_coffee,
                "Bicerin - coffee & chocolate drink",
                ingredients,
                step,
                5,
                100,
                4);
        step = new RealmList<>(
                new Step("Arrange the strawberry slices in the bottom of 2 pretty, long-stemmed glasses, then top each with 2 scoops of raspberry sorbet. Pour over the elderflower drink and serve straight away.")
        );
        ingredients = new RealmList<Ingredient>(
                new Ingredient("2 strawberries, sliced"),
                new Ingredient("4 scoops raspberry sorbet"),
                new Ingredient("100ml/3,5 fl oz sparkling elderflower drink")
        );
        recipe2 = new Recipe(R.drawable.drink_sorbet_fizz,
                "Sorbet fizz",
                ingredients,
                step,
                5,
                136,
                4);


        recipes = new RealmList<Recipe>();
        recipes.add(recipe1);
        recipes.add(recipe2);

        category = new Category();
        category.setImageCategory(R.drawable.if_drink);
        category.setNameCategory("Drinks");
        category.setRecipesCategory(recipes);
        realm.insert(category);


    }
}
