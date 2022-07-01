package com.Titulo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.Titulo.Maps.ExpedirMap;
import java.io.File;
import io.qameta.allure.Step;
import utilities.GenerarReportePdf;

public class ExpedirPage extends ExpedirMap {

	Object[] x;
	boolean val;
	int t = 15;
	
	
	String ValidacionCargue = "542369, 542370, 542371";
	String ValidacionTitulos = "543825";
	String ValidarLiberacion = "543826, 543828, 543832, 543826";
	String ValidarMercanciaLiberada = "543829, 543830";
	String ObjetoPresente = "543831";

	public ExpedirPage(WebDriver driver) {
		super(driver);
	}

	@Step("Crear expedir")
	public ExpedirPage crearExpedir(File folderPath, String n, String t, String o, String informacionG)
			throws Exception {

		String tb = null;

		n = driver.findElement(By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[1]")).getText();

		writeText(txtNitCliente, n);
		click(btnBuscarCliente);
		scrollElementH(btnVerCliente);
		click(btnVerCliente);
		click(lblTipoBodegaCliente);

		t = driver.findElement(By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[4]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]")).getText();
		o = driver.findElement(By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[4]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[5]")).getText();

		if (t.equals("Propia")) {
			tb = "Propia";
		} else if (t.equals("Particular")) {
			tb = "Particular";
		} else if (t.equals("ParticularArrendada")) {
			tb = "Particular Arrendada";
		} else if (t.equals("Transito")) {
			tb = "Tránsito";

			click(lblTitulo);
			click(lblExpedir);

			etiquetas(btnCrearExpedir, folderPath, "Etiqueta Crear expedir");
			click(btnCrearExpedir, folderPath, "Se ingresa a crear expedir");
			writeText(txtNitRazonSocial, n, folderPath, "Se ingresa el dato Nit");
			click(seleccionarNitRazon);
			waitInMs(2000);
			click(locatorVariable(lblOpciones, informacionG), folderPath, "Click en elemento");
			scrollDown();
			waitInMs(500);
			selectElementList(lblOficinaResponsable, o);
			selectElementList(lblTipoBodega, tb);
			click(lblBodega);
			click(lblBodegaOpcion, folderPath, "click en opcion");

		} else {
			printConsole("Error");
			Assert.fail("Error");
		}
		return this;
	}

	@Step("Bono de Prenda")
	public ExpedirPage bono(File folderPath, String bono, String nitB, String nitBono, String diasPlazo)
			throws Exception {

		click(lblTipoTitulo);
		click(lblTipoTituloBono, folderPath, "Click en tipo titulo de bono");
		click(locatorVariable(lblOpciones, bono), folderPath, "Click en opciones titulo");
		click(btnCrearBono, folderPath, "Click en crear bono");
		selectElementList(lblNitNombreCertificado, nitB);
		writeText(txtNitNombreBono, nitBono, folderPath, "Se escribe Nit");
		click(seleccionarNitNombreBono);
		writeRandomNum(txtCapitalInicial, 4);
		writeText(txtDiasPlazo, diasPlazo, folderPath, "Se escribe Dias de plazo");
		writeRandomAlp(txtTipoInteres, 35);
		writeRandomNum(txtValorInteres, 10);
		writeRandomAlp(txtFrecuencia, 20);
		click(btnGuardarBono, folderPath, "Click en guardar bono");
		click(btnAceptarBono, folderPath, "Click en aceptar bono");
		waitInMs(500);
		click(locatorVariable(lblOpciones, bono), folderPath, "");
		return this;
	}

	@Step("Certificado de Depósito de Mercancía")
	public ExpedirPage certificado(File folderPath, String certificado, String nitCertificado, String nitC,
			String tipoEndoso) throws Exception {

		// Long day = Long.valueOf(new
		// SimpleDateFormat("dd").format(Calendar.getInstance().getTime()));

		click(locatorVariable(lblOpciones, certificado), folderPath, "Click en opciones titulo");
		click(btnCrearCertificado, folderPath, "Click en crear bono");
		selectElementList(lblNitNombreCertificado, nitCertificado);
		writeText(txtNitNombre, nitC, folderPath, "Se escribe Nit");
		click(seleccionarNitNombre);
		selectElementList(lblTipoEndoso, tipoEndoso);
		// FALTA FECHA
		// click(txtFechaEndoso);

		//click(btnGuardarEndoso, folderPath, "");
		waitInMs(20000);
		// click(locatorVariable(lblOpciones, certificado), folderPath, "");
		return this;
	}

	@Step("Plazos")
	public ExpedirPage plazos(File folderPath, String plazos, String pCertificado, String pContrato) throws Exception {

		click(locatorVariable(lblOpciones, plazos), folderPath, "Click en opciones titulo");
		writeText(txtPlazoCertificado, pCertificado, folderPath, "Se escribe plazo certificado");
		writeText(txtPlazoContatro, pContrato, folderPath, "Se escribe plazo contrato");
		click(locatorVariable(lblOpciones, plazos), folderPath, "Click en opciones titulo");
		return this;
	}

	@Step("Póliza")
	public ExpedirPage poliza(File folderPath, String poliza) throws Exception {

		click(locatorVariable(lblOpciones, poliza), folderPath, "Click en menu opciones poliza");
		listRandom(lblPoliza, folderPath, "Se selecciona valor random");
		click(locatorVariable(lblOpciones, poliza), folderPath, "Click en menu opciones poliza");
		return this;
	}

	@Step("Tipo de Mercancía")
	public ExpedirPage tipoMercancia(File folderPath, String tipoMercancia) throws Exception {

		click(locatorVariable(lblOpciones, tipoMercancia), folderPath, "Click en menu opciones tipos de mercancia");
		listRandom(lblTipoMercancia, folderPath, "Se selecciona valor random");
		writeRandomAlp(txtDescripcionGeneral, 40);
		writeRandomNum(txtMerma, 4);
		listRandom(lblAplicaCondicion, folderPath, "Se selecciona valor random");
		writeRandomAlp(txtObservaciones, 10);
		scrollUp();
		click(locatorVariable(lblOpciones, tipoMercancia), folderPath, "Click en opciones tipo mercancia");
		return this;
	}

	@Step("Mercancías 'Individual'")
	public ExpedirPage mercanciasIndividual(File folderPath, String mercancias, String cargueI) throws Exception {

		click(locatorVariable(lblOpciones, mercancias), folderPath, "Click en opciones tipo mercancias");
		selectElementList(lblTipoCargue, cargueI, folderPath, "Se selecciona valor de lista");
		click(btnCrearCargueIndividual, folderPath, "Click en crear mercancia");
		writeRandomAlp(txtDetalleMercancia, 40);
		listRandom(lblUnidadMedida, folderPath, "Se selecciona valor random de la lista");
		listRandom(lblUnidadMedidaSuper, folderPath, "Se selecciona valor random de la lista");
		writeRandomNum(txtValorConversion, 2);
		writeRandomNum(txtCantidad, 18);
		writeRandomNum(txtValorUnitario, 28);
		writeText(txtFechaVencimientoMercancia, datePlusYear(3));
		writeRandomAlp(txtObservacionMercancia, 100);
		click(btnGuardarMercancia, folderPath, "Click en guardar mercancia");
		click(btnAceptarMercancias, folderPath, "Click en aceptar mercancia");
		click(locatorVariable(lblOpciones, mercancias), folderPath, "Se selecciona valor de opciones");
		return this;
	}

	@Step("Tarifas")
	public ExpedirPage tarifas(File folderPath, String tarifas) throws Exception {

		click(locatorVariable(lblOpciones, tarifas), folderPath, "Click en opciones tarifas");
		writeRandomNum(txtTarifa, 15);
		writeRandomNum(txtMinima, 50);
		click(locatorVariable(lblOpciones, tarifas), folderPath, "Click en opciones tarifas");
		return this;
	}

	@Step("Guardar expedir")
	public ExpedirPage guardarExpedir(File folderPath) throws Exception {

		click(btnGuardarExpedir, folderPath, "Click en Guardar y expedir");
		return this;
	}

	@Step("Imprimir")
	public ExpedirPage imprimir(File folderPath, String titulo) throws Exception {

		writeText(txtBuscarTitulo, titulo);
		click(btnBuscarTitulo, folderPath, "Click en buscar titulo");
		scrollElementH(btnImprimir);
		etiquetas(btnImprimir, folderPath, "Se evidencia etiqueta imprimir");
		click(btnImprimir, folderPath, "Click en buscar imprimir");
		
		val = validarElemento(lblImprimirOriginal, t);

	    if (Boolean.FALSE.equals(val)) {
	    	GenerarReportePdf.closeTemplate("Error en la validación: No se encontró el mensaje del elemento " + lblImprimirOriginal);
	        Assert.fail("Error en la validación: No se encontró el mensaje del elemento " + lblImprimirOriginal);
	    }
		escape();
		return this;
	}
	
	@Step("Modificar expedir")
	public ExpedirPage modificarExpedir(File folderPath, String titulo, String poliza, String tipoMercancia) throws Exception {
		
		writeText(txtBuscarTitulo, titulo);
		click(btnBuscarTitulo, folderPath, "Click en buscar titulo");
		scrollElementH(btnImprimir);
		etiquetas(btnModificar, folderPath, "Se evidencia etiqueta modificar expedicion");
		click(btnModificar, folderPath, "Click en modificar");

		click(locatorVariable(lblOpciones, poliza), folderPath, "Click en opciones poliza");
		listRandom(lblPoliza, folderPath, "Se selecciona un objeto random");
		click(locatorVariable(lblOpciones, poliza), folderPath, "Click en opciones poliza");
		
		click(locatorVariable(lblOpciones, tipoMercancia), folderPath, "Click en opciones tipo mercancia");
		listRandom(lblTipoMercancia, folderPath, "Se selecciona elemento random de la lista");
		click(locatorVariable(lblOpciones, tipoMercancia), folderPath, "Click en opciones tipo mercancia");
		click(btnGuardarExpedir, folderPath, "Click en Guardar y expedir");
		click(btnAceptarGuardarModificar, folderPath, "Click en Guardar y modificar");
		
		val = validarElemento(lblGudadoExitoso, t);

	    if (Boolean.FALSE.equals(val)) {
	    	GenerarReportePdf.closeTemplate("Error en la validación: No se encontró el mensaje del elemento " + lblGudadoExitoso);
	        Assert.fail("Error en la validación: No se encontró el mensaje del elemento " + lblGudadoExitoso);
	    }
		return this;
	}
	
	@Step("Ver expedir")
	public ExpedirPage verExpedir(File folderPath) throws Exception {

		scrollElementH(folderPath, btnVerExpedir, "Se desplaza hasta la opción Ver expedir");
		etiquetas(btnVerExpedir, folderPath, "Etiqueta Ver expedir");
		click(btnVerExpedir, folderPath, "Se ingresa a ver expedir");

		isEnabled(txtNit, folderPath, "Campo Nit No editable");
		isEnabled(txtNombreRazon, folderPath, "Campo Nombre/Razón social No editable");
		isEnabled(txtDireccion, folderPath, "Campo Dirección No editable");
		isEnabled(txtCiudad, folderPath, "Campo Ciudad No editable");
		isEnabled(txtTelefono, folderPath, "Campo Teléfono No editable");
		isEnabled(txtCorreo, folderPath, "Campo Correo No editable");
		return this;
	}
	
	
	//VALIDACIONES DE SEGUNDA HISTORIA DE USUARIO SOBRE TITULOS Y LIBERACIONES
	
	
	@Step("Ver expedir")
	public ExpedirPage ExpedirCancelar(File folderPath,String TituloCancelado,String Mercancias) throws Exception 
	{
		
		writeText(txtBuscar, TituloCancelado,folderPath, "Se escribe Id de titulo ");
		click(btnBusquedaTitulo, folderPath, "click busqueda titulo");
		scrollElementH(folderPath, ModificarCancelado, "Se desplaza hasta el elemento deseado");
		click(ModificarCancelado, folderPath, "click sobre modificar elemento");
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		scrollElementV(folderPath, btnCantidadInicial, "Se desplaza hasta el elemento");
		
		screenshot(folderPath ,"Estos son los casos: " + ValidacionTitulos);
		return this;
	}

	
	@Step("Ver expedir")
	public ExpedirPage ValidacionLiberacion(File folderPath,String TituloLiberacion,String Detalle) throws Exception 
	{
		

		
		
		
		
		writeText(txtBuscaTitulo, TituloLiberacion, folderPath, "Se digita el titulo a buscar");
		click(lblCodigoLiberacion, folderPath, "");
		click(locatorVariable(lblOpciones2, " Detalle de mercancía "), folderPath, "Click en detalle  Mercancias");
		
		scrollElementV(folderPath, locatorVariable(lblCamposDetalleMercancia, "Cant. Inicial"), "Se desplaza hasta el campo detalle de mercancia");
		
		
		
		
		scrollElementV(folderPath, locatorVariable(lblCamposDetalleMercancia, "Valor Total"), "Click en opciones titulo");
		
		scrollElementV(folderPath, locatorVariable(lblCamposDetalleMercancia, "Acción"), "Click en opciones titulo");
		
		screenshot(folderPath ,"Estos son los casos: " + ValidarLiberacion);
		
		return this;
		
	}
	
	@Step("Ver expedir")
	public ExpedirPage ValidacionMercanciaLiberada(File folderPath,String TituloLiberado,String Detalle) throws Exception 
	{ 
		
		//writeText(BuscarTitulo, TituloLiberado, folderPath, "Se digita el titulo a buscar");
		
		writeText(BuscarTitulo, TituloLiberado);
		
		scrollElementH(folderPath, ModificartituloLiberado, "Se desplaza hasta la opción modificar ");

        click(ModificartituloLiberado, folderPath, "Se da click sobre modificar ");
        
        scrollElementV(folderPath, locatorVariable(lblOpciones2, " Mercancías "), "Se desplaza hacia la opcion mercancias");
        
        click(locatorVariable(lblOpciones2, " Mercancías "), folderPath, "Click en Mercancias");
		
        
        scrollElementV(folderPath, btnCancelar, "Se desplaza hasta la opcion cancelar");
        
        
        //desplazarseVertical(0, 400);
		
		click(btnCancelar, folderPath, "Click en cancelar");
		
		writeText(BuscarTitulo, TituloLiberado);
		
		scrollElementH(folderPath, VisualizarTitulo, "Se desplaza hasta la opción Ver cupo");
		
		click(VisualizarTitulo, folderPath, "Se ingresa a ver Cupo");
		
		scrollElementV(folderPath, locatorVariable(lblOpciones2, " Mercancías "), "Se desplaza hacia la opcion mercancias");
	        
	    click(locatorVariable(lblOpciones2, " Mercancías "), folderPath, "Click en Mercancias");
	    scrollElementV(folderPath, btnCancelar, "click en la opcion cancelar");
	    
	    //desplazarseVertical(0, 400);
			
	    click(btnCancelar, folderPath, "Click en cancelar");
	
		screenshot(folderPath ,"Estos son los casos: " + ValidarMercanciaLiberada);
		
		
		
		return this;
		
		
	}
	
	
	@Step("Ver expedir")
	public ExpedirPage ObjetoPresente(File folderPath,String TituloaLiberar,String Detalle) throws Exception 
	{ 
		
		
		writeText(txtBuscaTitulo, TituloaLiberar, folderPath, Detalle);
		click(lblCodigoLiberacion, folderPath, Detalle);
		click(locatorVariable(lblOpciones2, " Detalle de mercancía "), folderPath, "Click en Mercancias");
		
		scrollElementV(folderPath, btnDone, "Se desplaza hasta el boton ok");
		scrollElementH(folderPath, cbxAccion, "Se desplaza hasta el checkbox de accion");
		click(cbxAccion, folderPath, "Se da click sobre el checkbox de accion");
		
		/*click(btnDone, folderPath, Detalle);
		
		desplazarseVertical(600, 0);
		
		writeText(txtBuscaTitulo, TituloaLiberar, folderPath, Detalle);
		
		click(lblCodigoLiberacion, folderPath, Detalle);
		
		scrollElementV(folderPath, btnDone, Detalle);*/
		
		screenshot(folderPath ,"Estos son los casos: " + ObjetoPresente);
		
		return this;
		
	}
	
	@Step("Ver expedir")
	public ExpedirPage ValidacionExpedirLiberacion(File folderPath,String TituloLiberado,String Detalle,String Mercancias) throws Exception 
	{ 
		
		writeText(txtBuscaTitulo, TituloLiberado, folderPath, "Se digita el titulo a buscar");
		scrollElementH(folderPath, ModificartituloLiberado, "Se desplaza al elemento");
		click(ModificartituloLiberado, folderPath, "click en modificar articulo");
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		scrollElementV(folderPath, btnObservarTitulo, "Se desplaza hasta la opcion observar titulo");
		click(btnObservarTitulo, folderPath, "click en observar titulo");
		click(btnCancelarvista, folderPath, "click en cancelar vista");
		
		
		
		
		
		return this;
		
		
	}
	
	
	
	
	
	
	
	
	@Step("Ver Bodega de cargue")
	public ExpedirPage BodegaCargue(File folderPath,String NitClienteAsociado,String Mercancias) throws Exception {
		

		
		
		scrollElementH(folderPath, btnModificarCliente, "Se desplaza hasta el boton modificar cliente");
		click(ModificarCancelado, folderPath, NitClienteAsociado);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		desplazarseVertical(0,400);
		click(btnCancelarEstado, folderPath, Mercancias);
		scrollElementH(folderPath, ModificarAplicado, "Se desplaza hasta el boton modificar cliente");
		click(ModificarAplicado, folderPath, Mercancias);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		desplazarseVertical(0,400);
		click(btnCancelarEstado, folderPath, Mercancias);
		
		scrollElementH(folderPath, ModificarAnulado, "Se desplaza hasta el boton modificar cliente");
		scrollElementV(folderPath, ModificarAnulado, "Se desplaza hasta el boton modificar cliente");
		click(ModificarAnulado, folderPath, Mercancias);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		desplazarseVertical(0,400);
		click(btnCancelarEstado, folderPath, Mercancias);
	
		
		
		return this;
	}
	
	@Step("Ver Bodega de cargue")
	public ExpedirPage ValidacionExpedicion(File folderPath,String NitClienteAsociado,String TipoDato,String InformacionGeneral,String DetalleMercancia,String Plazo,String Poliza,String TipodeMercancia,String Mercancias,String Route,String RouteA,String RouteB) throws Exception {
	
		
		
		
		x = new Object[2];
		x[0] = btnDescargar;
		x[1] = btnCargue;
		
		
		
		selectElementList(lblTipoDeDato, TipoDato);
		writeText(txtNitCargue, NitClienteAsociado, folderPath, "Se realiza busqueda de cliente de cargue");
		scrollElementV(folderPath, lblRegistro, "Se dezplaza hacia el ultimo registro");
		scrollElementH(folderPath, ModificarRegistro, "Se dezplaza hacia modificar registro");
		click(ModificarRegistro, folderPath, "Click en modificar registro");
		
		//waitInMs(30);
		
		
		
		
		
		desplazarseVertical(0,300);
		click(locatorVariable(lblOpciones, InformacionGeneral), folderPath, "Click en menu opciones poliza");
		click(locatorVariable(lblOpciones, InformacionGeneral), folderPath, "Click en menu opciones poliza");
		
		click(locatorVariable(lblOpciones, DetalleMercancia), folderPath, "Click en Detalle Mercancia");
		click(locatorVariable(lblOpciones, DetalleMercancia), folderPath, "Click en Detalle Mercancia");
		
		desplazarseVertical(0,250);
		click(locatorVariable(lblOpciones, Plazo), folderPath, "Click en Plazo");
		click(locatorVariable(lblOpciones, Plazo), folderPath, "Click en Plazo");
		
		click(locatorVariable(lblOpciones, Poliza), folderPath, "Click en menu opciones poliza");
		click(locatorVariable(lblOpciones, Poliza), folderPath, "Click en menu opciones poliza");
		
		desplazarseVertical(0,300);
		
		click(locatorVariable(lblOpciones, TipodeMercancia), folderPath, "Click en menu opciones poliza");
		click(locatorVariable(lblOpciones, TipodeMercancia), folderPath, "Click en menu opciones poliza");
		
		desplazarseVertical(0,300);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		
		
		scrollElementV(folderPath, btnDescargar, "Se dezplaza hasta elemento ");
		
			
		click(btnDescargar, folderPath, "");
		
		waitInMs(3);
		
		fileUpFull(btnCargue, Route);
		
		fileUpFull(btnCargue, RouteA);
		
		fileUpFull(btnCargue, RouteB);
		
		scrollElementV(folderPath, CheckBox, "Se dezplaza hasta checkbox");
		
		
		wait(6);
		
		
		screenshot(folderPath ,"Estos son los casos: " + ValidacionCargue);
	
		
		if (Boolean.TRUE.equals(val)) {
			
			
			
			
		} else {
			GenerarReportePdf.closeTemplate("Error en la validación, alguno de los elementos no fueron encontrados");
			Assert.fail("Error en la validación, alguno de los elementos no fueron encontrados");
		}
	
		
		//click(btnCargar,folderPath,"Se da click en cargar");
		
		
		return this;
	}
	
	
}