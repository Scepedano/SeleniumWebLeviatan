package comPageObjectsTestSaviaDigital;

import java.awt.AWTException;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.pageobjectpattern.saviadigital.moodesp.BarraMenuPageSavia;
import com.pageobjectpattern.saviadigital.moodesp.BrowserType;
import com.pageobjectpattern.saviadigital.moodesp.LoginMoodlePage;
import com.pageobjectpattern.saviadigital.moodesp.LoginPageSavia;
import com.pageobjectpattern.saviadigital.moodesp.SeleccionarLibroPage;
import com.pageobjectpattern.saviadigital.moodesp.TrabajosAsignadosPage;
import com.pageobjectpattern.saviadigital.moodesp.UnidadDidacticaPage;

public class VerImagenGaleria {
	WebDriver driver;
	LoginPageSavia logpag;
	SeleccionarLibroPage selLibro;
	LoginMoodlePage moddleLog;
	BarraMenuPageSavia barraMenu;
	UnidadDidacticaPage udidactica;
	TrabajosAsignadosPage tasignados;

	/**
	 * 
	 * @param url
	 * @param Username
	 * @param Password
	 * @throws AWTException
	 *             El alumno entrega una de las galerias que tiene asignadas por
	 *             el profesor
	 */
	@Parameters({ "url", "Username", "Password" })
	@Test
	public void EntregarGalerias(String url, String Username, String Password)
			throws AWTException {
		/**
		 * se crea el driver de la pagina de login Login en la aplicacion
		 */

		driver.get(url);
		logpag = new LoginPageSavia(driver);
		logpag.login(Username, Password);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		/**
		 * switch focus of WebDriver to the next found window handle (that's
		 * your newly opened window)
		 */
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		/**
		 * Creacion de driver para manejo del libro Seleccion de libro seleccion
		 * de unidad didactica
		 */
		selLibro = new SeleccionarLibroPage(driver);
		selLibro.selecLitbro();
		selLibro.unidadDidactica();

		udidactica = new UnidadDidacticaPage(driver);
		udidactica.seleccionarTrabajosAsignados();

		tasignados = new TrabajosAsignadosPage(driver);

		driver.findElement(By.linkText("galeria")).getText()
				.compareTo("galeria");

	}

	/**
	 * 
	 * @param browser
	 * @param platform
	 */
	@Parameters({ "browser", "platform" })
	@BeforeTest
	public void SetUp(String browser, String platform) {

		driver = BrowserType.Execute(browser, platform);

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
