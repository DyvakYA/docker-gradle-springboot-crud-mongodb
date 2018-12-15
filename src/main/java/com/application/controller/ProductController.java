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
@RequestMapping("/products") // Specified controller path
public class ProductController {

    // We introduce a logger for provide logging
    private final static Logger log = LoggerFactory.getLogger(ProductController.class);

    // Injects Product service, from DI container of Spring
    @Autowired
    private ProductService service;

    /**
     * If request path is /products and request method is GET,
     * then cause appropriate method from service
     * and return list of all available products from db
     *
     * @return List<Product> Content-Type: application/json
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> products() {
        log.info("get all products");
        // Invoke the appropriate service method and return
        return service.findAll();
    }

    /**
     * If request path is /products/{id} and request method is GET,
     * then cause appropriate method from service
     * and then return one available product from db
     *
     * @param id Parameter from the path, in controller you mast control of entering parameters,
     *           and then put it to the service, for throw to the next chain of responsibility
     * @return Product Content-Type: application/json
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product product(@PathVariable(value = "id") int id) {
        // Invoke the appropriate service method
        Optional<Product> product = service.findOne(id);
        // Check if product is present
        if (product.isPresent()) {
            return product.get();
        } else {
            // If is not present - then return null
            return null;
        }
    }

    /**
     * If request path is /products and Request method is POST,
     * then cause appropriate method from service, put product to method as parameter
     *
     * @param product Content-Type: application/json
     *                product come with request in the body of request
     *                you mast control entire parameters in the object
     *                and then put object to the service for create product, for throw to the next chain of responsibility
     * @return positive HttpResponse status if request is successful
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Product product) {
        // Invoke the appropriate service method
        service.create(product);
        // return positive HttpResponse status 200 = OK
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * If request path is /products/{id} and Request method is PUT,
     * then cause appropriate method from service for update product, put product and product.id to method as parameter
     *
     * @param id      get id parameter from the request path
     * @param product Content-Type: application/json
     *                product come with request in the body of request, product id come from the path
     *                you mast control entire parameters in the object, and id parameter
     *                and then put object to the service for update product, for throw to the next chain of responsibility
     * @return positive HttpResponse status if request is successful
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable(value = "id") int id, @RequestBody Product product) {
        // Invoke the appropriate service method
        service.update(id, product);
        // return positive HttpResponse status 200 = OK
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * If request path is /products/{id} and Request method is DELETE,
     * then cause appropiate method from service for delete product, put product.id to the service method as parameter
     *
     * @param id get id parameter from the request path
     * @return positive HttpResponse status if request is successful
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable(value = "id") int id) {
        // Invoke the appropriate service method
        service.delete(id);
        // return positive HttpResponse status 200 = OK
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
