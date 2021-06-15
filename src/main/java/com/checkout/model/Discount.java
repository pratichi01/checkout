package com.checkout.model;

import lombok.Getter;

@Getter
public class Discount {
  DiscounType discounType;
  Integer volume;
  Long volumePrice;

  Integer percentage;
  Long fixedDiscount;

  public Discount(DiscounType discounType, Integer volume, Long volumePrice) {
    this.discounType = discounType;
    this.volume = volume;
    this.volumePrice = volumePrice;
  }

  public Discount(DiscounType discounType) {
    this.discounType = discounType;
  }

}

