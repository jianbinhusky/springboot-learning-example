package org.spring.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Spring Boot HelloWorld 案例
 *
 * Created by bysocket on 16/4/26.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/co")
    public String cook(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession(true);
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " = " + cookie.getValue());
            session.setAttribute("session"+"_"+cookie.getName(),cookie.getValue());
        }

        List<String> names = Collections.list(session.getAttributeNames());

        for (String name : names) {
            System.out.println(name + "\t" + session.getAttribute(name));
        }

        return "cookie";
    }

    @RequestMapping("/")
    public String sayHello(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("start1","coke");
        cookie.setComment("This is a cute cookie for eating");
        cookie.setDomain("www.hyike.com");
        cookie.setMaxAge(-1);
        cookie.setValue("I'mavalue");
        cookie.setPath("/");

        Cookie cookie2 = new Cookie("start2","coke");
        cookie2.setComment("This is a cute cookie for cook");
        cookie2.setDomain("www.jianbin.com");
        cookie2.setMaxAge(3600);
        cookie2.setPath("/");
        cookie2.setHttpOnly(true);
        cookie2.setSecure(false);
        cookie2.setVersion(1);


        Cookie cookie3 = new Cookie("start3","sess");
        cookie3.setComment("This is a cute cookie for cook");
        cookie3.setMaxAge(3600);
        cookie3.setPath("/");
        cookie3.setHttpOnly(true);
        cookie3.setSecure(false);
        cookie3.setVersion(1);
        cookie3.setDomain("10.116.48.13");

        response.addCookie(cookie3);
        response.addCookie(cookie2);
        response.addCookie(cookie);

        Cookie cookie4 = new Cookie("start4","st4");
        cookie4.setComment("This is a cute cookie for eating");
        cookie4.setMaxAge(-1);
        cookie4.setPath("/");
        response.addCookie(cookie4);

        HttpSession session = request.getSession();
        while (session.getAttributeNames().hasMoreElements()) {
            String name = session.getAttributeNames().nextElement();
            System.out.println("Sessions : list ....");
            System.out.println(name + "\t" + session.getAttribute(name));
        }
        return "Hello,World!";
    }
}
