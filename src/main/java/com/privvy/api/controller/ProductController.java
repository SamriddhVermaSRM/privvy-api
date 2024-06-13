package com.privvy.api.controller;

import com.privvy.api.model.Product;
import com.privvy.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    // Fetch all products
    @GetMapping("/all")
    public ResponseEntity<?> fetchProductsList() {
        List<Product> productList = productService.fetchProductsList();
        if (!productList.isEmpty()) {
            return new ResponseEntity<>(productList,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Fetch product by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductByID(@PathVariable("id") Integer productId) {
        return productService.getProductByID(productId);
    }

    // Fetch product by name
//    @GetMapping("/{name}")
//    public ResponseEntity<?>

    // Save a new product
    @PostMapping("/saveProduct")
    public Product saveProduct(@Validated @RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // update products
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable("id") Integer productId) {
        return productService.updateProduct(product, productId);
    }

    //delete products
    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer productId) {

        return productService.deleteProductById(productId);
    }
}
