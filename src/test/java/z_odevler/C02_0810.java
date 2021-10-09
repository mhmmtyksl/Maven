package z_odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_0810 {
    //1-Test01 isimli bir class olusturun
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test() {

        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5- Sayfa basliginin “Amazon” ifadesi icerdigini control edin
        if ((driver.getTitle()).contains("Amazon")) {
            System.out.println("Sayfa basligi Amazon iceriyor, test PASS");
        } else {
            System.out.println("Sayfa basligi Amazon icermiyor, test FAILED");
        }

        //6-Sayfa basliginin “Amazon.com. Spend less. Smile more.” a esit oldugunu control ediniz
        if ((driver.getTitle()).equals("Amazon.com. Spend less. Smile more.")) {
            System.out.println("Sayfa basligi Amazon.com. Spend less. Smile more. ile ayni, test PASS");
        } else {
            System.out.println("Sayfa basligi Amazon.com. Spend less. Smile more. ile ayni degil, test FAILED");
        }

        //7- URL in amazon.com icerdigini control edin
        if ((driver.getCurrentUrl()).contains("amazon.com")) {
            System.out.println("Sayfa Url si amazon.com iceriyor, test PASS");
        } else {
            System.out.println("Sayfa Url si amazon.com icermiyor, test FAILED");
        }

        //8-”Nutella” icin arama yapiniz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        //9- Kac sonuc bulundugunu yaziniz
        driver.findElement(By.xpath("//span[@dir='auto'][1]"));
    }

    //10-Sayfayi kapatin
    @After
    public void tearDown() {
        driver.close();
    }
}


