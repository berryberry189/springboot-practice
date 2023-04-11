package com.grace.springbootpractice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@HelloBootTest
public class HelloRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired HelloRepository helloRepository;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    @Test
    void findHelloFailed() {
        assertThat(helloRepository.findHello("Andy")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("Andy")).isEqualTo(0);

        helloRepository.increaseCount("Andy");
        assertThat(helloRepository.countOf("Andy")).isEqualTo(1);

        helloRepository.increaseCount("Andy");
        assertThat(helloRepository.countOf("Andy")).isEqualTo(2);
    }

}
