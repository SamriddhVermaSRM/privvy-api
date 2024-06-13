package com.privvy.api.service;

import com.privvy.api.model.Product;
import com.privvy.api.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;


    // fetch all products
    @Override
    public List<Product> fetchProductsList() {
        return productRepo.findAll();
    }


    // save product
    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    // update product
    @Override
    public ResponseEntity<?> updateProduct(Product product, Integer id) {
        if (productRepo.findById(id).isPresent()){
            Product prodDB = productRepo.findById(id).get();

            if (Objects.nonNull(product.getId()) && (product.getId()) != null) {
                prodDB.setId(product.getId());
            }
            if (Objects.nonNull(product.getName()) && !"".equalsIgnoreCase(product.getName())) {
                prodDB.setName(product.getName());
            }
            if (Objects.nonNull(product.getDescription()) && !"".equalsIgnoreCase(product.getDescription())) {
                prodDB.setDescription(product.getDescription());
            }
            if (Objects.nonNull(product.getPathToImg()) && !"".equalsIgnoreCase(product.getPathToImg())) {
                prodDB.setPathToImg(product.getPathToImg());
            }
            if (Objects.nonNull(product.getPrice()) && (product.getPrice()) != 0) {
                prodDB.setPrice(product.getPrice());
            }
            if (Objects.nonNull(product.getDiscount()) && (product.getDiscount()) != 0) {
                prodDB.setDiscount(product.getDiscount());
            }
            if (Objects.nonNull(product.getRating()) && (product.getRating()) != 0) {
                prodDB.setRating(product.getRating());
            }
            if (Objects.nonNull(product.getTotalRating()) && (product.getTotalRating()) != 0) {
                prodDB.setTotalRating(product.getTotalRating());
            }

            return new ResponseEntity<>(productRepo.save(prodDB), HttpStatus.OK) ;
        }
        else {
            return new ResponseEntity<>("No such product exists", HttpStatus.NOT_FOUND);
        }
    }

    // delete products
    @Override
    public ResponseEntity<?> deleteProductById(Integer id) {
        productRepo.deleteById(id);
        return new ResponseEntity<>("Successfully Deleted",HttpStatus.OK) ;
    }

    // get product by id
    @Override
    public ResponseEntity<?> getProductByID(Integer id) {
        if (productRepo.findById(id).isPresent()) {
            return new ResponseEntity<>(productRepo.findById(id).get(), HttpStatus.OK) ;
        }
        else {
            return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
        }
    }

}
