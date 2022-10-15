# Spring Microservices

## Projects:
* 3 - [Building microservice](c03building/licensing-service)
* 2 - [Base empty project for licensing-service](c02explore/licensing-service)
* 1 - [Simple app](c01welcome)
    * run app: `mvn spring-boot:run`
    * make GET request: 
        * `curl localhost:8080/hello/Alice?lastName=Doe`
    * make POST request: 
        * `curl -X POST -H 'Content-Type: application/json' -d '{"firstName":"Sam","lastName":"Doe"}' localhost:8080/hello`
