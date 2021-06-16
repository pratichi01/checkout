package com.checkout.service;

import com.checkout.model.Product;
import com.checkout.repository.ProductRepository;
import com.checkout.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CartPriceCalculatorTest {

  @Mock
  ProductRepository productRepository;
  @Mock
  DiscountPriceCalculator discountPriceCalculator;
  CartPriceCalculator cartPriceCalculator;

  @BeforeEach
  void initialize() {
    MockitoAnnotations.openMocks(this);
    cartPriceCalculator = new CartPriceCalculator(
        productRepository, discountPriceCalculator);
  }

  @Test
  public void testCalculatePriceWithProductNotFound() {
    when(productRepository.getProductById(any(String.class))).thenReturn(null);
    long price = cartPriceCalculator.calculatePrice(TestUtil.createCartMap());
    Assertions.assertEquals(0L, price);
    verify(discountPriceCalculator, times(0))
        .calculateDiscountPrice(any(Product.class), any(Integer.class));
  }

  @Test
  public void testCalculatePriceSuccess() {
    when(productRepository.getProductById(any(String.class))).thenReturn(
        TestUtil.createProductWithoutDiscount());
    when(discountPriceCalculator.calculateDiscountPrice(
        any(Product.class), any(Integer.class))).thenReturn(100L);
    long price = cartPriceCalculator.calculatePrice(TestUtil.createCartMap());

    Assertions.assertEquals(100L, price);
    verify(productRepository, times(1)).getProductById(any(String.class));
    verify(discountPriceCalculator, times(1))
        .calculateDiscountPrice(any(Product.class), any(Integer.class));
  }


}
