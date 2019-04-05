package com.pageobjectpatter.smconectados;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import compageObjectsTestsaviaDigital.Login;

public class NuevoUsuarioPage {

	WebDriver driver;
	
	@FindBy(xpath="html/body/div[8]/div/div[4]/div[2]/div[1]/input")
	private WebElement correoElectonico;

	@FindBy(xpath="html/body/div[8]/div/div[4]/div[2]/div[2]/input")
	private WebElement repetirCorreo;
	
	@FindBy(xpath="html/body/div[8]/div/div[4]/div[2]/div[4]/input")
	private WebElement contrasenia;
	
	@FindBy(xpath="html/body/div[8]/div/div[4]/div[2]/div[5]/input")
	private WebElement repetirContasenia;
	
	@FindBy(xpath="html/body/div[8]/div/div[4]/div[2]/div[7]/input")
	private WebElement nombre;
	
	@FindBy(xpath="html/body/div[8]/div/div[4]/div[2]/div[8]/input")
	private WebElement apellido;
	
	@FindBy(xpath="html/body/div[8]/div/div[4]/div[2]/div[10]/input")
	private WebElement fechaNacimiento;
	
	@FindBy(xpath="html/body/div[8]/div/div[4]/div[2]/div[11]/input")
	private WebElement telefonoMovil;
	
	@FindBy(xpath="html/body/div[8]/div/div[4]/div[2]/div[12]/input[1]")
	private WebElement checkHijosSi;
	
	@FindBy(xpath="html/body/div[8]/div/div[4]/div[2]/div[12]/input[2]")
	private WebElement checkHijosNo;
	
	@FindBy(xpath="html/body/div[8]/div/div[4]/div[2]/div[13]/input[1]")
	private WebElement checkGeneroMasculino;
	
	@FindBy(xpath="html/body/div[8]/div/div[4]/div[2]/div[13]/input[2]")
	private WebElement checkGeneroFemenino;
	
	@FindBy(xpath="html/body/div[8]/div/div[5]/div[2]/div[2]/input")
	private WebElement codigoPostal;
	
	@FindBy(xpath="html/body/div[8]/div/div[5]/div[2]/div[2]/div[2]")
	private WebElement botonBuscar;
	
	@FindBy(xpath="html/body/div[8]/div/div[5]/div[2]/div[4]/input")
	private WebElement checkCentro;
	
	@FindBy(xpath="html/body/div[8]/div/div[7]/input")
	private WebElement checkCondiciones;
	
	@FindBy(xpath="html/body/div[8]/div/div[7]/div/div[1]")
	private WebElement botonRegistrar;
	
	@FindBy(xpath="html/body/div[8]/div/div[7]/div/div[2]/a")
	private WebElement botonCancelar;
	
	public NuevoUsuarioPage(WebDriver driver){
		 
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void IntroducirMail(String mail){
		if (correoElectonico.isEnabled()){
			correoElectonico.clear();
			correoElectonico.click();
			correoElectonico.sendKeys(mail);
		}else{
			System.out.print("Element is not enable");
		}
	}
	public void ReIntroducirMail(String mail){
		if (repetirCorreo.isEnabled()){
			repetirCorreo.clear();
			repetirCorreo.click();
			repetirCorreo.sendKeys(mail);
		}else{
			System.out.print("Element is not enable");
		}
	}
	public void IntrodcirPassword(String pass){
		if (contrasenia.isEnabled()){
			contrasenia.clear();
			contrasenia.click();
			contrasenia.sendKeys(pass);
		}else{
			System.out.print("Element is not enable");
		}
	}
	public void ReIntrodcirPassword(String repass){
		if (repetirContasenia.isEnabled()){
			repetirContasenia.clear();
			repetirContasenia.click();
			repetirContasenia.sendKeys(repass);
		}else{
			System.out.print("Element is not enable");
		}
	}
	public void Nombre(String nombrepro){
		if (nombre.isEnabled()){
			nombre.clear();
			nombre.click();
			nombre.sendKeys(nombrepro);
		}else{
			System.out.print("Element is not enable");
		}
	}
	public void Apellidos(String apellidos){
		if (apellido.isEnabled()){
			apellido.clear();
			apellido.click();
			apellido.sendKeys(apellidos);
		}else{
			System.out.print("Element is not enable");
		}
	}
	public void FechaNacimiento(String fecha){
		if (fechaNacimiento.isEnabled()){
			fechaNacimiento.clear();
			fechaNacimiento.click();
			fechaNacimiento.sendKeys(fecha);
		}else{
			System.out.print("Element is not enable");
		}
	}
	public void TelefonoMovil(String telefono){
		if (telefonoMovil.isEnabled()){
			telefonoMovil.clear();
			telefonoMovil.click();
			telefonoMovil.sendKeys(telefono);
		}else{
			System.out.print("Element is not enable");
		}
	}
	
	public void Profesorhijos(){
		if(checkHijosSi.isEnabled()||!(checkHijosSi.isSelected())){
			checkHijosSi.click();
		}else{
			System.out.print("Element is not enable");
		}
	}
	public void ProfesorSinhijos(){
		if(checkHijosNo.isEnabled()||!(checkHijosNo.isSelected())){
			checkHijosNo.click();
		}else{
			System.out.print("Element is not enable");
		}
	}
	public void GeneroFemenino(){
		if(checkGeneroFemenino.isEnabled()||!(checkGeneroFemenino.isSelected())){
			checkGeneroFemenino.click();
		}else{
			System.out.print("Element is not enable");
		}
	}
	public void escribirCodigoPostal(String codpostal){
		if(codigoPostal.isEnabled()){
			codigoPostal.click();
			codigoPostal.sendKeys(codpostal);
		}else{
			System.out.print("Element is not enable");
		}
	}
	public void BuscarCodigoPOstal(String cpostal){
		if(botonBuscar.isDisplayed()){
			
			escribirCodigoPostal(cpostal);
			botonBuscar.click();
			
		}else{
			System.out.print("Element is not enable");
		}
	}
	public void SeleccionarCentro(){
		
	}
	
}
