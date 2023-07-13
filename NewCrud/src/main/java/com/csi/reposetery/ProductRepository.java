package com.csi.reposetery;

import com.csi.user.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
     Product findByProductName(String productName);
}
