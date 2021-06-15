package com.checkout.util;

import com.checkout.domain.DiscounType;
import com.checkout.domain.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ProductUtil {
  public static List<Product> productList = new ArrayList<>();

  public static void initializeProducts() {
    Product product1 = new Product(
        "001", "Rolex", 100L, DiscounType.CUSTOM, "3 for 200");
    Product product2 = new Product(
        "002", "Michael Kors", 80L, DiscounType.CUSTOM, "2 for 120-=");
    Product product3 = new Product(
        "003", "Swatch", 50L, DiscounType.NONE, "");
    Product product4 = new Product(
        "004", "Casio", 30L, DiscounType.NONE, "");

  }

}
