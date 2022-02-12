package ru.gb.spring.app.product.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.spring.app.product.entity.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerDao extends JpaRepository<Manufacturer,Long> {
    List<Manufacturer> findAll();
    Optional<Manufacturer> findById(Long id);
    String findNameById(Long id);
    Manufacturer save(Manufacturer manufacturer);
    void deleteById(Long id);
}
