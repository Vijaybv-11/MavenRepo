package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchingFirefoxBrowserTest {
	
	@Test
	public void Tc() {
		
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com");
		
		
	}

}
