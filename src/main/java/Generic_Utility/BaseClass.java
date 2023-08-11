package Generic_Utility;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import POM.DashboardPage;
import POM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	


	@BeforeClass
	
		 public void BC() throws IOException { 
		 Property_Utility p = new Property_Utility(); 
		 String browser = p.getKeyValue("browser");
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		System.out.println("Lunching the Browser");
	}

	@BeforeMethod
	public void BM() throws IOException {
		Property_Utility p = new Property_Utility();
		Webdriver_utility w = new Webdriver_utility();
		w.implicitlyWait(driver);
		w.maximize(driver);
		String URL = p.getKeyValue("url");
		String USERNAME = p.getKeyValue("username");
		String PASSWORD = p.getKeyValue("password");
		driver.get(URL);
		LoginPage log = new LoginPage(driver);
		log.setLogin(USERNAME, PASSWORD);
		System.out.println("Login");
	}

	@AfterMethod
	public void AM() {
		DashboardPage d = new DashboardPage(driver);
		d.LogoutLink(driver);
		System.out.println("Logout");
	}

	@AfterClass
	public void AC() {
		driver.quit();
		System.out.println("Close the Browser");
	}



	
}
