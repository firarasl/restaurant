package az.restaurant.restaurant.repository;

import az.restaurant.restaurant.domain.BookStore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBookStoreRepository extends CrudRepository<BookStore, Long> {
     BookStore findAllById(long param);
}
