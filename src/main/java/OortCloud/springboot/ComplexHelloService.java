package OortCloud.springboot;

public class ComplexHelloService implements HelloService{
    @Override
    public String service(String name) {
        return "Complex Hello " + name;
    }
}
