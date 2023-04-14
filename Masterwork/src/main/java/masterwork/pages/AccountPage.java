package masterwork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends ParentPage {
    @FindBy (name = "first_name")
    private WebElement userFirstNameField;
    @FindBy (name = "last_name")
    private WebElement userLastNameField;
    @FindBy (name = "user_email")
    private WebElement userEmailField;
    @FindBy (id = "um_account_submit_general")
    private WebElement submitUpdateButton;
    @FindBy (xpath = "//*[@id=\"content\"]/article/div/div/div/form/div[3]/p")
    private WebElement successfulUpdateMessage;
    @FindBy (xpath = "//*[@id=\"content\"]/article/div/div/div/form/div[2]/ul/li[4]/a/span[1]")
    private WebElement deleteButton;

    AccountPage(WebDriver driver){
        super(driver);
    }

    // The update method can update an existing user's first name, last name and e-mail address.
    public void update (String firstname, String lastname, String email){
        getUserFirstNameField().clear();
        getUserLastNameField().clear();
        getUserEmailField().clear();
        getUserFirstNameField().sendKeys(firstname);
        getUserLastNameField().sendKeys(lastname);
        getUserEmailField().sendKeys(email);
        submitUpdateButton.click();
    }

    public WebElement getUserFirstNameField() {
        return userFirstNameField;
    }

    public WebElement getUserLastNameField() {
        return userLastNameField;
    }

    public WebElement getUserEmailField() {
        return userEmailField;
    }
}
