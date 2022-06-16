package com.demoautomatizacion.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
@Epic("Generar Reporte")
@Feature("Generar Reporte Test")

public class GenerarReporteTest extends BaseTest {

	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {

		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/GenerarReporte.properties").getAbsolutePath()));
		return fileprops;
	}

	public void login(String nameTest, String usuario, String contrasena) throws Exception {

		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderG"),
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

	@Test(priority = 0, description = "Reportes")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Reportes")
	@Story("Opciones reportes")
	public void generarReporte() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderG"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestGenerarReporte"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloG"));
		
		generarReporte.reportes(folderPath, getProperties().getProperty("FechaI"), getProperties().getProperty("FechaF"));

		GenerarReportePdf.closeTemplate("");
	}
}
