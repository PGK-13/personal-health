package org.example.service;

import org.example.pojo.result.Result;
import org.example.pojo.entity.FoodItem;

public interface FoodItemService {
    Result list(int currentPage);
    Result add(FoodItem foodItem);
    Result update(FoodItem foodItem);
}
