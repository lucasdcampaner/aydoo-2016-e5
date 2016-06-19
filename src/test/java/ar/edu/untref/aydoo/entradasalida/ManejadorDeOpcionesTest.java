package ar.edu.untref.aydoo.entradasalida;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.entradasalida.ManejadorDeOpciones;
import ar.edu.untref.aydoo.excepciones.CaracteresInvalidosEx;
import ar.edu.untref.aydoo.excepciones.CombinacionParametrosEx;
import ar.edu.untref.aydoo.excepciones.ModoEjecucionEx;

public class ManejadorDeOpcionesTest {

	@Test(expected = CaracteresInvalidosEx.class)
	public void obtenerOpcionesDesdeArrayDeArgumentosConCaracteresInvalidosEnNombreDeArchivoArrojaExcepction()
			throws Exception {

		String mode = "--MODE=default";
		String archivo = "cariño.md";
		String output = "--OUTPUT=PRESENTACION1";

		String[] args = { mode, archivo, output };

		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);
	}

	@Test(expected = CombinacionParametrosEx.class)
	public void modeNoOutputYOutputNoVacioArrojaException() throws Exception {

		String modeEsperado = "--MODE=NO-OUTPUT";
		String archivoEsperado = "MIPRESENTACION.MD";
		String output = "--OUTPUT=carpeta";
		String[] args = { modeEsperado, archivoEsperado, output };
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);
	}

	@Test(expected = ModoEjecucionEx.class)
	public void modeNoValidoArrojaException() throws Exception {

		String modeEsperado = "--MODE=PIRULO";
		String archivoEsperado = "MIPRESENTACION.MD";
		String output = "--OUTPUT=carpeta";
		String[] args = { modeEsperado, archivoEsperado, output };
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);
	}

	@Test(expected = CaracteresInvalidosEx.class)
	public void obtenerOpcionesDesdeArrayDeArgumentosConCaracteresInvalidosEnOutputArrojaExcepction() throws Exception {

		String modeEsperado = "--MODE=DEFAULT";
		String archivoEsperado = "MIPRESENTACION.MD";
		String output = "--OUTPUT=carpetiña";
		String[] args = { modeEsperado, archivoEsperado, output };
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);
		manejadorDeOpciones.getCarpetaSalida();
	}

	@Test
	public void obtenerOpcionesDesdeArrayDeArgumentosModoDefault() throws Exception {

		String modeParametro = "--MODE=DEFAULT";
		String modeEsperado = "DEFAULT";
		String archivoEsperado = "MIPRESENTACION.MD";
		String[] args = { modeParametro, archivoEsperado };
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);

		String modeObtenido = manejadorDeOpciones.getMode();
		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();

		Assert.assertEquals(modeEsperado, modeObtenido);
		Assert.assertEquals(archivoEsperado, archivoObtenido);
	}

	@Test
	public void obtenerOpcionesDesdeArrayDeArgumentosModoDefaultArchivoEnPrimerParametro()
			throws ModoEjecucionEx, CaracteresInvalidosEx, CombinacionParametrosEx {

		String modeParametro = "--MODE=DEFAULT";
		String archivoEsperado = "MIPRESENTACION.MD";
		String modeEsperado = "DEFAULT";
		String[] args = { archivoEsperado, modeParametro };
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);

		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();
		String modeObtenido = manejadorDeOpciones.getMode();

		Assert.assertEquals(archivoEsperado, archivoObtenido);
		Assert.assertEquals(modeEsperado, modeObtenido);

	}

	@Test
	public void obtenerOpcionesDesdeArrayDeArgumentosModoNoOutput()
			throws ModoEjecucionEx, CaracteresInvalidosEx, CombinacionParametrosEx {

		String modeParametro = "--MODE=NO-OUTPUT";
		String modeEsperado = "NO-OUTPUT";
		String archivoEsperado = "MIPRESENTACION.MD";

		String[] args = { modeParametro, archivoEsperado };
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);
		String modeObtenido = manejadorDeOpciones.getMode();
		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();

		Assert.assertEquals(modeEsperado, modeObtenido);
		Assert.assertEquals(archivoEsperado, archivoObtenido);
	}

	@Test
	public void obtenerOpcionesDesdeArrayDeArgumentosModoNoOutputArchivoEnPrimerParametro()
			throws ModoEjecucionEx, CaracteresInvalidosEx, CombinacionParametrosEx {

		String modeParametro = "--MODE=NO-OUTPUT";
		String archivoEsperado = "MIPRESENTACION.MD";
		String modeEsperado = "NO-OUTPUT";
		String[] args = { archivoEsperado, modeParametro };
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);

		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();
		String modeObtenido = manejadorDeOpciones.getMode();

		Assert.assertEquals(archivoEsperado, archivoObtenido);
		Assert.assertEquals(modeEsperado, modeObtenido);

	}

	@Test
	public void obtenerOpcionesDesdeArrayDeArgumentosConOutput()
			throws ModoEjecucionEx, CaracteresInvalidosEx, CombinacionParametrosEx {

		String archivoEsperado = "MIPRESENTACION.MD";
		String outputEsperado = "--OUTPUT=PRESENTACION1";

		String[] args = { archivoEsperado, outputEsperado };
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);

		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();
		String outputObtenido = manejadorDeOpciones.getOutput();

		Assert.assertEquals(outputEsperado, outputObtenido);
		Assert.assertEquals(archivoEsperado, archivoObtenido);
	}

	@Test
	public void obtenerOpcionesDesdeArrayDeArgumentosModeDefaultConOutput()
			throws ModoEjecucionEx, CaracteresInvalidosEx, CombinacionParametrosEx {

		String modeParametro = "--MODE=DEFAULT";
		String modeEsperado = "DEFAULT";
		String archivoEsperado = "MIPRESENTACION.MD";
		String outputEsperado = "--OUTPUT=PRESENTACION1";

		String[] args = { modeParametro, archivoEsperado, outputEsperado };
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);

		String modeObtenido = manejadorDeOpciones.getMode();
		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();
		String outputObtenido = manejadorDeOpciones.getOutput();

		Assert.assertEquals(modeEsperado, modeObtenido);
		Assert.assertEquals(archivoEsperado, archivoObtenido);
		Assert.assertEquals(outputEsperado, outputObtenido);

	}
}