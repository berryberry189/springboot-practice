package com.grace.config.autoconfig;

import com.grace.config.ConditionalMyOnClass;
import com.grace.config.MyAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

    @Value("${contextPath}")
    String contextPath;

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean // 같은 타입의 빈을 개발자가 구성한 것이 있는 경우에는 그것을 사용하고 없다면 이것을 사용
    public ServletWebServerFactory servletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setContextPath(this.contextPath);
        return factory;
    }
}
