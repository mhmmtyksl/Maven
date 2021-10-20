package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test02 {

    public static void main(String[] args) throws InterruptedException {

        // 1) https://gmibank.com/ ADRESiNE GiDiN
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://gmibank.com/");

        // 2) Sign In BUTONUNA TIKLAYIN
        driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]")).click();
        driver.findElement(By.xpath("//*[span='Sign in']")).click();

        // 3) Sign in EKRANINA GiTTiGiNiZi DOGRULAYIN
        System.out.println(driver.getCurrentUrl());
        String expectedUrl = "https://gmibank.com/login";

        if(driver.getCurrentUrl().equals(expectedUrl)){
            System.out.println("URL Sign in Testi PASS");
        }else {
            System.out.println("URL Sign in Testi FAİLED");
        }

        //Thread.sleep(2000);

        // 4) Sign in EKRANINA GiTTiGiNiZi FARKLI BiR WebElement'i KULLANARAK,2. KEZ DOGRULAYIN

        if((driver.findElement(By.xpath("(//span[.='Sign in'])[2]")).getText()).equals("Sign in")){
            System.out.println("URL Sign in Testi PASS");
        } else {
            System.out.println("URL Sign in Testi FAILED");
        }

        // 6) VERiLEN KULLANICI ADI VE SiFRE iLE SAYFAYA GiRiS YAPIN (Username: employee32, Password: team32team32-)

        WebElement username = driver.findElement(By.cssSelector("#username"));
        username.sendKeys("employee32", Keys.TAB);

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("team32team32-", Keys.ENTER);

        // 7) VERiLEN KULLANICI iLE GiRiS YAPTIGINIZI DOGRULAYIN
        if (driver.findElement(By.xpath("//*[span='employee32 employee32']")).isDisplayed()) {
            System.out.println("Sayfaya basariyla giris yapildi, test PASS");
        } else {
            System.out.println("Sayfaya maalesef giris yapilamadi, test FAILED");
        }

        // 8) VERiLEN KULLANICI iLE GiRiS YAPTIGINIZI FARKLI BiR WEBELEMENT'i KULLANARAK 2. KEZ DOGRULAYIN
        if (driver.findElement(By.xpath("//*[span='My Operations']")).isDisplayed()) {
            System.out.println("Sayfaya basariyla giris yapildi, test PASS");
        } else {
            System.out.println("Sayfaya maalesef giris yapilamadi, test FAILED");
        }

        // 9) SAYFADAN CIKIS YAPIN
        driver.findElement(By.xpath("//*[span='employee32 employee32']")).click();
        driver.findElement(By.xpath("//*[span='Sign out']")).click();

        // 10) SAYFADAN CIKIS YAPILDIGINI DOGRULAYIN
        if (driver.findElement(By.xpath("//h2[text()='THANK YOU FOR USING US...']")).isDisplayed()) {
            System.out.println("Sayfadan basariyla cikis yapildi, test PASS");
        } else {
            System.out.println("Sayfadan maalesef cikis yapilamadi, test FAILED");
        }

        // 11) FARKLI BiR WEBELEMENT'i KULLANARAK, SAYFADAN CIKIS YAPILDIGINI 2. KEZ DOGRULAYIN
        if (driver.findElement(By.xpath("//button[text()='SIGN IN AGAIN']")).isDisplayed()) {
            System.out.println("Sayfadan basariyla cikis yapildi, test PASS");
        } else {
            System.out.println("Sayfadan maalesef cikis yapilamadi, test FAILED");
        }
        driver.close();
    }
}