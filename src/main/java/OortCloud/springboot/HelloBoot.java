package OortCloud.springboot;

import java.util.Objects;

public class HelloBoot {
    private final HelloService helloService;

    public HelloBoot(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name){
        return helloService.service(Objects.requireNonNull(name));
    }
}
