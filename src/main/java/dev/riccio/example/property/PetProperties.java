package dev.riccio.example.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.pet")
@Data
public class PetProperties {

	/**
	 * Name of the pet
	 */
	private String name = "Lucky";

	/**
	 * Age of the pet
	 */
	private Integer age = 4;
}

