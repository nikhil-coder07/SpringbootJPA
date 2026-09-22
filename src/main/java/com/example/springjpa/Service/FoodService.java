package com.example.springjpa.Service;

import com.example.springjpa.Model.Food;
import com.example.springjpa.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public Food createFood(Food food) {
        return foodRepository.save(food);
    }
    public List<Food> getFood() {
        return foodRepository.findAll();
    }
    public Food getFoodById(Long id) {
        return foodRepository.findById(id).orElse(null);
    }
    public Food updateFood(Long id, Food food) {
        if (!foodRepository.existsById(id)) {
            return null;
        }
        food.setId(id);
        return foodRepository.save(food);
    }
    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}