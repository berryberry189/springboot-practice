package com.grace.springbootpractice;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class SpringbootPracticeApplication {

    @Bean
    public HelloController helloController(HelloService helloService) {
        return new HelloController(helloService);
    }

    @Bean
    public HelloService helloService() {
        return new SimpleHelloService();
    }


    public static void main(String[] args) {

        // 애플리케이션 컨텍스트
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {

            // 초기화
            @Override
            protected void onRefresh() {
                super.onRefresh();
                // TomcatServletWebServer 를 만드는 도우미 클래스 (Jetty등으로 바꾸기도 가능)
                ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
                WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet",
                                    new DispatcherServlet(this))
                            .addMapping("/*");
                });
                webServer.start();
            }
        };
        applicationContext.register(SpringbootPracticeApplication.class);
        applicationContext.refresh(); // 컨테이너 초기화 - 빈 오브젝트 생성해줌

    }

}
