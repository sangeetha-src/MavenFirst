package com.wipro.com.MavenSecondProject;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature\\BDD.feature", glue= {"com.wipro.com.MavenSecondProject"},monochrome = true)
public interface BDDRunner {

}
