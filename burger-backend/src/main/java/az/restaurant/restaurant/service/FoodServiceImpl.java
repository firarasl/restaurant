package az.restaurant.restaurant.service;

import az.restaurant.restaurant.domain.Food;
import az.restaurant.restaurant.repository.JpaMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private JpaMenuRepository jpaMenuRepository;


    @Override
    public Page<Food> getAllMenu(long category, int start, int limit) {
        Pageable pageable = PageRequest.of(start, limit);
        Page<Food> menu;
        if (category==-1){
            menu= jpaMenuRepository.findAll(pageable);
        }
        else{
            menu= jpaMenuRepository.findAllByCategoryId(category, pageable);
        }
        if (menu.getTotalPages() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else
        return menu;
    }
}
