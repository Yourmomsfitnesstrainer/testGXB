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
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[@data-qa[contains(.," + dataQa + ")]]")));
        WebElement button = driver.findElementByXPath
                ("//*[@data-qa[contains(.," + dataQa + ")]]");
        button.click();
    }

    // Метод заполнения текстом поля, с явным placeholder.
    @And("^User fill field which contains placeholder \"([^\"]*)\" using text \"([^\"]*)\"$")
    public void userFillFieldWhichContainsPlaceholderUsingText(String placeholder, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//input[@placeholder[contains(.," + placeholder + ")]]")));
        WebElement input = driver.findElementByXPath
                ("//input[@placeholder[contains(.," + placeholder + ")]]");
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
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//button[@id[contains(.," + idButton + ")]]")));
        WebElement greenSpan = driver.findElementByXPath
                ("//button[@id[contains(.," + idButton + ")]]");
        greenSpan.click();
    }

    // Метод заполнения текстом поля, с атрибутом data-qa.
    @And("^User fill field which contains data-qa \"([^\"]*)\" using text \"([^\"]*)\"$")
    public void userFillFieldWhichContainsDataQaUsingText(String dataQa, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//input[@data-qa[contains(.," + dataQa + ")]]")));
        WebElement input = driver.findElementByXPath
                ("//input[@data-qa[contains(.," + dataQa + ")]]");
        input.sendKeys(text);
    }

    //Метод только для клика по пользователю из выпадающего списка.
    @And("^Click to add user from the list$")
    public void clickToAddUserFromTheList() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[@class=\"c-select_options_list__option_label\"]")));
        WebElement elementWithUserName = driver.findElementByXPath
                ("//span[@class=\"c-select_options_list__option_label\"]");
        elementWithUserName.click();
    }

    //Метод для клика по кнопке с data-action.
    @And("^Click button which contains data-action \"([^\"]*)\"$")
    public void clickButtonWhichContainsDataAction(String dataAction) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//button[@data-action[contains(.," + dataAction + ")]]")));
        WebElement button = driver.findElementByXPath
                ("//button[@data-action[contains(.," + dataAction + ")]]");
        button.click();
    }

    //Метод для выбора чекбокса.
    @And("^Select checkbox by id \"([^\"]*)\"$")
    public void selectCheckboxById(String idOfInput) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//input[@id[contains(.," + idOfInput + ")]]")));
        WebElement button = driver.findElementByXPath
                ("//input[@id[contains(.," + idOfInput + ")]]");
        button.click();
    }

    // Метод для выбора раздела выпадающего меню настроек канала по id.
    @And("^Click on the section channel header settings \"([^\"]*)\"$")
    public void clickOnTheSectionChannelHeaderSettings(String idSectionMenu) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//div[text()[contains(., " + idSectionMenu + ")]]/parent::button")));
        WebElement button = driver.findElementByXPath
                ("//div[text()[contains(., " + idSectionMenu + ")]]/parent::button");
        button.click();
    }
}