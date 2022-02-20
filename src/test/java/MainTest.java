import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AllureUtils;
import utils.WebDriverSingleton;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;
import static utils.WebDriverSingleton.getDriver;

@DisplayName("Тест youtube.com")
public class MainTest {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
    Actions actions = new Actions(getDriver());

    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {

        getDriver().quit();
    }

    @Test
    @DisplayName("Непосредственно тест")
    public void checkYoutube() {

        Allure.step("Пользователь заходит на сайт Яндекс: www.yandex.ru", () -> {
            getDriver().get("https://www.yandex.ru");
            AllureUtils.screenshotAfterStep();
        });

        Allure.step("Пользователь вводит в поисковую строку «youtube» и нажимает на кнопку «Поиск»", () -> {
            AllureUtils.screenshotBeforeStep();

            getDriver().findElement(By.id("text"))
                    .sendKeys("youtube", ENTER);

            AllureUtils.screenshotAfterStep();
        });

        Allure.step("Пользователь ищет и переходит на сайт youtube.com ", () -> {
            AllureUtils.screenshotBeforeStep();

            getDriver()
                    .findElement(By.cssSelector("div[class='Path Organic-Path Organic-Path_verified path organic__path']")).click();

            AllureUtils.screenshotAfterStep();
        });

        Allure.step("Пользователь убеждается что попал на нужный сайт", () -> {
            AllureUtils.screenshotBeforeStep();

            String currentTab = WebDriverSingleton.getDriver().getWindowHandle();
            for (String tab : WebDriverSingleton.getDriver().getWindowHandles()) {
                if (!tab.equals(currentTab)) {
                    WebDriverSingleton.getDriver().switchTo().window(tab);
                }
            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='style-scope ytd-topbar-logo-renderer']")));

            AllureUtils.screenshotAfterStep();
        });

       Allure.step("Пользователь вводит в поисковую строку «Первое видео на youtube»", () -> {
            AllureUtils.screenshotBeforeStep();

           wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='search']")))
                   .sendKeys("Первое видео на youtube");

            AllureUtils.screenshotAfterStep();
        });

        Allure.step("Пользователь кликает по кнопке «Поиск» ", () -> {
            AllureUtils.screenshotBeforeStep();

            getDriver()
                    .findElement(By.cssSelector("button[id='search-icon-legacy']")).click();

            AllureUtils.screenshotAfterStep();
        });

        Allure.step("Пользователь ищет видео с названием «Me at the zoo» и кликает по нему", () -> {
            AllureUtils.screenshotBeforeStep();

            WebElement elm = WebDriverSingleton.getDriver().findElement(By.cssSelector("a[href='/watch?v=jNQXAC9IVRw']"));
            ((JavascriptExecutor)WebDriverSingleton.getDriver()).executeScript("arguments[0].scrollIntoView(true);",elm);
            elm.click();

            AllureUtils.screenshotAfterStep();
        });

        Allure.step("Пользователь нажимает на кнопку «Пауза»", () -> {
            AllureUtils.screenshotBeforeStep();

            getDriver()
                    .findElement(By.cssSelector("button[class='ytp-play-button ytp-button']")).click();

            AllureUtils.screenshotAfterStep();
        });

        Allure.step("Пользователь нажимает на кнопку «Развернуть видео на весь экран»", () -> {
            AllureUtils.screenshotBeforeStep();

            getDriver()
                    .findElement(By.cssSelector("button[class='ytp-fullscreen-button ytp-button']")).click();

            AllureUtils.screenshotAfterStep();
        });

        Allure.step("Пользователь жмет на кнопку «Воспроизвести видео»", () -> {
            AllureUtils.screenshotBeforeStep();

            getDriver()
                    .findElement(By.cssSelector("button[class='ytp-play-button ytp-button']")).click();
            AllureUtils.screenshotAfterStep();
        });

        Allure.step("Пользователь жмет на кнопку «Субтитры»", () -> {
            AllureUtils.screenshotBeforeStep();

            getDriver()
                    .findElement(By.cssSelector("button[class='ytp-subtitles-button ytp-button']")).click();
            AllureUtils.screenshotAfterStep();
        });

        Allure.step("Пользователь нажимает на кнопку «Выход из полноэкранного режима»", () -> {
            AllureUtils.screenshotBeforeStep();

            getDriver()
                    .findElement(By.cssSelector("button[class='ytp-fullscreen-button ytp-button']")).click();

            AllureUtils.screenshotAfterStep();
        });

        Allure.step("Пользователь нажимает на кнопку «Пауза»", () -> {
            AllureUtils.screenshotBeforeStep();

            getDriver()
                    .findElement(By.cssSelector("button[class='ytp-play-button ytp-button']")).click();

            AllureUtils.screenshotAfterStep();

            Thread.sleep(10000);
        });
    }
}