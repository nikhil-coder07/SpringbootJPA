package com.example.springjpa.Controller;

import com.example.springjpa.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springjpa.Model.Food;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class FoodController
{

  @Autowired
  public FoodService foodService;

  @RequestMapping("/test")
  public String test() {
    return "Testing..";
  }

  @PostMapping("/addFood")
  public ResponseEntity<Food> addFood(@RequestBody Food food) {

    return foodService.createFood(food);
  }

  @GetMapping("/getFood")
  public ResponseEntity<List<Food>> getFood() {
    return foodService.getFood();
  }

  @GetMapping("/getFood/{id}")
  public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
    return foodService.getFoodById(id);
  }

  @PutMapping("/updateFood/{id}")
  public ResponseEntity<Food> updateFood(
      @PathVariable Long id,
      @RequestBody Food food) {

    return foodService.updateFood(id, food);
  }

  @DeleteMapping("/deleteFood/{id}")
  public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
    return foodService.deleteFood(id);
  }
}
