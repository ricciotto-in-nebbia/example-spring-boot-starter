package dev.riccio.example.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoField.DAY_OF_WEEK;

public class DayOfWeekCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		int dayOfWeekNumber = LocalDateTime.now().get(DAY_OF_WEEK);

		return dayOfWeekNumber > 5;
	}
}
