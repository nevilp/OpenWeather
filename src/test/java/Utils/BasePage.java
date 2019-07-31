package Utils;



/*This is base class having selenium webdriver based functionality- which interacts with browser*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasePage {
protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;

    }



  protected  Set<String> getUrl(By Locator, String attribute) {
      Set<String> UrlList = new HashSet<String>();

      List<WebElement> webElements = driver.findElements(Locator);
      for (WebElement element : webElements) {
          UrlList.add(   element.getAttribute(attribute));
      }
      return  UrlList;


  }


    protected void clickOn(By Locator) {

        driver.findElement(Locator).click();


    }


    protected String getText(By Locator) {
       return driver.findElement(Locator).getText();

    }


    protected void enterText(By Locator, String ValueToBeEnter) {
        driver.findElement(Locator).sendKeys(ValueToBeEnter);
    }

}
