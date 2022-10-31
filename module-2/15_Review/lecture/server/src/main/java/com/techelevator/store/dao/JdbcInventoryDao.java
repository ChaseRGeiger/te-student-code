package com.techelevator.store.dao;


import com.techelevator.store.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInventoryDao  implements InventoryDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcInventoryDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
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

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();
        String sql = "SELECT sku, product_type.name AS product_type_name, product.name, description, perishable, price, weight_in_lbs, taxable " +
                "FROM product " +
                "JOIN product_type ON product.product_type = product_type.id";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while (result.next()){
            products.add(mapRowToProduct(result));
        }
        return products;
    }
}
