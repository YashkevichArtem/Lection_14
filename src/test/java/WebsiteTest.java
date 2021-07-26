import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WebsiteTest {

    private WebDriver driver = Driver.getChromeDriver();

    @BeforeAll
    void setUp() throws InterruptedException {

        driver.get("http://a.testaddressbook.com/sign_in");
        driver.findElement(By.id("session_email")).sendKeys("yashkevich6235@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[value='Sign in'")).click();

        Thread.sleep(3000);
    }

    @Order(1)
    @Test
    void testAddAdress() throws InterruptedException {
        driver.get("http://a.testaddressbook.com/addresses/new");
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/addresses/new", currentURL,
                "Открыта страница не создания нового адреса или указан некоректный URL");
        driver.findElement(By.id("address_first_name")).sendKeys("Andrey");
        driver.findElement(By.id("address_last_name")).sendKeys("Ivanov");
        driver.findElement(By.id("address_street_address")).sendKeys("Kirova");
        driver.findElement(By.id("address_city")).sendKeys("Grodno");
        driver.findElement(By.xpath("//*[@id='address_state']/option[7]")).click();
        driver.findElement(By.id("address_zip_code")).sendKeys("230027");
        driver.findElement(By.xpath("//*[@id='address_country_us']")).click();
        driver.findElement(By.id("address_birthday")).sendKeys("01011990");
        driver.findElement(By.cssSelector("input[value='Create Address'")).click();

        Thread.sleep(2000);
    }

    @Order(2)
    @Ignore
    void testChangeAddress() throws InterruptedException {
        driver.get("http://a.testaddressbook.com/addresses");
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/addresses", currentURL,
                "Открыта страница не базы данных адресов или указан некоректный URL");
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[6]/a")).click();
        driver.findElement(By.id("address_birthday")).sendKeys("11111911");
        driver.findElement(By.id("address_age")).sendKeys("109");
        driver.findElement(By.id("address_phone")).sendKeys("9379992");
        driver.findElement(By.xpath("//*[@id='address_interest_dance']")).click();
        driver.findElement(By.name("address[note]")).sendKeys("Hello World");
        driver.findElement(By.cssSelector("input[value='Update Address'")).click();

        Thread.sleep(2000);
    }

    @Order(3)
    @Test
    void testDeleteAddress() throws InterruptedException{
        driver.get("http://a.testaddressbook.com/addresses");String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/addresses", currentURL,
                "Открыта страница не базы данных адресов или указан некоректный URL");
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/td[7]/a")).click();
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
    }

    @Test
    void testSignOut() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id='navbar']/div[1]/a[3]")).click();

        Thread.sleep(1000);
    }

    @AfterAll
    void tearDown() {
        driver.quit();
    }
}