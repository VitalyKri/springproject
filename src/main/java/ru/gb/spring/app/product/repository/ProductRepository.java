package ru.gb.spring.app.product.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import ru.gb.spring.app.product.dao.product.ProductDao;
import ru.gb.spring.app.product.entity.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class ProductRepository {

    List<Product> products;
    
    private final ProductDao productDao;


    @PostConstruct
    public void init(){
        products = productDao.findFirst(5);
    }


    public Product save(Product Product) {

        Products.add(Product);
        // возвращаем копию, что бы не изменили нашу ссылку
        return Product.builder()
                .id(Product.getId())
                .from(Product.getFrom())
                .to(Product.getTo())
                .body(Product.getBody())
                .build();
    }

    public Product edit(Product Product) {
        Product set = Products.set(Product.getId(), Product);
        return Product.builder()
                .id(set.getId())
                .from(set.getFrom())
                .to(set.getTo())
                .body(set.getBody())
                .build();
    }

    public Optional<Product> findById(Integer id) {
        if (id < Products.size()) {
            return Optional.of(Products.get(id));
        } else {
            return Optional.empty();
        }
    }

    public List<Product> findAll() {
        return new ArrayList<>(Products);
    }

    public void deleteByID(Integer id) {
        if (id < Products.size()) {
            Products.remove(id);
        }
    }
    
    
}
