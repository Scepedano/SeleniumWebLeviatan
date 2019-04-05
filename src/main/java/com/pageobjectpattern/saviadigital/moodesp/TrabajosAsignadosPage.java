package com.pageobjectpattern.saviadigital.moodesp;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author sonia.cepedano
 * 
 * Definimos en este metodo los elementos y 
 * los metodos necesarios para manejar la pagina de trabajos y tareas asignadas, 
 * ya sean individuales o de grupo
 *
 */
public class TrabajosAsignadosPage {

	WebDriver driver;
	/**
	 * Elementos de la paginas.
	 */
	@FindBy(xpath="html/body/div[1]/section/div/div[5]/div/ul/li[2]/ul/li[2]/div/a")
	public WebElement propuestaAsignada;
	
	@FindBy(xpath= "html/body/div[1]/section/div/div[5]/div/ul/li[2]/ul/li/div/a")
	public WebElement tareaAsignada;
	
	@FindBy(xpath="html/body/div[1]/section/div/div[5]/div/ul/li[4]/ul/li[1]/div/a")
	public WebElement trabajoEquipo;
	
	@FindBy(xpath="html/body/div[3]/div/div[2]/div[2]/div[1]")
	public WebElement botonContinuar;
	
	@FindBy(id="suggestions_continue" )
	public WebElement bContinuarForo;
	
	@FindBy(xpath="html/body/div[2]/div/div/div/section/div/div[2]/div[2]/div[1]/form/div/input[1]")
	public WebElement botonRealizarTarea;
	
	@FindBy(xpath="html/body/div[3]/div/div/div/section/div/div[2]/form/fieldset[1]/div/div[1]/div[2]/div/div[1]/div/div[2]/div")
	public WebElement textBoxTarea;
	
	@FindBy(xpath="html/body/div[3]/div/div/div/section/div/div[2]/form/fieldset[2]/div/div/div/input[1]")
	public WebElement botonGuardar;
	
	@FindBy(xpath="html/body/div[2]/div/div/div/section/div/div[2]/div[3]/div[1]/form/div/input[1]")
	public WebElement botonEnviarTarea;
	
	@FindBy(xpath="html/body/div[2]/div/div/div/section/div/div/div/form/fieldset[2]/div/div/div/input[1]")
	public WebElement botonFinalizar;
	
	@FindBy(xpath="html/body/div[3]/div/div[2]/div[2]/div[2]")
	public WebElement botonResultado;
	
	@FindBy(xpath="html/body/div[3]/div/div[2]/div[2]/div[7]")
	public WebElement botonVerRespuestas;
	
	@FindBy(xpath="html/body/div[7]/header/button")
	public WebElement cerrarDialogo;
	
	@FindBy(xpath="html/body/div[2]/header/button[2]")
	public WebElement vistaAmpliada;
	
	@FindBy(xpath="html/body/div[2]/div/div/div/section/div/table/tbody/tr/td[1]")
	public WebElement temaForo;
	
	@FindBy(xpath="html/body/div[2]/div/div/div/section/div/div[3]/div[3]/div[2]/div/a")
	public WebElement responderForo;
	
	@FindBy(id="id_messageeditable")
	public WebElement mensaje;
	
	@FindBy(id="id_submitbutton")
	public WebElement enviarRespuesta;
	
	@FindBy(xpath="html/body/div[2]/div/div/div/header/div[2]/div")
	public WebElement valorNota;
	
	@FindBy(xpath="html/body/div[1]/section/div/div[5]/div/ul/li[4]/ul/li[2]/div/a")
	public WebElement galeria;
	
	@FindBy(xpath="html/body/div[2]/div/div/div/section/div/div/div/div[3]/div/form/div/input[1]")
	public WebElement aniadirImagen;
	
	@FindBy(id="id_title")
	public WebElement titloFoto;
	
	@FindBy(id="id_descriptioneditable")
	public WebElement descripcionFoto;
	
	@FindBy(xpath="html/body/div[3]/div/div/div/section/div/form/fieldset[2]/div/div[1]/div/input[2]")
	public WebElement SelImagen;
	
	@FindBy(xpath="html/body/div[6]/div[2]/div/div[2]/div/div[2]/div[2]/div/div/form/div/div[2]/div/input")
	public WebElement nombreImagen;
	
	@FindBy(xpath="html/body/div[6]/div[2]/div/div[2]/div/div[2]/div[2]/div/div/form/div/div[2]/div/input")
	public WebElement guardarComo;
	
	@FindBy(linkText="Subir este archivo")
	public WebElement botonSubirArchivo;
	
	public TrabajosAsignadosPage(WebDriver driver){
		 
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	/**
	 * Metodos para controlar la pagina
	 */
	public void seleccionarTareaAsignada(){
		if(tareaAsignada.isEnabled()){
			tareaAsignada.click();
		}
	}
	
	public void seleccionarTrabajoEquipo(){
		if(trabajoEquipo.isEnabled()){
			trabajoEquipo.click();
		}
	}
	public void continuarActividad(){
		if(botonContinuar.isEnabled()){
			botonContinuar.click();
		}
	}
	public void continuarForo(){
		if(bContinuarForo.isEnabled()){
			bContinuarForo.click();
		}
	}
	public void reliazarTarea(){
		if(botonRealizarTarea.isDisplayed()){
			botonRealizarTarea.click();
		}
	}
	public void aniadirTexto(){
		if(textBoxTarea.isEnabled()){
			textBoxTarea.click();
		}
	}
	public void guardarCambios(){
		if(botonGuardar.isEnabled()){
			botonGuardar.click();
		}
	}
	public void enviarTarea(){
		if (botonEnviarTarea.isEnabled()){
			botonEnviarTarea.click();
		}
	}
	public void finalizarTarea(){
		if(botonFinalizar.isEnabled()){
			botonFinalizar.click();
		}
	}
	public void generarREsultados(){
		if(botonResultado.isEnabled()){
			botonResultado.click();
		}
	}
	public void verRespuestas(){
		if(cerrarDialogo.isEnabled()){
			cerrarDialogo.click();
		}
	}
	public void ampliarVistaForo(){
		if(vistaAmpliada.isEnabled()){
			vistaAmpliada.click();
		}
	}
	public void seleccionarTemaForo(){
		if (temaForo.isEnabled()){
			temaForo.click();
		}
	}
	public void responderForo(){
		if(responderForo.isEnabled()){
			responderForo.click();
		}
	}
	public void respuesta(String respuesta){
		if(mensaje.isEnabled()) {
			mensaje.click();
			mensaje.sendKeys(respuesta);
		}
	}
	public void enviarRespuesta(){
		if(enviarRespuesta.isEnabled()){
			enviarRespuesta.click();
		}
	}
	public void verForoCorregido(){
		if (valorNota.isEnabled()){
			try{
			  if(!(valorNota.equals(null))){
				System.out.println("El foro esta corregido");
				
			  }
			 
			}catch(NoSuchElementException e){
				System.out.println(e.getMessage());
			}
		}
	}
	public void entrarGaleria(){
		if(galeria.isEnabled()){
			galeria.click();
		}
	}
	public void botonAniadir(){
		if (aniadirImagen.isEnabled()){
			aniadirImagen.click();
		}
	}
	public void aniadirTitDesc(String titulo, String descri){
		if(titloFoto.isEnabled()){
			titloFoto.click();
			titloFoto.sendKeys(titulo);
			descripcionFoto.click();
			descripcionFoto.sendKeys(descri);
		}
	}
	
	public void darNombreFichero(){
		if(guardarComo.isEnabled()){
			guardarComo.click();
		}
	}
	public void subirArchivo(){
		if(botonSubirArchivo.isEnabled()){
			botonSubirArchivo.click();
		}
	}
}
