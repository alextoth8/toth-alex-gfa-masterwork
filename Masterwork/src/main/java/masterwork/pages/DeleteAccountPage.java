package masterwork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends ParentPage {
    @FindBy (xpath = "//*[@id=\"content\"]/article/div/div/div/form/div[2]/ul/li[4]/a/span[1]")
    private WebElement deleteMenu;
    @FindBy (id = "single_user_password")
    private WebElement passwordToDelete;
    @FindBy (id = "um_account_submit_delete")
    private WebElement deleteAccountButton;

    DeleteAccountPage(WebDriver driver){
        super(driver);
    }

    public void clickOnDeleteMenu(){
        deleteMenu.click();
    }

    public void clickOnDeleteAccountButton(){
        deleteAccountButton.click();
    }


    // The deleteAccount method had made for delete an existing user's account completely.
    public void deleteAccount (String password){
        clickOnDeleteMenu();
        setPasswordToDelete(password);
        scrollDown();
        clickOnDeleteAccountButton();
    }
    public void setPasswordToDelete (String password) {passwordToDelete.sendKeys(password);}
}
