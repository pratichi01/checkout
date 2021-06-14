package com.checkout.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckoutController {
  @RequestMapping("/")
  public String checkout() {
    return "Checkout Products";
  }

}
