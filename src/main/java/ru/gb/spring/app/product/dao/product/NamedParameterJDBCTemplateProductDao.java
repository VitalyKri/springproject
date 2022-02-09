package ru.gb.spring.app.product.dao.product;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.gb.spring.app.product.entity.Product;

import java.util.HashMap;
import java.util.List;

//@Component
@RequiredArgsConstructor
public class NamedParameterJDBCTemplateProductDao implements ProductDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Product> findAll() {
        List<Product> query = namedParameterJdbcTemplate.query("select * from product",
                (rs, rowNum) -> Product.builder()
                        .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                        .cost(rs.getBigDecimal("cost"))
                        .build()

        );
        return query;
    }

    @Override
    public Product findRandom() {
        return null;
    }

    @Override
    public Product findById(Long id) {
        String sql = "Select * from product as p where p.id = :id";
        HashMap<String, Object> mapParams = new HashMap<>();
        mapParams.put("id", id);

        Product product = namedParameterJdbcTemplate.queryForObject(sql, mapParams,
                (rs, rowNum) -> Product.builder()
                        .cost(rs.getBigDecimal("cost"))
                        .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                        .date(rs.getDate("manufacture_date").toLocalDate())
                        .build()
        );
        return product;
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
