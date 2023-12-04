package OortCloud.springboot;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringBootApplication {

    public static void run(Class<?> applicationClass, String... args){
        //Spring Container 생성
        //Spring Container 생성하면서 ServletContainer 생성하도록 수정
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();
                ServletWebServerFactory webServerFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);

                //dispatcherServlet.setApplicationContext(this);
                //Spring에서 별 다른 설정없이 ServletContainer(Tomcat)를 쉽게 만들 수 있게 정의한 Class
                WebServer webServer = webServerFactory.getWebServer(
                        servletContext -> {
                            servletContext.addServlet("dispatcherServlet",
                                    dispatcherServlet
                            ).addMapping("/*");
                        });//Tomcat뿐만 아니라 다른 ServletContainer를 쉽게 생성하기 위해 추상화한 Class
                webServer.start();
            }
        };
        applicationContext.register(applicationClass);
        applicationContext.refresh();
    }
}
