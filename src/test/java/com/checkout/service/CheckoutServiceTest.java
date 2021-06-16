package com.checkout.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.checkout.util.TestUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CheckoutServiceTest {
  @Mock
  CartPriceCalculator cartPriceCalculator;
  @Captor
  ArgumentCaptor<Map<String, Integer>> cartCaptor;
  CheckoutService checkoutService;

  @BeforeEach
  void initialize() {
    MockitoAnnotations.openMocks(this);
    checkoutService = new CheckoutService(cartPriceCalculator);
  }

  @Test
  public void testCheckoutProductsWithoutProductList() {
    Long price = checkoutService.checkoutProducts(Collections.emptyList());
    Assertions.assertEquals(0L, price);
  }

  @Test
  public void testCheckoutProductsSuccess() {
    when(cartPriceCalculator.calculatePrice(any(Map.class))).thenReturn(100L);
    Long price = checkoutService.checkoutProducts(TestUtil.createProductList());
    verify(cartPriceCalculator).calculatePrice(cartCaptor.capture());
    Map<String, Integer> cartMap = cartCaptor.getValue();
    Assertions.assertEquals(2, cartMap.get("001"), "two items with id 001");
    Assertions.assertEquals(1, cartMap.get("002"), "one item with id 002");
    Assertions.assertEquals(100L, price);
  }
}
