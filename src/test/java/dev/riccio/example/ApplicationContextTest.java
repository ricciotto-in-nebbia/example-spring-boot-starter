package dev.riccio.example;

import dev.riccio.example.property.PetService;
import dev.riccio.example.property.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static dev.riccio.example.ApplicationContextTest.*;
import static java.time.temporal.ChronoField.DAY_OF_WEEK;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
	properties = {
		"app.condition.start-time=" + START,
		"app.condition.finish-time=" + FINISH,
		"app.user.name=" + USER_NAME,
		"app.user.age=" + USER_AGE,
		"app.pet.name=" + PET_NAME,
		"app.pet.age=" + PET_AGE
	}
)
class ApplicationContextTest {

	public static final int START = 11;
	public static final int FINISH = 17;
	public static final String USER_NAME = "J.Daniels";
	public static final String USER_AGE = "55";
	public static final String PET_NAME = "Chip";
	public static final String PET_AGE = "3";

	@Autowired
	private ApplicationContext context;

	@Autowired
	private UserService userService;

	@Autowired
	private PetService petService;

	@ParameterizedTest
	@MethodSource("beanNames")
	void isExampleServiceContains(String beanName) {
		var actual = context.containsBean(beanName);
		assertTrue(actual);
	}

	private static Stream<String> beanNames() {
		return Stream.of(
			"dev.riccio.example.service.ExampleService",
			"exampleServiceBeanFactory",
			"otherExampleService",
			"oneMoreExampleService"
		);
	}

	@Test
	void isWebExampleStubContains() {
		var actual = context.containsBean("webExampleStub");
		assertTrue(actual);
	}

	@Test
	void isWebExampleServiceContains() {
		var actual = context.containsBean("webExampleService");
		assertFalse(actual);
	}

	@Test
	void isWatchCartoonsServiceContains() {
		int currentHour = LocalDateTime.now().getHour();
		int dayOfWeekNumber = LocalDateTime.now().get(DAY_OF_WEEK);

		var actual = context.containsBean("watchCartoonsService");

		if ((START <= currentHour && currentHour <= FINISH) && dayOfWeekNumber > 5) {
			assertTrue(actual);
		} else {
			assertFalse(actual);
		}
	}

	@Test
	void isPlayStationServiceContains() {
		int currentHour = LocalDateTime.now().getHour();
		int dayOfWeekNumber = LocalDateTime.now().get(DAY_OF_WEEK);

		var actual = context.containsBean("playStationService");

		if ((START <= currentHour && currentHour <= FINISH) || dayOfWeekNumber > 5) {
			assertTrue(actual);
		} else {
			assertFalse(actual);
		}
	}

	@Test
	void checkUserPropertiesData() {
		assertEquals(USER_NAME, userService.getUserProperties().getName());
		assertEquals(Integer.parseInt(USER_AGE), userService.getUserProperties().getAge());
	}

	@Test
	void checkPetPropertiesData() {
		assertEquals(PET_NAME, petService.getPetProperties().getName());
		assertEquals(Integer.parseInt(PET_AGE), petService.getPetProperties().getAge());
	}

	@SpringBootApplication
	public static class TestApplication {
		//no-op
	}
}