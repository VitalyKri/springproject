package ru.gb.spring.app.product.dao.product;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.gb.spring.app.product.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaProductDao implements ProductDao{

    final private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("select m from Product m").getResultList();
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public List<Product> findFirst(int count) {
        return null;
    }

    @Override
    public Product save(Product manufacturer) {
        return null;
    }

    @Override
    public void insert(Product manufacturer) {

    }

    @Override
    public void update(Product manufacturer) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
