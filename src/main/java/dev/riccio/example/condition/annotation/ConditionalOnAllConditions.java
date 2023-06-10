package dev.riccio.example.condition.annotation;

import dev.riccio.example.condition.AllConditions;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Conditional(AllConditions.class)
public @interface ConditionalOnAllConditions {
}
