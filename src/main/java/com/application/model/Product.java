package com.application.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

    @Id
    private int id;
    private String name;
    private String description;

    private Product() {
    }

    private Product(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class ProductBuilder {

        private int id;
        private String name;
        private String description;

        public ProductBuilder id(int id) {
            this.id = id;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Product build() {
            return new Product(this.id, this.name, this.description);
        }
    }
}
