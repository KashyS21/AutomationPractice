package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_008 {
    @Test
    public void verifyIncorrectPasswordMessage()
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Shubham ");
        driver.findElement(By.id("input-lastname")).sendKeys("Kashyap");
        driver.findElement(By.id("input-email")).sendKeys("Shubham123@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("29014902");
        driver.findElement(By.id("input-password")).sendKeys("419092");
        driver.findElement(By.id("input-confirm")).sendKeys("14-1-2");
        driver.findElement(By.cssSelector("input[name='agree']")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        String passwordText="Password confirmation does not match password!";
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-confirm']/following-sibling::div")).getText(),passwordText);
        driver.quit();

    }

}
