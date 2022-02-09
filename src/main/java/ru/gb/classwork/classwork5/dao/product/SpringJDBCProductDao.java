package ru.gb.classwork.classwork5.dao.product;

import lombok.RequiredArgsConstructor;
import ru.gb.classwork.classwork5.entity.Product;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


//@Component
@RequiredArgsConstructor
public class SpringJDBCProductDao implements ProductDao {


    private final DataSource dataSource;



    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(Long id) {
        Connection connection = null;
        Product product = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product where id = ?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                product = Product.builder()
                        .cost(resultSet.getBigDecimal("cost"))
                        .title(resultSet.getString("title"))
                        .date(resultSet.getDate("manufacture_date").toLocalDate())
                        .id(resultSet.getLong("id"))
                        .build();
                break;
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return product;
        }

    }
}
