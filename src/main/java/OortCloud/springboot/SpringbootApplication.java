package OortCloud.springboot;

import OortCloud.springboot.servlet.MyFrontServlet;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;



public class SpringbootApplication {
	public static void main(String[] args) {
		//Spring Container 생성
		GenericApplicationContext applicationContext = new GenericApplicationContext();


		//Spring에서 별 다른 설정없이 ServletContainer(Tomcat)를 쉽게 만들 수 있게 정의한 Class
		ServletWebServerFactory webServerFactory = new TomcatServletWebServerFactory();
		WebServer webServer = webServerFactory.getWebServer(
				servletContext -> {
					servletContext.addServlet("hello", new MyFrontServlet(applicationContext)).addMapping("/*");
				});//Tomcat뿐만 아니라 다른 ServletContainer를 쉽게 생성하기 위해 추상화한 Class
		webServer.start();
	}

}
