package step_definitions;


import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class MyStepdefs {

    public static ChromeDriver driver;


    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "..\\TestTask\\drivers\\chromedriver78.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    @When("^User go to \"([^\"]*)\"$")
    public void userGoTo(String url) {
        driver.get(url);
    }

    @And("^Waiting \"([^\"]*)\" seconds$")
    public void waitingSeconds(String SecondOfWait) throws Throwable {
        double d = Double.parseDouble(SecondOfWait) * 1000;
        Thread.sleep((long) d);

    }

    @And("^Click on the button in the top menu which contains text \"([^\"]*)\"$")
    public void clickOnTheBUttonInTheTopMenuWhichContainsText(String textOfElement) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//ul//*[text()[contains(.," + textOfElement + ")]]")));
        WebElement buttonInTheTopMenu = driver.findElementByXPath
                ("//ul//a[text()[contains(.," + textOfElement + ")]]");
        buttonInTheTopMenu.click();

    }


    @After
    public void closeBrowser() {
        driver.quit();
    }


    @And("^Click on the green span which contains text \"([^\"]*)\"$")
    public void clickOnTheGreenSpanWitchContainsText(String textOfElement) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//span[text()[contains(.," + textOfElement + ")]]")));
        WebElement greenSpan = driver.findElementByXPath
                ("//span[text()[contains(.," + textOfElement + ")]]");
        greenSpan.click();
    }

    @And("^User fill field which contains placeholder \"([^\"]*)\" using text \"([^\"]*)\"$")
    public void userFillFieldWhichContainsPlaceholderUsingText(String placeholder, String text)  {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//input[@placeholder[contains(.," + placeholder + ")]]")));
        WebElement input = driver.findElementByXPath
                ("//input[@placeholder[contains(.," + placeholder + ")]]");
        input.sendKeys(text);

    }
}