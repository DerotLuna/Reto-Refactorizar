public class Capa {

	public String nombre;
	public int numCasillas;
	public Casilla[] casillas;

	public Capa(int numCasillas, String nombre){
		this.nombre = nombre;
		this.numCasillas = numCasillas;
		casillas = new Casilla[numCasillas];
	}

	//Manejamos la capa con un orden topologico entre las casillas de la capa
	public void addCasilla(int posicion, Casilla casilla){
		casillas[posicion] = casilla;
	}

	//Todavia no tengo la posibilidad de colocar una condicion o restriccion generica
	public boolean esValida(Casilla casilla){
		//codigo para validar que no se repita numero en la capa
		boolean valida = true;
		for(int i = 0; (i < numCasillas) && valida; i++){
			//Uso de los metedos GET (GETTERS) para garantizar el encapsulamiento
			System.out.println(nombre + " // " + casilla + " // " + casillas[i] + " // " + i);

			if(casilla.getId() != casillas[i].getId()){
				valida = valida && (casilla.valor != casillas[i].valor);
			}
		}
		return valida;
	}
}
