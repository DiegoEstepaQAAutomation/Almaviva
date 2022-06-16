package com.Titulo.Pages;

import org.openqa.selenium.WebDriver;
import com.Titulo.Maps.ProrrogarMap;
import java.io.File;
import io.qameta.allure.Step;

public class ProrrogarPage extends ProrrogarMap {

	Object[] x;
	boolean val;
	int t = 15;

	public ProrrogarPage(WebDriver driver) {
		super(driver);
	}

	@Step("proceso de prorroga")
	public ProrrogarPage prorrogas(File folderPath) throws Exception {

		scrollElementV(folderPath, NumberProrroga, "Se desplaza hacia el localizador codigo");
		String codigo = readText(NumberProrroga, folderPath, "Escritura");

		click(lblProrrogar, folderPath, "");
		writeText(txtCodigoTitulo, codigo, folderPath, "Se Escribe el titulo que se va a consultar en prorroga");
		click(lblBusquedaProrroga, folderPath, "Seleccion de numero prorroga");
		click(lblInformacionBasicaTitulo, folderPath, "Se da click en informacion basica de titulo");
		desplazarseVertical(0, 160);

		isEnabled(lblNit, folderPath, "Campo Nit No editable");
		isEnabled(lblRazonSocial, folderPath, "Campo Nit No editable");
		isEnabled(lblDireccion, folderPath, "Campo Nit No editable");
		isEnabled(lblCiudad, folderPath, "Campo Nit No editable");
		isEnabled(lblFechaExpedicion, folderPath, "Campo Nit No editable");
		isEnabled(lblOficinaExpedicion, folderPath, "Campo Nit No editable");
		isEnabled(lblTipoBodega, folderPath, "Campo Nit No editable");

		click(lblInformacionBasicaTitulo, folderPath, "Se da click en informacion basica de titulo");
		click(OptionDetalleMercancia, folderPath, "Se da click en informacion basica de titulo");
		desplazarseVertical(0, 140);

		isEnabled(lblValorInicial, folderPath, "Campo Nit No editable");
		isEnabled(lblMercanciaInicial, folderPath, "Campo Nit No editable");
		isEnabled(lblValorMercanciaTitulo, folderPath, "Campo Nit No editable");
		isEnabled(lblSaldo, folderPath, "Campo Nit No editable");
		isEnabled(lblrelacionCredito, folderPath, "Campo Nit No editable");
		isEnabled(lblSaldoCredito, folderPath, "Campo Nit No editable");
		isEnabled(lblSaldoTitulo, folderPath, "Campo Nit No editable");
		isEnabled(lblLiberacionesEjecutadas, folderPath, "Campo Nit No editable");

		click(OptionDetalleMercancia, folderPath, "Se da click en informacion basica de titulo");
		click(CertificadoDepositoMercancia, folderPath, "Se da click en certificado deposito mercancia");
		writeRandomNum(txtplazoDeposito, 2);
		isEnabled(lblPlazoDeposito, folderPath, "Campo Nit No editable");
		writeRandomNum(txtplazoCertificado, 2);
		isEnabled(lblNuevaFecha, folderPath, "Campo Nit No editable");

		scrollElementV(folderPath, btnGuardarProrroga, "Se desplaza hasta el boton guardar ");
		click(btnGuardarProrroga, folderPath, "Se da click en guardar prorroga");
		click(btnCancelarProrroga, folderPath, "Click en cancelar");
		return this;
	}
}