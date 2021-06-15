package com.checkout.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
  private String id;
  private String name;
  private Long price;
  private Discount discount;
}
