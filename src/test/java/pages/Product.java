package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product extends PageObject {

    @FindBy(id = "152132")
    private WebElement buttonSizePP;
    @FindBy(id = "152131")
    private WebElement buttonSizeP;
    @FindBy(id = "152130")
    private WebElement buttonSizeM;
    @FindBy(id = "152129")
    private WebElement buttonSizeG;

    public Product(WebDriver driver) {
        super(driver);
    }

    public String valueProduct() {
        return driver.findElement(By.xpath("//body/div[9]/main[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")).getText();
    }

    public String sizeProduct() {
        if (buttonSizePP.isSelected() ) return "Tamanho PP";
        else if (buttonSizeP.isSelected() ) return "Tamanho P";
        else if (buttonSizeM.isSelected() ) return "Tamanho M";
        else return "Tamanho G";
    }
}
