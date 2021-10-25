##Checkout Kata

###Run the executable jar
```
java -jar checkoutItv.jar
```
### Build project
```
mvn clean install tomcat7:exec-war-only
```

### Request Example
Body should be an array of strings.
Each string should be a single uppercase alpha character([A-Z]).
Empty string is not valid.Empty array is valid.

POST - http://localhost:8080/supermarket/api/checkout
```
["A","C"]
```

###TO DO
#### Extend API to add and remove products
### Add API doc