package com.techelevator.store.dao;


import com.techelevator.store.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


public class JdbcInventoryDao  {



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
