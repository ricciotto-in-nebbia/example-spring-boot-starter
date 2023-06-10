package dev.riccio.example.property;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PetService {

	@Getter
	private final PetProperties petProperties;
}
