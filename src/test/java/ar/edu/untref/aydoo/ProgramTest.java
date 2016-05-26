package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProgramTest {

	@Test
	public void seValidaTextoValido() {

		String texto = "nandu";
		Program obj = new Program();
		boolean valor = obj.validarNombreArchivo(texto);

		Assert.assertEquals(true, valor);

	}

	@Test
	public void seValidaTextoInValido() {

		String texto = "nandñ";
		Program obj = new Program();
		boolean valor = obj.validarNombreArchivo(texto);

		Assert.assertEquals(false, valor);

	}

	@Test
	public void seValidaTextoInValido1caracter() {

		String texto = "ñ";
		Program obj = new Program();
		boolean valor = obj.validarNombreArchivo(texto);

		Assert.assertEquals(false, valor);

	}

	@Test
	public void seValidaTextoValido1caracter() {

		String texto = "_";
		Program obj = new Program();
		boolean valor = obj.validarNombreArchivo(texto);

		Assert.assertEquals(true, valor);

	}
}
