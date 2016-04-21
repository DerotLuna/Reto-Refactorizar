public class Casilla {

	//DEBO PROTEGER EL ID PARA QUE NADIE LO CAMBIE ! SINO MI LOGICA NO FUNCIONA !
	private int id;
	public int valor;
	private Capa[] capas;

	//USO INTERNO. ENCAPSULADO
	private int indiceCapas = 0;
	/*
	Cual es el problema de tener un arreglo para colecciones de capas ?
	El arreglo no tiene una longitud variable
	ENTONCES DEBO COLOCARLE UN VALOR POR DEFECTO AL CREARLO !!!
	*/

	public Casilla(int id, int dimension){
		this.id = id;
		capas = new Capa[dimension*2]; //Puesto que es un cuadro latino, tendra una capa por cada fila y columna.
	}

	public int getId(){
		return this.id;
	}

	public void setValor(int valor){
		this.valor = valor;
	}

	public int getValor(){
		return valor;
	}

	public void addCapa(Capa capa){
		capas[indiceCapas] = capa;
		indiceCapas ++;
	}

	public boolean esValida(){
		boolean valida = true;
		for(int i = 0; (i < indiceCapas) && valida; i++){ //NO se validan todas las capas
			valida = valida && capas[i].esValida(this);
		}

		if (valida)
			System.out.println("Su valor fue colocado con exito");
		else
			System.out.println("Su valor no es posible de anadir");

		return valida;
	}
}
