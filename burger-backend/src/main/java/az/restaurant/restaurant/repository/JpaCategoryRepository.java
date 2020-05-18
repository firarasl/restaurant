package az.restaurant.restaurant.repository;

import az.restaurant.restaurant.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaCategoryRepository  extends CrudRepository<Category, Long> {

    List<Category> findAll();

}
