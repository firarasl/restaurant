package az.restaurant.restaurant.controller;

import az.restaurant.restaurant.domain.Category;
import az.restaurant.restaurant.domain.Food;
import az.restaurant.restaurant.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private FoodService foodService;



    @GetMapping("/menu/{category}")
    private Page<Food> getMenu(@PathVariable(name="category") long category,
                               @RequestParam(name="start", required = false, defaultValue = "0") int start,
                               @RequestParam (name="limit", required = false, defaultValue = "10") int limit){
        return foodService.getAllMenu(category, start, limit);
    }

}
