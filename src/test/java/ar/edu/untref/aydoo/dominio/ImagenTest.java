package ar.edu.untref.aydoo.dominio;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Imagen;
import ar.edu.untref.aydoo.dominio.Item;

public class ImagenTest {

	
	@Test
	public void obtenerElementosDeContenedorRetornaNulo() {
		
		String texto = "i: Imagen.jpg";

		Item imagen = new Imagen(texto);
		
		Assert.assertEquals(null, imagen.getElementosEnContenedor());
	}
	
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
