import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import practicum.project4.ScooterHeadPage;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.hamcrest.CoreMatchers.is;
import static practicum.project4.ScooterHeadPage.URL;
@RunWith(Parameterized.class)
public class AnswersQuestions {
    private final int questionIndex;
    private final int answerIndex;
    private final String expectedAnswer;

    public AnswersQuestions(int questionIndex, int answerIndex, String expectedAnswer) {
        this.questionIndex = questionIndex;
        this.answerIndex = answerIndex;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        //Сгенерируй тестовые данные (свою учётку и несколько случайных)
        return new Object[][] {
                {0, 0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, 1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, 2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, 3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, 4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, 5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, 6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, 7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
    }

    @Test
    public void trueAnswerQuestions() {
        driver.get(URL);
        ScooterHeadPage objScooterHeadPage = new ScooterHeadPage(driver);
        objScooterHeadPage.clickQuestion(questionIndex);
        //получаю текст ответа
        String answerText = objScooterHeadPage.getAnswerText(answerIndex);
        //сравниваю полученый текст ответа с ожидаемым ответом
        MatcherAssert.assertThat("Текст ответа не соответствует ожидаемому", expectedAnswer, is(answerText));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
