package dev.riccio.example.factory;

import dev.riccio.example.condition.annotation.ConditionalOnAllConditions;
import dev.riccio.example.condition.annotation.ConditionalOnAnyCondition;
import dev.riccio.example.property.PetProperties;
import dev.riccio.example.property.PetService;
import dev.riccio.example.property.UserProperties;
import dev.riccio.example.property.UserService;
import dev.riccio.example.service.*;
import dev.riccio.example.validation.ExampleValidationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

@AutoConfiguration(
	value = "exampleServiceBeanFactory",
	before = ExampleService.class
)
@EnableConfigurationProperties(UserProperties.class)
@RequiredArgsConstructor
public class ExampleServiceBeanFactory {

	@Bean
	@DependsOn("oneMoreExampleService")
	public OtherExampleService otherExampleService() {
		return new OtherExampleService();
	}

	@Bean
	public OneMoreExampleService oneMoreExampleService() {
		return new OneMoreExampleService();
	}

	@Bean
	@ConditionalOnProperty(value = "app.web.stub.is-enabled")
	public WebExampleStub webExampleStub() {
		return new WebExampleStub();
	}

	@Bean
	@ConditionalOnMissingBean(value = WebExampleStub.class)
	public WebExampleService webExampleService() {
		return new WebExampleService();
	}

	@Bean
	@ConditionalOnAllConditions
	public WatchCartoonsService watchCartoonsService() {
		return new WatchCartoonsService();
	}

	@Bean
	@ConditionalOnAnyCondition
	public PlayStationService playStationService() {
		return new PlayStationService();
	}

	@Bean
	public UserService userService(UserProperties userProperties) {
		return new UserService(userProperties);
	}

	@Bean
	public PetProperties petProperties() {
		return new PetProperties();
	}

	@Bean
	public PetService petService(PetProperties petProperties) {
		return new PetService(petProperties);
	}

	@Bean
	public ExampleValidationProperties exampleValidationProperties() {
		return new ExampleValidationProperties();
	}
}
