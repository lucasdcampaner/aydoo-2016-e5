package ar.edu.untref.aydoo;

import java.util.List;

public abstract class Formateador {

	public abstract Item instanciarItemLeidoMD(String itemLeido);

	public abstract List<Item> crearListaParaSalidaHTML(List<Item> itemsObtenidos);
	
	public abstract String getInicioSectionFormateado();

	public abstract String getFinSectionFormateado();

	public abstract String getInicioItemListaContenedorFormateado();

	public abstract String getFinItemListaContenedorFormateado();
}