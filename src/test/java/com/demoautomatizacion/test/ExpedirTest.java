
package com.demoautomatizacion.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoautomatizacion.BaseTest;
import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.test.utils.Listeners.TestListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import utilities.GenerarReportePdf;

@Listeners({ TestListener.class })
@Epic("Expedir")
@Feature("Expedir Test")

public class ExpedirTest extends BaseTest {
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Titulo.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Gestion.properties").getAbsolutePath()));
		return fileprops;
	}

	public void login(String nameTest, String usuario, String contrasena) throws Exception {

		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista"),
				getProperties().getProperty("urlPrivada"));

		GenerarReportePdf.setImgContador(0);

		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp(folderPath);
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp(folderPath);
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),
				folderPath);
	}

	@Test(priority = 0, description = "Crear expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("M??dulo Expedir")
	@Story("Creaci??n de expedir")
	public void crearExpedir() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestCrearExpedir"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"));

		expedir.crearExpedir(folderPath, null, null, null, getProperties().getProperty("informacionGeneralE"))

		.bono(folderPath, getProperties().getProperty("bono"), getProperties().getProperty("nitB"), getProperties().getProperty("nitBono"),
		getProperties().getProperty("diasPlazo"))
		
		/*.certificado(folderPath, getProperties().getProperty("certificado"),
				getProperties().getProperty("nitCertificado"), getProperties().getProperty("nitCerti"),
				getProperties().getProperty("tipoEndosoP"))*/
		
		.plazos(folderPath, getProperties().getProperty("plazosE"), getProperties().getProperty("diasPlazo"), getProperties().getProperty("diasPlazo"))
		
		.poliza(folderPath, getProperties().getProperty("polizaE"))
		
		.tipoMercancia(folderPath, getProperties().getProperty("tipoMercanciaE"))
		
		.mercanciasIndividual(folderPath, getProperties().getProperty("mercanciasE"), getProperties().getProperty("cargueI"))
		
		.tarifas(folderPath, getProperties().getProperty("tarifasE"))
		
		.guardarExpedir(folderPath);
		
		GenerarReportePdf.closeTemplate("");
	}
	
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("M??dulo Expedir")
	@Story("Modificaci??n de expedir")
	public void modificarExpedir() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestModificarExpedir"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));

		expedir.modificarExpedir(folderPath, getProperties().getProperty("tituloEditar"), getProperties().getProperty("polizaE"), getProperties().getProperty("tipoMercanciaE"));
		
		GenerarReportePdf.closeTemplate("");
	}
	
	
	@Test(priority = 1, description = "Validacion")
	@Severity(SeverityLevel.NORMAL)
	@Description("M??dulo Expedir")
	@Story("Modificaci??n de expedir")
	public void CargueBodega() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("CargueBodegaPropio"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloC"), getProperties().getProperty("SubmoduloC"));
		
		
		expedir.BodegaCargue(folderPath, getProperties().getProperty("NitClienteAsociado"),getProperties().getProperty("Mercancias"));
		
		
		

		
		GenerarReportePdf.closeTemplate("");
		
	}
	
	
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("M??dulo Expedir")
	@Story("Modificaci??n de expedir")
	public void CargueValidacion() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));
		

		expedir.ValidacionExpedicion(folderPath, getProperties().getProperty("NitClienteAsociado"),getProperties().getProperty("TipoDato"),getProperties().getProperty("InformacionGeneral"), getProperties().getProperty("DetalleMercancia"), getProperties().getProperty("Plazo"), getProperties().getProperty("Poliza"), getProperties().getProperty("TipodeMercancia"), getProperties().getProperty("Mercancias"),getProperties().getProperty("Route"),getProperties().getProperty("RouteA"),getProperties().getProperty("RouteB"));
		
		GenerarReportePdf.closeTemplate("");
		
	}

	
	
	//VALIDACIONES DE SEGUNDA HISTORIA DE USUARIO SOBRE LIBERACIONES Y EXPEDICIONES
	
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("M??dulo Expedir")
	@Story("Modificaci??n de expedir")
	public void ValidacionCancelado() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));
		
		expedir.ExpedirCancelar(folderPath, getProperties().getProperty("TituloCancelado"), getProperties().getProperty("Mercancias"));
		
		GenerarReportePdf.closeTemplate("");
	}
	
	
	
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("M??dulo Expedir")
	@Story("Modificaci??n de expedir")
	public void ValidacionLiberado() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloLiberacion"));
	
		expedir.ValidacionLiberacion(folderPath, getProperties().getProperty("TituloLiberacion"), getProperties().getProperty("Detalle"));
		
		GenerarReportePdf.closeTemplate("");
	}
	
	
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("M??dulo Expedir")
	@Story("Modificaci??n de expedir")
	public void ValidacionMercanciaLiberada() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloLiberacion"));
		
		expedir.ObjetoPresente(folderPath, getProperties().getProperty("TituloaLiberar"), getProperties().getProperty("Detalle"));
		

		GenerarReportePdf.closeTemplate("");
		
	}
	

	
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("M??dulo Expedir")
	@Story("Modificaci??n de expedir")
	public void ValidacionTituloLiberado() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));

		
		expedir.ValidacionMercanciaLiberada(folderPath, getProperties().getProperty("TituloLiberado"), getProperties().getProperty("Detalle"));
		
		
		GenerarReportePdf.closeTemplate("");
		
	}
	
	
	
	
	
	
	
	@Test(priority = 2, description = "Consultar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("M??dulo Expedir")
	@Story("Consulta de expedir")
	public void busquedaExpedir() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestConsultarExpedir"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));

		expedir.imprimir(folderPath, getProperties().getProperty("tituloBuscar"));
		
		GenerarReportePdf.closeTemplate("");
	}
	
	@Test(priority = 3, description = "Ver expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("M??dulo Expedir")
	@Story("Detalle de expedir")
	public void verExpedir() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestVerExpedir"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));

		expedir.verExpedir(folderPath);

		GenerarReportePdf.closeTemplate("");
	}
}