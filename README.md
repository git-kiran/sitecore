**Shortest Flight Path**

Example project demonstrating the use of Java/Spring-boot to build a microservice to be used in determining the shortest flight path.

**Running locally:**

```
mvn clean install
java -jar target/sitecore-0.0.1-SNAPSHOT.jar
```

**Tech stack:**

- Spring Boot: For auto configurable production-grade Spring application.
- lombok: For reducing boiler plate codes.
- Mockito: For integration testing console output. 
- SpringBootTest: Integration Test.
- H2 as database.
- Maven for managing the project's build.


**Examples:**

**Sample Request:**

Case 1:

```
Enter Departure and arrival
DUB
SYD

Shortest Path to choose: 
DUB
LHR
BKK
SYD
Time: 

21
```

Case 2:

```
Enter Departure and arrival
dub
SYD

throws RuntimeException mentioning "Either/both locations are not served yet"
```

Explanation: dub is not DUB, the limitation is the input needs to be UPPERCASE.

Case 3:

```
Enter Departure and arrival
SYD
DUB

throws RuntimeException mentioning "No route found"
```

Explanation: SYD as departure is not available in the sample dataset.
