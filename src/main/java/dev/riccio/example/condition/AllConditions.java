package dev.riccio.example.condition;

import dev.riccio.example.condition.annotation.ConditionalOnDayOfWeek;
import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.context.annotation.Conditional;

public class AllConditions extends AllNestedConditions {

	public AllConditions() {
		super(ConfigurationPhase.REGISTER_BEAN);
	}

	@Conditional(TimeCondition.class)
	static class OnTimeCondition {
	}

	@ConditionalOnDayOfWeek
	static class OnDayOfWeekCondition {
	}
}
