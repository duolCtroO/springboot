package OortCloud.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;


@RequestMapping("/hello")
public class HelloBootController {
    private final HelloService helloService;

    public HelloBootController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    @ResponseBody
    public String hello(String name){
        return helloService.service(Objects.requireNonNull(name));
    }
}
