package com.grace.springbootpractice;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringbootPracticeApplication {

    public static void main(String[] args) {

        // 애플리케이션 컨텍스트
        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
        applicationContext.registerBean(HelloController.class); // 빈 등록
        applicationContext.registerBean(SimpleHelloService.class); // 빈 등록
        applicationContext.refresh(); // 컨테이너 초기화 - 빈 오브젝트 생성해줌

        // TomcatServletWebServer 를 만드는 도우미 클래스 (Jetty등으로 바꾸기도 가능)
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("dispatcherServlet",
                            new DispatcherServlet(applicationContext))
                    .addMapping("/*");
        });
        webServer.start();

    }

}
