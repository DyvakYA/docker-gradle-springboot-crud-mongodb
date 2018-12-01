package com.application.service;

import com.application.dao.ProductRepository;
import com.application.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Transactional
    public Optional<Product> findOne(int id) {
        return repository.findById(id);
    }

    @Transactional
    public void create(Product product) {
        repository.save(product);
    }

    @Transactional
    public void update(int id, Product product) {
        product.setId(id);
        repository.save(product);
    }

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }
}
