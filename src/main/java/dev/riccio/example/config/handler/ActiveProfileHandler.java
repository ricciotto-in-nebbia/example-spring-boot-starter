package dev.riccio.example.config.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;

@Slf4j
public class ActiveProfileHandler implements EnvironmentPostProcessor {

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		String user = environment.getSystemProperties().get("user.name").toString();
		String javaVersion = environment.getSystemProperties()
		                                .get("java.vm.specification.version")
		                                .toString();

		environment.addActiveProfile(user + "_" + javaVersion);
		log.info("ActiveProfiles: {}", Arrays.asList(environment.getActiveProfiles()));
	}
}
