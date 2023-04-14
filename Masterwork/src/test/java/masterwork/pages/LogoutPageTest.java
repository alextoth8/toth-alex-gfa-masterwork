package masterwork.pages;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LogoutPageTest extends BaseTest {
    @ParameterizedTest
    @DisplayName("Logout")
    @Description("After successfully login the test case tries to log out from the account")
    @Feature("Logout")
    @CsvFileSource(resources = "/validLoginData.csv", numLinesToSkip = 1)
    public void logoutTest(String username, String password) {
        //given
        HomePage home = new HomePage(driver);
        home.openHomePage().clickOnLoginLink();
        getLogger().info("The user reached the login page");
        LoginPage log = new LoginPage(driver);
        log.login(username, password);
        getLogger().info("Login was successful");
        //when
        home.clickOnLogoutLink();
        getLogger().info("Logout page reached");
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();
        getLogger().info("Logout was successful");
        //then
        Assertions.assertEquals(driver.getTitle(), "Log In ‹ Greenfox test-automation-blog — WordPress");
    }
}
