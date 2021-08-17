package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class Home extends PageObject {
    @FindBy(id = "search")
    private WebElement searchTextBox;

    @FindBy(css = "button.button-search")
    private WebElement buttonSearch;

    public Home(WebDriver driver) {
        super(driver);
    }

    public void findProduct(String product) {
        searchTextBox.clear();
        searchTextBox.sendKeys(Keys.chord(product));
    }

    public void confirmSearch() {
        buttonSearch.click();
    }
}
