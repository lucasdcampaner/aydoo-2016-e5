package ar.edu.untref.aydoo.constructores;

import ar.edu.untref.aydoo.dominio.Item;

public abstract class ConstructorDeItem {

	private ConstructorDeItem siguiente;
	
	public void encadenarCon(ConstructorDeItem siguiente) {
		
		this.siguiente = siguiente;
	}
	
	public Item construirSiguienteSiExiste(String linea) {
		
		Item resultado = null;
		
		if (this.siguiente != null) {
			
			resultado = this.siguiente.construir(linea);
		}
		
		return resultado;
	}
	
	public abstract Item construir(String linea);
}
