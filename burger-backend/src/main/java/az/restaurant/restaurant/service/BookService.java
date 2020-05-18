package az.restaurant.restaurant.service;

import az.restaurant.restaurant.domain.Book;
import org.springframework.data.domain.Page;

import java.util.List;


public interface BookService {

    Page<Book> getAllMenu(long category, int start, int limit);

    List<Book> findBooksBySpecialIsTrue();
}
