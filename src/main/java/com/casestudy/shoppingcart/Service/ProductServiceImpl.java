package com.casestudy.shoppingcart.Service;

import com.casestudy.shoppingcart.Entitites.Product;
import com.casestudy.shoppingcart.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<Product> addProduct(Product p) {
        if (productRepository.getProductByName(p.getName(), p.getPrice(), p.getCategory(), p.getSubCategory(), p.getDetails(), p.getUrl()) == null) {
            productRepository.save(p);
            return new ResponseEntity<>(p, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<Product> updateProduct(Product pro) {
        try {
            int number = productRepository.updateProductById(pro.getName(), pro.getPrice(), pro.getCategory(), pro.getSubCategory(), pro.getDetails(), pro.getUrl(),pro.getProductId());
            Product updatedProduct = productRepository.getProductById(pro.getProductId());
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Product> getProById(int id) {
       if(productRepository.getProductById(id)==null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       else{
           Product p = productRepository.getProductById(id);
           return new ResponseEntity<>(p,HttpStatus.OK);
       }
    }

    @Override
    public ResponseEntity<List<Product>> getProductsByCategory(String categoryName) {
        if(productRepository.byCategory(categoryName).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            List<Product> list = productRepository.byCategory(categoryName);
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<Product>> getProductsBySearchString(String name) {
        if(productRepository.bySearchString(name).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            List<Product> list = productRepository.bySearchString(name);
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<String>> getcategories() {
        List<String> categoryList = productRepository.getCategories();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
      List<Product> allProducts = productRepository.getAllProducts();
      return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }


}
