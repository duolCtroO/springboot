package OortCloud.springboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration(proxyBeanMethods = false)
public class WebServerConfiguration {

    @Bean
    ServletWebServerFactory webServerFactory(){
        TomcatServletWebServerFactory webServerFactory = new TomcatServletWebServerFactory();
        webServerFactory.setPort(9090);
        return webServerFactory;
    }
}
