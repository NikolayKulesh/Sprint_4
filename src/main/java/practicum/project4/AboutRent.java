package practicum.project4;

import org.openqa.selenium.*;

public class AboutRent {
    private WebDriver driver;

    //поле "когда привезти самокат"
    By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //поле "срок аренды"
    By rental = By.className("Dropdown-placeholder");

    //кнопка "заказать"
    By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //кнопка "да" в окне "хотите оформить заказ?"
    By buttonYes = By.xpath(".//button[text()='Да']");

    //текст в окне "заказ оформлен"
    By orderTrueText = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");


    public AboutRent(WebDriver driver) {
        this.driver = driver;
    }

    //метод заполняет поле "когда привезти самокат"
    public void enterDate(String dateValue) {
        driver.findElement(date).sendKeys(dateValue);
        driver.findElement(date).sendKeys(Keys.ENTER);
    }

    //метод кликает на кнопку заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    //метод заполняет поле "срок аренды"
    public void enterRental(String index) {
        driver.findElement(rental).click();
        WebElement enterRentalIndex = driver.findElement(By.xpath(String.format(".//div[text()='%s']", index)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", enterRentalIndex);
        enterRentalIndex.click();
    }

    //метод кликает на кнопку "да" в окне "хотитет оформить заказ"
    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }

    //метод для получения текста из окна "заказ оформлен"
    public String getOrderTrueText() {
        return driver.findElement(orderTrueText).getText();
    }

    //метод заполняет страницу "про аренду" и идет дальше
    public void enterAboutRent(String dateValue, String index) {
        enterDate(dateValue);
        enterRental(index);
        clickOrderButton();
        clickButtonYes();
    }
}
