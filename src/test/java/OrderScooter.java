import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import practicum.project4.AboutRent;
import practicum.project4.ScooterHeadPage;
import practicum.project4.WhoIsTheScooterFor;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.hamcrest.CoreMatchers.is;
import static practicum.project4.ScooterHeadPage.URL;
public class OrderScooter {
    private WebDriver driver;
    String textOrderHasBeenPlaced = "Заказ оформлен";

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
    }

    //тест заказа самоката через верхнюю кнопку "заказать"
    @Test
    public void orderScooterTopButton() {
        driver.get(URL);
        ScooterHeadPage objScooterHeadPage = new ScooterHeadPage(driver);
        objScooterHeadPage.clickTopOrderButton();

        WhoIsTheScooterFor objScooterFor = new WhoIsTheScooterFor(driver);
        objScooterFor.enterWhoIsTheScooterFor("Иван", "Иванов", "Ленина, 12", 2, "+79998887766");

        AboutRent objAboutRent = new AboutRent(driver);
        objAboutRent.enterAboutRent("12.06.2024", "сутки");

        //получаю текст из окна "заказ оформлен"
        String text = objAboutRent.getOrderTrueText();
        //сравниваю полученный текст с текстом из переменной textOrderHasBeenPlaced
        MatcherAssert.assertThat("Должно появиться окно 'Заказ оформлен'", textOrderHasBeenPlaced, is(text));
    }

    //второй тест заказа самоката через верхнюю кнопку "заказать"
    @Test
    public void secondOrderScooterTopButton() {
        driver.get(URL);
        ScooterHeadPage objScooterHeadPage = new ScooterHeadPage(driver);
        objScooterHeadPage.clickTopOrderButton();

        WhoIsTheScooterFor objScooterFor = new WhoIsTheScooterFor(driver);
        objScooterFor.enterWhoIsTheScooterFor("Сергей", "Сергеев", "Рихарда Зорге, 49", 15, "+79458267863");

        AboutRent objAboutRent = new AboutRent(driver);
        objAboutRent.enterAboutRent("23.06.2024", "четверо суток");

        //получаю текст из окна "заказ оформлен"
        String text = objAboutRent.getOrderTrueText();
        //сравниваю полученный текст с текстом из переменной textOrderHasBeenPlaced
        MatcherAssert.assertThat("Должно появиться окно 'Заказ оформлен'", textOrderHasBeenPlaced, is(text));
    }

    //позитивный тест заказа самоката через нижнюю кнопку "заказать"
    @Test
    public void orderScooterBottomButton() {
        driver.get(URL);
        ScooterHeadPage objScooterHeadPage = new ScooterHeadPage(driver);
        objScooterHeadPage.clickBottomOrderButton();

        WhoIsTheScooterFor objScooterFor = new WhoIsTheScooterFor(driver);
        objScooterFor.enterWhoIsTheScooterFor("Петр", "Петров", "Будапештская, 47", 8, "+78887776655");

        AboutRent objAboutRent = new AboutRent(driver);
        objAboutRent.enterAboutRent("30.05.2024", "семеро суток");

        //получаю текст из окна "заказ оформлен"
        String text = objAboutRent.getOrderTrueText();
        //сравниваю полученный текст с текстом из переменной textOrderHasBeenPlaced
        MatcherAssert.assertThat("Должно появиться окно 'Заказ оформлен'", textOrderHasBeenPlaced, is(text));
    }

    //второй тест заказа самоката через нижнюю кнопку "заказать"
    @Test
    public void secondOrderScooterBottomButton() {
        driver.get(URL);
        ScooterHeadPage objScooterHeadPage = new ScooterHeadPage(driver);
        objScooterHeadPage.clickBottomOrderButton();

        WhoIsTheScooterFor objScooterFor = new WhoIsTheScooterFor(driver);
        objScooterFor.enterWhoIsTheScooterFor("Степан", "Степанов", "Ореховая, 25", 11, "+77776665544");

        AboutRent objAboutRent = new AboutRent(driver);
        objAboutRent.enterAboutRent("26.05.2024", "пятеро суток");

        //получаю текст из окна "заказ оформлен"
        String text = objAboutRent.getOrderTrueText();
        //сравниваю полученный текст с текстом из переменной textOrderHasBeenPlaced
        MatcherAssert.assertThat("Должно появиться окно 'Заказ оформлен'", textOrderHasBeenPlaced, is(text));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
