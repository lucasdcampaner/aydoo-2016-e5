package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ManejadorDeOpcionesTest {

	/**
	 * Casos para ir testeando:
	 */
	//java -jar slider.jar --output=presentacion1 mipresentacion.md --mode=default
	//java -jar slider.jar --output=presentacion1 mipresentacion.md
	//NO VALIDO, hacer excepciones
	//java -jar slider.jar --output=presentacion1 mipresentacion.md  --mode=no-output
	
	@Test
	public void obtenerOpcionesDefaultDesdeArrayDeArgumentos() {

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
	public void obtenerOpcionesNoOutputDesdeArrayDeArgumentos() {

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
	public void obtenerOpcionesOutputDesdeArrayDeArgumentos() {

		String modeEsperado = "--OUTPUT=PRESENTACION1";
		String archivoEsperado = "MIPRESENTACION.MD";

		String[] args = {modeEsperado, archivoEsperado};
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);

		String modeObtenido = manejadorDeOpciones.getMode();
		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();

		Assert.assertEquals(modeEsperado, modeObtenido);
		Assert.assertEquals(archivoEsperado, archivoObtenido);

	}	

}
