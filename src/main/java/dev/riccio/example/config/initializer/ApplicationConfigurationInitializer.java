package dev.riccio.example.config.initializer;

import dev.riccio.example.service.ApplicationConfigurationService;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationConfigurationInitializer implements ApplicationContextInitializer<AnnotationConfigApplicationContext> {

	@Override
	public void initialize(AnnotationConfigApplicationContext applicationContext) {
		applicationContext.register(ApplicationConfigurationService.class);
	}
}
