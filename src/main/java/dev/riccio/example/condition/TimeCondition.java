package dev.riccio.example.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class TimeCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//		String start = context.getEnvironment().getProperty("app.condition.start-time");
//		String finish = context.getEnvironment().getProperty("app.condition.finish-time");

		String start = "1";
		String finish = "22";

		int currentHour = LocalDateTime.now().get(ChronoField.HOUR_OF_DAY);
		return Integer.parseInt(start) <= currentHour && currentHour <= Integer.parseInt(finish);
	}
}
