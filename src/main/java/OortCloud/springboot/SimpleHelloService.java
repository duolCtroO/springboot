package OortCloud.springboot;

import OortCloud.springboot.annotation.MyAnnotation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SimpleHelloService implements HelloService {
    @Override
    public String service(String name){
        return "Hello Service " + name;
    }
}
