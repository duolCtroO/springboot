package OortCloud.springboot;

import OortCloud.springboot.annotation.MyAnnotation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


@RestController
public class HelloBootController {
    private final HelloService helloService;

    public HelloBootController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(String name){
        return helloService.service(Objects.requireNonNull(name));
    }
}
