package OortCloud.springboot;

import OortCloud.springboot.servlet.MyFrontServlet;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class SpringbootApplication {

	@Bean
	public HelloBootController helloBootController(HelloService helloService){
		return  new HelloBootController(helloService);
	}

	@Bean
	public HelloService simpleHelloService(){
		return new SimpleHelloService();
	}

	public static void main(String[] args) {
		//Spring Container 생성
		//Spring Container 생성하면서 ServletContainer 생성하도록 수정
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();
				//Spring에서 별 다른 설정없이 ServletContainer(Tomcat)를 쉽게 만들 수 있게 정의한 Class
				ServletWebServerFactory webServerFactory = new TomcatServletWebServerFactory();
				WebServer webServer = webServerFactory.getWebServer(
						servletContext -> {
							servletContext.addServlet("dispatcherServlet",
									new DispatcherServlet(this)
							).addMapping("/*");
						});//Tomcat뿐만 아니라 다른 ServletContainer를 쉽게 생성하기 위해 추상화한 Class
				webServer.start();
			}
		};
		applicationContext.register(SpringbootApplication.class);
		applicationContext.refresh();
	}

}
