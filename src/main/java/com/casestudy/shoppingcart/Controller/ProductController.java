package com.casestudy.shoppingcart.Controller;

import com.casestudy.shoppingcart.Entitites.Product;
import com.casestudy.shoppingcart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/products")
public class ProductController {

@Autowired
    private ProductService productService;

    @PostMapping("/addproduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
    return productService.addProduct(product);
    }

    @PostMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return  productService.updateProduct(product);
    }

    @GetMapping("/getById/{productId}")
    public ResponseEntity<Product> getProductId(@PathVariable Integer productId){
        return productService.getProById(productId);
    }
    @GetMapping("/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category){
        return productService.getProductsByCategory(category);
    }

    @GetMapping("search/{searchString}")
    public ResponseEntity<List<Product>> getProductsBySearch(@PathVariable String searchString){
       return productService.getProductsBySearchString(searchString);
    }

    @GetMapping("/getCategories")
    public ResponseEntity<List<String>> getCategories(){
        return productService.getcategories();
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        return productService.getAllProducts();
    }

}
