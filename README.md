# checkout

## To run the checkout project on the local machine 
1. git clone the repo - git clone https://github.com/pratichi01/checkout.git
2. build the repo using the command - ./gradlew clean build
3. Run the checkout application class 
   a. Right click on the class and then clink run. 
   b. Set the run configuration with main class as com.checkout.CheckoutApplication
4. Use the swagger ui link to test the api  - http://localhost:8080/swagger-ui.html  


## Design Consideration:  
1. The project consists of a Product entity with an extendable discount design.
2. The product contains a discount object. Currently it has a discount type and parameters for discount.
3. The checkoutService builds the cart and calls the CartPriceCalculator Service.
4. The CartPriceCalculator Service fetches the details of each product and calls DiscountPriceCalculator to get the price of each item.   
5. The DiscountPriceCalculator calcualtes the discounted Price for the give product. It contains a method calculateDiscountPrice which further has a different methods for price calculations based on dicount type.
6. This design can be extended with different discounted Price calculation classes.
7. The product repository returns the product object based on id.


## ExceptionHandling
1. if any of the Id of the product is not present then "null" will be returned. 
2. Later this can be changed to throw an exception.

## Test
1. All the services classes are unit tested using the Junit and Mockito framework.

   