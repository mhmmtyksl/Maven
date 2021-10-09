package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_BeforeClassNotasyonu {

    // amazon sayfasina gidip 3 farkli test methodu hazirlayin.
    // Her Methodda farkli aramalar yapalim

    static WebDriver driver; // her yerde kullanacagimiz icin burda WebDriver i olusturmamiz gerekiyor.
    // @BeforeClass method static olmasi gerektigi icin bunu da mutlaka static olarak tanimlamamiz gerekir.

    WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));

    // burda amazon a bir defa gitmak yeterli gittikten sonra 3 farkli arama yapilacak
    // ama baska sayfaya gitmeye gerek yok bu yuzden @BeforeClass kullaniriz

    @BeforeClass // @BeforeClass kullanilacak methodun mutlaka static olmasi gerekir
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");

    }
    @Test // method un ustune @Test ekleyince hemen Run tusu cikar
    public void test1() {
        searchBox.clear(); // Bunun amaci her arama oncesinde onceki yapilan aramalari temizlemek icin
        searchBox.sendKeys("Nutella"+ Keys.ENTER);
    }
    @Test
    public void test2() {
        searchBox.clear(); // daha once yazilan Nutella yi siler
        searchBox.sendKeys("bycicle"+ Keys.ENTER);
    }
    @Test
    public void test3() { // daha once yazilan bycicle i siler yi siler
        searchBox.clear();
        searchBox.sendKeys("Java"+ Keys.ENTER);
    }

    @AfterClass // bunun nerde yazildiginin hicbir onemi yoktur. bunu en basa dahi yazsak
    // once @BeforeClass i calistirir. siraya degil gorevlere bakar
    public  static void tearDown() {
        driver.close(); // bu da kapatma methodu
    }
}

    // Test1 Test2 veya Test3 un hangisinin once calismasini ongoremeyiz
    // hangisinin once hangisinin sonra calisacagini ongoremedgimiz icin Nutella dan ön ce de
    // clear() yazdik cunku bu nethod 2. veya en sonda da calisabilir.