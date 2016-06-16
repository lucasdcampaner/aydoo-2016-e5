package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ImagenTest {

	@Test
	public void seCreaImagenDeTextoEspecificadoRecuperandoSuNombre() {

		String contenido = "mundo.jpg";
		Item imagen = new Imagen(contenido);

		String textoDeLaImagen = imagen.getTexto();

		Assert.assertEquals(contenido, textoDeLaImagen);

	}

	@Test
	public void imagenConHTML() {

		String contenido = "mundo.jpg";
		Item imagen = new Imagen(contenido);

		String imagenObtenidoFormatoHTML = imagen.getTextoFormateadoHTML();

		Assert.assertEquals("<img src=\"mundo.jpg\"/>", imagenObtenidoFormatoHTML);
	}

	@Test
	public void imagenx2ConHTML() {

		String contenido = "mundo.jpg";
		Item imagen = new Imagen(contenido);
		String contenido2 = "mundo2.jpg";
		Item imagen2 = new Imagen(contenido2);

		String imagenObtenidoFormatoHTML = imagen.getTextoFormateadoHTML()
				+ imagen2.getTextoFormateadoHTML();

		Assert.assertEquals("<img src=\"mundo.jpg\"/><img src=\"mundo2.jpg\"/>", imagenObtenidoFormatoHTML);
	}
}
