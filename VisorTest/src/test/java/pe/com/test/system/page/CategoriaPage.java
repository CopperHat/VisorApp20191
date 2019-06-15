package pe.com.test.system.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.com.test.system.driver.VisorDriver;

public class CategoriaPage {
	
	private By botonNuevo = By.id("btnNuevo");
	private By cajaNombre = By.id("txtNombre");
	private By botonGuardar = By.id("btnGuardar");
	private By mensajeRespuesta = By.id("messages");
	private WebDriver webDriver = null;
	private final static int MAXIMO_TIEMPO = 3000;

	public CategoriaPage(WebDriver pagina) {
		webDriver = pagina;
	}
	
	public void hacerClicBotonNuevo() throws Exception{
		webDriver.findElement(botonNuevo).click();
		Thread.sleep(MAXIMO_TIEMPO);
	}
	
	public void escribirCampoNombre(String nombre) throws Exception{
		webDriver.findElement(cajaNombre).clear();
		webDriver.findElement(cajaNombre).sendKeys(nombre);
		Thread.sleep(MAXIMO_TIEMPO);
	}
	
	public String registrarCategoria() throws Exception{
		webDriver.findElement(botonGuardar).click();
		Thread.sleep(MAXIMO_TIEMPO);
		return webDriver.findElement(mensajeRespuesta).getText();
	}
	
	public WebDriver obtenerPagina() {
		return webDriver;
	}
	
	public void cerrarPagina() {
		VisorDriver.cerrarPagina(webDriver);
	}
	
	

}
