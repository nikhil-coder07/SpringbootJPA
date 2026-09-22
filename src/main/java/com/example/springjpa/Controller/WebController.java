package com.example.springjpa.Controller;

import com.example.springjpa.Model.Food;
import com.example.springjpa.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(value = "editId", required = false) Long editId) {
        List<Food> foods = foodService.getFood();
        model.addAttribute("foods", foods);

        if (editId != null) {
            Food editFood = foodService.getFoodById(editId);
            model.addAttribute("food", editFood != null ? editFood : new Food());
            model.addAttribute("isEdit", editFood != null);
        } else {
            model.addAttribute("food", new Food());
            model.addAttribute("isEdit", false);
        }

        return "index";
    }

    @PostMapping("/saveFood")
    public String saveFood(@ModelAttribute Food food, RedirectAttributes redirectAttributes) {
        if (food.getId() != null) {
            foodService.updateFood(food.getId(), food);
            redirectAttributes.addFlashAttribute("message", "Food item updated successfully!");
        } else {
            foodService.createFood(food);
            redirectAttributes.addFlashAttribute("message", "Food item added successfully!");
        }
        return "redirect:/";
    }

    @GetMapping("/deleteFood/{id}")
    public String deleteFood(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        foodService.deleteFood(id);
        redirectAttributes.addFlashAttribute("message", "Food item deleted successfully!");
        return "redirect:/";
    }
}