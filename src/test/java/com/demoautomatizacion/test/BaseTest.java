package com.demoautomatizacion.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.Impresion.Pages.ImpresionPage;
import com.Notificaciones.Pages.NotificacionesPage;
import com.Parametrizacion.pages.BodegasPage;
import com.Parametrizacion.pages.TiposMercanciasPage;
import com.Parametrizacion.pages.UmedidasPage;
import com.ProgramarVisita.Pages.ProgramarVisitasPage;
import com.Reportes.Pages.GenerarReportePage;
import com.Seguridad.Pages.LogAuditoriaPage;
import com.Seguridad.Pages.PerfilesPage;
import com.Seguridad.Pages.RolesPage;
import com.Seguridad.Pages.UsuariosPage;
import com.Titulo.Pages.AnularTituloPage;
import com.Titulo.Pages.ExpedirPage;
import com.Titulo.Pages.LiberacionPage;
import com.Titulo.Pages.ProrrogarPage;
import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.Pages.HomePage;
import com.demoautomatizacion.Pages.LoginPage;
import com.Cliente.Pages.CupoPage;
import com.Cliente.Pages.GestionPage;
import com.ConsultaRegistroVisita.Pages.CRVisitasPage;

public class BaseTest {

	public WebDriver driver;

	public HomePage home;
	public LoginPage login;
	public BasePage base;
	
	// Módulo Seguridad
	public UsuariosPage usuarios;
	public RolesPage roles;
	public PerfilesPage perfiles;
	public LogAuditoriaPage logAuditoria;
	
	// Módulo Parametrización
	public BodegasPage bodega;
	public UmedidasPage medidas;
	public TiposMercanciasPage tiposMercancia;
	
	// Módulo Cliente
	public GestionPage gestion;
	public CupoPage cupo;
	
	// Módulo Título
	public ExpedirPage expedir;
	public AnularTituloPage anularTitulo;
	public ProrrogarPage prorroga;
	public ImpresionPage Impresion;
	public NotificacionesPage Notificaciones;
	public CRVisitasPage CRVisitas;
	public ProgramarVisitasPage ProgramarVisitas;
	public GenerarReportePage generarReporte;
	public LiberacionPage liberacion;

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeMethod
	public void inicializar() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-notifications");
		// options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		home = new HomePage(driver);
		login = new LoginPage(driver);
		base = new BasePage(driver);
		
		// Módulo Seguridad
		usuarios = new UsuariosPage(driver);
		roles = new RolesPage(driver);
		perfiles = new PerfilesPage(driver);
		logAuditoria = new LogAuditoriaPage(driver);
		
		// Módulo Parametrización
		medidas = new UmedidasPage(driver);
		tiposMercancia = new TiposMercanciasPage(driver);
		bodega = new BodegasPage(driver);
		
		// Módulo Cliente
		gestion = new GestionPage(driver);
		cupo = new CupoPage(driver);
		
		// Módulo Título
		expedir = new ExpedirPage(driver);
		anularTitulo = new AnularTituloPage(driver);
		prorroga = new ProrrogarPage(driver);
		Impresion = new ImpresionPage(driver);
		Notificaciones = new NotificacionesPage(driver);
		CRVisitas = new CRVisitasPage(driver);
		ProgramarVisitas = new ProgramarVisitasPage(driver);
		generarReporte = new GenerarReportePage(driver);
		liberacion= new LiberacionPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
