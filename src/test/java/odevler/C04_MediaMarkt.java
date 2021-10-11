package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C04_MediaMarkt {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.mediamarkt.de/");
        driver.findElement(By.xpath("//button[@id='privacy-layer-accept-all-button']")).click();

        driver.findElement(By.xpath("//input[@class='StyledTextInput-o565af-1 jNOhNX']")).sendKeys("Iphone 13 Pro Max"+ Keys.ENTER);

        driver.findElement(By.xpath("(//p[@class='StyledInfoTypo-sc-1jga2g7-0 ezocPE'])[4]")).click();

        driver.findElement(By.xpath("//button[@button='StyledButton-sc-140xkaw-1 iGxCxO StyledButton-sc-1qvc90d-0 jLmrEc']")).click();

        driver.findElement(By.className("StyledButton-sc-140xkaw-1 cUpAbt StyledModalFooterButton-dn64wt-4 HNaiN")).click();

        driver.findElement(By.id("StyledButton-sc-140xkaw-1 iWGXyY StyledModalFooterButton-dn64wt-4 HNaiN")).click();

        driver.findElement(By.xpath("//input[@class='StyledTextInput-o565af-1 jNOhNX']")).clear();

        driver.findElement(By.xpath("//input[@class='StyledTextInput-o565af-1 jNOhNX']")).sendKeys("AirPods"+Keys.ENTER);

        driver.findElement(By.xpath("(//p[@class='StyledInfoTypo-sc-1jga2g7-0 ezocPE'])[2]")).click();

    }




}