package com.application.controller;

import com.application.model.Product;
import com.application.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final static Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> products() {
        log.info("get all products");
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product product(@PathVariable(value = "id") int id) {
        Optional<Product> product = service.findOne(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Product product) {
        service.create(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable(value = "id") int id, @RequestBody Product product) {
        service.update(id, product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
