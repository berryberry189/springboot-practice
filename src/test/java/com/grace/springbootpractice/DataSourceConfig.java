package com.grace.springbootpractice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringbootPracticeApplication.class) // 모든 빈 구성정보 끌어옴
@TestPropertySource("classpath:/application.properties")
public class DataSourceConfig {
    @Autowired
    DataSource dataSource;

    @Test
    void connect() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.close();
    }

}
