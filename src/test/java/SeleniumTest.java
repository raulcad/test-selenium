import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author raul.casillas
 */
public class SeleniumTest {
    
    private WebDriver driver;
    By nameInputLocator = By.id("name");
    By emailInputLocator = By.cssSelector("input[type='email']");
    By btnLocator = By.cssSelector("button[type='button']");
    By labelResultLocator = By.id("result");
    
    public SeleniumTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }
    
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void email() throws InterruptedException {
        driver.get("file://C:\\Users\\raul.casillas\\dev\\test-selenium\\src\\main\\java\\test\\selenium\\file.html");
        
        Thread.sleep(5000);
        
        driver.findElement(nameInputLocator).sendKeys("Raul");
        String email = "raulcd@gmail.com";
        driver.findElement(emailInputLocator).sendKeys(email);
        driver.findElement(btnLocator).click();
        String expectedText = "Your email is: "+email;
        String currentText = driver.findElement(labelResultLocator).getText();
        assertEquals(expectedText, currentText, "Error: email text is incorrect.");        
    }
}
