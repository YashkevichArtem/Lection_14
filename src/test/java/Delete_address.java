import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Delete_address {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Учёба SENLA\\Автоматизация тестирования\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Login
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.findElement(By.id("session_email")).sendKeys("yashkevich6235@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[value='Sign in'")).click();

        //Delete address
        driver.get("http://a.testaddressbook.com/addresses");
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/td[7]/a")).click();
        driver.switchTo().alert().accept();

        Thread.sleep(5000);

        driver.close();
        driver.quit();
    }
}
