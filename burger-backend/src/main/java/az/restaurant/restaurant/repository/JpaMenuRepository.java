package az.restaurant.restaurant.repository;

import az.restaurant.restaurant.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;


@Repository
public interface JpaMenuRepository extends PagingAndSortingRepository<Book, Long>{

    Page<Book> findAllByCategoryId(long category, Pageable pageable);
    Page<Book> findAll(Pageable pageable);

}
