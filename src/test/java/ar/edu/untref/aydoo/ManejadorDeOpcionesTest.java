package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ManejadorDeOpcionesTest {
	
	@Test
	public void obtenerOpcionesDesdeArrayDeArgumentosModoDefault() {

		String modeEsperado = "--MODE=DEFAULT";
		String archivoEsperado = "MIPRESENTACION.MD";
		String[] args = {modeEsperado, archivoEsperado};
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);

		String modeObtenido = manejadorDeOpciones.getMode();
		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();

		Assert.assertEquals(modeEsperado, modeObtenido);
		Assert.assertEquals(archivoEsperado, archivoObtenido);

	}
	
	@Test
	public void obtenerOpcionesDesdeArrayDeArgumentosModoDefaultArchivoEnPrimerParametro() {

		String archivoEsperado = "MIPRESENTACION.MD";
		String modeEsperado = "--MODE=DEFAULT";
		String[] args = {archivoEsperado, modeEsperado};
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);

		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();
		String modeObtenido = manejadorDeOpciones.getMode();

		Assert.assertEquals(archivoEsperado, archivoObtenido);
		Assert.assertEquals(modeEsperado, modeObtenido);

	}
	
	@Test
	public void obtenerOpcionesDesdeArrayDeArgumentosModoNoOutput() {

		String modeEsperado = "--MODE=NO-OUTPUT";
		String archivoEsperado = "MIPRESENTACION.MD";

		String[] args = {modeEsperado, archivoEsperado};
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);
		String modeObtenido = manejadorDeOpciones.getMode();
		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();

		Assert.assertEquals(modeEsperado, modeObtenido);
		Assert.assertEquals(archivoEsperado, archivoObtenido);

	}

	@Test
	public void obtenerOpcionesDesdeArrayDeArgumentosModoNoOutputArchivoEnPrimerParametro() {

		String archivoEsperado = "MIPRESENTACION.MD";
		String modeEsperado = "--MODE=NO-OUTPUT";
		String[] args = {archivoEsperado, modeEsperado};
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);
		
		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();
		String modeObtenido = manejadorDeOpciones.getMode();

		Assert.assertEquals(archivoEsperado, archivoObtenido);
		Assert.assertEquals(modeEsperado, modeObtenido);

	}	
	
	@Test
	public void obtenerOpcionesDesdeArrayDeArgumentosConOutput() {

		String archivoEsperado = "MIPRESENTACION.MD";
		String outputEsperado = "--OUTPUT=PRESENTACION1";

		String[] args = {archivoEsperado, outputEsperado};
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);

		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();
		String outputObtenido = manejadorDeOpciones.getOutput();

		Assert.assertEquals(outputEsperado, outputObtenido);
		Assert.assertEquals(archivoEsperado, archivoObtenido);

	}	

	@Test
	public void obtenerOpcionesDesdeArrayDeArgumentosModeDefaultConOutput() {

		String modeEsperado = "--MODE=DEFAULT";
		String archivoEsperado = "MIPRESENTACION.MD";
		String outputEsperado = "--OUTPUT=PRESENTACION1";

		String[] args = {modeEsperado, archivoEsperado, outputEsperado};
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);

		String modeObtenido = manejadorDeOpciones.getMode();
		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();
		String outputObtenido = manejadorDeOpciones.getOutput();

		Assert.assertEquals(modeEsperado, modeObtenido);
		Assert.assertEquals(archivoEsperado, archivoObtenido);
		Assert.assertEquals(outputEsperado, outputObtenido);

	}
	
	@Test(expected = ManejadorDeOpcionesException.class)
	public void combinacionConOutputYModoNoOutputArrojaExcepcion() throws ManejadorDeOpcionesException {

		String mode = "--MODE=NO-OUTPUT";
		String archivo = "MIPRESENTACION.MD";
		String output = "--OUTPUT=PRESENTACION1";

		String[] args = {mode, archivo, output};
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);
		manejadorDeOpciones.validarCombinacionDeOpciones();
		
	}
	
	//TODO 
	/*
	 * Test que verique que el archivo de entrada termine con md para verificar que sea realmente
	 * el archivo de entrada. Crear excepcion para tal caso
	 * Test que verique los caracteres validos, Crear excepcion para el caso.
	 * Terminar de verificar los ordenes combinados
	 * Testear Si me pasan --MODE=algo no valido
	 * Pensar y hacer mas test con otras posibilidades a cubrir.
	 */
	
	

}