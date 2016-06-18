package ar.edu.untref.aydoo.constructores;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.Titulo;

public class ConstructorDeTituloTest {

	@Test
	public void construirTituloMD() {
		
		ConstructorDeTitulo constructorDeTitulo = new ConstructorDeTitulo();
		String titulo = "# Titulo";
		Item itemEsperado = constructorDeTitulo.construir(titulo);
				
		Assert.assertEquals(Titulo.class, itemEsperado.getClass());
	}

}
