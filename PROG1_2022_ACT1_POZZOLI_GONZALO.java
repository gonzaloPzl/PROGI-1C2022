/* 
A N A L I S I S

entradas: salario, ingresos_autonomos, valor_bienes, precio_bienes_servicios

procesos: Usuario ingresa si es empleado en relación de dependencia o autonomo
dependiendo eso se va a calcular retenciones al trabajador o aporte de autonomos.
Una vez ingresado se va a requerir el salario(si es asalariado) o ingresos(autonomo).
Luego pedirmos el valor total de los bienes que posee el usuario y el precio de los
productos que adquirio en el año.
Cada uno de estos valores va a ser pasador a sus respectivos métodos:
  · calculo retenciones a trabajadores: 
    1. Salario bruto anual * 12 (se anualiza)
    2. Al resultado se le resta los porcentajes que componen el impuesto: salario
    anualizado * 0.17 (total), así obtenemos el total del impuesto
  · calculo de impuesto a autonomos:
    1. Con un if determinamos a que categoría corresponde el autonomo
    2. Multiplicamos * 12 lo que debe pagar para obtenerlo anualizado
  · Bienes personales:
    1. Con un if determinamos si debe pagar este impuesto
    2. Si paga hacemos un if para determinamos a que segmento corresponde
    3. Restamos el valor de los bienes al valor base del segmento a pagar.
    4. El excedente lo multiplicamos con el porcentaje correspondiente para obtener
    el total del excedente a pagar
    5. Sumamos el total de excedente a la base para obtener el total del impuesto
  · Ganancias: 
    1. Con un if verificamos si el autonomo o asalariado gana mas del minimo al mes
    2. Con un if vemos a que segmento corresponde
    3. Restamos la ganancia mensual al valor base del segmento a pagar.
    4. El excedente lo multiplicamos con el porcentaje correspondiente para obtener
    el total del excedente a pagar
    5. Sumamos el total de excedente a la base para obtener el total del impuesto
    6. Multiplicamos el resultado por 12 para obtener el impuesto anualizado.
  · IVA:
    1. Multiplicamos el valor de todos los productos * 0.21

  calculamos los impuestos maximos y minimos mientras se van dando a través de un if

salidas: retenciones trabajadores, aportes autonomos, bienes personales, 
ganancias, iva, Impuesto maximo, Impuesto minimo. 

P R U E B A S  D E  E S C R I T O R I O

*/

public class PROG1_2022_ACT1_POZZOLI_GONZALO {
  public static void main (String [] args) {

  }
}