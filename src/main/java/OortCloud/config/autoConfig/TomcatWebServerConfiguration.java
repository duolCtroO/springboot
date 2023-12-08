package OortCloud.config.autoConfig;

import OortCloud.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

@MyAutoConfiguration
@ConditionalOnMyclass("org.apache.catalina.startup.Tomcat")
//@Conditional(TomcatWebServerConfiguration.TomcatCondition.class)
public class TomcatWebServerConfiguration {
    @Bean("tomcatWebServer")
    @ConditionalOnMissingBean
    public ServletWebServerFactory webServerFactory(){
        return new TomcatServletWebServerFactory();
    }

    static class TomcatCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return ClassUtils.isPresent("org.apache.catalina.startup.Tomcat", context.getClassLoader());
        }
    }
}
