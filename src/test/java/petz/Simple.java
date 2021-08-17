package petz;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public final class Simple {
    private static String baseUrl;
    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        baseUrl = "https://www.petz.com.br/";

        System.setProperty("webdriver.chrome.driver",
                "/home/samuel/Downloads/petz/drivers/chrome/93/chromedriver"
        );

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    void acessingHomePage() {
        driver.get(baseUrl);

        final String titleHeaderPage = driver.getTitle();
        String expectedTitleHeaderPage = "Pet Shop: Petz o maior pet shop do Brasil.";

        assertThat(titleHeaderPage).isEqualTo(expectedTitleHeaderPage);
    }

}
