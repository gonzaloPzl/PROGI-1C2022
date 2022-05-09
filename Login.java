/* A N A L I S I S

EJERCICIO 2.1

📥Entrada:
  - usuario
  - contraseña 

⚙️Proceso:
  1. Primero establecemos las 2 constantes como tipo String usuario_correcto y contraseña correcta
  2. Validamos que el contador sea menor a 3, en el caso de que no lo sea mostramos el mensaje de "CUENTA BLOQUEADA"
    y finalizamos el programa, SI es menor pasamos al siguiente paso
  2. Pedimos el ingreso de los datos de entrada para almacenarlos en sus respectivas variables.
  3. Hacemos una validación de tipo AND en un if para ver si los 2 datos coinciden con las respetivas constantes
  4. En el caso de que SI se muestra por pantalla "Acceso correcto"
  5. En el caso de que NO se aumenta el acumulador de intentos y se muestra por pantalla el mensaje 
  "Usuario o contraseña incorrecto, vuelva a ingresarlo" junto con los intentos restantes iguales a 3 - el acumulador
    
📤Salida:
  - "Acceso correcto"
  - "Acceso inorrecto"

*/
import java.util.Scanner;

public class Login {
  public static void main (String [] args) {
    // Declaramos la variables que va a ingresar el usuario
    String user = " ";
    String password = " ";
    
    // Variabls que utiliza el programa
    int count = 0;

    // Declaramos las constantes
    String CORRECT_USER = "a";
    String CORRECT_PASSWORD = "a";

    // Instanciamos el objeto scanner para utilizarlo
    Scanner in = new Scanner(System.in);

    while(!(user.equals(CORRECT_USER)) && !(password.equals(CORRECT_PASSWORD))){
      System.out.println("Ingrese el usuario y contraseña para ingresar al sistema");
      System.out.println("Usuario:");
      user = in.next(); // Le asignamos el valor ingresado a la viariable user

      System.out.println("Contraseña:");
      password = in.next(); // Le asignamos el valor ingresado a la variable password

      if (user.equals(CORRECT_USER) && password.equals(CORRECT_PASSWORD)) { // si ambos datos son correctos se muestra el mensaje
        System.out.println("Acceso correcto");
        break;
      } else {
        count++;
        if (count == 3) {
          System.out.println("Cuenta bloqueada por varios ingresos");
          break;
        }
        System.out.println("Acceso incorrecto vuelva intentarlo");
        System.out.println("Cantidad de intentos restantes: " + (3 - count));  
      }
    }

  }
}