package com.pageobjectpatter.smconectados;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
/**
 * 
 * @author sonia.cepedano
 *
 */


public class BarraMenusPage {
	 WebDriver driver;

	@FindBy(xpath="html/body/div[5]/div/div[7]/div[1]/div")
	private WebElement miEspacio;
	 
	@FindBy(xpath="html/body/div[5]/div/div[7]/div[2]/div")
	private WebElement botonProfesor;
	
	@FindBy(xpath ="html/body/div[6]/div[2]/div[2]")
	private WebElement logout;

	@FindBy(xpath="html/body/div[6]/div[2]/div[1]")
	private WebElement modificar;
	
	@FindBy(xpath= "html/body/div[5]/div/div[1]/div")
	private WebElement  catalogo;
	
	@FindBy(xpath = "html/body/div[5]/div/div[2]/div")
	private WebElement blog;
	
	@FindBy(xpath = "html/body/div[5]/div/div[3]/div")
	private WebElement bRecursos;
	
	@FindBy(xpath = "html/body/div[5]/div/div[4]/div[1]")
	private WebElement soportetecnico;
	
	@FindBy(xpath= "html/body/div[5]/div/div[4]/div[2]/div[1]")
	private WebElement quienSomos;
	
	@FindBy(xpath ="html/body/div[5]/div/div[4]/div[2]/div[2]")
	private WebElement videoytuto;
	
	@FindBy(xpath = "html/body/div[5]/div/div[4]/div[2]/div[3]")
	private WebElement guiaUso;
	
	@FindBy (xpath = "html/body/div[5]/div/div[4]/div[2]/div[4]")
	private WebElement contacta;
	
	@FindBy(xpath = "html/body/div[5]/div/div[5]/div[1]")
	private WebElement servicios;
	
	@FindBy(xpath = "html/body/div[5]/div/div[5]/div[2]/div[1]")
	private WebElement legEductiva;

	@FindBy(xpath = "html/body/div[5]/div/div[5]/div[2]/div[2]" )
	private WebElement progAcompania;
	
	@FindBy(xpath = "html/body/div[5]/div/div[5]/div[2]/div[3]")
	private WebElement smConecResponde;
	
	@FindBy(xpath = "html/body/div[5]/div/div[5]/div[2]/div[4]")
	private WebElement asesoria;
	
	@FindBy(xpath = "html/body/div[5]/div/div[5]/div[2]/div[4]")
	private WebElement librosPersonalizados;
	
	@FindBy(xpath = "html/body/div[5]/div/div[6]/div")
	private WebElement masConectados;
	
	
	
	public BarraMenusPage (WebDriver driver){
		 
        this.driver = driver;
        PageFactory.initElements(driver, this);
 	    }
	
	public void miEspacio(){
		if(miEspacio.isEnabled()){
			miEspacio.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	public void bPidentif(){
		if (botonProfesor.isEnabled()){
			botonProfesor.click();
		}else{
			System.out.println("Element is not enable");
		}
	}	
	
	public void cerrarsesion(){
		if(logout.isEnabled()){
			logout.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
		
	public void modificarDatos(){
			if(modificar.isEnabled()){
				modificar.click();
				System.out.println("Element is not enable");
			}
		}
		
	public void botonProfesorlogout(){
		if (logout.isEnabled()){
		 logout.click();
		}else {
		 System.out.println("Element is not enable");
		}
	}	

	public void accderCatalogo(){
		if(catalogo.isEnabled()){
			catalogo.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	
	public void accderBlog(){
		if(blog.isEnabled()){
			blog.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	
	public void recursos(){
		if(bRecursos.isEnabled()){
			bRecursos.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	
	public void soportetecnico(){
		if (soportetecnico.isEnabled()){
			soportetecnico.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	
	public void videoytuto(){
		if(videoytuto.isEnabled()){
			videoytuto.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	
	public void quienSomos(){
		if(quienSomos.isEnabled()){
			quienSomos.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	
	public void contacta(){
		if (contacta.isEnabled()){
			contacta.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	
	public void guiauso(){
		if (guiaUso.isEnabled()){
			guiaUso.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	
	public void servicios(){
		if (servicios.isEnabled()){
			servicios.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	
	public void legEductiva(){
		if (legEductiva.isEnabled()){
			legEductiva.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	
	public void progAcompania(){
		if (progAcompania.isEnabled()){
			progAcompania.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	
	public void smConecResponde(){
		if(smConecResponde.isEnabled()){
			smConecResponde.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	
	public void asesoria(){
		if (asesoria.isEnabled()){
			asesoria.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	
	public void librosPersonalizados(){
		if(librosPersonalizados.isEnabled()){
			librosPersonalizados.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	
	public void masConectados(){
		if(masConectados.isEnabled()){
			masConectados.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	

}
