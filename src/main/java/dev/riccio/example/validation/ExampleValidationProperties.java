package dev.riccio.example.validation;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.List;

@ConfigurationProperties(prefix = "app.validation")
@Data
@Validated
public class ExampleValidationProperties {

	@NotBlank
	@Length(min = 3, max = 100)
	private String name;

	@Min(10)
	@Max(65)
	private Integer age;

	@NotEmpty
	private List<String> hobbies;

	@Pattern(regexp = "\\d{6}")
	private String index;

	@Email
	private String email;

	@CellPhone
	private Long phone;
}
