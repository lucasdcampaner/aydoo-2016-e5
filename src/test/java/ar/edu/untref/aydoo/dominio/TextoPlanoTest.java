package ar.edu.untref.aydoo.dominio;

import org.junit.Assert;
import org.junit.Test;

public class TextoPlanoTest {

	@Test
	public void obtenerElementosDeContenedorRetornaNulo() {

		String textoPlanoEntrada = "Texto plano";

		Item textoPlano = new TextoPlano(textoPlanoEntrada);

		Assert.assertEquals(null, textoPlano.getElementosEnContenedor());
	}

	@Test
	public void seObtieneContenidoEnFormatoHTMLParaUnTextoPlano() {

		String textoPlanoEntrada = "Texto plano de prueba";
		Item textoPlano = new TextoPlano(textoPlanoEntrada);
		String textoPlanoEsperado = textoPlanoEntrada;

		String textoPlanoObtenidoFormatoHTML = textoPlano.getTextoFormateadoHTML();

		Assert.assertEquals(textoPlanoEsperado, textoPlanoObtenidoFormatoHTML);
	}

	@Test
	public void seObtieneContenidoEnFormatoHTMLPara2TextosPlanos() {

		String textoPlanoEntrada = "Texto plano de prueba1";
		String textoPlanoEntrada2 = "Texto plano de prueba2";
		Item textoPlano = new TextoPlano(textoPlanoEntrada);
		Item textoPlano2 = new TextoPlano(textoPlanoEntrada2);
		String textoPlanoEsperado = textoPlanoEntrada + textoPlanoEntrada2;

		String textoPlanoObtenidoFormatoHTML = textoPlano.getTextoFormateadoHTML()
				+ textoPlano2.getTextoFormateadoHTML();

		Assert.assertEquals(textoPlanoEsperado, textoPlanoObtenidoFormatoHTML);
	}

}
