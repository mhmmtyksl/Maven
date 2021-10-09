package day05;

import org.junit.Test;

public class C01_Notasyon {
    // Java daki gibi seleniumda da belirli islevleri yapan methodlar olusturabiliriz.
    // Ancak bu methodlar cagrilmadikca calismazlar.
    // en cok kullanacagimiz Junit annotationlari
    // @Test
    // @BeforeClass ve @AfterClass
    // @Before ve @After
    // @Ignore

    // Yazdığımız bazı test metotları henüz tamamlanmamış veya değişiklikleri
    // uğrayabileceğinden dolayı test sırasında çalıştırılmasını istemiyorsak
    // @Ignore notasyonu eklememiz yeterlidir.

    public void ilkTestMethodu() {
        System.out.println("ilk test methodumuz");
    }
    // bu method siradan bir method oldugu icin notasyon yani @test yazilmadigi icin calismadi
    // notasyonluya donusturmek icin yapmamiz gerek ustune @Test yazmaktir.

    // JUnit ile notasyon kullanark siradan methodlari test methoduna donusturebiliriz
    // Bir test methodu bagimsiz olarak calisabilen test yapmamiza imkan verir.
    // @Test notasyonu sayesinde main method mecburiyeti ortadan kalkar.

    @Test
    public void nutasyonluIlkTestMethodu() {
        System.out.println("notasyonlu ilk test methodumuz");
    }
}

// sadece notasyonlu ilk test methodumuz yazdririr.