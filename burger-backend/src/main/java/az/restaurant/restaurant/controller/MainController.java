package az.restaurant.restaurant.controller;

import az.restaurant.restaurant.domain.Book;
import az.restaurant.restaurant.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
    @Autowired
    private BookService bookService;



    @GetMapping("/menu/{category}")
    private Page<Book> getMenu(@PathVariable(name="category") long category,
                               @RequestParam(name="start", required = false, defaultValue = "0") int start,
                               @RequestParam (name="limit", required = false, defaultValue = "10") int limit){
        return bookService.getAllMenu(category, start, limit);
    }
    @GetMapping("/test")
    private void  test(){
        System.out.println("TEST WORKED");
    }

}
