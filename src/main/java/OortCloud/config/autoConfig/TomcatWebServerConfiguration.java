package OortCloud.config.autoConfig;

import OortCloud.config.MyAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@MyAutoConfiguration
public class TomcatWebServerConfiguration {
    @Bean
    public ServletWebServerFactory webServerFactory(){
        return new TomcatServletWebServerFactory();
    }
}
