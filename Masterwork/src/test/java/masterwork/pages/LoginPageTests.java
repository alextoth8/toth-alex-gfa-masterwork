package masterwork.pages;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LoginPageTests extends BaseTest{

    @ParameterizedTest
    @DisplayName("Login with valid data")
    @Description("Logging in with valid data which comes from a csv file")
    @Feature("Login")
    @CsvFileSource(resources = "/validLoginData.csv", numLinesToSkip = 1)
    public void validLoginTest (String username, String password){
        //given
        HomePage home = new HomePage(driver);
        home.openHomePage().clickOnLoginLink();
        getLogger().info("The user reached the login page");
        LoginPage log = new LoginPage(driver);
        //when
        log.login(username, password);
        getLogger().info("Login was successful");
        //then
        Assertions.assertTrue(home.getLogoutLink().isDisplayed());
    }

    @ParameterizedTest
    @DisplayName("Login with invalid data")
    @Description("Logging in with invalid data which comes from a csv file")
    @Feature("Login")
    @CsvFileSource(resources = "/invalidLoginData.csv", numLinesToSkip = 1)
    public void invalidLoginTest (String username, String password){
        //given
        HomePage home = new HomePage(driver);
        home.openHomePage().clickOnLoginLink();
        LoginPage log = new LoginPage(driver);
        getLogger().info("The user reached the login page");
        //when
        log.login(username, password);
        getLogger().info("Login attempt failed");
        //then
        Assertions.assertTrue(log.getLoginErrorMessage().isDisplayed());
    }
}
