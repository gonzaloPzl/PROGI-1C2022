/* A N A L I S I S 
📥 Entradas: 
    - Numero de pedido
    - Agencia (1 o 2)
    - Mes (1 a 12)
    - Destino (1, 2, 3)
    - Cantidad de personas mayores
    - Cantidad de personas menores

🤖 Proceso: 
    1. Pedimos el ingreso del usuario de los datos de entrada
    2. Verificamos si el numero de pedido es 0, si es el caso mostramos la información y finalizamos el programa
    3. Si se ingresa la agencia 1 se va a aumentar el contador de pedidos en esa agencia, lo mismo para la 2
    4. Cada agencia va a tener un contador para cada destino, por lo que al marcarse el destino a uno de estos se aumenta
      es contador
    5. para obtener le precio total del pasaje vamos a multiplicar el valor del destion(constante) por la cantidad de
      personas mayores mas el mismo precio por la cantidad de personas menores multiplicado por 0.25(para tener el 75% menos).
    6. Mostramos ese total en cada ingreso
    7. Cada ingreso con su total se va a ir acumulando en el acumulador de cada agencia.
    8. Cada destino va a tener un acumulador donde se van a ir acumulando estos totales.
  
📤 Salidas:
    - Monto total del pedido (al finalizar una carga)
    - Cantidad total de pedidos por agencia
    - Cuantos pedidos por cada agencia y a que destino
    - Monto total facturado por destino
    - Monto total facturado por agencia

*/

import java.util.Scanner;

public class Travel {
  public static void main (String [] args) {
  // Declaramos las variables de entrada
  int numero_de_pedido = -1;
  int agencia = -1;
  int mes = 0;
  int destino = -1;
  int cant_personas_mayores = -1;
  int cant_personas_menores = -1;
  
  // Declaramos los contadores y acumuladores
  int count_agen_1 = 0;
  int count_agen_2 = 0;
  int count_agen_1_des_1 = 0;
  int count_agen_1_des_2 = 0;
  int count_agen_1_des_3 = 0;
  int count_agen_2_des_1 = 0;
  int count_agen_2_des_2 = 0;
  int count_agen_2_des_3 = 0;
  double acum_agen_1 = 0;
  double acum_agen_2 = 0;
  double acum_des_1 = 0;
  double acum_des_2 = 0;
  double acum_des_3 = 0;

  // Variables de totalmes
  double precio_total_viaje = 0;

  // Constantes
  double PRECIO_DES_1 = 100000;
  double PRECIO_DES_2 = 250000;
  double PRECIO_DES_3 = 180000;

  // Instanciamos el scanner para el ingreso de datos
  Scanner in = new Scanner(System.in);

  while (numero_de_pedido != 0) {
    System.out.println("PROGRAMA PARA INGRESO DE VIAJES");
    System.out.println("Ingrese el numero de pedido o Ingrese 0 para ver el informe y finalizar el programa:");
    numero_de_pedido = in.nextInt();
    if (numero_de_pedido == 0) {
      System.out.println("I N F O R M E  C O M P L E T O");
      
      System.out.println("Cantidad de pedidos por agencia:");
      System.out.println("Agencia 1: " + count_agen_1 + " | Agencia 2: " + count_agen_2);

      System.out.println("Cantidad de destinos por la agencia 1 ");
      System.out.println("La cantidad de viajes al destino 1 fueron: " + count_agen_1_des_1);
      System.out.println("La cantidad de viajes al destino 2 fueron: " + count_agen_1_des_2);
      System.out.println("La cantidad de viajes al destino 3 fueron: " + count_agen_1_des_3);

      System.out.println("Cantidad de destinos por la agencia 2 ");
      System.out.println("La cantidad de viajes al destino 1 fueron: " + count_agen_2_des_1);
      System.out.println("La cantidad de viajes al destino 2 fueron: " + count_agen_2_des_2);
      System.out.println("La cantidad de viajes al destino 3 fueron: " + count_agen_2_des_3);

      System.out.println("Monto total facturado por cada destino: ");
      System.out.println("Cantidad total del destino 1: " + acum_des_1);
      System.out.println("Cantidad total del destino 2: " + acum_des_2);
      System.out.println("Cantidad total del destino 3: " + acum_des_3);

      System.out.println("Monto total facturado por cada agencia: ");
      System.out.print("El monto total facturado por la agencia 1 es: " + acum_agen_1);
      System.out.print("El monto total facturado por la agencia 2 es: " + acum_agen_2);

      System.out.println("Saliendo del programa...");
      break;
    }
    // Ingreso de la agencia
    while ((agencia != 1) && (agencia != 2)) { 
      System.out.println("Ingrese la agencia de viaje (1 o 2)");
      agencia = in.nextInt();
      System.out.println(agencia);

      if ((agencia != 1) && (agencia != 2)) { // validamos que sea las agencias permitidas
        System.out.println("El numero ingresado es invalido, vuelva a intentarlo");
      }
    }

    // Ingreso del mes de vieja
    while ((mes < 0) || (mes > 12)) {
      System.out.println("Ingrese el mes en el que se realizara el viaje");
      mes = in.nextInt();
      if ((mes < 0) || (mes > 12)) { // verificamos que el mes sea el correcto
        System.out.println("El mes ingresado tiene que ser mayor que 0 y menor o igual a 12");
      }
    }

    // Ingreso de destino
    while (destino < 0 || destino > 3) {
      System.out.println("Seleccione la opción del destino que desee");
      System.out.println("1. America");
      System.out.println("2. Europa");
      System.out.println("3. Asia");
      destino = in.nextInt();
      if (destino < 0 || destino > 3) { // validación de destino
        System.out.println("La opcion seleccionada es incorrecta, ingrese una de las disponibles");
      }
    }

    // Ingreso cantidad de personas mayores
    while (cant_personas_mayores <= 0) {
      System.out.println("Ingrese la cantidad de personas mayores");
      cant_personas_mayores = in.nextInt();
      if (cant_personas_mayores <= 0) { //verificamos que la cantidad de personas mayores sea al menos 1
        System.out.println("La cantidad de personas mayores debe ser de almenos 1");
      }
    }

    // Ingreso cantidad de personas menores
    while (cant_personas_menores < 0) {
      System.out.println("Ingrese la cantidad de personas menores");
      cant_personas_menores = in.nextInt();
    }
    // Realizamos el calculo del viaje para este cada ingreso
    // Esta variable la tenemos que limpiar para que no se acumule
    if (destino == 1) {
      precio_total_viaje = (PRECIO_DES_1 *cant_personas_mayores) + ((PRECIO_DES_1 * cant_personas_menores) * 0.25);
      acum_des_1 = acum_des_1 + precio_total_viaje; // acumulamos el valor en el destino para saber el total
    } else if (destino == 2){
      precio_total_viaje = (PRECIO_DES_2 *cant_personas_mayores) + ((PRECIO_DES_2 * cant_personas_menores) * 0.25);
      acum_des_2 = acum_des_2 + precio_total_viaje;
    } else if (destino == 3) {
      precio_total_viaje = (PRECIO_DES_3 *cant_personas_mayores) + ((PRECIO_DES_3 * cant_personas_menores) * 0.25);
      acum_des_3 = acum_des_3 + precio_total_viaje;
    }
    // Mostramos en cada bucle el precio total del viaje
    System.out.println("El precio total del viaje para el destion " + destino + "Es $" + precio_total_viaje);

    // Realizamos los calculos pra el informe
    if (agencia == 1){
      count_agen_1++;
      acum_agen_1 = acum_agen_1 + precio_total_viaje;
      if(destino == 1) {
        count_agen_1_des_1++;
      } else if(destino == 2) {
        count_agen_1_des_2++;
      } else if(destino == 3) {
        count_agen_1_des_3++;
      }
    } else if (agencia == 2){
      acum_agen_2 = acum_agen_2 + precio_total_viaje;
      count_agen_2++;
      if(destino == 1) {
        count_agen_2_des_1++;
      } else if(destino == 2) {
        count_agen_2_des_2++;
      } else if(destino == 3) {
        count_agen_2_des_3++;
      }
    }

    // Limpiamos las variables
    agencia = -1;
    mes = 0;
    destino = -1;
    cant_personas_mayores = -1;
    cant_personas_menores = -1;
    precio_total_viaje = 0;
  }
  }
}