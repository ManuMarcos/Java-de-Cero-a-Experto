package com.arg.ecommerce.dao;

import com.arg.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
