/* A N A L I S I S

EJERCICIO 1.1
Cuotas de socios

📥Entrada:
  - deposito_socio 

⚙️Proceso:
  1. Guardamos en una constante el precio de las cuotas.
  2. Pedimos el ingreso del saldo para el pago de la cuota permitiendo valores con punto flotante.
  3. En la variable saldo restante se almacenara el resultado entre la resta cuota y el deposito
  4. Si el deposito es 0 se mostrará que ya se saldo todo el saldo
  5. Si el deposito es mayor a 0 se mostrará cuanto falta saldar
    
📤Salida:
  - saldo_restante

*/
import java.util.Scanner; // Importamos el scanner

public class sociosCuotas {
  public static void main(String [] args) {
    // Variables
    double deposito_socio = 0; 

    double saldo_restante = 0;

    // Constante
    double CUOTA = 1500;

    Scanner in = new Scanner(System.in); // Estanciamos el objeto scanner

    while(deposito_socio <= 0 || deposito_socio > 1500) { // Si es menor o igual a 0 o mayor a 1500 entra acá 
      System.out.println("Ingrese el deposito de la cuota: ");
      deposito_socio = in.nextDouble(); // Ingreso del usuario

      if(deposito_socio <= 0) { // Validamos, si es igual o menor a 0 muestra este mensaje
        System.out.println("El deposito ingresado tiene que ser mayor que 0");
      } else if (deposito_socio > 1500) { // Si es mayor a 1500 se muestra lo que falta
        System.out.println("El deposito ingresado tiene que ser menor que el precio de la cuota " + CUOTA);
      }
    }
    saldo_restante = CUOTA - deposito_socio;
  
    if(saldo_restante == 0) { // Si se pagó entera la cuota se muestra el mensaje
      System.out.println("La cuota se pagó completamente");
    } else if (saldo_restante > 0) { // Si falta pagar mas, se muestra lo que resta
      System.out.println("El saldo restante a pagar es de $" + saldo_restante);
    }

  }
}
