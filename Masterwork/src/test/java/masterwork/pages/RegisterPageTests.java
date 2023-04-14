package masterwork.pages;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RegisterPageTests extends BaseTest{

    /**
     * Important note about these two tests.
     * All these two get the data from a csv file.
     * These two user are not existing until you run the tests.
     * You can run the Successful registration test only once if you not modify the data in the
     * /resources/validRegistryData.csv before the second try. If you not change the data in the csv file
     * and try to run the first test twice, the second occasion will lead to an error because you will
     * try to register with an already existing user's data.
     */

    @ParameterizedTest
    @DisplayName("Successful registration")
    @Description("Registration with valid data")
    @Features({@Feature("Registration"),
            @Feature("Using Privacy Statement"),
            @Feature("Repetitive data entry from external source")})
    @CsvFileSource(resources = "/validRegistryData.csv", numLinesToSkip = 1)
    public void validRegistryTest (String username, String firstname, String lastname, String email,
                                   String password, String confirmpassword) {
        //given
        HomePage home = new HomePage(driver);
        home.openHomePage().clickOnRegisterLink();
        getLogger().info("Registry page loaded");
        RegisterPage registrySite = new RegisterPage(driver);
        //when
        registrySite.registry(username, firstname, lastname, email, password, confirmpassword);
        getLogger().info("Registration completed");
        //then
        //after the registration is completed, you will be a logged-in user automatically
        Assertions.assertTrue(home.getLogoutLink().isDisplayed());
    }

    @ParameterizedTest
    @DisplayName("Unsuccessful registration")
    @Description("Registration with invalid data")
    @Features({@Feature("Registration"),
            @Feature("Using Privacy Statement"),
            @Feature("Repetitive data entry from external source")})
    @CsvFileSource(resources = "/invalidRegistryData.csv", numLinesToSkip = 1)
    public void invalidRegistryTest (String username, String firstname, String lastname, String email,
                                   String password, String confirmpassword) {
        //given
        HomePage home = new HomePage(driver);
        home.openHomePage().clickOnRegisterLink();
        getLogger().info("Registry page loaded");
        RegisterPage registrySite = new RegisterPage(driver);
        //when
        registrySite.registry(username, firstname, lastname, email, password, confirmpassword);
        getLogger().info("Registration failed");
        //then
        Assertions.assertTrue(registrySite.getRegErrorMessage().isDisplayed());
    }
}
