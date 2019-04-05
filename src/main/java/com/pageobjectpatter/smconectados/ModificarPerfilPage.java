package com.pageobjectpatter.smconectados;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class ModificarPerfilPage {

	 WebDriver driver;
	
	@FindBy(xpath ="html/body/div[8]/div/div[7]/input")
	private WebElement checkAceptar;
	
	@FindBy(xpath="html/body/div[8]/div/div[7]/div/div[1]")
	private WebElement aceptarmodif;
	
	@FindBy(xpath="html/body/div[17]/div[2]/div[2]")
	private WebElement menpopup;
	
	public ModificarPerfilPage (WebDriver driver){
		 
        this.driver = driver;
        PageFactory.initElements(driver, this);
 	    }
	
	public void aceptarCondiciones(){
		if (checkAceptar.isEnabled()){
			checkAceptar.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	public void aceptarModificaciones(){
		if (aceptarmodif.isEnabled()){
			aceptarmodif.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
	public void cerrarPopUp(){
		if (menpopup.isEnabled()){
			menpopup.click();
		}else{
			System.out.println("Element is not enable");
		}
	}
}
