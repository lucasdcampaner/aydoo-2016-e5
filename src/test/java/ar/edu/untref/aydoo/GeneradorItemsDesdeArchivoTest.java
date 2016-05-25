package ar.edu.untref.aydoo;

public class GeneradorItemsDesdeArchivoTest {
	
	//TODO ver si se puede mockear para no ir al file system.

	
//	@Test
//	public void seCreaListaDeItemsEntradaDelEjemploIntegrador() throws IOException {
//		
//		String archivoEntrada = "ejemploIntegrador.md";
//		GeneradorItemsDesdeArchivo generadorItemsDesdeArchivo = new GeneradorItemsDesdeArchivo(archivoEntrada);
//		List<ItemEntrada> itemsEntradaEsperada = new LinkedList<ItemEntrada>();
//		itemsEntradaEsperada.add(new Section(""));
//		itemsEntradaEsperada.add(new Titulo("El titulo"));
//		itemsEntradaEsperada.add(new SubTitulo("El Subtitulo"));
//		itemsEntradaEsperada.add(new Section(""));
//		itemsEntradaEsperada.add(new Titulo("Solo un titulo"));
//		itemsEntradaEsperada.add(new Section(""));
//		itemsEntradaEsperada.add(new TextoPlano("solo texto sin nada mas"));
//		Formateador formateadorHTML = new FormateadorHTML();
//		
//		//Aca estaria el mock
//		List<ItemEntrada> itemsEntradaObtenida = generadorItemsDesdeArchivo.getItemsEntrada(formateadorHTML);
//		
//		for (int i = 0; i < itemsEntradaObtenida.size(); i++) {
//			Assert.assertEquals(itemsEntradaEsperada.get(i).getTexto(), itemsEntradaObtenida.get(i).getTexto());
//		}
//		
//	}
	
}
