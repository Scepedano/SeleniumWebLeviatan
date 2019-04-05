package compageObjectsTestsaviaDigital;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageobjectpattern.saviadigital.BarraMenuPageSavia;
import com.pageobjectpattern.saviadigital.LoginMoodlePage;
import com.pageobjectpattern.saviadigital.LoginPageSavia;
import com.pageobjectpattern.saviadigital.SeleccionarLibroPage;
import com.pageobjectpattern.saviadigital.UnidadDidactica;
import com.sm.utility.Constant;

public class DescargaOffline {
	WebDriver driver;
	//Actions action = new Actions(driver);
	LoginPageSavia logpag;
	SeleccionarLibroPage selLibro;
	LoginMoodlePage  moddleLog;	
	BarraMenuPageSavia barraMenu;
	UnidadDidactica udidactica;
	//String originalHandle = driver.getWindowHandle();
	
	@Test
	public void DescarOffline() {
		  
		//Creacion del navegador y maximizar navegador
		  driver.get(Constant.BaseURL);  
		  
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
		  
		  driver.get(Constant.BaseURL3);
		  selLibro = new SeleccionarLibroPage(driver);
		  selLibro.descargaOffline();
		  
		  driver.get(Constant.BaseURL4);
		  // considering that there is only one tab opened in that point.
		  String oldTab = driver.getWindowHandle();
		  ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		  newTab.remove(oldTab);
		    // change focus to new tab
		  driver.switchTo().window(newTab.get(0));
		  selLibro.descargar();
		  Alert alert = driver.switchTo().alert();
		 
		  alert.dismiss();
		  /*for(String handle : driver.getWindowHandles()) {
		        if (!handle.equals(originalHandle)) {
		            driver.switchTo().window(handle);
		        }
		    }*/
		 
	    // Do what you want here, you are in the new tab

		  driver.close();
		    // change focus back to old tab
		  driver.switchTo().window(oldTab);
	
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
				} else if (browser.equalsIgnoreCase("IE")) {
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
					capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
					System.setProperty("webdriver.ie.driver", "C:/Documents/Automation/IEDriverServer.exe");
					driver= new RemoteWebDriver(capabilities);
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
