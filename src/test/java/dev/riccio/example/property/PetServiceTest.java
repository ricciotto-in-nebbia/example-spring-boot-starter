package dev.riccio.example.property;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PetServiceTest {

	private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
		.withConfiguration(AutoConfigurations.of(PetService.class))
		.withUserConfiguration(TestConfiguration.class)
		.withPropertyValues("app.pet.name=Lassy", "app.pet.age=8");

	@Test
	void petServiceTest() {
		this.contextRunner.run((context) -> {
			assertThat(context).hasSingleBean(PetService.class);
			assertThat(context).getBean("petService").isSameAs(context.getBean(PetService.class));

			PetService petService = context.getBean(PetService.class);
			assertEquals("Lassy", petService.getPetProperties().getName());
			assertEquals(8, petService.getPetProperties().getAge());
		});
	}

	@EnableConfigurationProperties(PetProperties.class)
	private static class TestConfiguration {
		//no-op
	}
}