package dev.riccio.example.property;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "app.user")
@ConstructorBinding
@Value
public class UserProperties {

	/**
	 * Test META-data: Name of the user
	 */
	String name;

	/**
	 * Test META-data: Age of the user
	 */
	Integer age;

//	public UserProperties(@DefaultValue("default_user") String name,
//	                      @DefaultValue("-1") Integer age) {
//		this.name = name;
//		this.age = age;
//	}
}
