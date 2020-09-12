package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature1\\Assign5.feature", glue= {"com.wipro.com.MavenSecondProject"},monochrome = true)

public class Assignment5Runner {

}
