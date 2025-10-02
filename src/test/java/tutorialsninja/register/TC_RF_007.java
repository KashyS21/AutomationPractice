package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_007 {
    @Test
   public void validate_registeration_ways()
   {
       WebDriver driver=new ChromeDriver();
       driver.get("https://tutorialsninja.com/demo/");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       driver.findElement(By.cssSelector("a[title='My Account']")).click();
       driver.findElement(By.xpath("//ul/li/a[contains(@href,'account/register')]")).click();
       driver.findElement(By.xpath("//span[text()='My Account']")).click();
       driver.findElement(By.xpath("//li/a[text()='Login']")).click();
       driver.findElement(By.linkText("Continue")).click();
       String text=driver.findElement(By.cssSelector("div[id='content'] h1")).getText();
       Assert.assertEquals(text,"Register Account");
       driver.findElement(By.cssSelector("a[title='My Account']")).click();
       driver.findElement(By.xpath("//ul/li/a[contains(@href,'account/register')]")).click();
       driver.findElement(By.xpath("//span[text()='My Account']")).click();
       driver.findElement(By.xpath("//li/a[text()='Login']")).click();
       driver.findElement(By.xpath("//div/a[text()='Register']")).click();
       Assert.assertEquals(text,"Register Account");
       driver.quit();
   }

}
