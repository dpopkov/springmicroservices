package learn.springmicroservices.c01welcome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/hello")
public class C01welcomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(C01welcomeApplication.class, args);
    }

    @GetMapping("/{fistName}")
    public String getHello(@PathVariable("fistName") String fistName, @RequestParam("lastName") String lastName) {
        return String.format("{\"message\":\"Hello, %s %s!\"}", fistName, lastName);
    }

    @PostMapping
    public String postHello(@RequestBody HelloRequest helloRequest) {
        return String.format("{\"message\":\"Hello, %s %s!\"}", helloRequest.getFirstName(), helloRequest.getLastName());
    }
}
