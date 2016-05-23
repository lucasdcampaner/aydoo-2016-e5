package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ImagenTest {

	@Test
	public void seCreaImagenDeTextoEspecificadoRecuperandoSuNombre() {

		String contenido = "mundo.jpg";
		ItemEntrada imagen = new Imagen(contenido);

		String textoDeLaImagen = imagen.getTexto();

		Assert.assertEquals(contenido, textoDeLaImagen);

	}

}
