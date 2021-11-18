package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class C02_AssertionsYoutube {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    static WebDriver driver;
    @BeforeClass // static olmak zorundarir
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.youtube.com/");
        driver.findElement(By.xpath("//*[text()='Ich stimme zu']")).click();
        // sayfada guvenlik sorusu ciktigi icin once onu tiklamamiz lazim o yuzden bunu yazdik ve klick yaptik
        // yerini text ile locate ettik text ile locate etmek icin
        // //*[text()='...'] yazariz eger tagname onemsiz ise * kullanilir.
    }

    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //  ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    @Test
    public void titleTest(){
        String expectedTitle="YouTube";
        String actualTitle= driver.getTitle();
        Assert.assertEquals("Sayfa title'i beklenenden farkli",expectedTitle,actualTitle);
        // bunlarin hepsinde testin FAILED olmasi durumunda yazdigimiz mesaj gorunecek
        // girilen degerlerin expected ve actual in yerleri onemli aksi takdirde FAILED durumunda hatayi bulamayiz
        // hangi siraya hangisini yazacagimiz methodda belli oluyor
    }

    //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void logoTesti(){
        WebElement logo=driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue("Logo gorunmuyor",logo.isDisplayed());
    }

    //   ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void aramaKutusuTesti(){
        WebElement aramaKutusu=driver.findElement(By.id("search-input"));
        Assert.assertTrue("Arama kutusuna ulasilamiyor", aramaKutusu.isEnabled());
        // isEnabled() erisilebilir olup olmadigini anlamak icin kullanilir.
    }

    //  ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void yanlisTitleTesti(){
        String istenmeyenBaslik="youtube";
        String actualTitle= driver.getTitle();
        Assert.assertNotEquals("Title istenmeyen kelimeye esit",istenmeyenBaslik,actualTitle);
        //Assert.assertFalse("false mesaji",istenmeyenBaslik.equals(actualTitle));
        //Assert.assertTrue("True Mesaji",!istenmeyenBaslik.equals(actualTitle));
        // yazilan 3 ifadenin de sonucu aynidir. hangisini kullandigimiz onemli degildir.
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}