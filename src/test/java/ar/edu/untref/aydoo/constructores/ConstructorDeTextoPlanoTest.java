package ar.edu.untref.aydoo.constructores;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.TextoPlano;

public class ConstructorDeTextoPlanoTest {

	@Test
	public void construirTextoPlanoMD() {
		
		ConstructorDeTextoPlano constructorDeTextoPlano = new ConstructorDeTextoPlano();
		String textoPlano = "Texto plano";
		Item itemEsperado = constructorDeTextoPlano.construir(textoPlano);
				
		Assert.assertEquals(TextoPlano.class, itemEsperado.getClass());
	}

}
