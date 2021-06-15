# checkout

## To run the checkout project on the local machine 
1. git clone the repo - git clone https://github.com/pratichi01/checkout.git
2. build the repo using the command - ./gradlew clean build
3. Run the checkout application class 
   a. Right click on the class and then clink run. 
   b. Set the run configuration with main class as com.checkout.CheckoutApplication
4. Use the swagger ui link to test the api  - http://localhost:8080/swagger-ui.html  


## Design Consideration:  
1. The project consists of a Product entity with an extendable discount design 
   ### First Approach
   a. I have considered a discount type field which will tell the discount is percentage, fixed or custom
   b. Based on the type we can instantiate the discount implementation classusing a factory pattern
   ### Second Approach
   a. We can write a string parser on the discount field to identify what is the discount type and then following the above approach
   
I am going by the first approach where in addition to the fields you have mention for the catalogue type, discount type will also be there to make the design extendable and support different discount types later.