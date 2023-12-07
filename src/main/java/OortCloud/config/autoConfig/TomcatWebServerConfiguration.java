package OortCloud.config.autoConfig;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatWebServerConfiguration {
    @Bean
    public ServletWebServerFactory webServerFactory(){
        return new TomcatServletWebServerFactory();
    }
}