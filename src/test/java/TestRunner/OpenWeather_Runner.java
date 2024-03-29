package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features"},
        format = {"pretty","html:target/Destination"},
        tags = {"@EndToEnd"},
        glue = {"Utils","Pages"}
)
public class OpenWeather_Runner {


}
