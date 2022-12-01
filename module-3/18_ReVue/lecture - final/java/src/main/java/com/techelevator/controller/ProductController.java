package com.techelevator.controller;

import com.techelevator.dao.ProductDao;
import com.techelevator.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    private ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @RequestMapping(path="/products", method= RequestMethod.GET)
    public List<Product> list() {
        return productDao.list();
    }

    @RequestMapping(path="/products/{id}", method= RequestMethod.GET)
    public Product get(@PathVariable("id") int productId) {
        return productDao.get(productId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/products", method= RequestMethod.POST)
    public Product add(@RequestBody Product product) {
        return productDao.add(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path="/products/{id}", method= RequestMethod.PUT)
    public void update(@PathVariable("id")int productId, @RequestBody Product product) {
        productDao.update(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path="/products/{id}", method= RequestMethod.DELETE)
    public void delete(@PathVariable("id")int productId) {
        productDao.delete(productId);
    }

    @RequestMapping(path="/categories", method=RequestMethod.GET)
    public List<String> listCategories() {
        return productDao.listCategories();
    }

}
