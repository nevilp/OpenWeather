package Utils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Browser {

    private WebDriver driver;





    public WebDriver getDriver() {
        return driver;
    }

    @Before
    public void invokeBrowser()
    {
       File file = new File("src\\test\\resources\\Drivers\\chromedriver.exe");
       System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
       driver = new ChromeDriver();
       driver.manage().window().maximize();
    }


    @After
    public void quitBrowser(Scenario scenario)


    {

        if(scenario.isFailed())
        {

        }
        driver.close();
        driver.quit();
    }

}
