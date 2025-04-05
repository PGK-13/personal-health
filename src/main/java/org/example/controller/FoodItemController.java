package org.example.controller;

import org.example.pojo.result.Result;
import org.example.pojo.entity.FoodItem;
import org.example.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") int currentPage) {
        return foodItemService.list(currentPage);
    }

    @PostMapping("/add")
    public Result add(@RequestBody FoodItem foodItem) {
        return foodItemService.add(foodItem);
    }

    public Result update(@RequestBody FoodItem foodItem) {
        return foodItemService.update(foodItem);
    }
}
