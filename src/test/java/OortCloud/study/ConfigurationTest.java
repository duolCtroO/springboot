package OortCloud.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class ConfigurationTest {

    @Test
    void configuration(){
        MyConfig myConfig = new MyConfig();
        Assertions.assertThat(myConfig.bean1().common).isNotSameAs(myConfig.bean2().common);
    }

    @Test
    void configuration1(){
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh();
        Bean1 bean1 = ac.getBean(Bean1.class);
        Bean2 bean2 = ac.getBean(Bean2.class);
        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    @Test
    void MyconfigProxy(){
        MyconfigProxy myconfigProxy = new MyconfigProxy();
        Bean1 bean1 = myconfigProxy.bean1();
        Bean2 bean2 = myconfigProxy.bean2();
        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    static class MyconfigProxy extends MyConfig{
        private Common common;

        @Override
        public Common common() {
            if(common == null) this.common = super.common();
            return this.common;
        }
    }



    @Configuration
    static class MyConfig{

        @Bean
        public Common common(){
            return new Common();
        }

        @Bean
        public Bean1 bean1(){
            return new Bean1(common());
        }

        @Bean
        public Bean2 bean2(){
            return new Bean2(common());
        }

    }

    static class Bean1{
        private final Common common;

        Bean1(Common common) {
            this.common = common;
        }
    }

    static class Bean2{
        private final Common common;

        Bean2(Common common) {
            this.common = common;
        }
    }

    static class Common {

    }
}
