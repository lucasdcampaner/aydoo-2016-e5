package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class Section extends ItemEntrada {

	private ArrayList<ItemEntrada> listaDeItems;

	public Section(String texto) {
		super(texto);
		this.listaDeItems = new ArrayList<>();
	}

	public String getInicioFormateado(Formateador formateador) {
		return formateador.getInicioSectionFormateado();
	}

	public String getFinFormateado(Formateador formateador) {
		return formateador.getFinSectionFormateado();
	}

	public ArrayList<ItemEntrada> getElementosEnColeccion() {
		return this.listaDeItems;
	}

	public String getFormatoListoEnHTML() {
		String html = "";

		Formateador formateadorHTML = new FormateadorHTML();

		for (ItemEntrada item : this.listaDeItems) {
			html += item.getTextoFormateado(formateadorHTML);

		}

		return html;
	}

	@Override
	public String getTextoFormateado(Formateador formateador) {
		return formateador.getInicioSectionFormateado() + getFormatoListoEnHTML()
				+ formateador.getFinSectionFormateado();

	}

	@Override
	public void agregarElementoEnContenedor(ItemEntrada item) {
		// TODO Auto-generated method stub
		this.listaDeItems.add(item);
	}

}
