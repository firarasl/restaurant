package az.restaurant.restaurant.controller;

import az.restaurant.restaurant.domain.Book;
import az.restaurant.restaurant.domain.BookStore;
import az.restaurant.restaurant.domain.Category;
import az.restaurant.restaurant.service.BookService;
import az.restaurant.restaurant.service.BookStoreService;
import az.restaurant.restaurant.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MainController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
   @Autowired
    private BookStoreService bookStoreService;


    @GetMapping("/menu/{category}")
    private Page<Book> getMenu(@PathVariable(name="category") long category,
                               @RequestParam(name="start", required = false, defaultValue = "0") int start,
                               @RequestParam (name="limit", required = false, defaultValue = "10") int limit){
        return bookService.getAllMenu(category, start, limit);
    }

    @GetMapping("/all-catalogues")
    private List<Category> getCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("bookStore-info")
    private BookStore getBookStore(){
        return bookStoreService.getBookStoreInfo();
    }

    @GetMapping("special-menu")
    private List<Book> getSpecialBooks(){
        return bookService.findBooksBySpecialIsTrue();
    }

}
