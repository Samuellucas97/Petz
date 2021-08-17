package petz;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Home;
import pages.ProductList;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyProduct {
    private String baseUrl;
    private WebDriver driver;

    private Home homePage;
    private ProductList productListPage;

    @Before
    public void setUp() {
        baseUrl = "https://www.petz.com.br/";

        System.setProperty("webdriver.chrome.driver",
                "/home/samuel/Downloads/petz/drivers/chrome/93/chromedriver"
        );

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        homePage = new Home(driver);
        productListPage = new ProductList(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^User accesses the Petz website home page$")
    public void user_accesses_the_Petz_website_home_page() {
        driver.get(baseUrl);
    }

    @When("^find by \"([^\"]*)\"$")
    public void find_by(String product) {
        homePage.findProduct(product);
    }

    @When("^Press the enter button$")
    public void press_the_enter_button() {
        homePage.confirmSearch();
    }

    // Normally, I should make a assertion in @Then
    @Then("^Show a list of products related with \"([^\"]*)\"$")
    public void show_a_list_of_products_related_with(String titleSearch) {
        final String titleResulted = productListPage.getTitleResult(titleSearch);
        final String expectedTitleResult = "Resultados para \"" + titleSearch + "\"";
        assertThat(titleResulted).isEqualToIgnoringCase(expectedTitleResult);
    }

    @When("^Choose \"([^\"]*)\"$")
    public void choose(String product) {
        productListPage.clickProduct(product);
    }

    // Normally, I should make a assertion in @Then
    @Then("^Show for \"([^\"]*)\" with the price \"([^\"]*)\"$")
    public void show_for_with_the_price(String arg1, String arg2) {

    }
}
