package com.checkout.service;

import com.checkout.domain.Product;

public interface DiscountService {
  long calculateDiscount(Product product, Integer productCount);
}
