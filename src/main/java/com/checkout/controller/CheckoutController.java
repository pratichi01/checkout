package com.checkout.controller;

import java.lang.reflect.Method;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {
  @RequestMapping(method = RequestMethod.POST)
  public String checkout(@RequestBody List<Integer> productList) {
    for (Integer product: productList) {
      System.out.println(product);
    }
    return "Checkout Products";
  }

}
