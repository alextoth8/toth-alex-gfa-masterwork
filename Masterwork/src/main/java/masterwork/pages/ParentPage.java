package masterwork.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class ParentPage {
    static WebDriver driver;

    ParentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*** This scrollDown method is necessary because sometimes the Selenium WebDriver can't find
     * some elements if they are below on the page and aren't visible.
     */
    public void scrollDown (){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
