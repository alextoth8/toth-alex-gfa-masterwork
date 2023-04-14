package masterwork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PostPage extends ParentPage {
    @FindBy (xpath = "//*[@id=\"post-27\"]/div[1]/p")
    private WebElement postContent;
    @FindBy (id = "comment")
    private WebElement commentField;
    @FindBy (id = "comment-submit")
    private WebElement commentSubmitButton;
    @FindBy (id = "author")
    private WebElement guestName;
    @FindBy (id = "email")
    private WebElement guestEmail;
    @FindBy (className = "comment-content")
    private WebElement comment;
    @FindBy (css = "div.entry-content")
    private WebElement blogPostContent;

    PostPage(WebDriver driver){
        super(driver);
    }

    /**
     * There are two different methods to cover the process of sending a comment. One of them is
     * for comment as a logged-in user, and the other one is for leave a comment as a guest.
     */
    public void commentAsUser (String comment){
        setCommentField(comment);
        commentSubmitButton.click();
    }

    public void commentAsGuest (String name, String email, String comment){
        setGuestName(name);
        setGuestEmail(email);
        setCommentField(comment);
        commentSubmitButton.click();
    }

    public void savePostsContent (){
        String postText = blogPostContent.getText();
        //blogpost.txt is not existing until you run this method
        File file = new File("src/main/resources/blogpost.txt");
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(postText);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCommentField(String comment) {
        commentField.sendKeys(comment);
    }

    public void setGuestName(String gueName) {
        guestName.sendKeys(gueName);
    }

    public void setGuestEmail(String gueEmail) {
        guestEmail.sendKeys(gueEmail);
    }
    public WebElement getComment() {
        return comment;
    }
}
