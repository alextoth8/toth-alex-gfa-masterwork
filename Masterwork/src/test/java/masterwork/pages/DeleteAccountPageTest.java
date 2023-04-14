package masterwork.pages;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class DeleteAccountPageTest extends BaseTest{

    @ParameterizedTest
    @DisplayName("Delete a user")
    @Description("After logging in with an existing user, the test case tries to delete the account completely")
    @Feature("Deleting data")
    @CsvFileSource(resources = "/userToDelete.csv", numLinesToSkip = 1)
    public void deleteUserTest (String username, String password){
        //given
        HomePage home = new HomePage(driver);
        home.openHomePage().clickOnLoginLink();
        getLogger().info("The user navigated to the login page");
        LoginPage log = new LoginPage(driver);
        log.login(username, password);
        getLogger().info("The user logged in");
        home.clickOnAccountLink();
        getLogger().info("The user navigated to the account page");
        //when
        DeleteAccountPage deletePage = new DeleteAccountPage(driver);
        //send the password to the field which is required to delete the account
        deletePage.deleteAccount(password);
        getLogger().info("The delete process executed");
        //then
        //trying to log back in with the deleted user's username and password
        home.clickOnLoginLink();
        getLogger().info("The user navigated to the login page again");
        log.login(username, password);
        getLogger().info("Second login attempt failed");
        Assertions.assertTrue(log.getLoginErrorMessage().isDisplayed());
    }
}