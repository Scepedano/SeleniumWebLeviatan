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
import com.pageobjectpatter.smconectados.NuevoUsuarioPage;
import com.sm.utility.Constant;
/**
 * 
 * @author sonia.cepedano
 * Test de la pagina sm conectados que nos permite crear un nuevo profesor
 */
public class CrearNuevoUsuario {
	  WebDriver driver;
	  LoginPage logpag;
	  NuevoUsuarioPage nusuario;
	
	  @Test
	public void testCrearNuevoUsuario(){
		  
		driver.get(Constant.BaseURL5);
		
		/**
		 * Create Login Page object
		 */
	    logpag = new LoginPage(driver);
	    
	    /**
	     * Acceso a crear usuario haciendo click en el botón
	     */
		logpag.CrearNuevoUsuario();
		  
		/**
		 * Acceso a la pagina de creacion de nuevo usuario profesor
		 */
		 driver.get(Constant.BASEURL8);
		 nusuario = new NuevoUsuarioPage(driver);
		  
		  /**
		   * Definicion de las constantes
		   */
		 
		  String CorreoElectronico = Constant.CorreoElectronico;
		  String recorreoElectronico = Constant.RepetirCorreoElectronico;
		  String password = Constant.Contrasenia;
		  String repetirpassword = Constant.RepetirContrasenia;
		  String apellidos = Constant.Apellidos;
		  String nombre= Constant.Nombre;
		  String telefono = Constant.TelefonoMovil;
		  String fecha = Constant.FechaNacimiento;
		  String cpostal = Constant.CodigoPostal;
		  
		  /**
		   * introducción de datos en el formulario
		   */
		  
		  nusuario.IntroducirMail(CorreoElectronico);
		  nusuario.ReIntroducirMail(recorreoElectronico);
		  nusuario.IntrodcirPassword(password);
		  nusuario.ReIntrodcirPassword(repetirpassword);
		  nusuario.Nombre(nombre);
		  nusuario.Apellidos(apellidos);
		  nusuario.FechaNacimiento(fecha);
		  nusuario.TelefonoMovil(telefono);
		  nusuario.Profesorhijos();
		  nusuario.GeneroFemenino();
		  nusuario.BuscarCodigoPOstal(cpostal);
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
