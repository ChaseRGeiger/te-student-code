package com.techelevator.reviews.dao;

import com.techelevator.reviews.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductsDao implements ProductsDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcProductsDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Product> list() {
        List<Product> products = new ArrayList<Product>();
        String sql = "SELECT id, name, description FROM products";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while (rows.next()) {
            products.add(mapRowToProduct(rows));
        }
        return products;
    }



    @Override
    public Product getById(long productId) {
        Product product = null;
        String sql = "SELECT id, name, description FROM products WHERE id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, productId);
        if (rows.next()) {
            product = mapRowToProduct(rows);
        }
        return product;
    }

    @Override
    public Product add(Product product) {
        String sql = "INSERT INTO products (name, description) VALUES (?,?) RETURNING id";
        Long productId = jdbcTemplate.queryForObject(sql, Long.class, product.getName(), product.getDescription());
        product.setId(productId);
        return product;
    }

    @Override
    public Product update(Product product) {
        String sql = "UPDATE products SET name = ?, description = ? WHERE id = ?";
        jdbcTemplate.update(sql, product.getName(), product.getDescription(), product.getId());
        return getById(product.getId());
    }

    @Override
    public void delete(long productId) {
        String sql = "DELETE FROM products WHERE id = ?";
        jdbcTemplate.update(sql, productId);
    }


    private Product mapRowToProduct(SqlRowSet row) {
        Product product = new Product();
        product.setId(row.getLong("id"));
        product.setName(row.getString("name"));
        product.setDescription(row.getString("description"));

        return product;
    }
}
