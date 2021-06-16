package com.checkout.service;

import com.checkout.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class DiscountPriceCalculatorTest {

  DiscountPriceCalculator discountPriceCalculator;

  @BeforeAll
  void initialize() {
    discountPriceCalculator = new DiscountPriceCalculator();
  }

  @Test
  public void testCalculateDiscountPriceSuccess() {
    Long price = discountPriceCalculator
        .calculateDiscountPrice(TestUtil.createVolumeDiscountTestProduct(), 3);
    Assertions.assertEquals(200, price);
  }

  @Test
  public void testCalculateDiscountPriceSuccessWithMoreVolume() {
    Long price = discountPriceCalculator
        .calculateDiscountPrice(TestUtil.createVolumeDiscountTestProduct(), 4);
    Assertions.assertEquals(300, price);
  }

  @Test
  public void testCalculateDiscountPriceSuccessWithLessVolume() {
    Long price = discountPriceCalculator
        .calculateDiscountPrice(TestUtil.createVolumeDiscountTestProduct(), 2);
    Assertions.assertEquals(200, price);
  }

  @Test
  public void testCalculateDiscountPriceSuccessWithNoDiscount() {
    Long price = discountPriceCalculator
        .calculateDiscountPrice(TestUtil.createProductWithoutDiscount(), 2);
    Assertions.assertEquals(200, price);
  }

}
