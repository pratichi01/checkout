package com.checkout.util;

import com.checkout.model.DiscounType;
import com.checkout.model.Discount;
import com.checkout.model.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUtil {

  public static Product createVolumeDiscountTestProduct() {
    return new Product(
        "001", "Rolex", 100L,
        new Discount(DiscounType.VOLUME_DISCOUNT, 3, 200L));
  }

  public static Product createProductWithoutDiscount() {
    return new Product(
        "001", "Rolex", 100L, new Discount(DiscounType.NONE));
  }

  public static Map<String, Integer> createCartMap() {
    Map<String, Integer> cart = new HashMap<>();
    cart.put("001", 3);
    return cart;
  }

  public static List<String> createProductList() {
    List<String> productlist = new ArrayList<>();
    productlist.add("001");
    productlist.add("002");
    productlist.add("001");
    productlist.add("004");
    productlist.add("003");
    return productlist;
  }

}
