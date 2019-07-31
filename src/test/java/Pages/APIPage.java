package Pages;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class APIPage {

static com.jayway.restassured.response.Response Response;


    @Given("^I search for the city \"([^\"]*)\" with API$")
    public void i_search_for_the_city_with_API(String CityName) throws Throwable {
        RestAssured.baseURI ="https://samples.openweathermap.org";
        RestAssured.basePath ="data/2.5/weather";
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("q",CityName);
        paramMap.put("APPID","d0e51f8f3221ebca0cd2e290c7faa2ba");
        Response =  RestAssured.given().parameters(paramMap).get();

    }

    @Then("^I should see searched city Result contains \"([^\"]*)\"  in API$")
    public void i_should_see_searched_city_Result_contains_in_API(String CityName) throws Throwable {

                    Gson gson = new Gson();
                   ResponseWeatherData data = gson.fromJson(Response.asString(),ResponseWeatherData.class);
        Assert.assertEquals(CityName,data.name);

    }


    public class ResponseWeatherData{
        String name;
    }
}
