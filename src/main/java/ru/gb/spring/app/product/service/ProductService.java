package ru.gb.spring.app.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.gb.spring.app.product.dao.product.ProductDao;
import ru.gb.spring.app.product.entity.Product;
import ru.gb.spring.app.product.entity.enums.Status;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;


    public Product save(Product product) {
        return productDao.save(product);
    }

    public Product edit(Product product) {
        return productDao.save(product);
    }

    public Product findById(Long id) {


        return productDao.findById(id).orElseThrow(() -> new NoSuchElementException());

    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public List<Product> findActiveAll() {
        return productDao.findAllByStatus(Status.ACTIVE);
    }

    public void deleteByID(Long id) {
        Optional.of(productDao.findById(id))
                .ifPresent(p->{
            p.get().setStatus(Status.DISABLE);
            productDao.save(p.get());
        });

    }


    public Product getRandomProduct() {

        List<Product> resultList = productDao.findAll();
        return resultList.get(0);

    }

    public void disableById(Long id){
        productDao.findById(id).ifPresent(
                product -> {
                    product.setStatus(Status.DISABLE);
                    productDao.save(product);
                }
        );
    }


    public List<Product> findAllActive(int page, int size){
        return productDao.findAllByStatus(Status.ACTIVE,PageRequest.of(page, size));
    }

    public List<Product> findAllActiveSortedById(Sort.Direction sort){
        return productDao.findAllByStatus(Status.ACTIVE, Sort.by(sort,"cost"));
    }

    public List<Product> findAllActiveSortedById(int page, int size){
        return productDao.findAllByStatus(Status.ACTIVE,PageRequest.of(page, size, Sort.Direction.DESC));
    }
}
