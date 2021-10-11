package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;
public class C01_Assertions {
    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
    // asagidaki testleri yapin

    static WebDriver  driver;

    @BeforeClass // setup methodunun sadece bvir defa calismasi bizim icin yeterli oldugundan @BeforeClass kullandik
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.com/");
    }
    //      ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    @Test
    public void urlTest(){
        String expectedURL="https://www.bestbuy.com/"; // bunlari hic tanimlamadan da yazabiliriz ama kodun anlasilir olmasi icin bu sekilde yazmak mantikli
        String actualURL= driver.getCurrentUrl();
        Assert.assertEquals("Istenen URL bulanamadi",expectedURL,actualURL);
        // burada basa yazilan mesaj testin calismadigi yani FAILED oldugu durumda gozukur
        // test basarili ise gozukmez
    }
    //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    @Test
    public void titleTest(){
        String istenmeyenKelime="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse("istenmeyen kelime title da var", actualTitle.contains(istenmeyenKelime));
    }
    //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
    @Test
    public void logoTest(){
        WebElement logo = driver.findElement(By.xpath("(//img[@class= 'logo'])[1]"));
        Assert.assertTrue("Logo gorunmuyor", logo.isDisplayed());
    }
    //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    @Test
    public void fransizcaTesti(){
        WebElement fransizcaLinki=driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue("Fransizca linki gorunmuyor",fransizcaLinki.isDisplayed());
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}