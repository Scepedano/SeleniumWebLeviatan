package comPageObjectsTestSaviaDigital;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import com.sm.utility.Constant;

public class EntregarGaleria {
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
		WebDriverWait wait = new WebDriverWait(driver, 20);
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
		tasignados.entrarGaleria();
		tasignados.continuarForo();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.switchTo().frame("el-modal-asset");

		WebElement botonAniadirImagen = driver.findElement(By
				.cssSelector("input[type='submit']"));

		botonAniadirImagen.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(250, 0)");
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("id_descriptioneditable")));

		tasignados
				.aniadirTitDesc(Constant.tituloForo, Constant.descripcionForo);

		jse.executeScript("scroll(0, -250)");

		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("html/body/div[3]/div/div/div/section/div/form/fieldset[1]/div/div[3]/div[2]/div[2]/div[1]/input")));
		WebElement aniadirFoto = driver
				.findElement(By
						.xpath("html/body/div[3]/div/div/div/section/div/form/fieldset[1]/div/div[3]/div[2]/div[2]/div[1]/input"));
		aniadirFoto.click();
		tasignados.darNombreFichero();
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("html/body/div[6]/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/button")));
		driver.findElement(
				By.xpath("html/body/div[6]/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/button"))
				.click();
		/**
		 * Vamos alert window para seleccionar fichero guarda en el portapapeles
		 * el nombre del fichero Estas dos primeras lineas nos ayudan a copiar
		 * en el portapapeles
		 */
		StringSelection string = new StringSelection("java.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard()
				.setContents(string, null);
		/**
		 * Simulamos la gestion de teclas
		 */
		Robot tecla = new Robot();
		tecla.keyPress(KeyEvent.VK_ENTER);
		tecla.keyRelease(KeyEvent.VK_ENTER);
		tecla.keyPress(KeyEvent.VK_CONTROL);
		tecla.keyPress(KeyEvent.VK_V);
		tecla.keyRelease(KeyEvent.VK_V);
		tecla.keyRelease(KeyEvent.VK_CONTROL);
		tecla.keyPress(KeyEvent.VK_ALT);
		tecla.keyPress(KeyEvent.VK_A);
		tecla.keyRelease(KeyEvent.VK_A);
		tecla.keyRelease(KeyEvent.VK_ALT);
		tecla.delay(40);

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
