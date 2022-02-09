package ru.gb.spring.app.product.dao.product;

import ru.gb.spring.app.product.entity.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findAll();
    Product findById(Long id);
    List<Product> findFirst(int count);
    Product save(Product manufacturer);
    void insert(Product manufacturer);
    void update(Product manufacturer);
    void deleteById(Long id);
}
