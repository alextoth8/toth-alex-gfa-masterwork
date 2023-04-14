package masterwork.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    static WebDriver driver;

    @BeforeEach
    //setting up the webdriver and the logger properly
    public void setup() {
        logger.info("Test suite started: {}", getClass().getSimpleName());
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void cleanUp () {
        driver.quit();
        logger.info("Test suite finished: {} \n", getClass().getSimpleName());
    }

    //Getter which provide the usage of the logger in the classes which extends this BaseTest class
    protected Logger getLogger() {
        return logger;
    }
}
