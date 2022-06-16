package com.Reportes.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.Reportes.Maps.GenerarReporteMap;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.qameta.allure.Step;
import utilities.GenerarReportePdf;

public class GenerarReportePage extends GenerarReporteMap {

	Object[] x;
	boolean val;
	int t = 15;

	public GenerarReportePage(WebDriver driver) {
		super(driver);
	}

	@Step("Reportes")
	public GenerarReportePage reportes(File folderPath, String fechaI, String fechaF) throws Exception {

		String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
		fechaI = timeStamp;
		fechaF = timeStamp;

		listRandom(lblTipoReporte, folderPath, "Se toma un Reporte aleatorio");
		writeText(lblFechaInicio, fechaI, folderPath, "Se ingresa fecha inicial");
		writeText(lblFechaFin, fechaF, folderPath, "Se ingresa fecha final");

		val = validarElemento(btnDescargar, t);

		if (Boolean.TRUE.equals(val)) {
			time(1);
			click(btnDescargar, folderPath, "Se da click sobre descargar");

			val = validarElemento(reporteExitoso, t);

			if (Boolean.TRUE.equals(val)) {
			} else {
				GenerarReportePdf.closeTemplate("Descarga fallida");
				Assert.fail("Error en la validación, no se encontro el elemento");
			}
		} else {
			GenerarReportePdf.closeTemplate("Error en la validación, descarga fallida");
			Assert.fail("Error en la validación, descarga fallida");
		}
		return this;
	}
}