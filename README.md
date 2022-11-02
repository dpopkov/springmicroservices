# Spring Microservices

## Projects:
* 5 - Controlling configuration with Spring Cloud Config Server
    * Build Spring Cloud [Configuration Server](c05cloudconfig/configserver)
        * Set up the Spring Cloud Config bootstrap class
            * configserver: add `@EnableConfigServer` annotation
        * Use Config Server with a filesystem
            * configserver: add bootstrap.yml file containing `spring.cloud.config.server.native.search-locations`
            * licensing-service: add bootstrap.yml file containing `spring.cloud.config.uri`
        * Setup the configuration files for a service
            * create `resources/config` directory within configserver project
            * put property files for the licensing-service into the config directory
    * Integrate Config Server with a Spring Boot client - [licensing-service](c05cloudconfig/licensing-service)
        * Set up licensing service dependencies: `spring-cloud-starter-config` plus dependencies for JPA and DB driver
        * Configure licensing service to use Spring Cloud Config Server
            * The bootstrap.yml should contain properties for communicating with Spring Cloud Config service:
                * `spring.application.name`
                * `spring.profiles.active`
                * `spring.cloud.config.uri`
    * Wire in a datasource using Config Server
        * Add JPA repository, modify model, service and controlling classes for using Data JPA and real DB
        * Test with config server disabled using property `spring.cloud.config.enabled=false`
* 4 - [Using Docker](c04docker/licensing-service)
    * Building image with Docker Maven plugin:
        * Add Docker Maven plugin
        * Add Dockerfile
        * Build image: `mvn package dockerfile:build`
        * Run container: 
            * In interactive bash: `docker run -it -p8080:8080 sprmsaction/licensing-service:0.0.1-SNAPSHOT`
            * In background: `docker run -d -p8080:8080 sprmsaction/licensing-service:0.0.1-SNAPSHOT`
        * Stop container: `Ctrl+C` or `docker stop <container-id>`
    * Building image with Spring Boot:
        * Build image: `mvn spring-boot:build-image`
    * Launching the services with Docker Compose:
        * Add docker-compose.yml file
        * Run: `docker-compose up`
* 3 - [Building microservice](c03building/licensing-service)
* 2 - [Base empty project for licensing-service](c02explore/licensing-service)
* 1 - [Simple app](c01welcome)
    * run app: `mvn spring-boot:run`
    * make GET request: 
        * `curl localhost:8080/hello/Alice?lastName=Doe`
    * make POST request: 
        * `curl -X POST -H 'Content-Type: application/json' -d '{"firstName":"Sam","lastName":"Doe"}' localhost:8080/hello`
