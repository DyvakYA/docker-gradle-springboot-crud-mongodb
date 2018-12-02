//package com.application;
//
//import com.application.controller.ProductController;
//import com.application.model.Product;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//import java.util.List;
//
//import static java.util.Collections.singletonList;
//import static org.mockito.BDDMockito.given;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(ProductController.class)
////@SpringBootTest
//public class ProductControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private ProductController productController;
//
//    @Test
//    public void getAllProducts() {
//        //mvc.perform();
//    }
//
//    @Test
//    public void createProduct() throws Exception {
//
//        //List<Product> products = singletonList(product);
//
////        Product product = Product.builder()
////                .id(1)
////                .name("Good")
////                .description("Best product in th word")
////                .build();
////        // given(productController.create(product)).willReturn()
////
////        //productController.create(product);
////        mvc.perform(get("localhost:8000/products")
////                .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(MockMvcResultMatchers.status().isOk());
//   }
//}
