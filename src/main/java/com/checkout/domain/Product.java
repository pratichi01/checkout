package com.checkout.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Product {
  private String id;
  private String name;
  private Long price;
  private DiscounType discountType;
  private String discount;
}
