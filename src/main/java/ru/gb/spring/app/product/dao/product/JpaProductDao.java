package ru.gb.spring.app.product.dao.product;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.spring.app.product.entity.Product;


import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Random;

@Repository
@RequiredArgsConstructor
public class JpaProductDao implements ProductDao {

    final private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return  entityManager.createNamedQuery("Product.getAll",Product.class).getResultList();
    }

    @Override
    public Product findById(Long id) {

        TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.id = :id", Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Product> findFirst(int count) {
        return entityManager.createQuery("select  p from Product p order by p.id ")
                .setMaxResults(count)
                .getResultList();

    }

    @Override
    public Product findRandom() {
        Random random = new Random();

        List<Product> resultList = entityManager.createQuery("select p from Product p order by p.id desc ")
                .setMaxResults(100)
                .getResultList();
        int i = random.nextInt(resultList.size());

        return resultList.get(i);
    }

    @Override
    public Product save(Product product) {

        if (product.getId() == null) {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        } else {
            entityManager.merge(product);
        }
        return product;
    }

    @Override
    public void insert(Product product) {
        entityManager.persist(product);

    }



    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        Product product = findById(id);
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }
}
