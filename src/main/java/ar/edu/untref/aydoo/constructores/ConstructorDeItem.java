package ar.edu.untref.aydoo.constructores;

import ar.edu.untref.aydoo.dominio.Item;

public abstract class ConstructorDeItem {

	private ConstructorDeItem siguiente;

	//Todo poner comentarios
	
	protected Item continuarConstruccion(String texto) {
		
		Item resultado = null;

		if (this.siguiente != null) {

			resultado = this.siguiente.construir(texto);
		}

		return resultado;
	}
		
	protected void detenerConstruccion(){
		
		if (this.siguiente != null) {

			this.siguiente.itemConstruido();
		}
	}
	
	protected void itemConstruido() {
	}	
	
	public abstract Item construir(String texto);
	
	public void encadenarCon(ConstructorDeItem siguiente) {

		this.siguiente = siguiente;
	}
}
