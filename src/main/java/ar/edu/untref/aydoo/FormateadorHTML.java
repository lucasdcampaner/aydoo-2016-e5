package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FormateadorHTML extends Formateador {

	private List<Item> itemsPermitidos = new ArrayList<Item>();
	
	public FormateadorHTML() {
		itemsPermitidos.add(new Imagen(""));
		itemsPermitidos.add(new ItemLista(""));
		itemsPermitidos.add(new Seccion(""));
		itemsPermitidos.add(new SubTitulo(""));
		itemsPermitidos.add(new TextoPlano(""));
		itemsPermitidos.add(new Titulo(""));
	}
	
	@Override
	public Item instanciarItemLeidoMD(String itemLeido) {
		
		Item itemInstanciado = null;
		Iterator<Item> iterador = itemsPermitidos.iterator();
		while (itemInstanciado == null && iterador.hasNext()) {
			itemInstanciado = iterador.next().instanciarConMD(itemLeido);
		}
		return itemInstanciado;
	}	
			
	public List<Item> crearListaParaSalidaHTML(List<Item> itemsObtenidos) {
	
		List<Item> listaParaSalida = new LinkedList<Item>();
		
		Item itemContenedorActual = null;
		Item itemListaContenedorActual = null;
		for (Item item : itemsObtenidos) {
			if (item.isContieneItems()) {
				itemListaContenedorActual = null;
				/* Contenedor */
				listaParaSalida.add(item);
				itemContenedorActual = item;
			} else if (itemContenedorActual != null) {
				if (item.isEsContenidoPorUnItemLista()) {
					if (itemListaContenedorActual == null) {
						itemListaContenedorActual = new ItemListaContenedor("");
						itemContenedorActual.agregarElementoEnContenedor(itemListaContenedorActual);
					}
					itemListaContenedorActual.agregarElementoEnContenedor(item);
				} else {
					itemListaContenedorActual = null;
					/* Item dentro de un contenedor */
					itemContenedorActual.agregarElementoEnContenedor(item);
				}
			} else {
				/* Item fuera de contenedor */
				listaParaSalida.add(item);
			}
		}
		return listaParaSalida;
	}
	
	
	
	@Override
	public String getInicioSectionFormateado() {

		String sectionFormateada = "<section>";
		return sectionFormateada;
	}

	@Override
	public String getFinSectionFormateado() {

		String sectionFormateada = "</section>";
		return sectionFormateada;
	}

	@Override
	public String getItemListaFormateado(String texto) {

		String tagInicio = "<li>";
		String tagFin = "</li>";

		String imagenFormateado = tagInicio + texto + tagFin;

		return imagenFormateado;
	}

	@Override
	public String getInicioItemListaContenedorFormateado() {
		String itemListaFormateada = "<ul>";
		return itemListaFormateada;
	}

	@Override
	public String getFinItemListaContenedorFormateado() {
		String itemListaFormateada = "</ul>";
		return itemListaFormateada;
	}

	@Override
	public String getTextoPlanoFormateado(String texto) {
		return texto;
	}
	
}
