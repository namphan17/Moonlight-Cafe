package com.cornellcollege.android.moonlightcafe;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Tibuchuba on 9/22/2015.
 */
public class MenuGenerator {
    public static List<Item> itemsForMenu() {
        List<Item> items = new ArrayList<>();

        Item pizza = new Item("Pizza");
        pizza.setPrice(10);
        pizza.setLayoutResId(R.layout.customize_pizza_fragment);
        Hashtable<String, Boolean> pizzaOptions = new Hashtable<>();
        pizzaOptions.put("pepperoni", false);
        pizzaOptions.put("bacon", false);
        pizzaOptions.put("onion", false);
        pizzaOptions.put("black_olives", false);
        pizzaOptions.put("sausage", false);
        pizzaOptions.put("mushroom", false);
        pizzaOptions.put("extra_cheese", false);
        pizzaOptions.put("chicken", false);
        pizzaOptions.put("pineapple", false);
        pizza.setOptions(pizzaOptions);





        Item burger = new Item("Burger");
        burger.setPrice(6);
        burger.setLayoutResId(R.layout.customize_burger_fragment);
        Hashtable<String, Boolean> burgerOptions = new Hashtable<>();
        burgerOptions.put("lettuce", false);
        burgerOptions.put("pickles", false);
        burgerOptions.put("onion", false);
        burgerOptions.put("tomatoes", false);
        burgerOptions.put("cucumber", false);
        burgerOptions.put("cheese", false);
        burgerOptions.put("bacon", false);
        burger.setOptions(burgerOptions);

        Item chickenTender = new Item("Chicken Tender");
        chickenTender.setPrice(5);
        chickenTender.setLayoutResId(R.layout.customize_chicken_fragment);
        Hashtable<String, Boolean> sauceOptions = new Hashtable<>();
        sauceOptions.put("barbeque", false);
        sauceOptions.put("hot", false);
        sauceOptions.put("ranch", false);
        sauceOptions.put("ketchup", false);
        chickenTender.setOptions(sauceOptions);

        // Same options with the chicken tender
        Item fries = new Item("Fries");
        fries.setPrice(2);
        fries.setLayoutResId(R.layout.customize_fries_fragment);
        Hashtable<String, Boolean> sauceOptionsFries = new Hashtable<>();
        sauceOptionsFries.put("barbeque", false);
        sauceOptionsFries.put("hot", false);
        sauceOptionsFries.put("ranch", false);
        sauceOptionsFries.put("ketchup", false);
        fries.setOptions(sauceOptionsFries);

        Item eggroll = new Item("Eggroll(Pork)");
        eggroll.setPrice(3);
        eggroll.setLayoutResId(R.layout.customize_porkeggroll_fragment);
        Hashtable<String, Boolean> sauceOptionsEggroll = new Hashtable<>();
        sauceOptionsEggroll.put("barbeque", false);
        sauceOptionsEggroll.put("hot", false);
        sauceOptionsEggroll.put("ranch", false);
        sauceOptionsEggroll.put("ketchup", false);
        eggroll.setOptions(sauceOptionsEggroll);

        Item eggrollVegie = new Item("Eggroll(Vegie");
        eggrollVegie.setPrice(3);
        eggrollVegie.setLayoutResId(R.layout.customize_vegie_eggroll_fragment);
        Hashtable<String, Boolean> sauceOptionsVegieEggroll = new Hashtable<>();
        sauceOptionsVegieEggroll.put("barbeque", false);
        sauceOptionsVegieEggroll.put("hot", false);
        sauceOptionsVegieEggroll.put("ranch", false);
        sauceOptionsVegieEggroll.put("ketchup", false);
        eggrollVegie.setOptions(sauceOptionsVegieEggroll);

        Item grilledCheese = new Item("Grilled Cheese");
        grilledCheese.setPrice(4);
        grilledCheese.setLayoutResId(R.layout.customize_grilledcheese_fragment);


        Item smoothie = new Item("Smoothie");
        smoothie.setPrice(4);
        smoothie.setLayoutResId(R.layout.customize_smoothie_fragment);
        Hashtable<String, Boolean> smoothieOptions = new Hashtable<>();
        smoothieOptions.put("strawberry", false);
        smoothieOptions.put("pineapple", false);
        smoothieOptions.put("banana", false);
        smoothieOptions.put("forbidden_fruit", false);
        smoothieOptions.put("mango", false);
        smoothieOptions.put("lemonade", false);
        smoothie.setOptions(smoothieOptions);

        items.add(pizza);
        items.add(burger);
        items.add(chickenTender);
        items.add(fries);
        items.add(eggroll);
        items.add(eggrollVegie);
        items.add(grilledCheese);
        items.add(smoothie);


        return items;
    }
}
