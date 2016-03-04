package ar.com.templateit.prueba;

import java.util.Scanner;

public class MiTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);  
        int numero;
        System.out.print("Introduzca 1 o 0: ");       
        numero = sc.nextInt();
        
        switch (numero) {
		case 0:
			System.out.print("Su opcion es false"); 
			break;
		case 1:
			System.out.print("Su opcion es true"); 
			break;	
		default:
			System.out.print("Ingreso un numero incorrecto"); 
			break;
		}
       
       
	}

}
