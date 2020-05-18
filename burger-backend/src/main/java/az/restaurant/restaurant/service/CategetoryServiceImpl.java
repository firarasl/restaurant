package az.restaurant.restaurant.service;

import az.restaurant.restaurant.domain.Category;
import az.restaurant.restaurant.repository.JpaCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategetoryServiceImpl implements CategoryService{
    @Autowired
    private JpaCategoryRepository jpaCategoryRepository;


    @Override
    public List<Category> getAllCategories() {
        return jpaCategoryRepository.findAll();
    }
}
