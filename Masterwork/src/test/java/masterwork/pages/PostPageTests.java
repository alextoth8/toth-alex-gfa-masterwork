package masterwork.pages;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

public class PostPageTests extends BaseTest {
    @ParameterizedTest
    @DisplayName("Comment as user")
    @Description("Send a comment to a post as a logged in user")
    @Feature("Input of new data")
    @CsvFileSource(resources = "/validLoginData.csv", numLinesToSkip = 1)
    public void commentAsUserTest(String username, String password) {
        //given
        HomePage home = new HomePage(driver);
        home.openHomePage().clickOnLoginLink();
        getLogger().info("The user reached the login page");
        LoginPage log = new LoginPage(driver);
        log.login(username, password);
        getLogger().info("Login was successful");
        home.goToPost();
        getLogger().info("The user reached the post page");
        //when
        PostPage postPage = new PostPage(driver);
        //Needed to avoid the duplication error, because the site detects duplicate comments
        String randomString = UUID.randomUUID().toString();
        postPage.commentAsUser(randomString);
        getLogger().info("The user commented successfully");
        //then
        Assertions.assertTrue(postPage.getComment().isDisplayed());
    }

    @Test
    @DisplayName("Comment as guest")
    @Description("Send a comment to a post with guest name and email")
    @Feature("Input of new data")
    public void commentAsGuest() {
        //given
        HomePage home = new HomePage(driver);
        home.openHomePage().goToPost();
        getLogger().info("The guest reached the post page");
        //when
        PostPage postPage = new PostPage(driver);
        //Needed to avoid the duplication error, because the site detects duplicate comments
        String randomString = UUID.randomUUID().toString();
        postPage.commentAsGuest("GeorgeGuest", "george@guest.com", randomString);
        getLogger().info("The guest commented successfully");
        //then
        Assertions.assertTrue(postPage.getComment().isDisplayed());
    }

    @Test
    @DisplayName("Save content into txt")
    @Description("Testing if saving a blogpost's text is successful")
    @Feature("Saving data from the web application")
    public void txtFileTest (){
        //given
        HomePage home = new HomePage(driver);
        home.openHomePage().goToPost();
        getLogger().info("Post page loaded");
        //when
        PostPage postPage = new PostPage(driver);
        postPage.savePostsContent();
        getLogger().info("Text saved");
        //then
        String expectedContent = "I believe that nothing in this world is ever completely one-sided. There are black and white, good and bad, as well as TDD. I had got a lot of information on the good sides of it. I was looking for how to make it right and the bad sides of it so I know what do I need to be careful.";
        //make an actualContent variable then fill it with the post's text
        String actualContent;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/blogpost.txt"))) {
            actualContent = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getLogger().info("Txt file created");
        Assertions.assertEquals(expectedContent, actualContent);
    }
}
