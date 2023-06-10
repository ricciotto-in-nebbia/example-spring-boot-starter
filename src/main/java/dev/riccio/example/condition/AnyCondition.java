package dev.riccio.example.condition;

import dev.riccio.example.condition.annotation.ConditionalOnDayOfWeek;
import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.context.annotation.Conditional;

public class AnyCondition extends AnyNestedCondition {

	public AnyCondition() {
		super(ConfigurationPhase.REGISTER_BEAN);
	}

	@Conditional(TimeCondition.class)
	static class OnTimeCondition {
	}

	@ConditionalOnDayOfWeek
	static class OnDayOfWeekCondition {
	}
}
