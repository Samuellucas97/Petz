package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductList extends PageObject {
    // @FindBy(xpath = "//h3[contains(text(),'Guia Petz Flamingo para Cães')]")  - It is not possible to parametrized
    // private WebElement selectedProduct;


    public ProductList(WebDriver driver) {
        super(driver);
    }

    public void clickProduct(String titleProduct) {
        final WebElement element = driver.findElement(By.xpath("//h3[contains(text(),'" + titleProduct + "')]"));
        element.click();
    }

    public String getTitleResult(String titleSearched) {
        return driver.findElement(By.xpath("//h1[contains(text(),'resultados para \"" + titleSearched + "\"')]"))
                                .getText();
    }
}