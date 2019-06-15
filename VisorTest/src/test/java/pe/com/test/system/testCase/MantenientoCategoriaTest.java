package pe.com.test.system.testCase;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pe.com.test.system.data.Excel;
import pe.com.test.system.page.BienvenidaPage;
import pe.com.test.system.page.CategoriaPage;
import pe.com.test.system.page.IniciarSesionPage;
import pe.com.test.system.util.Utilitario;

public class MantenientoCategoriaTest {

	private IniciarSesionPage iniciarSesionPage;
	private BienvenidaPage bienvenidaPage;
	private CategoriaPage categoriaPage;
	private String rutaCapturaPantalla;
	
	@BeforeTest
	@Parameters({"navegador", "rutaCapturaPantalla"})
	public void inicioTest(String navegador, String rutaCapturaPantalla) {
		iniciarSesionPage = new IniciarSesionPage(navegador);
		bienvenidaPage = new BienvenidaPage(iniciarSesionPage.obtenerPagina());
		categoriaPage = new CategoriaPage(bienvenidaPage.obtenerPagina());
		this.rutaCapturaPantalla = rutaCapturaPantalla;
	}
	
	@DataProvider(name = "datosRegistrarCategoria")
	public static Object[][] datosRegistrarCategoria(ITestContext contexto){
		String ruta = contexto.getCurrentXmlTest().getParameter("rutaExcel");
		return Excel.leerExcel(ruta);
	}
	
	@Test(dataProvider =  "datosRegistrarCategoria")
	public void insertarCategoria_FlujoBasico(String nombreCasoPrueba,
			String url, String usuario, String clave, String nombre, String valorEsperado) {
		try {
			iniciarSesionPage.ingresarPagina(url);
			iniciarSesionPage.iniciarSesion(usuario, clave);
			bienvenidaPage.hacerClicMenuPrincipal();
			bienvenidaPage.hacerClicMenuModuloAlmacen();
			bienvenidaPage.hacerClicMenuMntDeCategoria();
			categoriaPage.hacerClicBotonNuevo();
			categoriaPage.escribirCampoNombre(nombre.trim());
			String valorObtenido = categoriaPage.registrarCategoria();
			Assert.assertEquals(valorObtenido, valorEsperado);
		}catch(AssertionError e) {
			Utilitario.caputarPantallarError(rutaCapturaPantalla, 
					e.getMessage(), 
					categoriaPage.obtenerPagina());
			Assert.fail(e.getMessage());
		}catch (Exception e) {
			Assert.fail("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void finTest() {
		categoriaPage.cerrarPagina();
	}
	
}
