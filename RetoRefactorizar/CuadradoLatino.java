import java.util.Scanner;

public class CuadradoLatino {

	public int dimension;
	public Tablero tablero;
	public Capa[] capas;

	public CuadradoLatino(int dimension){
		this.dimension = dimension;
		tablero = new Tablero(dimension);

		int contador_Global = 0;
		int contador_Sec = 0;
		int contador = 0;
		capas = new Capa[dimension*dimension];
		while(contador_Sec <= dimension*dimension-1){
			Capa fila = new Capa(dimension ,"Fila" + (contador_Global+1));
			contador = 0;
			while(contador < dimension){
				fila.addCasilla(contador, tablero.getCasilla(contador_Sec));
				tablero.getCasilla(contador_Sec).addCapa(fila);
				contador ++; contador_Sec ++;
			}
			capas[contador_Global] = fila;
			contador_Global ++;
		}

		contador_Sec = 0; int sumador = 0;
		while(contador_Sec <= dimension*dimension-1){
			Capa columna = new Capa(dimension ,"Columna" + (sumador+1));
			contador = sumador; int saldor = 0;
				while(saldor < dimension){
					columna.addCasilla(saldor, tablero.getCasilla(contador));
					tablero.getCasilla(contador).addCapa(columna);
					contador += dimension; contador_Sec ++; saldor ++;
			}
			sumador ++;
			capas[contador_Global] = columna;
			contador_Global ++;
		}

	}

		/*
		METODO SOLO VALIDO PARA EL CASO DE UN TABLERO CUADRADO
		Metodo que busca la casilla, convirtiendo las posiciones x, y de la casilla a nivel grafico
		NO CORRESPONDE AL X,Y del atributo matriz
		Cuando estemos programando en LibGDX recibiremos unas coordenadas x,y de la pantalla que tendremos que transformar en casilla
		  0 1 2 3
		0 0 1 2 3 ----------> (4xFila) + Columna
		1 4 5 6 7 ----------> (4xFila) + Columna
		2 8 9 ... ----------> IDEM
		3 ....... (4x4 - 1 = 15)
		Si este es mi tablero de juego, implica que mi atributo matriz es de 16x16 (matriz de adyacencias)
	*/
	public int getIdCasilla(int fila, int columna){
		return (dimension * fila) + columna;
	}

	public void setValor(int fila, int columna, int valor){
		Casilla casilla = tablero.getCasilla(getIdCasilla(fila, columna));
		tablero.setValor(valor, casilla);
	}

	public boolean imprimir_Tablero(boolean flag){
		for(int posf = 0 ; posf < dimension; posf++){
			for (int posC = 0; posC < dimension; posC++){
				Casilla casilla = tablero.getCasilla(getIdCasilla(posf, posC));
				flag = flag & tablero.print_Board(casilla, flag);
			}
			System.out.println("\n");
		}
		return flag;
	}

	public int scanner_Valores(int answer){ //valida que los valores ingresados por el usuario sean correctos
		int give_Back = 0; boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		while(flag == true){
			if (answer == 1) System.out.print(" Ingrese valor: ");
			else if (answer == 2) System.out.print(" Ingrese fila: ");
			else System.out.print(" Ingrese columna: ");
			give_Back = scanner.nextInt(); System.out.print("\n");
			if (answer == 1 && (give_Back <= dimension) && (give_Back > 0)) flag = false;
			else if (answer != 1 && (give_Back < dimension) && (give_Back >= 0)) flag = false;
			else System.out.print(" Valor incorrecto. \n");
		}
		return give_Back;
	}

		public void clear(){ //limpio pantalla en consola
			System.out.print("\033[H\033[2J");
			System.out.flush();
		}
}
