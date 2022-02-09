package ru.gb.classwork.classwork5.dao;


import ru.gb.classwork.classwork5.entity.Manufacturer;

public interface ManufacturerDao {
    Iterable<Manufacturer> findAll();
    Manufacturer findById(Long id);
    String findNameById(Long id);
    Manufacturer save(Manufacturer manufacturer);
    void insert(Manufacturer manufacturer);
    void update(Manufacturer manufacturer);
    void deleteById(Long id);
}
