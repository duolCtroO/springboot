package OortCloud.springboot;

public class SimpleHelloService implements HelloService {
    @Override
    public String service(String name){
        return "Hello Service " + name;
    }
}
