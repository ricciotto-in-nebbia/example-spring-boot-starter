package dev.riccio.example.service;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

@Slf4j
public class ApplicationConfigurationService {

	@PostConstruct
	public void init() {
		log.info("ApplicationConfigurationService initialized");
	}
}
