/* ************************************************************************
                          L I B R E R I A S
*  ***********************************************************************/
import java.util.Scanner;

/* ************************************************************************
   Materia: Programación I
   Fecha: 30/4/21
   Autor: Lic. Diego Krauthamer
   Descripción: Desarrollo de una calculadora que realiza las operaciones
	            de suma, resta, multiplicación y división a partir de 
				2 numeros reales positivos.
   Paradigma empleado: programación modular
   Ultima actualización: 30/04/21 12:00hs.
************************************************************************ */


class ej_calculadora_modular {
	/* ************************************************************************
                 P R O G R A M A     P R I N C I P A L
    *  ***********************************************************************/
	
	public static void main(String[] args) {
		//Declaración de objetos
		Scanner in=new Scanner(System.in);

		//Declaracion e inicialzación de variables
		int opcion=0;
		double num1=0.00, num2=0.00, resultado=0.00;

		do{
			menu(); //Llamo al procedimiento menu
			opcion=ingresar_opcion(); //Llamo a la función ingresar opción

			//Sigo con el flujo del programa si el usuario decidio no salir
			if(opcion!=5){
				num1=ingresar_numero(); //Llamo a la función ingresar numero real 
				num2=ingresar_numero(); //Llamo a la función ingresar numero real
				determinar_opcion(opcion,num1,num2); //llamo a la función para determinar el resultado
			
				//incialización de variables
				resultado=0.00;			
			}
		}while(opcion!=5);
  }// F I N   P R O G R A M A     P R I N C I P A L
  
    /* ************************************************************************
                                   M O D U L O S
    *  ***********************************************************************/
	
	/* ************************************************************************
                                   M E N U
    *  ************************************************************************
     	Descripción: Dibuja un menu en panalla con las opciones
		tipo: procedimiento
		párametros de entrada: ninguno
		páramentros de salida: ninguno

    ********************************************************************** */
	
	public static void menu() {
		System.out.println(" M E N U");
		System.out.println("1. Suma");
		System.out.println("2. Resta");
		System.out.println("3. Multiplicacion");
		System.out.println("4. Division");
		System.out.println("5. Salir\n");
	}
	
	/* ************************************************************************
                      I N G R E S A R    O P C I O N
    *  ************************************************************************
     	Descripción: ingreso y valido la opción elegida por el usuario
		tipo: funcion
		párametros de entrada: ninguno
		páramentros de salida: opcion

    ********************************************************************** */
	public static int ingresar_opcion(){
		
		//Declaración de objetos
		Scanner in=new Scanner(System.in);
		
		//Declaracón de variables locales
		int opcion=0;
		
		do{
				System.out.println("Seleccione una opcion:");
				opcion=in.nextInt();

				//Mensaje de error
				if(opcion<1 || opcion >5){
					System.out.println("Error - Ingrese una opción valida");
				}
			}while(opcion<1 || opcion >5);
	
		//Devuelvo un párametro
		return opcion;
	}
	
	/* ************************************************************************
                      I N G R E S A R    N U M E R O
    *  ************************************************************************
     	Descripción: ingreso y validación del número
		tipo: función
		párametros de entrada: ninguno
		páramentros de salida: numero

    ************************************************************************ */
	public static double ingresar_numero(){	
	
		//Declaración de objetos
		Scanner in=new Scanner(System.in);
		
		double pnumero=0;
		
		//Ingreso y validación de un numero
		do{
			System.out.println("Ingrese un numero positivo");
			
			pnumero=in.nextDouble();

			//Mensaje de error
			if(pnumero<=0){
				System.out.println("Error - Ingrese numero positivo válido");
			}
		}while(pnumero<=0);
		return pnumero;
	}
	
	/* *****************************************************************************
                      D E T E R M I N A R    O P C I O N
    *  *****************************************************************************
     	Descripción: Determino la opcion elegida por el usuario para realizar
		             la operación correspondiente (suma, resta, multipl., o división)
					 y muestro por pantalla el resultado correspondiente.
		tipo: procedimiento
		párametros de entrada: opcion elegida, numero1 y numero2
		páramentros de salida: resultado

    ****************************************************************************** */
	public static void determinar_opcion(int popcion, double pnum1,double pnum2){
			
		//Declaracion de variables locales
		double vresultado=0.00;
			
		//Determino la operación elegida
		if(popcion==1){
					
			//Eligio operacion SUMA
			vresultado=pnum1+pnum2;
					
		}else if(popcion==2){
					
			//Eligio operacion RESTA
			vresultado=pnum1-pnum2;
					
		}else if(popcion==3){
					
			//Eligio operacion MULTIPLICACION
			vresultado=pnum1*pnum2;
					
		}else if(popcion==4){
					
			//Eligio operacion DIVISION
			vresultado=pnum1/pnum2;
		}
			
		//Salida por pantalla del resultado
		System.out.println("El resultado de la operacion es: "+vresultado+"\n");
	}
}