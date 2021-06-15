package com.checkout.repository;

import com.checkout.model.Product;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

@Repository
public class ProductRepository {

  @Autowired
  private List<Product> productList;

  public Product getProductById(String id) {
     List<Product> productListById =  productList.stream().filter(
        product -> product.getId().equals(id)).collect(Collectors.toList());
     if (CollectionUtils.isEmpty(productListById)) {
       return null;
     }
     return productListById.get(0);
  }
}
