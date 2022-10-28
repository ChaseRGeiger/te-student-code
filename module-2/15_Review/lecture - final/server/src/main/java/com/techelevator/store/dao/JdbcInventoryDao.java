package com.techelevator.store.dao;


import com.techelevator.store.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInventoryDao implements InventoryDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcInventoryDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Product> getAllProducts() {
        /*
         4) The DAO retrieves the list of products from the
            database and returns it as a List<Product>
         */
        List<Product> products = new ArrayList<Product>();
        String sql = "SELECT sku, product_type.name AS product_type_name, product.name, description, perishable, price, " +
                "weight_in_lbs, taxable" +
                " FROM product" +
                " JOIN product_type ON product.product_type = product_type.id";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        while (rows.next()) {
            products.add( mapRowToProduct(rows ));
        }
        return products;
    }

    private Product mapRowToProduct(SqlRowSet row) {
        Product product = new Product();

        product.setSku( row.getString("sku") );
        product.setProductType( row.getString("product_type_name") );
        product.setName( row.getString("name") );
        product.setDescription( row.getString("description") );
        product.setPerishable( row.getString("perishable").equalsIgnoreCase("Y") );
        product.setPrice( row.getDouble("price") );
        product.setWeight( row.getInt("weight_in_lbs") );
        product.setTaxable( row.getBoolean("taxable") );

        return product;
    }


}
