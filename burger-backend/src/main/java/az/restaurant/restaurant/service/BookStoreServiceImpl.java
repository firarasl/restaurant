package az.restaurant.restaurant.service;

import az.restaurant.restaurant.domain.BookStore;
import az.restaurant.restaurant.repository.JpaBookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookStoreServiceImpl implements BookStoreService {
    @Autowired
    private JpaBookStoreRepository jpaBookStoreRepository;


    @Override
    public BookStore getBookStoreInfo() {
        long param=1;
        return jpaBookStoreRepository.findAllById(param);
    }
}
