package com.checkout.service;

import com.checkout.model.DiscounType;
import com.checkout.model.Product;
import org.springframework.stereotype.Service;

@Service
public class DiscountPriceCalculator {

  Long calculateDiscountPrice(Product product, Integer productCount) {
    if (product.getDiscount().getDiscounType().equals(DiscounType.NONE))
      return getPriceWithoutDiscount(product, productCount);
    else if (product.getDiscount().getDiscounType().equals(DiscounType.VOLUME_DISCOUNT))
      return calculateVolumeDiscountPrice(product, productCount);
    return 0L;
  }

  private Long getPriceWithoutDiscount(Product product, Integer count) {
    return count*product.getPrice();
  }

  private Long calculateVolumeDiscountPrice(Product product, Integer count) {
    Long price = 0L;
    Integer discountVolume = product.getDiscount().getVolume();
    int divisor = count/discountVolume;
    int reminder = count%discountVolume;
    price = price + divisor*product.getDiscount().getVolumePrice();
    price = price + reminder*product.getPrice();
    return price;
  }

}
