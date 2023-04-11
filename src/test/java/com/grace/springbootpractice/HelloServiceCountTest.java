package com.grace.springbootpractice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

@HelloBootTest
public class HelloServiceCountTest {
    @Autowired
    HelloService helloService;
    @Autowired HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount() {
        IntStream.rangeClosed(1, 10).forEach(count -> {
            helloService.sayHello("Andy");
            Assertions.assertThat(helloRepository.countOf("Andy")).isEqualTo(count);
        });
    }
}
