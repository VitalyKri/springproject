package ru.gb.spring.app.product.dao.product;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.spring.app.product.entity.Product;
import ru.gb.spring.app.product.entity.enums.Status;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends JpaRepository<Product,Long> {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product saveAndFlush(Product product);
    Product save(Product product);
    void deleteById(Long id);

    List<Product> findAllByStatus(Status status, Pageable pageable);
    List<Product> findAllByStatus(Status status, Sort sort);
    List<Product> findAllByStatus(Status status);
}
