package compageObjectsTestsaviaDigital;

import java.util.concurrent.TimeUnit;

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
import com.pageobjectpattern.saviadigital.BarraMenuPageSavia;
import com.pageobjectpattern.saviadigital.LoginPageSavia;
import com.pageobjectpattern.saviadigital.SeleccionarLibroPage;
import com.pageobjectpattern.saviadigital.UnidadDidactica;
import com.sm.utility.Constant;

public class Notificaciones {
 
	WebDriver driver;
	
	LoginPageSavia logpag;
	SeleccionarLibroPage selLibro;
	LoginMoodlePage  moddleLog;	
	BarraMenuPageSavia barraMenu;
	UnidadDidactica udidactica;
	
	@Test
	public void Nitificaciones() {
		  
		//Creacion del navegador y maximizar navegador
		  
		driver.get(Constant.BaseURL);
		  driver.manage().window().maximize(); 
		  driver.manage().deleteAllCookies();
	      //CreateLogin Page object
		  logpag = new LoginPageSavia(driver);
		  //login to application

		  String username= Constant.Username;
		  String pass = Constant.Password;
		  logpag.login(username,pass);
		  		  
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  
		  driver.get(Constant.BaseURL2);
		  
		  moddleLog =  new LoginMoodlePage(driver);
		  moddleLog.login(username, pass);
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  
		  driver.get(Constant.BaseURL3);;
		  selLibro = new SeleccionarLibroPage(driver);
		  selLibro.verNotificaciones();
		  /**
		   * Acceso al logout para liberar la sesion para otras pruebas		  
		   */
		  barraMenu = new BarraMenuPageSavia(driver);
		  barraMenu.sellogid();
		  barraMenu.cerrarSesion();

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
	@AfterTest
	public void tearDown() {
	  
	  driver.quit();
	}
}
