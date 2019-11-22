package step_definitions;

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

    //Установление настроек для экземпляра браузера.
    @When("^Opening and setting the browser$")
    public void openingAndSettingTheBrowser() {
        System.setProperty("webdriver.chrome.driver", "..\\TestTask\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //Метод загрузки страницы.
    @When("^User go to \"([^\"]*)\"$")
    public void userGoTo(String url) {
        driver.get(url);
    }

    //Метод для явного ожидания в секундах.
    @And("^Waiting \"([^\"]*)\" seconds$")
    public void waitingSeconds(String SecondOfWait) throws Throwable {
        double d = Double.parseDouble(SecondOfWait) * 1000;
        Thread.sleep((long) d);
    }

    //Метод клика по кнопке, у которой есть data-qa атрибут.
    @And("^Click on the button which contains data-qa \"([^\"]*)\"$")
    public void clickOnTheButtonWhichContainsDataQa(String dataQa) {
        String locator = "//*[@data-qa[contains(.," + dataQa + ")]]";
        waiterToBeClickable(locator);
        WebElement button = driver.findElementByXPath(locator);
        button.click();
    }

    // Метод заполнения текстом поля, с явным placeholder.
    @And("^User fill field which contains placeholder \"([^\"]*)\" using text \"([^\"]*)\"$")
    public void userFillFieldWhichContainsPlaceholderUsingText(String placeholder, String text) {
        String locator = "//input[@placeholder[contains(.," + placeholder + ")]]";
        waiterVisibilityOfElement(locator);
        WebElement input = driver.findElementByXPath(locator);
        input.sendKeys(text);
    }

    // Метод закрытия браузера.
    @And("^Close browser$")
    public static void closeBrowser() {
        driver.quit();
    }

    // Метод клика по зелёным кнопкам по уникальному id.
    @And("^Click on the green span which contains id \"([^\"]*)\"$")
    public void clickOnTheGreenSpanWitchContainsId(String idButton) {
        String locator = "//button[@id[contains(.," + idButton + ")]]";
        waiterToBeClickable(locator);
        WebElement greenSpan = driver.findElementByXPath(locator);
        greenSpan.click();
    }

    // Метод заполнения текстом поля, с атрибутом data-qa.
    @And("^User fill field which contains data-qa \"([^\"]*)\" using text \"([^\"]*)\"$")
    public void userFillFieldWhichContainsDataQaUsingText(String dataQa, String text) {
        String locator = "//input[@data-qa[contains(.," + dataQa + ")]]";
        waiterVisibilityOfElement(locator);
        WebElement input = driver.findElementByXPath(locator);
        input.sendKeys(text);
    }

    //Метод только для клика по пользователю из выпадающего списка.
    @And("^Click to add user from the list$")
    public void clickToAddUserFromTheList() {
        String locator = "//span[@class=\"c-select_options_list__option_label\"]";
        waiterVisibilityOfElement(locator);
        WebElement elementWithUserName = driver.findElementByXPath(locator);
        elementWithUserName.click();
    }

    //Метод для клика по кнопке с data-action.
    @And("^Click button which contains data-action \"([^\"]*)\"$")
    public void clickButtonWhichContainsDataAction(String dataAction) {
        String locator = "//button[@data-action[contains(.," + dataAction + ")]]";
        waiterToBeClickable(locator);
        WebElement buttonElement = driver.findElementByXPath(locator);
        buttonElement.click();
    }

    //Метод для выбора чекбокса.
    @And("^Select checkbox by id \"([^\"]*)\"$")
    public void selectCheckboxById(String idOfInput) {
        String locator = "//input[@id[contains(.," + idOfInput + ")]]";
        waiterVisibilityOfElement(locator);
        WebElement buttonElement = driver.findElementByXPath(locator);
        buttonElement.click();
    }

    // Метод для выбора раздела выпадающего меню настроек канала по id.
    @And("^Click on the section channel header settings \"([^\"]*)\"$")
    public void clickOnTheSectionChannelHeaderSettings(String idSectionMenu) {
        String locator = "//div[text()[contains(., " + idSectionMenu + ")]]/parent::button";
        waiterToBeClickable(locator);
        WebElement buttonElement = driver.findElementByXPath(locator);
        buttonElement.click();
    }

    //Метод для ожидания видимости элемента.
    public void waiterVisibilityOfElement(String SomeLocatorByXpath) {
        WebDriverWait waitVisibility = new WebDriverWait(driver, 10);
        waitVisibility.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SomeLocatorByXpath)));

    }

    //Метод для ожидания кликабельности элемента.
    public void waiterToBeClickable(String SomeLocatorByXpath) {
        WebDriverWait waitClickable = new WebDriverWait(driver, 10);
        waitClickable.until(ExpectedConditions.elementToBeClickable(By.xpath(SomeLocatorByXpath)));

    }
}