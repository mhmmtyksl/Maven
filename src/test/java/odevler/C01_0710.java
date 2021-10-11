package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C01_0710 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

    //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

    //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

    //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        System.out.println(driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText());

        driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).click();

    //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

    //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();

    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        if (driver.findElement(By.xpath("(//div[@class='inventory_item_name'][1])")).isDisplayed()){
            System.out.println("Urun sepete basarili sekilde eklenmistir.");
        } else {
            System.out.println("Urun maalesef sepete eklenmeistir, lutfen tekrar deneyiniz.");
        }

    //9. Sayfayi kapatin
        driver.close();

}
}