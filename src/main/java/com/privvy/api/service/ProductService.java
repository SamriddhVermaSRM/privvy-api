package com.privvy.api.service;

import com.privvy.api.model.Product;
import com.privvy.api.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> fetchProductsList();

    ResponseEntity<?> updateProduct(Product product, Integer id);

    ResponseEntity<?> deleteProductById(Integer id);

    ResponseEntity<?> getProductByID(Integer id);

//    ResponseEntity<?> getProductByName(String name);
}
