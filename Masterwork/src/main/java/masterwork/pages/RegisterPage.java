package masterwork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends ParentPage{
    @FindBy (id = "user_login-46")
    private WebElement userNameField;
    @FindBy (id = "first_name-46")
    private WebElement firstNameField;
    @FindBy (id = "last_name-46")
    private WebElement lastNameField;
    @FindBy (id = "user_email-46")
    private WebElement emailField;
    @FindBy (id = "user_password-46")
    private WebElement passwordField;
    @FindBy (id = "confirm_user_password-46")
    private WebElement confirmPasswordField;
    @FindBy (xpath = "//*[@id=\"um_field_46_privacy_statement\"]/div[2]/label/span[1]")
    private WebElement privacyCheckbox;
    @FindBy (xpath = "//*[@id=\"content\"]/article/div/div/div/form/div[1]/div/div[8]/a")
    private WebElement showPrivacyStatement;
    @FindBy (id = "um-submit-btn")
    private WebElement submitRegButton;
    @FindBy (xpath = "//*[@id=\"L2AGLb\"]")
    private WebElement acceptAllButton;
    @FindBy (className = "um-field-error")
    private WebElement regErrorMessage;

    RegisterPage (WebDriver driver){
        super(driver);
    }

    public void registry (String username, String firstname, String lastname, String email, String password, String conformpassword) {
        //open the privacy statement page (google.com) before doing anything else on the form
        showPrivacyStatement.click();
        scrollDown();
        acceptCookies();
        // until this point the method simulates the open and read process of the privacy statement
        driver.navigate().back();
        //the fill out all the fields
        setUserNameField(username);
        setFirstNameField(firstname);
        setLastNameField(lastname);
        setEmailField(email);
        setPasswordField(password);
        setConfirmPasswordField(conformpassword);
        //and accepts the privacy statement and click on the submit button
        privacyCheckbox.click();
        submitRegButton.click();
    }

    /**This acceptCookies method is necessary because sometimes the ChromeDriver can't navigate back to
     * the registry page until it accepts the cookies on the url which is marked as the privacy statement
     * document's url.
     */
    public void acceptCookies(){
        acceptAllButton.click();
    }

    public void setUserNameField(String username) {
        userNameField.sendKeys(username);
    }

    public void setFirstNameField(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void setLastNameField(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void setEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void setConfirmPasswordField(String password) {
        confirmPasswordField.sendKeys(password);
    }

    public WebElement getRegErrorMessage() {
        return regErrorMessage;
    }
}
