package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TextoPlanoTest {

	@Test
	public void seObtieneContenidoEnFormatoHTMLParaUnTextoPlano() {

		String textoPlanoEntrada = "Texto plano de prueba";
		ItemEntrada textoPlano = new TextoPlano(textoPlanoEntrada);
		String textoPlanoEsperado = textoPlanoEntrada;

		Formateador formateadorHTML = new FormateadorHTML();
		String textoPlanoObtenidoFormatoHTML = textoPlano.getTextoFormateado(formateadorHTML, true);

		Assert.assertEquals(textoPlanoEsperado, textoPlanoObtenidoFormatoHTML);
	}
	
}
