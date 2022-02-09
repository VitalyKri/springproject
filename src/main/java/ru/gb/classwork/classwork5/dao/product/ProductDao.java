package ru.gb.classwork.classwork5.dao.product;


import ru.gb.classwork.classwork5.entity.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findAll();
    Product findById(Long id);

}
