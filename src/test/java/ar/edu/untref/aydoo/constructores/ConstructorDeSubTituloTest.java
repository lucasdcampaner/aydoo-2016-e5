package ar.edu.untref.aydoo.constructores;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.SubTitulo;

public class ConstructorDeSubTituloTest {

	@Test
	public void construirSubTituloMD() {

		ConstructorDeSubTitulo constructorDeSubTitulo = new ConstructorDeSubTitulo();
		String SubTitulo = "## SubTitulo";
		Item itemEsperado = constructorDeSubTitulo.construir(SubTitulo);

		Assert.assertEquals(SubTitulo.class, itemEsperado.getClass());
	}

}
