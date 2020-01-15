package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
    private WebDriver driver;

    @Test
    public void testEasy() throws InterruptedException {
        driver.get("https://ici.radio-canada.ca/");

        stepLogin();
        stepCredentials();
        stepDeconnexion();

        //Assert.assertTrue(title.contains("Demo Guru99 Page"));
    }
    //@ Description("Step 01 - Login")
    public void stepLogin() throws InterruptedException {
        Thread.sleep(2000);
        WebElement buttonAccount = driver.findElement(By.cssSelector("button[class*='e-button-account']"));
        Thread.sleep(2000);
        buttonAccount.click();
        Thread.sleep(2000);
    }

    //@Description("Step 02 - Credentials")
    public void stepCredentials() throws InterruptedException {
        Thread.sleep(2000);
        WebElement loginEmail = driver.findElement(By.id("login-email"));
        Thread.sleep(2000);
        loginEmail.sendKeys("aborges2020@gmail.com");
        Thread.sleep(2000);

        WebElement loginPassword = driver.findElement(By.id("login-password"));
        loginPassword.sendKeys("123Mudar2020!");
        Thread.sleep(2000);

        WebElement btnOuvrirSession = driver.findElement(By.className("btn-ouvrir-session"));
        btnOuvrirSession.click();
        Thread.sleep(2000);
    }

    //@Description("Step 03 - Deconnexion")
    public void stepDeconnexion() throws InterruptedException {
        Thread.sleep(15000);
        WebElement buttonAccount = driver.findElement(By.cssSelector(".e-avatar"));
        buttonAccount.click();

        Thread.sleep(5000);
        WebElement optDeconn = driver.findElement(By.cssSelector(".account-panel-item-logout .menu-tab-label"));
        optDeconn.click();

        //WebElement buttonAccount = driver.findElement(By.cssSelector("button[class*='e-button-account has-tooltip is-logged']"));
    }

    @BeforeTest
    public void beforeTest() {

        System.setProperty("webdriver.chrome.driver", "C:\\temp\\seleniumDriver\\chromedriver.exe");
        driver = new ChromeDriver();



    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
