package practicum.project4;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WhoIsTheScooterFor {
    private WebDriver driver;

    //поле "Имя"
    private By name = By.xpath(".//input[@placeholder='* Имя']");


    //поле "Фамилия"
    private By surname = By.xpath(".//input[@placeholder='* Фамилия']");

    //поле "Адрес"
    private By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //поле "Станция метро"
    private By metroStation = By.className("select-search__input");

    //поле "Номер телефона"
    private By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //кнопка "далее"
    private By nextButton = By.xpath(".//button[text()='Далее']");

    public WhoIsTheScooterFor(WebDriver driver) {
        this.driver = driver;
    }

    //Метод заполняет поле "Имя"
    public void enterName(String nameValue) {
        driver.findElement(name).sendKeys(nameValue);
    }

    //метод заполняет поле "фамилия"
    public void enterSurname(String surnameValue) {
        driver.findElement(surname).sendKeys(surnameValue);
    }

    //метод заполняет поле "адрес"
    public void enterAddress(String addressValue) {
        driver.findElement(address).sendKeys(addressValue);
    }

    //метод заполняет поле "метро"
    public void enterMetroStation(int index) {
        driver.findElement(metroStation).click();
        WebElement metroStationIndex = driver.findElement(By.xpath(String.format(".//button[@value='%s']", index)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", metroStationIndex);
        metroStationIndex.click();
    }

    //метод заполняет поле "номер телефона"
    public void enterPhone(String phoneValue) {
        driver.findElement(phone).sendKeys(phoneValue);
    }

    //метод кликает на кнопку "далее"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    //Метод заполняет страницу "для кого самокат" и идет дальше
    public void enterWhoIsTheScooterFor(String nameValue, String surnameValue, String addressValue, int index, String phoneValue) {
        enterName(nameValue);
        enterSurname(surnameValue);
        enterAddress(addressValue);
        enterMetroStation(index);
        enterPhone(phoneValue);
        clickNextButton();
    }
}
