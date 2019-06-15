package pe.com.test.system.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class VisorDriver {

	private VisorDriver() {
		
	}
	
	public final static WebDriver inicializarWebDriver(String navegador) {
		WebDriver webDriver = null;
		try {
			switch (navegador.toLowerCase()) {
			case "firefox":
				System.setProperty("webdriver.gecko.driver",
						"C:\\ProgramasInstalados\\geckodriver.exe");
				webDriver = new FirefoxDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver",
						"C:\\ProgramasInstalados\\chromedriver.exe");
				webDriver = new ChromeDriver();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webDriver;
	}
	
	public final static void cerrarPagina(WebDriver webDriver) {
		if(webDriver != null) {
			webDriver.quit();
		}
	}
	
}
