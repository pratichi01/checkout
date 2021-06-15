package com.checkout.service.impl;

import com.checkout.domain.Product;
import com.checkout.service.DiscountService;

public class FixedDiscountService implements DiscountService {

  @Override
  public long calculateDiscount(Product product, Integer productCount) {
    return 0;
  }
}