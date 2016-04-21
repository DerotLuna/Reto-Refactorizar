import java.util.Scanner;

public class Game{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
    System.out.print(" Ingrese la dimension: ");
		int dimension = sc.nextInt(); System.out.print("\n");
		CuadradoLatino cuadrado = new CuadradoLatino(dimension);
    boolean flag = false; int fila, columna, valor;
		while(flag == false){
      valor = cuadrado.scanner_Valores(1);
      fila = cuadrado.scanner_Valores(2);
      columna = cuadrado.scanner_Valores(3);
  		cuadrado.setValor(fila , columna , valor);
      flag = cuadrado.imprimir_Tablero(true);
      System.out.print(" Teclee un numero para limpiar pantalla...");
  		valor = sc.nextInt();
      cuadrado.clear();
    }
	}
}
