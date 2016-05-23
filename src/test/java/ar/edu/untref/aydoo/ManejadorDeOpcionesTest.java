package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ManejadorDeOpcionesTest {

	@Test
	public void obtenerOpcionesDefaultDesdeArrayDeArgumentos() {

		String modeEsperado = "--MODE=DEFAULT";
		String archivoEsperado = "MIPRESENTACION.MD";

		String[] args = { modeEsperado, archivoEsperado };
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);

		String modeObtenido = manejadorDeOpciones.getMode();
		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();

		Assert.assertEquals(modeEsperado, modeObtenido);
		Assert.assertEquals(archivoEsperado, archivoObtenido);

	}

}
