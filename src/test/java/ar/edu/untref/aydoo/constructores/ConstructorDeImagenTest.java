package ar.edu.untref.aydoo.constructores;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Imagen;
import ar.edu.untref.aydoo.dominio.Item;

public class ConstructorDeImagenTest {

	@Test
	public void construirImagenMD() {
		
		ConstructorDeImagen constructorDeImagen = new ConstructorDeImagen();
		String Imagen = "i: Imagen";
		Item itemEsperado = constructorDeImagen.construir(Imagen);
				
		Assert.assertEquals(Imagen.class, itemEsperado.getClass());
	}

}
