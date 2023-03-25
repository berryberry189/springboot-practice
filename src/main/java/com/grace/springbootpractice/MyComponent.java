package com.grace.springbootpractice;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 언제까지 어노테이션이 살아 남을지
@Target(ElementType.TYPE)
@Component
public @interface MyComponent {
}
