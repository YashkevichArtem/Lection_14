import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Driver;

import java.time.Duration;

public class Sign_out {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getChromeDriver();

        //Login
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.findElement(By.id("session_email")).sendKeys("yashkevich6235@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[value='Sign in'")).click();

        //Sign Out
        driver.findElement(By.xpath("//*[@id='navbar']/div[1]/a[3]")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
