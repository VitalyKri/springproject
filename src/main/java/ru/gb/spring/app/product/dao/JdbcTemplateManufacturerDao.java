//package ru.gb.spring.app.product.dao;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.jdbc.core.JdbcTemplate;
//import ru.gb.spring.app.product.entity.Manufacturer;
//
//import java.util.Optional;
//
////@Component
//@RequiredArgsConstructor
//public class JdbcTemplateManufacturerDao implements ManufacturerDao {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Override
//    public Iterable<Manufacturer> findAll() {
//        return null;
//    }
//
//    @Override
//    public Optional<Manufacturer> findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public String findNameById(Long id) {
//
//        return jdbcTemplate.queryForObject("SELECT name FROM manufacturer where id = ?", String.class, id);
//    }
//
//    @Override
//    public Manufacturer save(Manufacturer manufacturer) {
//        return null;
//    }
//
//    @Override
//    public void insert(Manufacturer manufacturer) {
//
//    }
//
//    @Override
//    public void update(Manufacturer manufacturer) {
//
//    }
//
//    @Override
//    public void deleteById(Long id) {
//
//    }
//}
