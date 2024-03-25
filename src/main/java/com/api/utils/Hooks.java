package com.api.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * Hooks allow you to execute setup and teardown actions before and after
 * scenarios.
 *
 * @author Ashok
 *
 */
public class Hooks {

	private static final Logger LOG = LogManager.getLogger(Hooks.class);

	@Before
	public static void testStart(Scenario scenario) {
		LOG.info("*****************************************************************************************");
		LOG.info("	Scenario: " + scenario.getName());
		LOG.info("*****************************************************************************************");
	}
}
