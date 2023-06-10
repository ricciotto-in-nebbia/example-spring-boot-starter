package dev.riccio.example.config.handler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

public class EnvironmentHandler implements EnvironmentPostProcessor {

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		Resource resource = new ClassPathResource("example-spring-boot-starter-validation.properties");
		if (resource.exists()) {
			setResource(resource, environment);
		}
	}

	private void setResource(Resource resource, ConfigurableEnvironment environment) {
		try {
			ResourcePropertySource propertySource = new ResourcePropertySource(resource);
			environment.getPropertySources().addLast(propertySource);
		} catch (IOException e) {
			throw new IllegalStateException("Failed to load integration properties from " + resource);
		}
	}
}
