package com.checkout.service;

import com.checkout.model.Product;
import com.checkout.repository.ProductRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

  @Autowired
  ProductRepository productRepository;
  @Autowired
  DiscountService discountService;

  public Long checkoutProducts(List<String> productList) {
    Long price = 0L;
    Map<String, Integer> productMap = createProductMap(productList);
    for (Entry<String, Integer> product:productMap.entrySet()) {
      Product productObj = productRepository.getProductById(product.getKey());
      if (productObj == null)
        return 0L;
      price = price + discountService.calculateDiscountPrice(productObj, product.getValue());
    }
    return price;
  }


  private Map<String, Integer> createProductMap(List<String> productList) {
    Map<String, Integer> productMap = new HashMap<>();
    for (String productId:productList) {
      productMap.merge(productId, 1, Integer::sum);
    }
    return productMap;
  }

}
