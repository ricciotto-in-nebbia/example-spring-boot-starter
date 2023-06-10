package dev.riccio.example.event;

import dev.riccio.example.factory.ExampleServiceBeanFactory;
import dev.riccio.example.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.ApplicationEventPublisher;

import javax.annotation.PostConstruct;

@AutoConfiguration(
	after = {
		ExampleService.class,
		ExampleServiceBeanFactory.class
	}
)
@RequiredArgsConstructor
public class ExampleEventPublisher {

	private final ApplicationEventPublisher eventPublisher;

	@PostConstruct
	public void init() {
		eventPublisher.publishEvent(new ExampleSpringBootStarterEvent());
	}
}
