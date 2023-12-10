package OortCloud.config.autoConfig;

import OortCloud.config.MyAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

@MyAutoConfiguration
@ConditionalOnMyclass("org.apache.catalina.startup.Tomcat")
@EnableMyConfigurationProperty(ServerProperties.class)
//@Conditional(TomcatWebServerConfiguration.TomcatCondition.class)
public class TomcatWebServerConfiguration {

    @Bean("tomcatWebServer")
    @ConditionalOnMissingBean
    public ServletWebServerFactory webServerFactory(ServerProperties serverProperties){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.setContextPath(serverProperties.getContextPath());
        tomcat.setPort(serverProperties.getPort());
        return tomcat;
    }

    static class TomcatCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return ClassUtils.isPresent("org.apache.catalina.startup.Tomcat", context.getClassLoader());
        }
    }
}
