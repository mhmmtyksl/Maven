package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test01 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // 1) https://gmibank.com/ ADRESiNE GiDiN
        driver.get("https://gmibank.com/");

        // 2) Sign In BUTONUNA TIKLAYIN
        driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]")).click();
        driver.findElement(By.xpath("//*[span='Sign in']")).click();

        // 3) USERNAME "deneme@gmi.bank.com", PASSWORD "Deneme44" KULLANARAK GiRiS YAPIN
        WebElement username = driver.findElement(By.cssSelector("#username"));
        username.sendKeys("deneme@gmi.bank.com", Keys.TAB);

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("Deneme44", Keys.ENTER);

        // 4) SAYFAYA YANLIS SiFRE VE PASSWORD iLE GiRiS YAPILAMADIGINI DOGRULAYIN
        WebElement hataliGiris = driver.findElement(By.xpath("//strong"));

        if(hataliGiris.isEnabled()){
            System.out.println("Yanlis username ve password ile giris, TEST PASS");
        } else {
            System.out.println("Yanlis username ve password ile giris, TEST FAILED");
        }
        // 5) SAYFAYA YANLIS SiFRE VE PASSWORD iLE GiRiS YAPILAMADIGINI
        //    FARKLI BiR WEBELEMENT KULLANARAK 2. KEZ DOGRULAYIN
        // <div role="alert" class="Toastify__toast-body">translation-not-found[error.http.401]</div>
        WebElement hataliGiris2 = driver.findElement(By.xpath("//div[@role='alert']"));

        if(hataliGiris2.isEnabled()){
            System.out.println("Yanlis username ve password ile giris, TEST 2 PASS");
        } else {
            System.out.println("Yanlis username ve password ile giris, TEST 2 FAILED");
        }
        driver.close();
    }
}