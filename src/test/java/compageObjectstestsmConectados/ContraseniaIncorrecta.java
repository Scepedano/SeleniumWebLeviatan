package compageObjectstestsmConectados;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageobjectpatter.smconectados.LoginPage;
import com.sm.utility.Constant;

public class ContraseniaIncorrecta {
  WebDriver driver;
  LoginPage logpag;
	
	@Test
public void test_login_Correct(){
		  
		driver.get(Constant.BaseURL5);
		//Create Login Page object

		  logpag = new LoginPage(driver);
		  //login to application
		  
		  String username= Constant.Username;
		  String pass = Constant.Password2;
		  logpag.loginKOPass(username, pass);

	  }
	@Parameters({ "browser" })
	@BeforeTest
		public void openBrowser(String browser) {
			try {
				if (browser.equalsIgnoreCase("Firefox")) {
					  DesiredCapabilities capability = DesiredCapabilities.firefox();
				      driver = new RemoteWebDriver(capability);
				      driver.manage().window().maximize();
						driver.manage().deleteAllCookies();
				} else if (browser.equalsIgnoreCase("chrome")) {
					  DesiredCapabilities capability = DesiredCapabilities.chrome();
				      driver = new RemoteWebDriver(capability);
				      driver.manage().window().maximize();
						driver.manage().deleteAllCookies();
				} else if (browser.equalsIgnoreCase("IE")) {
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
					System.setProperty("webdriver.ie.driver", "C:/Documents/Automation/IEDriverServer.exe");
					driver= new RemoteWebDriver(capabilities);
					driver.manage().window().maximize();
					driver.manage().deleteAllCookies();
			}
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}
@AfterSuite
public void tearDown() {
    
    driver.quit();
}
}
