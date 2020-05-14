package az.restaurant.restaurant.service;

import az.restaurant.restaurant.domain.Food;
import org.springframework.data.domain.Page;


public interface FoodService {

    Page<Food> getAllMenu(long category, int start, int limit);

}
