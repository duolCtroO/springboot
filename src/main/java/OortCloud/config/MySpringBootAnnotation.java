package OortCloud.config;

import OortCloud.config.Config;
import OortCloud.config.EnableMyAutoConfig;
import OortCloud.config.autoConfig.DispatcherServletConfiguration;
import OortCloud.config.autoConfig.TomcatWebServerConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration
@ComponentScan
@EnableMyAutoConfig
public @interface MySpringBootAnnotation {
}
