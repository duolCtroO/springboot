package OortCloud.springboot.servlet;

import OortCloud.springboot.ComplexHelloService;
import OortCloud.springboot.HelloBoot;
import OortCloud.springboot.SimpleHelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class MyFrontServlet extends HttpServlet {
    private GenericApplicationContext gac;
    public MyFrontServlet(){}

    public MyFrontServlet(GenericApplicationContext applicationContext){
        gac = applicationContext;
        gac.registerBean(HelloBoot.class);
        gac.registerBean(SimpleHelloService.class);
        //gac.registerBean(ComplexHelloService.class); HelloService 구현체 중복 에러
        gac.refresh();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().equals("/hello")){
            //요청 메세지, name 찾기
            String name = req.getParameter("name");
            HelloBoot helloBoot = gac.getBean(HelloBoot.class);
            String res = helloBoot.hello(name);
            //응답 메세지 세팅
            resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
            PrintWriter writer = resp.getWriter();
            writer.print(res);
        }else{
            resp.setStatus(HttpStatus.NOT_FOUND.value());
            resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
            PrintWriter writer = resp.getWriter();
            writer.print("NOT FOUND ERROR!");
        }
    }
}
