package com.example.springjpa.Controller;

import com.example.springjpa.Model.Food;
import com.example.springjpa.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class FoodController {

    @Autowired
    private FoodService foodService;
    @PostMapping("/addFood")
    public Food addFood(@RequestBody Food food) {
        return foodService.createFood(food);
    }
    @GetMapping("/getFood")
    public List<Food> getFood() {
        return foodService.getFood();
    }
    @GetMapping("/getFood/{id}")
    public Food getFoodById(@PathVariable Long id) {
        return foodService.getFoodById(id);
    }
    @PutMapping("/updateFood/{id}")
    public Food updateFood(@PathVariable Long id, @RequestBody Food food) {
        return foodService.updateFood(id, food);
    }
    
    @DeleteMapping("/deleteFood/{id}")
    public String deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return "Food deleted with id " + id;
    }
}