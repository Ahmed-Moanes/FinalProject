
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class Homepage {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","E:\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.navigate().to("https://www.demoblaze.com/index.html");

    }
    @Test
    public void Test1Login() throws InterruptedException {
        // tc1

        driver.findElement(By.linkText("Log in")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModalLabel")));
       //tc2
       Assert.assertTrue(driver.findElement(By.id("logInModalLabel")).isDisplayed(), "Login page is not visible");
        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("Ahmed00");
        driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("1234");
       driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));
       driver.findElement(By.xpath("//*[@id=\"logout2\"]")).click();

        //tc3
       driver.findElement(By.linkText("Log in")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModalLabel")));
        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();

        //tc4
        // tc4 - التحقق من ظهور التنبيه عند ترك الحقول فارغة
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();

        Assert.assertEquals(alertText, "Please fill out Username and Password.");

        alert.accept();
        //tc4
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModalLabel")));
        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert2 = driver.switchTo().alert();

        String alertText2 = alert2.getText();

        Assert.assertEquals(alertText2, "Please fill out Username and Password.");
        alert2.accept();

        WebElement password = driver.findElement(By.id("loginpassword"));
        password.clear();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModalLabel")));
        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("Ahmed00");
        driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert3 = driver.switchTo().alert();
        String alertText3 = alert2.getText();
        Assert.assertEquals(alertText3, "Please fill out Username and Password.");
        alert2.accept();
        WebElement username = driver.findElement(By.id("loginusername"));
        username.clear();
        //tc6
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModalLabel")));
        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("ali");
        driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();


        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert4 = driver.switchTo().alert();
        String alertText4 = alert2.getText();
        Assert.assertEquals(alertText3, "Please fill out Username and Password.");
        alert2.accept();
        WebElement username1 = driver.findElement(By.id("loginusername"));
        username1.clear();
        WebElement password1 = driver.findElement(By.id("loginpassword"));
        password1.clear();

        //tc7
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModalLabel")));
        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("Ahmed00");
        driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("zzz");
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert5 = driver.switchTo().alert();
        String alertText5 = alert2.getText();
        Assert.assertEquals(alertText3, "Please fill out Username and Password.");
        alert2.accept();
        WebElement username2 = driver.findElement(By.id("loginusername"));
        username2.clear();
        WebElement password2 = driver.findElement(By.id("loginpassword"));
        password2.clear();

        //tc8

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModalLabel")));
        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("zcxo");
        driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("zzz");
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert6 = driver.switchTo().alert();
        String alertText6 = alert2.getText();
        Assert.assertEquals(alertText3, "Please fill out Username and Password.");
        alert2.accept();
        WebElement username3 = driver.findElement(By.id("loginusername"));
        username2.clear();
        WebElement password3 = driver.findElement(By.id("loginpassword"));
        password2.clear();


        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[1]")).click();
        Thread.sleep(1000);
        Assert.assertFalse(driver.findElement(By.id("logInModal")).isDisplayed(), "login form did not close properly.");


    }

}
