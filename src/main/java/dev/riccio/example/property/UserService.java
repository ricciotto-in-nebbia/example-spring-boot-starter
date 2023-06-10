package dev.riccio.example.property;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {

	@Getter
	private final UserProperties userProperties;
}
