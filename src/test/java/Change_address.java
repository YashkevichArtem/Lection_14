import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Change_address {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "D:\\Учёба SENLA\\Автоматизация тестирования\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Login
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.findElement(By.id("session_email")).sendKeys("yashkevich6235@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[value='Sign in'")).click();

        //Change address
        driver.get("http://a.testaddressbook.com/addresses");
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[6]/a")).click();
        driver.findElement(By.id("address_birthday")).sendKeys("11111911");
        driver.findElement(By.id("address_age")).sendKeys("109");
        driver.findElement(By.id("address_phone")).sendKeys("9379992");
        driver.findElement(By.xpath("//*[@id='address_interest_dance']")).click();
        driver.findElement(By.name("address[note]")).sendKeys("Hello World");
        driver.findElement(By.cssSelector("input[value='Update Address'")).click();


        Thread.sleep(5000);

        driver.close();
        driver.quit();

    }
}
