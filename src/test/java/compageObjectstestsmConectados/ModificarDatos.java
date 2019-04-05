package compageObjectstestsmConectados;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageobjectpatter.smconectados.BarraMenusPage;
import com.pageobjectpatter.smconectados.LoginPage;
import com.pageobjectpatter.smconectados.ModificarPerfilPage;
import com.sm.utility.Constant;


public class ModificarDatos {
	WebDriver driver;
	LoginPage logpag;
	BarraMenusPage bmenu;
	ModificarPerfilPage perfil;
	static Logger log = Logger.getLogger(ModificarDatos.class);
  @Test
  public void ModificarDatosUsuario() {
	  WebDriverWait wait = new WebDriverWait(driver, 15); 
	  driver.get(Constant.BaseURL5);  
		//Create Login Page object

		  logpag = new LoginPage(driver);
		  //login to application
		  
		  log.info("introduce usuario y contraseña");
		  
			String Username= Constant.Username;
			String Password = Constant.Password;;
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			logpag.loginOK(Username,Password);
		
			bmenu = new BarraMenusPage (driver);
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[5]/div/div[7]/div[2]/div"))); 
			wait.until(ExpectedConditions.urlToBe("http://www.smconectados.com/smc/miespacio.aspx"));
			bmenu.bPidentif();
			bmenu.modificarDatos();
			
			perfil = new ModificarPerfilPage (driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[8]/div/div[6]/div[2]/div/div[1]/input"))); 
			perfil.aceptarCondiciones();
			perfil.aceptarModificaciones();
			perfil.cerrarPopUp();
			
			//bmenu.bPidentif();
			//bmenu.cerrarsesion();
			

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
