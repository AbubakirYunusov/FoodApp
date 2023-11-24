package com.example.foodapp.database

import android.content.Context
import com.example.foodapp.model.FoodModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

private const val SHARED_PREFERENCES_KEY = "SHARED_PREFERENCES_KEY"
private const val FOOD_SHARED_PREF = " FOOD_SHARED_PREF"


class FoodDatabase (
    context: Context
) {
    private val sharedPreferences = context.getSharedPreferences(
        SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE
    )

    fun getAllFood(): List<FoodModel> {
        val gson = Gson()
        val json = sharedPreferences.getString(FOOD_SHARED_PREF,null)
        val type: Type = object : TypeToken<ArrayList<FoodModel?>?>() {}.type
        val foodList = gson.fromJson<List<FoodModel>>(json, type)
        return foodList ?: emptyList()
    }

    fun saveFood(foodModel: FoodModel) {
        val foods = getAllFood().toMutableList()
        foods.add(0, foodModel)
        val foodsGson = Gson().toJson(foods)
        sharedPreferences
            .edit()
            .putString(FOOD_SHARED_PREF, foodsGson)
            .apply()
    }

    fun updateFoods(foodModel: FoodModel) {
        val food = getAllFood().toMutableList()
        food.removeIf{foodModel.foodId == it.foodId}
        food.add(0, foodModel)
        val foodsGson = Gson().toJson(food)
        sharedPreferences.edit().putString(FOOD_SHARED_PREF,foodsGson).apply()
    }

    fun deleteAllFoods() = sharedPreferences.edit().clear().apply()

    fun deleteFoodAtIndex(index: Int) {
        val getAllFood = getAllFood().toMutableList()
        if (index in 0 until getAllFood.size) {
            getAllFood.removeAt(index)
            val foodGsonString = Gson().toJson(getAllFood)
            sharedPreferences.edit().putString(FOOD_SHARED_PREF, foodGsonString).apply()
        }
    }
}