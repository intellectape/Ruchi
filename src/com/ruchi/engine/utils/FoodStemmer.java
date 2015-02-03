package com.ruchi.engine.utils;

import java.util.ArrayList;

import com.ruchi.engine.database.DatabaseConnector;
import com.ruchi.engine.preprocessing.TextUtilizer;

/**
 * Created by brusoth on 11/25/2014.
 */
public class FoodStemmer {
    ArrayList<String> foods=new ArrayList<String>();
    ArrayList<String> stem_food=new ArrayList<String>();
    public static void main(String args[])
    {
        new FoodStemmer().fooStem();
    }

    public void fooStem(){
        DatabaseConnector db=new DatabaseConnector();
        db.connect();
        db.getFoodNames(foods);

        for(String s:foods)
        {
            String stemmed= TextUtilizer.pluralToSingular(s);
            if(!stem_food.contains(stemmed.trim())){
                db.insertFoodItem(stemmed.trim());
                stem_food.add(stemmed.trim());
            }

        }
    }
}
