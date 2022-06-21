package Data_Driven_Testing;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistertodemoWebShop {
	
	@Test(dataProvider = "register")
	public void Tc(String firstname, String Lastname, String email, String password) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demowebshop.tricentis.com");	
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.id("FirstName")).sendKeys(firstname);
		driver.findElement(By.id("LastName")).sendKeys(Lastname);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@value='Register']")).click();	
	}
@DataProvider(name="register")
public static Object[][] dataP() throws EncryptedDocumentException, IOException{
return 	Excel_Data.readData("Register", "./src/test/resources/TestData/TestData.xlsx");
	
}
}
