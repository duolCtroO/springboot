package OortCloud.springboot.servlet;

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
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().equals("/hello")){
            //요청 메세지, name 찾기
            String name = req.getParameter("name");
            //응답 메세지 세팅
            resp.setStatus(HttpStatus.OK.value());
            resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
            PrintWriter writer = resp.getWriter();
            writer.print("Hello " + name);
        }else{
            resp.setStatus(HttpStatus.NOT_FOUND.value());
            resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
            PrintWriter writer = resp.getWriter();
            writer.print("NOT FOUND ERROR!");
        }
    }
}
