package masterwork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends ParentPage {
    @FindBy (xpath = "//*[@id=\"error-page\"]/div/p[2]/a")
    private WebElement logoutSubmitLink;

    LogoutPage (WebDriver driver){
        super(driver);
    }

    public void logout (){
        logoutSubmitLink.click();
    }
}
