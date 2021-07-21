import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Add_address {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Login
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.findElement(By.id("session_email")).sendKeys("yashkevich6235@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[value='Sign in'")).click();

        //Add address
        driver.get("http://a.testaddressbook.com/addresses/new");
        driver.findElement(By.id("address_first_name")).sendKeys("Andrey");
        driver.findElement(By.id("address_last_name")).sendKeys("Ivanov");
        driver.findElement(By.id("address_street_address")).sendKeys("Kirova");
        driver.findElement(By.id("address_city")).sendKeys("Grodno");
        driver.findElement(By.xpath("//*[@id='address_state']/option[7]")).click();
        driver.findElement(By.id("address_zip_code")).sendKeys("230027");
        driver.findElement(By.xpath("//*[@id='address_country_us']")).click();
        driver.findElement(By.id("address_birthday")).sendKeys("01011990");
        driver.findElement(By.cssSelector("input[value='Create Address'")).click();



        Thread.sleep(5000);

        driver.quit();
    }
}
