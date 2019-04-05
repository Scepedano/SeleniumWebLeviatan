package com.pageobjectpattern.saviadigital;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EditarMePerfilPage {
	WebDriver driver;
	
	@FindBy (xpath="html/body/section[1]/div[2]/div[1]/input")
	private WebElement checkCondiciones;
	
	@FindBy (xpath ="html/body/section[1]/div[1]/ul/li[1]/div[2]/input")
	private WebElement nombre;
	
	@FindBy(xpath ="html/body/section[1]/div[1]/ul/li[4]/div[2]/input")
	private WebElement passWord;
	
	@FindBy(xpath="html/body/section[1]/div[2]/div[2]/a[1]")
	private WebElement aceptar; 
	
	public EditarMePerfilPage(WebDriver driver){
		 
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	public void ModificarNombre(){
		if (nombre.isEnabled()){
			nombre.click();
		}else{
			System.out.print("Element is not enable");
		}
	}

}
