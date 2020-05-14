package az.restaurant.restaurant.repository;

import az.restaurant.restaurant.domain.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface JpaMenuRepository extends PagingAndSortingRepository<Food, Long>{

    Page<Food> findAllByCategoryId(long category, Pageable pageable);
    Page<Food> findAll(Pageable pageable);

}
