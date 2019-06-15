package pe.com.test.system.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.com.test.system.driver.VisorDriver;

public class BienvenidaPage {

	private By linkMenu = By.xpath("/html/body/section/div[1]/div");
	private By linkModAlmacen = By.xpath("/html/body/section/div[1]/nav/ul/li/span");
	private By linkMntCategoria = By.linkText("Mnt. de Categoría");
	private WebDriver webDriver = null;
	private final static int MAXIMO_TIEMPO = 3000;
	
	public BienvenidaPage(WebDriver pagina) {
		webDriver = pagina;
	}
	
	public void hacerClicMenuPrincipal() throws Exception{
		webDriver.findElement(linkMenu).click();
		Thread.sleep(MAXIMO_TIEMPO);
	}
	
	public void hacerClicMenuModuloAlmacen() throws Exception{
		webDriver.findElement(linkModAlmacen).click();
		Thread.sleep(MAXIMO_TIEMPO);
	}
	
	public void hacerClicMenuMntDeCategoria() throws Exception{
		webDriver.findElement(linkMntCategoria).click();
		Thread.sleep(MAXIMO_TIEMPO);
	}
	
	public WebDriver obtenerPagina() {
		return webDriver;
	}
	
	public void cerrarPagina() {
		VisorDriver.cerrarPagina(webDriver);
	}
	
	
}
