package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

// mvn.sporitory.com dan WebDriverManager  ve selenium java dosyalarini indirdik
// bunu her projede yapmak lazim

public class C01_Maven {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize(); // sayfayi acinca hemen sayfayi buyuttuk cunku bazi yazilar veya linkler kucuk ekranda gozukmeyebilir
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // bu komut yazilinca her komutta yazilan saniyeye kadar bekleme yapabilir bu internet yavasligi problemlerini cozer
        // eger sayfa erken acilirsa otomatikmen gecer beklemeden eger yazilan sure icinde de acilmazsa
        // exception firlatir.

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //2- arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);

        //4- Bulunan sonuc sayisini yazdiralim
        // WebElement sonucYazisiElementi= driver.findElement(By.className("a-section a-spacing-small a-spacing-top-small"));
        // bu sekilde aratinca iki sonuc oldugu icin hata verdi kod calismadi. bu yuzden x.path e gore asagidaki gibi yaptik
        // By.className ile locate ettigimiz webelementi ile class attribute nin degerinde
        // bosluk varsa locator saglikli calismayabilir.
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisiElementi.getText());


        //5- Ilk urunu tiklayalim
        //WebElement ilkUrunElementi=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        //ilkUrunElementi.click();
        // sadece bir click yapacaksak webelement olusturmaya ve assign etmeye gerek yok
        // direk locate edip sonra click yapabiliriz
        // asagidaki usttekinin kisaltilmis hali
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        //6- Sayfadaki tum basliklari yazdiralim
        driver.navigate().back(); // tum urunleri gormek icin mecburen bir onceki sayfaya donduk

        List<WebElement> urunlerListesi= driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement each:urunlerListesi
        ) {
            System.out.println(each.getText());
        }
    }
}