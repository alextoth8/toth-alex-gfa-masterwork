package masterwork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends ParentPage {
    @FindBy (id = "menu-item-44")
    private WebElement loginLink;
    @FindBy (id = "menu-item-72")
    private WebElement logoutLink;
    @FindBy (id = "menu-item-45")
    private WebElement registerLink;
    @FindBy (id = "menu-item-85")
    private WebElement accountLink;
    @FindBy (xpath = "//*[@id=\"post-27\"]/div/header/h2/a")
    private WebElement blogPostTitle;
    @FindBy (xpath = "//*[@id=\"content\"]/div[2]/div[2]/a")
    private WebElement olderPostsLink;

    HomePage (WebDriver driver){
        super(driver);
    }

    //This method opens the web application under test.
    public HomePage openHomePage (){
        driver.get("http://test-automation-blog.greenfox.academy/");
        return new HomePage(driver);
    }

    public void clickOnLoginLink (){
        loginLink.click();
    }

    public void clickOnLogoutLink (){
        logoutLink.click();
    }

    public void clickOnRegisterLink (){
        registerLink.click();
    }

    public void clickOnAccountLink (){
        accountLink.click();
    }
    public void paginate (){
        scrollDown();
        olderPostsLink.click();
    }

    public String listBlogPostsTitles (){
        //Get all the post titles selected by css selector into a list of webelements.
        List<WebElement> postTitles = driver.findElements(By.cssSelector("h2.entry-title a"));
        List<String> titles = new ArrayList<String>();
        for (WebElement title : postTitles) {
            titles.add(title.getText());
        }
        String result = String.join(", ", titles);
        return result;
    }

    public void goToPost (){
        blogPostTitle.click();
    }

    public WebElement getLogoutLink() {
        return logoutLink;
    }
}
