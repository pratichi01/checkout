package com.checkout.service;

import com.checkout.model.Product;
import com.checkout.repository.ProductRepository;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartPriceCalculator {

  ProductRepository productRepository;
  DiscountPriceCalculator discountPriceCalculator;

  @Autowired
  public CartPriceCalculator (ProductRepository productRepository,
      DiscountPriceCalculator discountPriceCalculator) {
    this.productRepository = productRepository;
    this.discountPriceCalculator = discountPriceCalculator;
  }

  public long calculatePrice(Map<String, Integer> cart) {
    Long price = 0L;
    for (Entry<String, Integer> cartItem: cart.entrySet()) {
      Product product = productRepository.getProductById(cartItem.getKey());
      if (product == null)
        return 0L;
      price = price + discountPriceCalculator
          .calculateDiscountPrice(product, cartItem.getValue());
    }
    return price;
  }
}
