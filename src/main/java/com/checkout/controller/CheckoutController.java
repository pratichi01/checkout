package com.checkout.controller;

import com.checkout.service.CheckoutService;
import java.lang.reflect.Method;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {
  @Autowired
  CheckoutService checkoutService;
  @RequestMapping(method = RequestMethod.POST)
  public Long checkout(@RequestBody List<String> productList) {
    return checkoutService.checkoutProducts(productList);
  }

}
