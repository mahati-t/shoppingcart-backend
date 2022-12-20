package com.casestudy.shoppingcart.Service;

import com.casestudy.shoppingcart.Entitites.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ProductService {
    public ResponseEntity<Product> addProduct(Product product);
    public ResponseEntity<Product> updateProduct(Product product);
    public ResponseEntity<Product> getProById(int id);
    public ResponseEntity<List<Product>> getProductsByCategory(String categoryName);

    public ResponseEntity<List<Product>> getProductsBySearchString(String name);
    public ResponseEntity<List<String>> getcategories();
    public ResponseEntity<List<Product>> getAllProducts();

}
