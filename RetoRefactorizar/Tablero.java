public class Tablero {

	public int numCasillas;
	public Casilla[] casillas; //Nodos/Casillas
	public boolean[][] matriz; //Adyacencias/Lados
	public int dimension;

	public Tablero(int dimension){
		this.dimension = dimension;
		this.numCasillas = dimension*dimension;
		casillas = new Casilla[numCasillas];
		//Crear las casillas
		for(int i = 0; i < this.numCasillas; i++){
			casillas[i] = new Casilla(i, dimension);
		}
		matriz = new boolean[numCasillas][numCasillas];
		for(int i = 0; i < numCasillas; i++){
			for(int j = 0; j < numCasillas; j++){
				matriz[i][j] = false;
			}
		}
	}

	public Casilla getCasilla(int id){
		return casillas[id];
	}

	//Todavia no tengo una clase generica, solo manejo valores enteros
	public void setValor(int valor, Casilla casilla){
		casilla.setValor(valor);
		if (casilla.esValida() == false) casilla.setValor(0); //para asignar 0 al valor que no pueda ir ahi
		//ocurre un error si primero llamo esValida antes de setValor y debe ser porque esValida depende de setValor
	}

	public boolean print_Board(Casilla casilla, boolean flag){
		int imprimir = 0;
		imprimir = casilla.getValor();
		System.out.print("|" + imprimir + "|");
		if (imprimir == 0) flag = false;
		else flag = true;
		return flag; //este boolean indica si aun faltan casillas a jugar
	}
}
