package ar.edu.untref.aydoo.constructores;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.Seccion;

public class ConstructorDeSeccionTest {

	@Test
	public void construirSeccionMD() {

		ConstructorDeSeccion constructorDeSeccion = new ConstructorDeSeccion();
		String Seccion = "---";
		Item itemEsperado = constructorDeSeccion.construir(Seccion);

		Assert.assertEquals(Seccion.class, itemEsperado.getClass());
	}

}
