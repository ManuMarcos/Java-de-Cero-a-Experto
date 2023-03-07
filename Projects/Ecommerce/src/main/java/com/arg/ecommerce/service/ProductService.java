package com.arg.ecommerce.service;

import com.arg.ecommerce.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> listProducts();

    public void save(Product product);

    public void remove(Product product);

    public Product findProduct(Product product);

}
