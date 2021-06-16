package com.checkout.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class CheckoutService {

  CartPriceCalculator cartPriceCalculator;

  @Autowired
  public CheckoutService(CartPriceCalculator cartPriceCalculator) {
    this.cartPriceCalculator = cartPriceCalculator;
  }

  public Long checkoutProducts(List<String> productList) {
    if (CollectionUtils.isEmpty(productList)) {
      return 0L;
    }
    Map<String, Integer> cart = createCartMap(productList);
    return cartPriceCalculator.calculatePrice(cart);
  }

  private Map<String, Integer> createCartMap(List<String> productList) {
    Map<String, Integer> cart = new HashMap<>();
    for (String productId:productList) {
      cart.merge(productId, 1, Integer::sum);
    }
    return cart;
  }

}
