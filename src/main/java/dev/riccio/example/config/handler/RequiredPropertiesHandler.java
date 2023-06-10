package dev.riccio.example.config.handler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

public class RequiredPropertiesHandler implements EnvironmentPostProcessor {

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		environment.setRequiredProperties("app.web.stub.is-enabled");
		environment.validateRequiredProperties();
	}
}
