package masterwork.pages;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AccountPageTests extends BaseTest {

    @ParameterizedTest
    @DisplayName("Update user's data")
    @Description("Checking if update user's data is successful")
    @Feature("Existing data modification")
    @CsvFileSource(resources = "/validLoginData.csv", numLinesToSkip = 1)
    public void dataUpdateTest(String username, String password) {
        //given
        HomePage home = new HomePage(driver);
        home.openHomePage().clickOnLoginLink();
        getLogger().info("The user navigated to the login page");
        LoginPage log = new LoginPage(driver);
        log.login(username, password);
        getLogger().info("The user logged in");
        //when
        home.clickOnAccountLink();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.update("Alex", "Toth", "alex@toth.com");
        getLogger().info("The user updated his/her data successfully");
        //then
        //assert if all the modified data had been updated
        Assertions.assertEquals(accountPage.getUserFirstNameField().getAttribute("value"), "Alex");
        Assertions.assertEquals(accountPage.getUserLastNameField().getAttribute("value"), "Toth");
        Assertions.assertEquals(accountPage.getUserEmailField().getAttribute("value"), "alex@toth.com");
    }
}
