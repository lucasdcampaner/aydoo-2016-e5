package ar.edu.untref.aydoo.constructores;

import ar.edu.untref.aydoo.dominio.Item;

public abstract class ConstructorDeItem {

	private ConstructorDeItem siguiente;

	/**
	 * Cuando un item no se crea, se lo pide al siguiente constructor en la
	 * cadena. Exceptuando el ultimo eslabon.
	 */
	protected Item continuarConstruccion(String texto) {

		Item resultado = null;

		if (this.siguiente != null) {

			resultado = this.siguiente.construir(texto);
		}
		return resultado;
	}

	/**
	 * Se detiene la construccion diciendo que el item esta construido.
	 * 
	 */
	protected void detenerConstruccion() {

		if (this.siguiente != null) {

			this.siguiente.itemConstruido();
		}
	}

	/**
	 * Es sobreescrito si la subclase necesita un comportamiento particular
	 * cuando se construye.
	 */
	protected void itemConstruido() {
	}

	/**
	 * Si el item es creado detiene la construccion. Sino, continua con el
	 * siguiente eslabon.
	 */
	public abstract Item construir(String texto);

	/**
	 * Este metodo enlaza los eslabones de la cadena de constructores.
	 */
	public void encadenarCon(ConstructorDeItem siguiente) {

		this.siguiente = siguiente;
	}
}
