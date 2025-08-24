package tutorialsninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {

	@Test
	public void verifyRegisterwithMandatoryFields() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-blink-features=AutomationControlled");
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.cssSelector("a[title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Shubham");
		driver.findElement(By.id("input-lastname")).sendKeys("Kashyap");
		driver.findElement(By.id("input-email")).sendKeys(generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("7860169256");
		driver.findElement(By.id("input-password")).sendKeys("Shubh2915@21");
		driver.findElement(By.id("input-confirm")).sendKeys("Shubh2915@21");
		driver.findElement(By.cssSelector("input[name='agree']")).click();
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		String accountCreatedText = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Assert.assertEquals("Your Account Has Been Created!", accountCreatedText);
		String confirmText1 = "Congratulations! Your new account has been successfully created!";
		String confirmText2 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String confirmText3 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String confirmText4 = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(confirmText1));
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(confirmText2));
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(confirmText3));
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(confirmText4));
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();
	}

	public static String generateEmail() {
		Date date = new Date();

		return date.toString().replaceAll("\\s", "").replaceAll("\\:", "") + "@gmail.com";

	}

}
