package com.checkout.controller;

import com.checkout.CheckoutApplication;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
    webEnvironment = WebEnvironment.RANDOM_PORT,
    classes = CheckoutApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CheckoutControllerTest {

  @LocalServerPort
  private int port;

  TestRestTemplate restTemplate = new TestRestTemplate();

  @Test
  public void addCourse() {
    HttpEntity<List<String>> entity = new HttpEntity(createInput());

    ResponseEntity<String> response = restTemplate.exchange(
        createURLWithPort("/checkout"),
        HttpMethod.POST, entity, String.class);

    Long price = Long.parseLong(response.getBody());
    Assertions.assertEquals(360L, price);
  }


  private List<String>  createInput() {
    List<String> productList = new ArrayList<>();
    productList.add("001");
    productList.add("002");
    productList.add("001");
    productList.add("003");
    productList.add("004");
    return productList;
  }

  private String createURLWithPort(String uri) {
    return "http://localhost:" + port + uri;
  }
}
