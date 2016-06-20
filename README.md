# aydoo-2016-e5
Principales decisiones de diseño:

- Las clases estan divididas en los siguientes paquetes: contructores, dominio, entradasalida y excepciones. De similar manera para sus clases de test.

- Los elementos del dominio fueron modelados como hijos de una superclase Item. Algunos items a su vez pueden contener otros items. Esto hace a la estructura elegida para el desarrollo del programa.

- La entrada de parámetros por consola se realiza mediante la clase ManejadorDeOpciones. La misma tiene la lógica y las validaciones correspondientes. Lanza excepciones de ser necesario para: caracteres invalidos, combinacion de parametros incorrecta y modos de ejecucion inexistentes.

- La entrada de datos es manejada por la clase LectorDeArchivoDeEntrada, lee el archivo y genera una lista de strings que luego seran procesados.

- El corazon del diseño es la implementacion en conjunto de dos patrones, el abstract factory y el chaing of responsability. La clase FabricaDeItem se encarga de instanciar todos los constructores de las clases del dominio y de enlazarlos en la cadena de responsabilidades. Luego tiene un metodo que devuelve una lista de items con el formato necesario para ser leida e impresa o persistida. Recomendamos leer los comentarios que se encuentran en las clases constructores a fin de comprender mejor la logica. La fabrica puede ser extendida creando nuevos contructores y pensamos en la posibilidad de agregar un metodo que permita enlazar un nuevo contructor en la cadena. De igual manera pueden escribirse fabricas hijas y crear y enlazar contructores como sea necesario.

- Los diagramas de clase estan divididos por paquetes y hay un diagrama completo.

- Los diagramas de secuencia para la cadena fueron dividios debido a su complejidad. Se muestran 2 diagramas con los contructores de elementos del dominio que contienen a su vez items. El tercer diagrama de la cadena muestra como se encadenan los item que no contienen a otros items. Si bien el metodo que los va enlazando es continuarConstruccion, en los diagramas figura como contruir, porque en definitiva es a donde dirige ese metodo. Leer los diagramas en el orden en que se encuentran, del 0 al 3, facilitara ver como se enlazan los objetos.

- La responsabilidad de la salida de los datos procesados está en la clase GeneradorSalida. Posee dos métodos publicos, uno para sobreescribir el index.html en la carpeta especificada segun el negocio y otro para devolver un literal a imprimir por pantalla.

