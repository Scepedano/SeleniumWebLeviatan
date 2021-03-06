package compageObjectsTestsaviaDigital;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.pageobjectpattern.saviadigital.EditarMePerfilPage;
import com.pageobjectpattern.saviadigital.BarraMenuPageSavia;
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

public class SeleccionarIdioma {
	WebDriver driver;
	LoginPageSavia logpag;
	LoginMoodlePage  moddleLog;
	BarraMenuPageSavia bmenu;
	EditarMePerfilPage	editPerfil;
	static Logger log = Logger.getLogger(Login.class);
	@Test
	 public void MoficarIdioma() throws Exception{
		  
	  	WebDriverWait wait = new WebDriverWait(driver, 15); 
	  	driver.get(Constant.BaseURL);  
		
	  	/**
		 * Create Login Page object
		 */
	  	
	  	driver.manage().window().maximize(); 
	  	driver.manage().deleteAllCookies();
		
	  	logpag = new LoginPageSavia(driver);
		
		log.info("El usuario introduce mal los datos del login");
				
		String Username= Constant.Username;
		String Pass=Constant.Password;
		logpag.login_PassFail(Username, Pass);
		
		bmenu = new BarraMenuPageSavia (driver);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[5]/div/div[7]/div[2]/div"))); 
		wait.until(ExpectedConditions.urlToBe("http://centros.smsaviadigital.com/s13/local/webbook/book.php"));
		bmenu.sellogid();
		bmenu.clickIdioma();
		//bmenu.seleccionarGallego();
		Actions actions = new Actions(driver);
		WebElement menuIdioma = driver.findElement(By.xpath("html/body/div[1]/section/div/div[1]/div/ul/li[1]/a"));
		actions.moveToElement(menuIdioma).perform();
		WebElement subLink = driver.findElement(By.xpath("html/body/div[1]/section/div/div[1]/div/ul/li[1]/ul/li[2]/a"));
		subLink.click();
		bmenu.sellogid();
		bmenu.cerrarSesion();
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
