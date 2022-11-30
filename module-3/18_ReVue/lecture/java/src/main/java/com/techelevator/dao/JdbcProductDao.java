package com.techelevator.dao;


import com.techelevator.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> list() {
        List<Product> products = new ArrayList<Product>();
        String sql = "SELECT products.id, product_categories.category, name, image_name, rating, is_top_seller, quantity, price " +
                "FROM products " +
                "JOIN product_categories ON products.category = product_categories.id";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            products.add(mapRowToProduct(results));
        }
        return products;
    }



    @Override
    public Product get(int productId) {
        Product product = null;

        String sql = "SELECT products.id, product_categories.category, name, image_name, rating, is_top_seller, quantity, price " +
                " FROM products " +
                " JOIN product_categories ON products.category = product_categories.id WHERE products.id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, productId);
        if (results.next()) {
            product = mapRowToProduct(results);
        }
        return product;
    }

    @Override
    public Product add(Product product) {
        int categoryId = getCategoryId(product.getCategory());
        String sql = "INSERT INTO products(" +
                "id, category, name, image_name, rating, is_top_seller, quantity, price) " +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?) RETURNING id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, categoryId, product.getName(),
                product.getImageName(), product.getRating(), product.isTopSeller(), product.getQuantity(),
                product.getPrice());
        product.setId(id);
        return product;
    }

    @Override
    public void update(Product product) {
        int categoryId = getCategoryId(product.getCategory());
        String sql = "UPDATE products " +
                "SET category=?, name=?, image_name=?, rating=?, is_top_seller=?, quantity=?, price=? " +
                "WHERE id=?";
        jdbcTemplate.update(sql, categoryId, product.getName(),
                product.getImageName(), product.getRating(), product.isTopSeller(), product.getQuantity(),
                product.getPrice(), product.getId());
    }

    @Override
    public void delete(int productId) {
        String sql = "DELETE FROM products WHERE id = ?";
        jdbcTemplate.update(sql, productId);
    }

    @Override
    public List<String> listCategories() {
        List<String> categories = new ArrayList<String>();
        SqlRowSet rows = jdbcTemplate.queryForRowSet("SELECT category FROM product_categories");
        while(rows.next()) {
            categories.add(rows.getString("category"));
        }
        return categories;
    }

    /*
    This is not a great method.  It throws an unhandled SQL exception if the category is not found.
    It should determine the category exists and if it does not, then it should throw an exception that would
    result in a 404 - Category Not Found exception so the client can handle it correctly.  This could be done either
    by catching the Sql Exception or by using queryForRowSet and throwing the exception if next() returns false.
     */
    private Integer getCategoryId(String category) {
        return jdbcTemplate.queryForObject("SELECT id FROM product_categories WHERE category = ?", Integer.class, category );
    }


    private Product mapRowToProduct(SqlRowSet row) {
        Product product = new Product();

        product.setId(row.getInt("id"));
        product.setCategory(row.getString("category"));
        product.setName(row.getString("name"));
        product.setImageName(row.getString("image_name"));
        product.setRating(row.getInt("rating"));
        product.setTopSeller(row.getBoolean("is_top_seller"));
        product.setQuantity(row.getInt("quantity"));
        product.setPrice(row.getDouble("price"));

        return product;
    }
}
