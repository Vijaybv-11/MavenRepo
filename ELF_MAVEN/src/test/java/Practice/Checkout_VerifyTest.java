package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Checkout_VerifyTest extends BaseTest {
	
	@Test	
		public void tc() {
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
		driver.get("http://demowebshop.tricentis.com");
		
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("222222222222@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("111111");
		
		driver.findElement(By.xpath("//input[@value='Log in']")).submit();
		driver.findElement(By.xpath("//div[@class='header-menu']/.//a[contains(text(),'Books')]")).click();
		
		driver.findElement(By.xpath("//a[text()='Computing and Internet']//..//..//..//..//input[@value='Add to cart']")).click();
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
        WebElement dropdown  = driver.findElement(By.xpath("//select[@class='country-input valid']"));
		Select sl = new Select(dropdown);
		sl.selectByVisibleText("India");
		driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		
		
		
		
	}

}
