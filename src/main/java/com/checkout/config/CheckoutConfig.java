package com.checkout.config;

import com.checkout.model.DiscounType;
import com.checkout.model.Discount;
import com.checkout.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class CheckoutConfig {

  /**
   * Expose swagger UI.
   *
   * @return Swagger Docket
   */
  @Bean
  public Docket exposeSwaggerUi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();
  }

  @Bean
  public List<Product> productList(){
    List<Product> productList = new ArrayList<>();
    Product product1 = new Product(
        "001", "Rolex", 100L,
        new Discount(DiscounType.VOLUME_DISCOUNT, 3, 200L));
    Product product2 = new Product(
        "002", "Michael Kors", 80L,
        new Discount(DiscounType.VOLUME_DISCOUNT, 2, 120L));
    Product product3 = new Product(
        "003", "Swatch", 50L, new Discount(DiscounType.NONE));
    Product product4 = new Product(
        "004", "Casio", 30L, new Discount(DiscounType.NONE));
    productList.add(product1);
    productList.add(product2);
    productList.add(product3);
    productList.add(product4);
    return productList;
  }


}
