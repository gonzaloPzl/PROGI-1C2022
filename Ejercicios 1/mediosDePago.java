/*
A N A L I S I S

  📥 Entrada:
  - Medio de pago
  - Cantidad de cuotas (si eleigio credito)
  - Monto a depositar (Si se eligio efectivo)

  ⚙️ Proceso:
  1. Primero hacemos un menu donde se pregunte que medio de pago de desea para pagar la cuota
  - Medio efectivo:
    a. Se avisa al usuario que si realiza el pago entero en efectivo se le hará un descuento del 10%
    b. Se elige si pagar una parte o todo
    c. Si se elije una parte se ingresa esa parte y se muestrá el restante(procedimiento del ejercicio anterior)
    d. Si se elije pagar completo se muestra cuanto se debe pagar con un descuento del 10%
    Se multiplica la constante CUOTA por 10 y se lo divide por 100 para obtener el valor a descontar.
    Luego ese descuento se lo resta a CUOTA y se guarda en cuota_descuento
    c. Se muestra la cuota descuento que es lo que debe ingresar el usuario para saldar la cuenta.
  - Tarjeta de debito:
    a. Se avisa que se va a generar un recargo del 7%
    b. Entonces muestra el total a depositar, para esto se multiplica CUOTA por 1.07 y se guarda en cuota con recargo
    c. Se pide que introduzca el total para terminar el programa
  - Tarjeta de credito:
    a. Se muestran las diferentes opciones de cuotas con sus respectivos recargos
    b. El usuario elige la cantidad de cuotas
    c. Dependiendo lo que eleija se va a generar el recargo como con la tarjeta de debito y se muestra
      Despues se divide por la cantidad de cuotas y muestra el valor de cada cuota
    d. finaliza el programa

  📤 Salida:
    - Efectivo:
      - descuento
      - restante
    - Debito:
      - recargo
    - Credito
      - Recargo
      - Cuotas

*/

import java.util.Scanner;

public class mediosDePago {
  public static void main (String [] args) {
    // Variables

    // Constantes
    double CUOTA = 1500;
    
  }
}
