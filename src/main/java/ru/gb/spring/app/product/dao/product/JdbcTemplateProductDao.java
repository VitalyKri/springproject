//package ru.gb.spring.app.product.dao.product;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.jdbc.core.JdbcTemplate;
//import ru.gb.spring.app.product.entity.Product;
//import ru.gb.spring.app.product.entity.enums.Status;
//
//import java.util.List;
//import java.util.Optional;
//
//
////@Component
//@RequiredArgsConstructor
//public class JdbcTemplateProductDao implements ProductDao {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Override
//    public Product save(Product manufacturer) {
//        return null;
//    }
//
//    @Override
//    public Product findRandom() {
//        return null;
//    }
//
//    @Override
//    public List<Product> findAllByStatus(Status active) {
//        return null;
//    }
//
//    @Override
//    public void insert(Product manufacturer) {
//
//    }
//
//    @Override
//    public void update(Product manufacturer) {
//
//    }
//
//    @Override
//    public void deleteById(Long id) {
//
//    }
//
//    @Override
//    public List<Product> findAll() {
//        List<Product> query = jdbcTemplate.query("select * from product",
//                (rs, rowNum) -> Product.builder()
//                        .id(rs.getLong("id"))
//                        .title(rs.getString("title"))
//                        .cost(rs.getBigDecimal("cost"))
//                        .build()
//
//        );
//        return query;
//    }
//
//    @Override
//    public Optional<Product> findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public List<Product> findFirst(int count) {
//        return null;
//    }
//
//}
