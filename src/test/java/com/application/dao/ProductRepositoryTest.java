package com.application.dao;

import com.application.model.Product;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ProductRepositoryTest {

    private final static Logger log = Logger.getLogger(ProductRepositoryTest.class);

    @Autowired
    private ProductRepository repository;

    private Product product;

    @Before
    public void init() {
        product = Product.builder()
                .id(12)
                .name("name")
                .description("description")
                .build();
        repository.save(product);
    }

    // Create new Account
    @Test
    public void whenCreateNewProduct() {
        // given
        Product product = Product.builder()
                .id(15)
                .name("name-2")
                .description("description-2")
                .build();
        repository.save(product);
        List<Product> list = new ArrayList<>();
        Iterable<Product> iterable = repository.findAll();
        iterable.forEach(list::add);
        log.info(repository.findById(15) + " : " + product);
        assertThat(2).isEqualTo(list.size());
    }

    // Find one Account by ID
    @Test
    public void whenFindById_thenReturnProduct() {
        // when
        Optional<Product> optional = repository.findById(product.getId());
        Product found = null;
        if (optional.isPresent())
            found = optional.get();
        log.info(found);
        // then
        assertThat(product).isEqualTo(found);
    }

    @Test
    public void whenFindAll_thenReturnListWithOneProduct() {
        // when
        Optional<Product> optional = repository.findById(product.getId());
        Product found = null;
        if (optional.isPresent())
            found = optional.get();
        log.info(found);
        List<Product> result = Arrays.asList(found);
        log.info("List : " + result);
        List<Product> list = new ArrayList<>();
        Iterable<Product> iterable = repository.findAll();
        iterable.forEach(list::add);
        assertThat(list).isEqualTo(list);
    }

    // Update exist product
    @Test
    public void whenUpdateExistProduct() {
        Optional<Product> found = repository.findById(product.getId());

        Product newProduct = Product.builder()
                .id(product.getId())
                .name("newName")
                .description("newDescription")
                .build();
        repository.save(newProduct);

        Optional<Product> newFound = repository.findById(product.getId());

        assertThat(found).isNotEqualTo(newFound);
    }

    // Delete exist product
    @Test
    public void whenDeleteExistProduct() {
        Optional<Product> optional = repository.findById(product.getId());
        Product found = null;
        if (optional.isPresent())
            found = optional.get();
        log.info(found);
        System.out.println(found);
        repository.delete(found);
        log.info(repository.findAll());
        assertThat(repository.findAll()).isEmpty();
    }

    @After
    public void destroy() {
        repository.deleteAll();
    }
}

