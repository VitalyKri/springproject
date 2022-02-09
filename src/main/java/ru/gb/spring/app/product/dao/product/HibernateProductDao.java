package ru.gb.spring.app.product.dao.product;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.spring.app.product.entity.Product;

import java.util.Collections;
import java.util.List;

//@Repository
@RequiredArgsConstructor
public class HibernateProductDao implements ProductDao {
    private final SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return Collections.unmodifiableList(sessionFactory.getCurrentSession().getNamedQuery("Product.getAll").list());
    }



    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return (Product) sessionFactory.getCurrentSession()
                .getNamedQuery("Product.findById")
                .setParameter("id", id)
                .getSingleResult();
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
