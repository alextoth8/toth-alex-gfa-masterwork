package masterwork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy (id = "user_login")
    private WebElement usernameField;
    @FindBy (id = "user_pass")
    private WebElement passwordField;
    @FindBy (id = "wp-submit")
    private WebElement loginButton;
    @FindBy (xpath = "//*[@id=\"nav\"]/a[1]")
    private WebElement registryLink;
    @FindBy (id = "login_error")
    private WebElement loginErrorMessage;

    LoginPage (WebDriver driver){
        super(driver);
    }

    //The login method types in the username and the password to their fields.
    public void login (String username, String password){
        setUsernameField(username);
        setPasswordField(password);
        loginButton.click();
    }

    public void setUsernameField(String username) {
        usernameField.sendKeys(username);
    }
    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }
    public WebElement getLoginErrorMessage() {
        return loginErrorMessage;
    }
}
