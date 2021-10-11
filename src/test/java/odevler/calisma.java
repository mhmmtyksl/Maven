package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class calisma {


    static WebDriver driver;

    @BeforeClass
    public static void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.className("login")).click();
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("muhammet"+ Keys.ENTER);
        Thread.sleep(3000);
    }
    @Test
    public void test1(){
        Assert.assertTrue(driver.findElement(By.id("create_account_error")).isDisplayed());

    }









}


