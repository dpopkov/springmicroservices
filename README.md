# Spring Microservices

## Projects:
* 4 - [Using Docker](c04docker/licensing-service)
    * Add Docker Maven plugin
    * Add Dockerfile
    * Build image: `mvn package dockerfile:build`
    * Run container: 
        * In interactive bash: `docker run -it -p8080:8080 sprmsaction/licensing-service:0.0.1-SNAPSHOT`
        * In background: `docker run -d -p8080:8080 sprmsaction/licensing-service:0.0.1-SNAPSHOT`
    * Stop container: `Ctrl+C` or `docker stop <container-id>`
* 3 - [Building microservice](c03building/licensing-service)
* 2 - [Base empty project for licensing-service](c02explore/licensing-service)
* 1 - [Simple app](c01welcome)
    * run app: `mvn spring-boot:run`
    * make GET request: 
        * `curl localhost:8080/hello/Alice?lastName=Doe`
    * make POST request: 
        * `curl -X POST -H 'Content-Type: application/json' -d '{"firstName":"Sam","lastName":"Doe"}' localhost:8080/hello`
