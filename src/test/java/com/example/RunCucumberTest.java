package com.example;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectDirectories("src/test/resources/features")
@ConfigurationParameter(key = "cucumber.glue", value = "com.example.steps")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, html:build/reports/cucumber/html, json:build/reports/cucumber/cucumber.json")

public class RunCucumberTest {
}
