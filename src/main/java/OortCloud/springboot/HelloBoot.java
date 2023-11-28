package OortCloud.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloBoot {
    @GetMapping("/hello")
    public String hello(String name){
        return "Hello " + name;
    }
}
