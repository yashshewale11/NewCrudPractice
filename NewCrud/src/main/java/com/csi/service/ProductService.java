package com.csi.service;

import com.csi.reposetery.ProductRepository;
import com.csi.user.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
      return  repository.save(product);
    }

    public List<Product> saveProduct(List<Product> products){
        return  repository.saveAll(products);
    }

    public Product getProductById(int productId){
       return repository.findById(productId).orElse( null);
    }
    public Product getProductByName(String productName ){
        return repository.findByProductName(productName);
    }

    public String deleteProduct(int productId){
        repository.deleteById(productId);
        return "product remove !!"+productId;
    }

    public Product updateProduct(Product product){
        Product existingProduct= repository.findById(product.getProductId()).orElse(null);
        Objects.requireNonNull(existingProduct).setProductName(product.getProductName());
        existingProduct.setProductQuantity(product.getProductQuantity());
        existingProduct.setProductPrice(product.getProductPrice());
        return repository.save(existingProduct);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }
}
