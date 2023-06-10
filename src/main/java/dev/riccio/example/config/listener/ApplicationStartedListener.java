package dev.riccio.example.config.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationStartedListener implements ApplicationListener<ApplicationStartedEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		Thread hook = new Thread(() -> System.out.println("Example Spring Boot Starter ShutdownHook"));
		Runtime.getRuntime().addShutdownHook(hook);
	}
}
