package com.company.api.frontendBDD.runners;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
        retryCount = 3,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        //coverageReport = true,
        jsonUsageReport = "target/cucumber-usage.json",
        usageReport = true,
        toPDF = true,
        excludeCoverageTags = {"@flaky" },
        includeCoverageTags = {"@passed" },
        outputFolder = "reports/")
@CucumberOptions(
        features = { "src/test/resources/features" },
        glue = { "classpath:com.company.api.frontendBDD.webDriver", "classpath:com.company.api.frontendBDD.steps", "classpath:com.company.api.frontendBDD.runners" },
        tags = { "~@ignore","@Steps"},
        plugin = { "html:target/LoginReport", "json:target/cucumber.json",
                "pretty:target/cucumber-pretty.txt",
                "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"})
public class TestRunner {

}
