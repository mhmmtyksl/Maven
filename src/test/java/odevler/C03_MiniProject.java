package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_MiniProject {
    public static void main(String[] args) {


    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

    // 1) Navigate to "https://react-shopping-cart-67954.firebaseapp.com/"
    //"https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
    driver.navigate().to("https://react-shopping-cart-67954.firebaseapp.com/");

    // 2) List all the elements on the website
    // Web sitesindeki tüm öğeleri listeleyin


    // 3) Create a String Arraylist and put Product Names into the ArrayList
    // Bir Dize Dizi Listesi oluşturun ve Ürün Adlarını ArrayList'e yerleştirin


    // 4) Choose 5 items randomly, add to cart and print the names of items
    // Rastgele 5 öğe seçin, sepete ekleyin ve öğelerin adlarını yazdırın


    // 5) (Her ürün 1 defadan fazla eklenemez!)
    // (Each product cannot be added more then 1 time!)


    // 6) CHECK THE PRICES!
    // FİYATLARI GÖR!


    // 7) Sum each item's price and compare your result with the website
    // If results are matching print success message
    // Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
    // Sonuçlar eşleşiyorsa yazdırma başarısı mesajı


    // 8) Get string price values from Website, convert them to double and add to <Double> ArrayList and print the price list
    // Web Sitesinden dize fiyat değerlerini alın, ikiye dönüştürün ve <Double> ArrayList'e ekleyin ve fiyat listesini yazdırın


    // 9) Click Checkout
    // Ödemeye Tıkla

}







}
