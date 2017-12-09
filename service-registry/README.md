# Service Registry

## First Start

````
./mvnw build
./mvnw spring-boot:run  
```` 

## Implementation

### MainClass

Just add the ``@EnableEurekaServer`` Annotation to the MainClass.

[ServiceRegistryApplication.java](src/main/java/net/autorisiert/micro/serviceregistry/ServiceRegistryApplication.java)
````java
@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryApplication.class, args);
    }
}
````

... basicly that's all needed for creating a fully functional service-registry.