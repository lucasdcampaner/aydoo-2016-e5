package ar.edu.untref.aydoo.constructores;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Imagen;
import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.ItemLista;
import ar.edu.untref.aydoo.dominio.ItemListaContenedor;
import ar.edu.untref.aydoo.dominio.Seccion;
import ar.edu.untref.aydoo.dominio.SubTitulo;
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
	public void crearUnItemsSeccionConUnSubTitulo() {
				
		listaLeida = Arrays.asList("---", "## SubTitulo1");
	
		listaSalida = fabricaDeItem.crearItems(listaLeida);
		
		Assert.assertEquals(1, listaSalida.size());
		Assert.assertEquals(Seccion.class, listaSalida.get(0).getClass());
		Assert.assertEquals(1, listaSalida.get(0).getElementosEnContenedor().size());
		Assert.assertEquals(SubTitulo.class, listaSalida.get(0).getElementosEnContenedor().get(0).getClass());
	}
	
	@Test
	public void crearUnItemsSeccionConUnaImagen() {
				
		listaLeida = Arrays.asList("---", "i: Imagen");
	
		listaSalida = fabricaDeItem.crearItems(listaLeida);
		
		Assert.assertEquals(1, listaSalida.size());
		Assert.assertEquals(Seccion.class, listaSalida.get(0).getClass());
		Assert.assertEquals(1, listaSalida.get(0).getElementosEnContenedor().size());
		Assert.assertEquals(Imagen.class, listaSalida.get(0).getElementosEnContenedor().get(0).getClass());
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
	
	@Test
	public void crearItemsDelEjemplo1() {

		listaLeida = Arrays.asList("---", "# El titulo", "## El subtitulo", "---", "# Solo un titulo", "---", "solo texto sin nada mas");		
		
		listaSalida = fabricaDeItem.crearItems(listaLeida);
	
		Assert.assertEquals(3, listaSalida.size());
		//Seccion 1
		Assert.assertEquals(Seccion.class, listaSalida.get(0).getClass());
		Assert.assertEquals(2, listaSalida.get(0).getElementosEnContenedor().size());
		Assert.assertEquals(Titulo.class, listaSalida.get(0).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(SubTitulo.class, listaSalida.get(0).getElementosEnContenedor().get(1).getClass());
		//Seccion 2
		Assert.assertEquals(Seccion.class, listaSalida.get(1).getClass());
		Assert.assertEquals(1, listaSalida.get(1).getElementosEnContenedor().size());
		Assert.assertEquals(Titulo.class, listaSalida.get(1).getElementosEnContenedor().get(0).getClass());
		//Seccion 3
		Assert.assertEquals(Seccion.class, listaSalida.get(2).getClass());
		Assert.assertEquals(1, listaSalida.get(1).getElementosEnContenedor().size());
		Assert.assertEquals(TextoPlano.class, listaSalida.get(2).getElementosEnContenedor().get(0).getClass());	
	}	

	@Test
	public void crearItemsDelEjemploConBullets() {
		
		listaLeida = Arrays.asList("---", "# El titulo", "## El subtitulo", "---", "# Solo un titulo", "---", "solo texto sin nada mas", "---", "* Un item de una lista", "* Otro item");		
		
		listaSalida = fabricaDeItem.crearItems(listaLeida);

		Assert.assertEquals(4, listaSalida.size());
		//Seccion 1
		Assert.assertEquals(Seccion.class, listaSalida.get(0).getClass());
		Assert.assertEquals(2, listaSalida.get(0).getElementosEnContenedor().size());
		Assert.assertEquals(Titulo.class, listaSalida.get(0).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(SubTitulo.class, listaSalida.get(0).getElementosEnContenedor().get(1).getClass());
		//Seccion 2
		Assert.assertEquals(Seccion.class, listaSalida.get(1).getClass());
		Assert.assertEquals(1, listaSalida.get(1).getElementosEnContenedor().size());
		Assert.assertEquals(Titulo.class, listaSalida.get(1).getElementosEnContenedor().get(0).getClass());
		//Seccion 3
		Assert.assertEquals(Seccion.class, listaSalida.get(2).getClass());
		Assert.assertEquals(1, listaSalida.get(1).getElementosEnContenedor().size());
		Assert.assertEquals(TextoPlano.class, listaSalida.get(2).getElementosEnContenedor().get(0).getClass());
		//Seccion 4
		Assert.assertEquals(Seccion.class, listaSalida.get(3).getClass());
		Assert.assertEquals(1, listaSalida.get(3).getElementosEnContenedor().size());
		Assert.assertEquals(ItemListaContenedor.class, listaSalida.get(3).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(ItemLista.class, listaSalida.get(3).getElementosEnContenedor().get(0).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(ItemLista.class, listaSalida.get(3).getElementosEnContenedor().get(0).getElementosEnContenedor().get(1).getClass());
		Assert.assertEquals("Otro item", listaSalida.get(3).getElementosEnContenedor().get(0).getElementosEnContenedor().get(1).getTexto());
	}

	@Test
	public void crearItemsDelEjemploConEncabezadoSinSeccion() {
		
		listaLeida = Arrays.asList("Encabezado", "---", "# El titulo", "## El subtitulo", "---", "# Solo un titulo", "---", "solo texto sin nada mas");		
		
		listaSalida = fabricaDeItem.crearItems(listaLeida);

		Assert.assertEquals(4, listaSalida.size());
		//Encabezado
		Assert.assertEquals(TextoPlano.class, listaSalida.get(0).getClass());
		
		//Seccion 1
		Assert.assertEquals(Seccion.class, listaSalida.get(1).getClass());
		Assert.assertEquals(2, listaSalida.get(1).getElementosEnContenedor().size());
		Assert.assertEquals(Titulo.class, listaSalida.get(1).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(SubTitulo.class, listaSalida.get(1).getElementosEnContenedor().get(1).getClass());
		//Seccion 2
		Assert.assertEquals(Seccion.class, listaSalida.get(2).getClass());
		Assert.assertEquals(1, listaSalida.get(2).getElementosEnContenedor().size());
		Assert.assertEquals(Titulo.class, listaSalida.get(2).getElementosEnContenedor().get(0).getClass());
		//Seccion 3
		Assert.assertEquals(Seccion.class, listaSalida.get(3).getClass());
		Assert.assertEquals(1, listaSalida.get(3).getElementosEnContenedor().size());
		Assert.assertEquals(TextoPlano.class, listaSalida.get(3).getElementosEnContenedor().get(0).getClass());
	}	
	
	@Test
	public void crearItemsDelEjemploConMultiplesBullets() {
		
		listaLeida = Arrays.asList("---", "# El titulo", "## El subtitulo", 
								   "---", "# Primera lista", "* Uno", "* Dos", 
								   "---", "# Solo un titulo", 
								   "---", "solo texto sin nada mas", 
								   "---", 	"# Segunda lista", "* Tres", "* Cuatro", "* Cinco", 
								   "---", 	"* Seis", "* Siete");		

		listaSalida = fabricaDeItem.crearItems(listaLeida);

		Assert.assertEquals(6, listaSalida.size());
		
		//Seccion 1
		Assert.assertEquals(Seccion.class, listaSalida.get(0).getClass());
		Assert.assertEquals(2, listaSalida.get(0).getElementosEnContenedor().size());
		Assert.assertEquals(Titulo.class, listaSalida.get(0).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(SubTitulo.class, listaSalida.get(0).getElementosEnContenedor().get(1).getClass());
		//Seccion 2
		Assert.assertEquals(Seccion.class, listaSalida.get(1).getClass());
		Assert.assertEquals(2, listaSalida.get(1).getElementosEnContenedor().size());
		Assert.assertEquals(Titulo.class, listaSalida.get(1).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(ItemListaContenedor.class, listaSalida.get(1).getElementosEnContenedor().get(1).getClass());
		//Dentro del contenedor de listas
		Assert.assertEquals(ItemLista.class, listaSalida.get(1).getElementosEnContenedor().get(1).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals("Uno", listaSalida.get(1).getElementosEnContenedor().get(1).getElementosEnContenedor().get(0).getTexto());
		Assert.assertEquals(ItemLista.class, listaSalida.get(1).getElementosEnContenedor().get(1).getElementosEnContenedor().get(1).getClass());
		Assert.assertEquals("Dos", listaSalida.get(1).getElementosEnContenedor().get(1).getElementosEnContenedor().get(1).getTexto());
		//Seccion 3
		Assert.assertEquals(Seccion.class, listaSalida.get(2).getClass());
		Assert.assertEquals(1, listaSalida.get(2).getElementosEnContenedor().size());
		Assert.assertEquals(Titulo.class, listaSalida.get(2).getElementosEnContenedor().get(0).getClass());		
		//Seccion 4
		Assert.assertEquals(Seccion.class, listaSalida.get(3).getClass());
		Assert.assertEquals(1, listaSalida.get(3).getElementosEnContenedor().size());
		Assert.assertEquals(TextoPlano.class, listaSalida.get(3).getElementosEnContenedor().get(0).getClass());
		//Seccion 5
		Assert.assertEquals(Seccion.class, listaSalida.get(4).getClass());
		Assert.assertEquals(2, listaSalida.get(4).getElementosEnContenedor().size());
		Assert.assertEquals(Titulo.class, listaSalida.get(4).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(ItemListaContenedor.class, listaSalida.get(4).getElementosEnContenedor().get(1).getClass());
		//Dentro del contenedor de listas
		Assert.assertEquals(ItemLista.class, listaSalida.get(4).getElementosEnContenedor().get(1).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals("Tres", listaSalida.get(4).getElementosEnContenedor().get(1).getElementosEnContenedor().get(0).getTexto());
		Assert.assertEquals(ItemLista.class, listaSalida.get(4).getElementosEnContenedor().get(1).getElementosEnContenedor().get(1).getClass());
		Assert.assertEquals("Cuatro", listaSalida.get(4).getElementosEnContenedor().get(1).getElementosEnContenedor().get(1).getTexto());
		//Seccion 6
		Assert.assertEquals(Seccion.class, listaSalida.get(5).getClass());
		Assert.assertEquals(1, listaSalida.get(5).getElementosEnContenedor().size());
		Assert.assertEquals(ItemListaContenedor.class, listaSalida.get(5).getElementosEnContenedor().get(0).getClass());
		//Dentro del contenedor de listas
		Assert.assertEquals(ItemLista.class, listaSalida.get(5).getElementosEnContenedor().get(0).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals("Seis", listaSalida.get(5).getElementosEnContenedor().get(0).getElementosEnContenedor().get(0).getTexto());
		Assert.assertEquals(ItemLista.class, listaSalida.get(5).getElementosEnContenedor().get(0).getElementosEnContenedor().get(1).getClass());
		Assert.assertEquals("Siete", listaSalida.get(5).getElementosEnContenedor().get(0).getElementosEnContenedor().get(1).getTexto());
	}	

	@Test
	public void crearItemsDelEjemploConImagen() {
		
		listaLeida = Arrays.asList("---", "# El titulo", "## El subtitulo", "---", "# Solo un titulo", "---", "solo texto sin nada mas", "---", "i: src/test/resources/winteriscoming.jpg");		
		
		listaSalida = fabricaDeItem.crearItems(listaLeida);
	
		Assert.assertEquals(4, listaSalida.size());
		//Seccion 1
		Assert.assertEquals(Seccion.class, listaSalida.get(0).getClass());
		Assert.assertEquals(2, listaSalida.get(0).getElementosEnContenedor().size());
		Assert.assertEquals(Titulo.class, listaSalida.get(0).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals(SubTitulo.class, listaSalida.get(0).getElementosEnContenedor().get(1).getClass());
		//Seccion 2
		Assert.assertEquals(Seccion.class, listaSalida.get(1).getClass());
		Assert.assertEquals(1, listaSalida.get(1).getElementosEnContenedor().size());
		Assert.assertEquals(Titulo.class, listaSalida.get(1).getElementosEnContenedor().get(0).getClass());
		//Seccion 3
		Assert.assertEquals(Seccion.class, listaSalida.get(2).getClass());
		Assert.assertEquals(1, listaSalida.get(1).getElementosEnContenedor().size());
		Assert.assertEquals(TextoPlano.class, listaSalida.get(2).getElementosEnContenedor().get(0).getClass());	
		//Seccion 4
		Assert.assertEquals(Seccion.class, listaSalida.get(3).getClass());
		Assert.assertEquals(1, listaSalida.get(1).getElementosEnContenedor().size());
		Assert.assertEquals(Imagen.class, listaSalida.get(3).getElementosEnContenedor().get(0).getClass());
		Assert.assertEquals("src/test/resources/winteriscoming.jpg", listaSalida.get(3).getElementosEnContenedor().get(0).getTexto());
	}
	
}
