package dev.riccio.example.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class CellPhoneValidator implements ConstraintValidator<CellPhone, Long> {

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		return Objects.nonNull(value)
			&& value >= 7_900_000_00_00L
			&& value <= 7_999_999_99_99L;
	}
}
