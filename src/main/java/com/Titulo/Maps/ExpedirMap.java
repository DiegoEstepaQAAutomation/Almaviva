package com.Titulo.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class ExpedirMap extends BasePage {

	public ExpedirMap(WebDriver driver) {
		super(driver);
	}

	// CREAR
	protected By lblTitulo = By.xpath("//*[@id='sidebar']/ul/li/div/a[contains(text(),'Título')]");
	protected By lblExpedir = By.xpath("//*[@id='sidebar']/ul/li/div/ul/li/div/a[contains(text(),'Expedir')]");
	protected By btnCrearExpedir = By.xpath("//*[@id='contenido']/main-titulos/titulos-home/div/div/div/a");
	protected By txtNitRazonSocial = By.id("termino");
	protected By seleccionarNitRazon = By.xpath("//body/app-root/div/div/div/main-titulos/app-titulo/div/busqueda-cliente/form/div/ngb-typeahead-window/button[1]/ngb-highlight");
	
	protected By lblOpciones = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div/div/accordion/accordion-group/div/div/div/div/button[contains(text(),'{0}')]");
	protected By lblOpciones2 = By.xpath("//button[(text()='{0}')]");
	
	protected By btnGuardarExpedir = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div/div/button[contains(text(),'Guardar')]");
	// Opciones de cliente - gestión
	protected By txtNitCliente = By.id("termino");
	protected By btnBuscarCliente = By.xpath("//*[@id='contenido']/app-main/clientes-home/div/form/button[(text() = ' Buscar ')]");
	protected By btnVerCliente = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/div[2]/a");
	protected By lblTipoBodegaCliente = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group/div/div/div/div/button[contains(text(),'Tipo de Bodega')]");
	
	// Información General del Título
	protected By lblOficinaResponsable = By.id("oficinaResponsableSelect");
	protected By lblTipoBodega = By.id("tipoBodega");
	protected By lblBodega = By.id("bodegaSelect");
	protected By lblBodegaOpcion = By.xpath("//*[@id='bodegaSelect']/option[2]");
	protected By lblTipoTitulo = By.id("tipoTituloSelect");
	protected By lblTipoTituloCertificado = By.xpath("//*[@id='tipoTituloSelect']/option[2]");
	protected By lblTipoTituloBono = By.xpath("//*[@id='tipoTituloSelect']/option[3]");
	protected By cbxMercanciaTransito = By.id("mercanciaTransito");
	protected By cbxBodegasAuxiliares = By.id("masBodegas");
	
	// Detalle de la mercancia
	
	// Endoso del Certificado de Depósito - Bono de Prenda
	protected By btnCrearBono = By.xpath("//*[@id='contenido']//accordion-group[3]/div/div/div/div/div/a");
	protected By btnCrearCertificado = By.xpath("//*[@id='contenido']//accordion/accordion-group[4]/div/div/div/div/div/a");
	protected By lblNitNombreCertificado = By.id("tipo");
	protected By txtNitNombre = By.xpath("//body/modal-container/div/div/app-depositomencancia/div/app-fitro-acreedor/div/div/div/form/div[2]/input");
	protected By seleccionarNitNombre = By.xpath("//body/modal-container/div/div/app-depositomencancia/div/app-fitro-acreedor/div/div/div/form/div/ngb-typeahead-window/button");
	protected By lblTipoEndoso = By.id("tipointeres");
	protected By txtFechaEndoso = By.id("fendoso");
	protected By btnGuardarEndoso = By.xpath("//modal-container/div/div/app-depositomencancia/div/form/div/button[contains(text(),'Guardar')]");
	
	protected By txtNitNombreBono = By.xpath("//body/modal-container/div/div/app-bonoprenda/div/app-fitro-acreedor/div/div/div/form/div[2]/input");
	protected By seleccionarNitNombreBono = By.xpath("//body/modal-container/div/div/app-bonoprenda/div/app-fitro-acreedor/div/div/div/form/div/ngb-typeahead-window/button/ngb-highlight");
	protected By txtCapitalInicial = By.id("capital");
	protected By txtDiasPlazo = By.id("diasplazo");
	protected By txtTipoInteres = By.id("tipointeres");
	protected By txtValorInteres = By.id("valorinteres");
	protected By txtFrecuencia = By.id("frecuencia");
	protected By btnGuardarBono = By.xpath("//modal-container/div/div/app-bonoprenda/div/form/div/button[contains(text(),'Guardar')]");
	protected By btnAceptarBono = By.xpath("//div/div/div/button[contains(text(),'Aceptar')]");
	
	// Plazos
	protected By txtPlazoCertificado = By.id("plazoCertificadoDeposito");
	protected By txtPlazoContatro = By.id("plazoContratoDeposito");
	
	// Póliza
	protected By lblPoliza = By.id("polizaSelect");
	
	// Tipo de mercancía
	protected By lblTipoMercancia = By.id("tipoMercancia");
	protected By txtDescripcionGeneral = By.id("timeDescripcion");
	protected By txtMerma = By.id("merma");
	protected By lblAplicaCondicion = By.id("aplicaCondicionCalidad");
	protected By txtObservaciones = By.id("observaciones");
	
	// Mercancías
	protected By lblTipoCargue = By.id("tipoCargue");
	protected By btnCrearCargueIndividual = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div/div/accordion/accordion-group[8]/div/div/div/div/div/a");
	protected By txtDetalleMercancia = By.id("detalleMercancia");
	protected By lblUnidadMedida = By.id("unidadMedida");
	protected By lblUnidadMedidaSuper = By.id("unidadMedidaSuper");
	protected By txtValorConversion = By.name("valorConversion");
	protected By txtCantidad = By.id("cantidad");
	protected By txtValorUnitario = By.id("valorUnitario");
	protected By txtFechaVencimientoMercancia = By.xpath("//div/div/mercancia-titulos/div/form/div/div[8]/input");
	protected By txtObservacionMercancia = By.xpath("//div/div/mercancia-titulos/div/form/div/div[9]/input");
	protected By btnGuardarMercancia = By.xpath("//modal-container/div/div/mercancia-titulos/div/form/div/div/button[contains(text(),'Guardar')]");
	protected By btnAceptarMercancias = By.xpath("//div/div/div/button[contains(text(),'Aceptar')]");
	
	// Tarifas
	protected By txtTarifa = By.id("tarifa");
	protected By txtMinima = By.id("minima");
	
	// Buscar
	protected By txtBuscarTitulo = By.id("termino");
	protected By btnBuscarTitulo = By.xpath("//*[@id='contenido']/main-titulos/titulos-home/div/form/button[contains(text(),'Buscar')]");
	protected By btnImprimir = By.xpath("//*[@id='tbClientes']/tbody/tr/td[9]/div/a[3]");
	protected By lblImprimirOriginal = By.xpath("//modal-container/div/div/app-impresion-titulo/div/div/h5[contains(text(),'Imprimir Original')]");

	// Modificar
	protected By btnModificar = By.xpath("//*[@id='tbClientes']/tbody/tr/td[9]/div/a[1]");
	protected By btnAceptarGuardarModificar = By.xpath("//div/div/div/button[contains(text(),'Aceptar')]");
	protected By lblGudadoExitoso = By.xpath("//div[@id='toast-container']/div/div[contains(text(),'El registro se ha guardado con estado')]");

	// Ver
	protected By btnVerExpedir = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td/div/a[2]");
	protected By txtNit = By.id("nit");
	protected By txtNombreRazon = By.id("razonSocial");
	protected By txtDireccion = By.id("direccionTitulo");
	protected By txtCiudad = By.id("ciudad");
	protected By txtTelefono = By.id("telefono");
	protected By txtCorreo = By.id("correo");
	
	protected By txtBuscar = By.xpath("//*[@id='termino']");
	
	
	
	//ClienteCargueMasivo
	protected By btnModificarCliente = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/div[1]/a");
	protected By txtConsultarNit = By.xpath("//input[contains(@formcontrolname,'termino')]");
	protected By btnBuscar = By.xpath("//*[@id='contenido']/app-main/clientes-home/div/form/button[(text() = ' Buscar ')]");
	protected By btnTipoBodega = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[4]/div/div[1]/div/div/button");
	protected By lblTobacco = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[4]/div/div[2]/div/div[2]/div[2]/table/tbody/tr[12]/td[1]");
	protected By btnTitulo = By.xpath("//*[@id='sidebar']/ul/li[4]/div/a");
	protected By btnExpedir = By.xpath("//body/app-root/div/app-sidebar/nav/ul/li[4]/div/ul/li[1]/div/a");
	protected By txtNitCargue = By.xpath("//*[@id='termino']");
	protected By lblTipoDeDato = By.xpath("//*[@id='criterio']");
	protected By lblRegistro = By.xpath("//*[@id='tbClientes']/tbody/tr[10]/td[1]");
	protected By ModificarRegistro = By.xpath("//*[@id='tbClientes']/tbody/tr[9]/td[9]/div/a[1]");
	
	//*[@id="tbClientes"]/tbody/tr[9]/td[9]/div/a[1]
	
	
	protected By btnCancelar = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[2]/div/button[2]");
	
	
	protected By BuscarTitulo = By.xpath("//body/app-root/div/div/div/main-titulos/titulos-home/div/form/div[2]/input");
	protected By ModificartituloLiberado = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/a[1]");
	protected By VisualizarTitulo = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/a[1]");
	
	
	
	protected By ModificarCancelado = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/a[1]");
	protected By btnCantidadInicial = By.xpath("//*[@id='tbMercancia']/thead/tr/th[3]");
	
	protected By ModificarAplicado = By.xpath("//*[@id='tbClientes']/tbody/tr[2]/td[9]/div/a[1]");
	protected By ModificarAnulado = By.xpath("//*[@id='tbClientes']/tbody/tr[8]/td[9]/div/a[1]");
	protected By btnCancelarEstado = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[2]/div/button");
	protected By txtBuscaTitulo = By.xpath("//*[@id='titulo']");
	protected By txtBusquedaTermino = By.xpath("//*[@id='termino']");
	protected By btnDescargar = By.xpath("//body/app-root/div/div/div/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[3]/div/div[2]/button");
	
	//*[@id="contenido"]/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[3]/div/div[2]/button
	
	protected By btnCargue = By.xpath("//input[contains(@id,'fileCsv')]");
	protected By btnObservarTitulo = By.xpath("//*[@id='tbMercancia']/tbody/tr/td[10]/a");
	protected By btnCancelarvista = By.xpath("//body/modal-container/div/div/app-consulta-liberacion-mercancia/div/div[2]/div[2]/button");
	protected By CheckBox= By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[1]/table/tbody/tr[2]/td[9]/input");
	
	//input[contains(@name,'fileCsv')
	
	protected By btnupload = By.xpath("//*[@id='fileCsv']");
	protected By Cargue = By.id("//*[@id='fileCsv']");
	protected By lblCodigoLiberacion = By.xpath("//app-filtrotitulo/form/div/div/ngb-typeahead-window/button");
	protected By btnBusquedaTitulo = By.xpath("//button[(text()=' Buscar ')]");
	protected By lblCamposDetalleMercancia = By.xpath("//th[(text()='{0}')]");
	
	
	protected By btnDone = By.xpath("//button[(text()=' Ok ')]");
	
	protected By cbxAccion = By.id("flexCheckChecked");
	
	//protected By Cargue = By.xpath("//input[contains(@name,'fileCsv')]");
	
	
}