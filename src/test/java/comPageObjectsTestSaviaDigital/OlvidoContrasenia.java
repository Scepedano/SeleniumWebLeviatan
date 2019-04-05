package compageObjectsTestsaviaDigital;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.pageobjectpattern.saviadigital.LoginMoodlePage;
import com.pageobjectpattern.saviadigital.LoginPageSavia;
import com.sm.utility.Constant;

import org.apache.log4j.Logger;


/**
 * 
 * @author sonia.cepedano
 *
 *Clase en la que se definen los test relacionados con el login de savia digital
 */

public class OlvidoContrasenia {
	WebDriver driver;
	LoginPageSavia logpag;	
	LoginMoodlePage  moddleLog;
	static Logger log = Logger.getLogger(Login.class);
  @Test
  public void RecuperarContrasenia() throws Exception{
	  
	  	driver.get(Constant.BaseURL);  
		/**
		 * Create Login Page object
		 */
	  	
	  	driver.manage().window().maximize(); 
	  	driver.manage().deleteAllCookies();
		
	  	logpag = new LoginPageSavia(driver);
		
		log.info("El usuario ha olvidado su contraseña");
		logpag.recordarcontraseña();
		
		String Username= Constant.Username;
		log.info("introduce el usuario");
		logpag.introducemail(Username);
		logpag.enviarmail();
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
					capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
					System.setProperty("webdriver.ie.driver", "C:/Documents/Automation/IEDriverServer.exe");
					driver= new RemoteWebDriver(capabilities);
					driver.manage().window().maximize();
					driver.manage().deleteAllCookies();
			}
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}
@AfterTest
public void tearDown() {
  
  driver.quit();
}

}
