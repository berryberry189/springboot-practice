package com.grace.config.autoconfig;

import com.grace.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@MyAutoConfiguration
public class PropertyPlaceholderConfig {

    @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        // 빈을 정의하는 기본적인 정보를 모은 후 후처리기를 돌려서 초기 구성 정보에서 치환자를 찾아서 교체한다
        return new PropertySourcesPlaceholderConfigurer();
    }


}
