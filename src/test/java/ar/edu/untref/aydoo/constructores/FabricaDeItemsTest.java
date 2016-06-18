package ar.edu.untref.aydoo.constructores;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.ItemLista;
import ar.edu.untref.aydoo.dominio.ItemListaContenedor;
import ar.edu.untref.aydoo.dominio.Seccion;
import ar.edu.untref.aydoo.dominio.TextoPlano;
import ar.edu.untref.aydoo.dominio.Titulo;

public class FabricaDeItemsTest {

	private FabricaDeItem fabricaDeItem = new FabricaDeItem();
	private List<String> listaLeida;
	private List<Item> listaSalida;
	
	@Test
	public void crearDosItemsTextoPlano() {
				
		listaLeida = Arrays.asList("TextoPlano1", "TextoPlano2");
	
		listaSalida = fabricaDeItem.crearItems(listaLeida);
		
		Assert.assertEquals(2, listaSalida.size());
		Assert.assertEquals(TextoPlano.class, listaSalida.get(0).getClass());
		Assert.assertEquals(listaLeida.get(0), listaSalida.get(0).getTexto());
		Assert.assertEquals(TextoPlano.class, listaSalida.get(1).getClass());
		Assert.assertEquals(listaLeida.get(1), listaSalida.get(1).getTexto());
	}
	
	@Test
	public void crearUnItemsSeccion() {
				
		listaLeida = Arrays.asList("---");
	
		listaSalida = fabricaDeItem.crearItems(listaLeida);
		
		Assert.assertEquals(1, listaSalida.size());
		Assert.assertEquals(Seccion.class, listaSalida.get(0).getClass());
	}
	
	@Test
	public void crearUnItemsSeccionConUnTextoPlano() {
				
		listaLeida = Arrays.asList("---", "TextoPlano1");
	
		listaSalida = fabricaDeItem.crearItems(listaLeida);
		
		Assert.assertEquals(1, listaSalida.size());
		Assert.assertEquals(Seccion.class, listaSalida.get(0).getClass());
		Assert.assertEquals(1, listaSalida.get(0).getElementosEnContenedor().size());
		Assert.assertEquals(TextoPlano.class, listaSalida.get(0).getElementosEnContenedor().get(0).getClass());
	}
	
	@Test
	public void crearUnItemsSeccionConTresTextosPlano() {
				
		listaLeida = Arrays.asList("---", "TextoPlano1", "TextoPlano2", "TextoPlano3");
	
		listaSalida = fabricaDeItem.crearItems(listaLeida);
		
		Assert.assertEquals(1, listaSalida.size());
		Assert.assertEquals(Seccion.class, listaSalida.get(0).getClass());
		Assert.assertEquals(3, listaSalida.get(0).getElementosEnContenedor().size());
		Assert.assertEquals(TextoPlano.class, listaSalida.get(0).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(TextoPlano.class, listaSalida.get(0).getElementosEnContenedor().get(1).getClass());
		Assert.assertEquals(TextoPlano.class, listaSalida.get(0).getElementosEnContenedor().get(2).getClass());
	}
	
	@Test
	public void crearUnItemsSeccionConUnTitulo() {
				
		listaLeida = Arrays.asList("---", "# Titulo1");
	
		listaSalida = fabricaDeItem.crearItems(listaLeida);
		
		Assert.assertEquals(1, listaSalida.size());
		Assert.assertEquals(Seccion.class, listaSalida.get(0).getClass());
		Assert.assertEquals(1, listaSalida.get(0).getElementosEnContenedor().size());
		Assert.assertEquals(Titulo.class, listaSalida.get(0).getElementosEnContenedor().get(0).getClass());
	}

	@Test
	public void crearUnItemsSeccionConDosTitulos() {
				
		listaLeida = Arrays.asList("---", "# Titulo1", "# Titulo2");
	
		listaSalida = fabricaDeItem.crearItems(listaLeida);
		
		Assert.assertEquals(1, listaSalida.size());
		Assert.assertEquals(Seccion.class, listaSalida.get(0).getClass());
		Assert.assertEquals(2, listaSalida.get(0).getElementosEnContenedor().size());
		Assert.assertEquals(Titulo.class, listaSalida.get(0).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(Titulo.class, listaSalida.get(0).getElementosEnContenedor().get(1).getClass());
	}

	@Test
	public void crearTextoPlanoLuegoSeccionConTitulo() {
				
		listaLeida = Arrays.asList("TextoPlano", "---", "# Titulo1");
	
		listaSalida = fabricaDeItem.crearItems(listaLeida);
		
		Assert.assertEquals(2, listaSalida.size());
		Assert.assertEquals(TextoPlano.class, listaSalida.get(0).getClass());
		Assert.assertEquals(Seccion.class, listaSalida.get(1).getClass());
		Assert.assertEquals(1, listaSalida.get(1).getElementosEnContenedor().size());
		Assert.assertEquals(Titulo.class, listaSalida.get(1).getElementosEnContenedor().get(0).getClass());
	}	

	@Test
	public void crearUnaSeccionConUnItemLista() {
				
		listaLeida = Arrays.asList("---", "* Item lista 1");
	
		listaSalida = fabricaDeItem.crearItems(listaLeida);
		
		Assert.assertEquals(1, listaSalida.size());
		Assert.assertEquals(Seccion.class, listaSalida.get(0).getClass());
		Assert.assertEquals(1, listaSalida.get(0).getElementosEnContenedor().size());
		Assert.assertEquals(ItemListaContenedor.class, listaSalida.get(0).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(1, listaSalida.get(0).getElementosEnContenedor().get(0).getElementosEnContenedor().size());
		Assert.assertEquals(ItemLista.class, listaSalida.get(0).getElementosEnContenedor().get(0).getElementosEnContenedor().get(0).getClass());
	}	

	@Test
	public void crearUnaSeccionConDosItemLista() {
				
		listaLeida = Arrays.asList("---", "* Item lista 1", "* Item lista 2");
	
		listaSalida = fabricaDeItem.crearItems(listaLeida);
		
		Assert.assertEquals(1, listaSalida.size());
		Assert.assertEquals(Seccion.class, listaSalida.get(0).getClass());
		Assert.assertEquals(1, listaSalida.get(0).getElementosEnContenedor().size());
		Assert.assertEquals(ItemListaContenedor.class, listaSalida.get(0).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(2, listaSalida.get(0).getElementosEnContenedor().get(0).getElementosEnContenedor().size());
		Assert.assertEquals(ItemLista.class, listaSalida.get(0).getElementosEnContenedor().get(0).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(ItemLista.class, listaSalida.get(0).getElementosEnContenedor().get(0).getElementosEnContenedor().get(1).getClass());
	}
	
	@Test
	public void crearUnaSeccionDosItemListaSeparadasPorUnTitulo() {
				
		listaLeida = Arrays.asList("---", "* Item lista 1", "* Item lista 2", "# Titulo1", "* Item lista 3", "* Item lista 4");
	
		listaSalida = fabricaDeItem.crearItems(listaLeida);
		
		Assert.assertEquals(1, listaSalida.size());
		Assert.assertEquals(Seccion.class, listaSalida.get(0).getClass());
		Assert.assertEquals(3, listaSalida.get(0).getElementosEnContenedor().size());
		Assert.assertEquals(ItemListaContenedor.class, listaSalida.get(0).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(2, listaSalida.get(0).getElementosEnContenedor().get(0).getElementosEnContenedor().size());
		Assert.assertEquals(ItemLista.class, listaSalida.get(0).getElementosEnContenedor().get(0).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(ItemLista.class, listaSalida.get(0).getElementosEnContenedor().get(0).getElementosEnContenedor().get(1).getClass());
		
		Assert.assertEquals(Titulo.class, listaSalida.get(0).getElementosEnContenedor().get(1).getClass());

		Assert.assertEquals(ItemListaContenedor.class, listaSalida.get(0).getElementosEnContenedor().get(2).getClass());
		Assert.assertEquals(2, listaSalida.get(0).getElementosEnContenedor().get(2).getElementosEnContenedor().size());
		Assert.assertEquals(ItemLista.class, listaSalida.get(0).getElementosEnContenedor().get(2).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(ItemLista.class, listaSalida.get(0).getElementosEnContenedor().get(2).getElementosEnContenedor().get(1).getClass());
		
	}

	@Test
	public void crearDosSeccionesCadaUnaConUnaLista() {
				
		listaLeida = Arrays.asList("---", "* Item lista 1", "* Item lista 2", "---", "* Item lista 3", "* Item lista 4");
	
		listaSalida = fabricaDeItem.crearItems(listaLeida);
		
		Assert.assertEquals(2, listaSalida.size());
		Assert.assertEquals(Seccion.class, listaSalida.get(0).getClass());
		Assert.assertEquals(Seccion.class, listaSalida.get(1).getClass());
		
		//Seccion 1
		Assert.assertEquals(1, listaSalida.get(0).getElementosEnContenedor().size());
		//Item lista contenedor 1
		Assert.assertEquals(ItemListaContenedor.class, listaSalida.get(0).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(2, listaSalida.get(0).getElementosEnContenedor().get(0).getElementosEnContenedor().size());
		Assert.assertEquals(ItemLista.class, listaSalida.get(0).getElementosEnContenedor().get(0).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(ItemLista.class, listaSalida.get(0).getElementosEnContenedor().get(0).getElementosEnContenedor().get(1).getClass());
		
		//Seccion 2
		Assert.assertEquals(1, listaSalida.get(1).getElementosEnContenedor().size());
		//Item lista contenedor 1
		Assert.assertEquals(ItemListaContenedor.class, listaSalida.get(1).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(2, listaSalida.get(1).getElementosEnContenedor().get(0).getElementosEnContenedor().size());
		Assert.assertEquals(ItemLista.class, listaSalida.get(1).getElementosEnContenedor().get(0).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(ItemLista.class, listaSalida.get(1).getElementosEnContenedor().get(0).getElementosEnContenedor().get(1).getClass());
	}
	

}
