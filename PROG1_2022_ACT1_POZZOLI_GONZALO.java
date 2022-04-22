/* 
A N A L I S I S

entradas: ingresos_mensuales, valor_bienes, precio_bienes_servicios

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
ingreso mensual | valor bienes | val bienes y servicios | reten aportes tra | imp auto | ganancias| bines per | total
      0         |      0       |         0              |        0          |    0     |    0     |     0     |   0 
    96542       |   8432432    |      634000            |     196945        |    0     |    0     |   60574   | 257509
      0         |      0       |         0              |        0          |    0     |    0     |     0     |   0
    230523      |    6700432   |      743234            |        0          |  140668  |  215310  |   43254   | 399232
      0         |      0       |         0              |        0          |    0     |    0     |     0     |   0
    123000      |   2783950    |      525000            |        0          |  98467   |  86182   |     0     | 709650

*/

import java.util.Scanner; // importamos el modulo para leer los datos que introduce el usuario

public class PROG1_2022_ACT1_POZZOLI_GONZALO {
  // método de calculo de retenciones trabajador
  static double calc_imp_reten( double salario) {
    double salario_anualizado = salario * 12; // anualizamos el salario
    double JUBILACION = 0.11;
    double PAMI = 0.03;
    double OBRA_SOCIAL = 0.03;
    double total_porcent_impuesto = JUBILACION + PAMI + OBRA_SOCIAL; // obtenemos el porcentaje de impuesto total
    double impuesto_total = salario_anualizado * total_porcent_impuesto; // obtenemos el dinero pagado en impuesto
    return Math.round(impuesto_total*100.0)/100.0; // retornamos el valor redondeado
  }
  
  static double calc_imp_auto(double ingreso_autonomo) {
    double total_impuesto = 0; // declaramos la variable total impuesto
    // declaramos las categorias
    double cat_1 = 5861.26;
    double cat_2 = 8205.62;
    double cat_3 = 11722.40;
    double cat_4 = 25789.18;

    // Determinamos la anualización dependiendo la categoría de pertenencia
    if ( ingreso_autonomo < 20000) {
      total_impuesto = cat_1 * 12;
    } else if (ingreso_autonomo > 20000 && ingreso_autonomo < 150000) {
      total_impuesto = cat_2 * 12;
    } else if (ingreso_autonomo >= 150000 && ingreso_autonomo < 300000) {
      total_impuesto = cat_3 * 12;
    } else if (ingreso_autonomo >= 300000) {
      total_impuesto = cat_4 * 12;
    }
    return Math.round(total_impuesto*100.0)/100.0;
  }
  
  static double calc_bienes_personales(double valor_bienes) {
    double total_impuesto = 0;
    double excedente = 0; // declaramos el exdecente
    double minimo_imponible = 3000000; // si gana menos que esto no paga el impuesto
    if (valor_bienes > minimo_imponible) { // verificamos que gane mas para pagar el impuesto
      if (valor_bienes <= 6500000) {
        excedente = valor_bienes - minimo_imponible; // creamos el exdente para calcular el porcentaje a cobrar
        excedente *= 0.005; // multiplicamos el excedente por el porcentaje a cobrar del mismo
        total_impuesto = 15000 + excedente; // sumamos el impuesto base con el excedente
      } else if (valor_bienes > 6500000 && valor_bienes <= 18000000) {
        excedente = valor_bienes - 6500000;
        excedente *= 0.01;
        total_impuesto = 41250 + excedente; 
      } else if (valor_bienes > 18000000 && valor_bienes <= 100000000) {
        excedente = valor_bienes - 18000000;
        excedente *= 0.0125;
        total_impuesto = 156250 + excedente;
      } else if (valor_bienes > 100000000 && valor_bienes <= 300000000) {
        excedente = valor_bienes - 100000000;
        excedente *= 0.0150;
        total_impuesto = 1181250 + excedente;
      } else if (valor_bienes > 300000000) {
        excedente = valor_bienes - 300000000;
        excedente *= 0.0175;
        total_impuesto = 4181250  + excedente;
      }
    } else {
      return Math.round(total_impuesto*100.0)/100.0;
    }
    return Math.round(total_impuesto*100.0)/100.0;
  }

  static double calc_ganancias(double ganancia_mensual) {
    double total_impuesto = 0; // declaramos el total de los impuestos
    double excedente = 0; // declaramos el excedente
    double minimo_imponible = 97202.06; // declaramos el minimo imponible
    // declaramos la base de los segmentos
    double base_seg_1 = 4860.10;
    double base_seg_2 = 13608.29;
    double base_seg_3 = 25272.54;
    double base_seg_4 = 121502.57;
    double base_seg_5 = 226480.81;

    if (ganancia_mensual > minimo_imponible) {
      if (ganancia_mensual <= 194404) {
        excedente = ganancia_mensual - minimo_imponible;
        excedente *= 0.09;
        total_impuesto = (base_seg_1 + excedente) * 12; // anualizamos el total
      } else if (ganancia_mensual > 194404 && ganancia_mensual <= 291606) {
        excedente = ganancia_mensual - 194404;
        excedente *= 0.12;
        total_impuesto = (base_seg_2 + excedente) * 12;
      } else if (ganancia_mensual > 291606 && ganancia_mensual <= 777616) {
        excedente = ganancia_mensual - 291606;
        excedente *= 0.15;
        total_impuesto = (base_seg_3 + excedente) * 12;
      } else if (ganancia_mensual > 777616 && ganancia_mensual <= 1166424) {
        excedente = ganancia_mensual - 777616;
        excedente *= 0.27;
        total_impuesto = (base_seg_4 + excedente) * 12;
      } else if (ganancia_mensual > 1166424 ) {
        excedente = ganancia_mensual - 1166424;
        excedente *= 0.31;
        total_impuesto = (base_seg_5 + excedente) * 12;
      }
    } else {
      return Math.round(total_impuesto*100.0)/100.0;
    }
    return Math.round(total_impuesto*100.0)/100.0;
  }

  static double calc_IVA(double total_bienes_y_servicios) {
    double total_impuesto = 0;
    double porcentaje_IVA = 0.21;
    total_impuesto = total_bienes_y_servicios * porcentaje_IVA;
    return Math.round(total_impuesto*100.0)/100.0;
  }
  public static void main (String [] args) {
    Scanner leer = new Scanner(System.in);

    // Declaración de vairables
    int menu = 1; // iniciamos el controlador del ciclo del menu
    int opcion = -1;  // iniciamos la variable que controla la validación de las opciones
    double imp_acum = 0;
    double ingreso_mensual = 0;
    double imp_ganancias = 0;
    double reten_aportes_trabajadores = 0;
    double imp_aportes_autonomo = 0;
    double imp_bienes_personales = 0;
    double imp_IVA = 0;
    double bienes_personales = 0;
    double valor_bienes_serivicios = 0;
    double imp_max = 0;
    double imp_min = 0;
    
    while (menu != 3) {
      System.out.println("Calculadora de impuestos nacionales");
      while (opcion != 1 || opcion != 2) {
        System.out.println("Seleccione la opción que corresponda");
        System.out.println("1. Empleado en relación de dependencia");
        System.out.println("2. Autónomo");
        System.out.println("3. Salir");
        opcion = leer.nextInt();
        if (opcion == 1 || opcion == 2) {
          // Ingreso de salario
          if (opcion == 1) {
            System.out.println("Ingrese su salario mensual");
          } else if (opcion == 2){
            System.out.println("Ingrese el monto de sus ingresos mensuales promedio");
          }
          while (ingreso_mensual <= 0) {
            ingreso_mensual = leer.nextDouble();
            if (ingreso_mensual <= 0) {
              System.out.println("El monto ingresado tiene que ser mayor a 0");
              System.out.println("Vuelva a ingresar el monto");
            }
          }
          // Retencion aporter trabajador
          if (opcion == 1) { // validamos que sea un trabajador en relación de dependencia
            reten_aportes_trabajadores = calc_imp_reten(ingreso_mensual);
            imp_acum += reten_aportes_trabajadores;
  
            imp_min = reten_aportes_trabajadores;
  
            imp_max = reten_aportes_trabajadores;
          } else if (opcion == 2) {
            
            imp_aportes_autonomo = calc_imp_auto(ingreso_mensual);
            imp_acum += imp_aportes_autonomo;
  
            imp_min = imp_aportes_autonomo;
  
            imp_max = imp_aportes_autonomo;
          }

          // ganancias
          if (ingreso_mensual > 97202) { // validamos que se pague el impuesto
            imp_ganancias = calc_ganancias(ingreso_mensual);
            imp_acum += imp_ganancias;
            if (imp_ganancias < imp_min) {
              imp_min = imp_ganancias;
            }
            if (imp_ganancias > imp_max) {
              imp_max = imp_ganancias;
            }
          }
          // Bienes personales
          System.out.println("Ingrese el valor de sus bienes personales");
          while (bienes_personales <= 0) {
            bienes_personales = leer.nextDouble();
            if (bienes_personales <= 0) {
              System.out.println("Los bienes personales tienen que ser mayores a 0");
              System.out.println("Ingrese el valor de sus bienes personales");
            }
          }
          if (bienes_personales > 3000000) { // validamos el pago del impuesto
            imp_bienes_personales = calc_bienes_personales(bienes_personales);
            imp_acum += imp_bienes_personales;
            if (imp_bienes_personales < imp_min) {
              imp_min = imp_bienes_personales;
            }
            if (imp_bienes_personales > imp_max) {
              imp_max = imp_bienes_personales;
            }
          }
          // IVA
          System.out.println("Ingrese el precio total de los productos comprados en el año");
          while (valor_bienes_serivicios <= 0) {
            valor_bienes_serivicios = leer.nextDouble();
            if (valor_bienes_serivicios <= 0) {
              System.out.println("Los productos no puden valor menos que 0");
              System.out.println("Ingrese el precio total de los productos");
            }
          }
          imp_IVA = calc_IVA(valor_bienes_serivicios);
          imp_acum += imp_IVA;
          if (imp_IVA < imp_min) {
            imp_min = imp_IVA;
          }
          if (imp_IVA > imp_max) {
            imp_max = imp_IVA;
          }

          // Mostramos los resultados por pantalla:
          if (opcion == 1) {
            System.out.println("Los aportes del trabajador a la seguridad social son $" + reten_aportes_trabajadores);
          } else if (opcion == 2) {
            System.out.println("Los aportes del autonomo a la seguridad social son $" + imp_aportes_autonomo);
          }

          // Validamos mostrar por pantalla los impuestos que se pagan segun el salario y bienes personales
          if (imp_ganancias > 0) {
            System.out.println("El total del Impuesto a las ganancias pagado en el año es $" + imp_ganancias);
          }
          if (bienes_personales > 0) {
            System.out.println("El total del Impuesto a los bienes personales pagado en el año es $" + imp_bienes_personales);
          }

          System.out.println("El valor de los impuestos totales pagados en el año es de $" + imp_acum);
          System.out.println("El importe del impuesto mas alto es de $" + imp_max );
          System.out.println("El importe del impuesto mas bajo es de $" + imp_min );

        }
        else if (opcion == 3){
          System.out.println("Saliendo del programa...");
          menu = 3;
          break;
        } else if (opcion != 1 || opcion != 2) {
          System.out.println("La opción ingresada no es válida, vuelva a intentar $" + imp_acum);
        }
      }

    }
  }
}