package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class C03_Before_After {
    // uc test methodu yapin
    // 1.method amazon.com
    // 2. method techproeducation'a
    // 3. method facebook'a gitsin
    // eger her test method'u icin yeni bir sayfa acilsin ve test mey=thod'u sonunda kapansin
    // istiyorsak @Before ve @After notasyonlari kullanilmali

    // Bunda static olmasina gerek yoktur.

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void amazonTesti(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void techproedTesti(){
        driver.get("https://www.techproed.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void facebookTesti(){
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());
    }

    @After
    public void tearDown(){
        driver.close();
    }
}

// burda da herhangi bir sira gozetmez.
// @BeforeClass ile @Before farki
// @BeforeClass her method sirasiyla calisir ve @After ile kapanir
// 5 Test methodu varsa calistirilinca toplamda 1+5+2=7 method calisir
// @Before da ise her test methodundan sonra @After calisir sonra sonrakine gecer
// 5 Test methodu varsa calistirilinca toplamda (1+1+1)*5=15 method calisir
// yanbi bunda hepsi icin Before ve After da calisir.