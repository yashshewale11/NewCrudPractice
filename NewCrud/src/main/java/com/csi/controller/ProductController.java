package com.csi.controller;

import com.csi.service.ProductService;
import com.csi.user.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
     private ProductService service;
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> products){
        return service.saveProduct(products);
    }

    @GetMapping("/products")
    public List<Product>findAllProducts(){
       return service.getProducts();
    }
 @GetMapping("/productById/{productId}")
    public Product findProductById(@PathVariable  int productId){
        return service.getProductById(productId);
    }
    @GetMapping("/ProductByName/{productName}")
    public Product findProductByUsingName(@PathVariable String productName){
        return service.getProductByName(productName);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable  int id){
        return service.deleteProduct(id);
    }

}
