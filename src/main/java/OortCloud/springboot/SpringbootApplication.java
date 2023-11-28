package OortCloud.springboot;

import OortCloud.springboot.servlet.MyFrontServlet;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class SpringbootApplication {
	public static void main(String[] args) {
		//Spring에서 별 다른 설정없이 ServletContainer(Tomcat)를 쉽게 만들 수 있게 정의한 Class
		ServletWebServerFactory webServerFactory = new TomcatServletWebServerFactory();
		WebServer webServer = webServerFactory.getWebServer(
				servletContext -> {
					servletContext.addServlet("hello", new MyFrontServlet()).addMapping("/*");
				});//Tomcat뿐만 아니라 다른 ServletContainer를 쉽게 생성하기 위해 추상화한 Class
		webServer.start();
	}

}
