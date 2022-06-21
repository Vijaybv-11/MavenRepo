package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	  WebDriver driver;
	@Parameters("browsers")
	@BeforeClass
	public void openBrowser(@Optional("chrome") String browser ) {
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
			 driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
			else if(browser.equalsIgnoreCase("Firefox")){
				System.setProperty("webdriver.gecko.driver", "./src/main/resources/Drivers/geckodriver.exe");
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
			}
		}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}