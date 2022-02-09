package ru.gb.spring.app.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ru.gb.spring.app.product.dao.product.ProductDao;
import ru.gb.spring.app.product.entity.Product;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private final ProductDao productDao;


    public Product save(Product product){
        return productDao.save(product);
    }

    public Product edit(Product product){
        return productDao.save(product);
    }

    public Product findById(Integer id){
        Product productDaoById = productDao.findById(Long.valueOf(id));
        Optional<Product> product = Optional.of(productDaoById);

        return product.orElseThrow(()-> new NoSuchElementException());

    }

    public List<Product> findAll(){
        return productDao.findAll();
    }

    public void deleteByID(Integer id){
       productDao.deleteById(Long.valueOf(id));
    }


    public Product getRandomProduct() {

        return productDao.findRandom();

    }
}
