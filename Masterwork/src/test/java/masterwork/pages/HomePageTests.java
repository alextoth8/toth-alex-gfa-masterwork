package masterwork.pages;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HomePageTests extends BaseTest{
    @Test
    @DisplayName("List the blogposts titles")
    @Description("Collect all the blog posts titles which are in the homepage in a list")
    @Feature("Listing data")
    public void listTitleTest (){
        //given
        String titlesAsString = "Post 11, Post 10, Post 9, Post 8, The dangers of Unit tests, Post 6, Post 5, \uD83C\uDF09\uD83C\uDF01, Post 3, Test automation rules";
        HomePage home = new HomePage(driver);
        //when
        home.openHomePage();
        getLogger().info("Landing page opened");
        String titles = home.listBlogPostsTitles();
        getLogger().info("Listing the titles was successful");
        //then
        Assertions.assertEquals(titlesAsString, titles);
    }

    @Test
    @DisplayName("Pagination")
    @Description("Test if the pagination is working properly")
    @Feature("Pagination")
    public void paginationTest (){
        //given
        HomePage home = new HomePage(driver);
        //when
        home.openHomePage().paginate();
        getLogger().info("Pagination was successful");
        //then
        Assertions.assertEquals(driver.getCurrentUrl(), "http://test-automation-blog.greenfox.academy/page/2/");
    }
}
