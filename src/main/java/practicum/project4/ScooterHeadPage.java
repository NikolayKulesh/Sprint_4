package practicum.project4;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScooterHeadPage {
    private WebDriver driver;

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";


    // кнопка "Заказать" вверху страницы
    private By topOrderButton = By.className("Button_Button__ra12g");

    // кнопка "Заказать" внизу страницы
    private By bottomOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public ScooterHeadPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод кликает на кнопку "заказать" вверху
    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    //Метод кликает на кнопку "заказать" внизу
    public void clickBottomOrderButton() {
        WebElement botOrdBut = driver.findElement(bottomOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", botOrdBut);
        botOrdBut.click();
    }

    //метод кликает на вопрос в разделе "вопросы о важном"
    public void clickQuestion(int index) {
        WebElement questionIndex = driver.findElement(By.id(String.format("accordion__heading-%s", index)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", questionIndex);
        questionIndex.click();
    }

    //метод для получения текста ответа
    public String getAnswerText(int index) {
        WebElement answerIndex = driver.findElement(By.xpath(String.format(".//div[@id='accordion__panel-%s']/p", index)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", answerIndex);
        return answerIndex.getText();
    }
}
