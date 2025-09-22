package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class TC_RF_004 {
    @Test
    public void verifyRegisterationWithoutDetails() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        String firstNameText = driver.findElement(with(By.tagName("div")).below(firstName)).getText();
        String lastNameText = driver.findElement(By.xpath("//div[(contains(text(),\"Last Name must be between 1 and 32 characters!\"))]")).getText();
        String emailText = driver.findElement(By.xpath("//div[text()='E-Mail Address does not appear to be valid!']")).getText();
        String telephoneText = driver.findElement(By.xpath("//div[text()='Telephone must be between 3 and 32 characters!']")).getText();
        WebElement password = driver.findElement(By.id("input-password"));
        String passwordText = driver.findElement(with(By.tagName("div")).below(password)).getText();
        String PrivacyPolicyWarning=driver.findElement(By.cssSelector(".alert-danger")).getText();

        Assert.assertEquals(firstNameText, "First Name must be between 1 and 32 characters!");
        Assert.assertEquals(lastNameText, "Last Name must be between 1 and 32 characters!");
        Assert.assertEquals(emailText, "E-Mail Address does not appear to be valid!");
        Assert.assertEquals(telephoneText, "Telephone must be between 3 and 32 characters!");
        Assert.assertEquals(passwordText, "Password must be between 4 and 20 characters!");
        Assert.assertEquals(PrivacyPolicyWarning,"Warning: You must agree to the Privacy Policy!");

        driver.quit();
    }


}
