/*
A N A L I S I S
entrada: ingresos_mensuales, valor_bienes, precio_bienes_servicios

procesos:
  retenciones:
  retenciones_totales = JUBILACION + PAMI + OBRA SOCIAL
  retenciones = (ingresos_mensuales * 12) * (retenciones_totales)

  impuesto autonomos:
  constantes de categorias -> cat_1,cat_2,cat_3,cat_4
  imp_a_autonomos = cat_n * 12

  impuesto bienes personales:
  constantes de niveles -> nivel_1,nivel_2,nivel_3,nivel_n
  constantes de porcentaje por nivel -> porcen_por_nivel_n 
  obtenemos el exdente -> excdente = valor_bienes - nivel_n
  excedente *= porcen_por_nivel_n
  imp_bienes_personales = fijo_por_nivel_n + excedente

  impuestos a la ganancias:
  constantes de segmento -> seg_1,seg_n
  excedente = ganancias_mensuales - minimo_imponible
  excedente *= porcen_por_seg_n
  imp_ganancias = (seg_n  + excedente) * 12

  iva:
  iva = POCEN_IVA * precio_bienes_servicios

salida: imp_ganancias, retencion_aportes, aporte_autonomos, imp_bienes_personales, imp_iva

P R U E B A  D E  E S C R I T O R I O
ingreso mensual | valor bienes | val bienes y servicios | reten aportes tra | imp auto | ganancias| bines per | total
      0         |      0       |         0              |        0          |    0     |    0     |     0     |   0 
    96542       |   8432432    |      634000            |     196945        |    0     |    0     |   60574   | 257509
      0         |      0       |         0              |        0          |    0     |    0     |     0     |   0
    230523      |    6700432   |      743234            |        0          |  140668  |  215310  |   43254   | 399232
      0         |      0       |         0              |        0          |    0     |    0     |     0     |   0
    123000      |   2783950    |      525000            |        0          |  98467   |  86182   |     0     | 709650
*/

import java.util.Scanner;

class PROG1_2022_ACT2_POZZOLI_GONZALO {
  public static double retenciones (double ingresos_mensuales) {
    // declaramos constantes de retenciones
    double JUBILACION = 0.11;
    double PAMI = 0.03;
    double OBRA_SOCIAL = 0.03;
    double retenciones_totales = JUBILACION + PAMI + OBRA_SOCIAL; // sumamos las retenciones para obtener el total
    double retenciones = (ingresos_mensuales * 12) * retenciones_totales; // anualizamos y multiplicamos para obtener el porcentaje
    return retenciones; // devolvemos el resultado
  }

  public static double imp_a_autonomos (double ingresos_mensuales) {
    double imp_a_autonomos = 0.00;
    // declaramos las constantes de categorias
    double CAT_1 = 5861.26;
    double CAT_2 = 8205.62;
    double CAT_3 = 11722.40;
    double CAT_4 = 25789.18;
    // Dependiendo el rango de categoría lo anualizamos porque es lo que se va a pagar en el año por pertenencia
    if ( ingresos_mensuales < 20000 ) {
      imp_a_autonomos = CAT_1 * 12;
    } else if ( ingresos_mensuales > 20000 && ingresos_mensuales < 150000 ) {
      imp_a_autonomos = CAT_2 * 12;
    } else if ( ingresos_mensuales >= 150000 && ingresos_mensuales < 300000 ) {
      imp_a_autonomos = CAT_3 * 12;
    } else if ( ingresos_mensuales >= 300000 ) {
      imp_a_autonomos = CAT_4 * 12;
    }
    return imp_a_autonomos;
  }

  public static double imp_bienes_personales (double valor_bienes) {
    double imp_bienes_personales = 0.00;
    double excedente = 0.00;
    double MINIMO_NO_IMPONIBLE = 3000000.00;
    if ( valor_bienes > MINIMO_NO_IMPONIBLE ) { // si gana menos que el MINIMO_NO_IMPONIBLE retorna 0 de impuestos
      if ( valor_bienes <= 6500000 ) {
        excedente = valor_bienes - MINIMO_NO_IMPONIBLE; // obtenemos el excedente para sumar
        excedente *= 0.005; // aplicamos el porcentaje correspondiente al nivel
        imp_bienes_personales = 15000 + excedente; // sumamos el impuesto base con el excedente
      // Repetimos el mismo porceso para los diferentes rangos
      } else if (valor_bienes > 6500000 && valor_bienes <= 18000000) {
        excedente = valor_bienes - 6500000;
        excedente *= 0.01;
        imp_bienes_personales = 41250 + excedente; 
      } else if (valor_bienes > 18000000 && valor_bienes <= 100000000) {
        excedente = valor_bienes - 18000000;
        excedente *= 0.0125;
        imp_bienes_personales = 156250 + excedente;
      } else if (valor_bienes > 100000000 && valor_bienes <= 300000000) {
        excedente = valor_bienes - 100000000;
        excedente *= 0.0150;
        imp_bienes_personales = 1181250 + excedente;
      } else if (valor_bienes > 300000000) {
        excedente = valor_bienes - 300000000;
        excedente *= 0.0175;
        imp_bienes_personales = 4181250  + excedente;
      }
    }
    return imp_bienes_personales;
  }
  
  public static double imp_ganancias (double ganancias_mensuales) {
    double imp_ganancias = 0.00;
    double excedente = 0.00;
    // Declaramos los segmentos
    double MINIMO_NO_IMPONIBLE = 97202.06;
    double SEG_1 = 4860.10;
    double SEG_2 = 13608.29;
    double SEG_3 = 25272.54;
    double SEG_4 = 121502.57;
    double SEG_5 = 226480.81;

    if (ganancias_mensuales > MINIMO_NO_IMPONIBLE) { // Si se gana mensualmente menos que el minimo se devuelve 0 de imp
      if (ganancias_mensuales <= 194404) {
        excedente = ganancias_mensuales - MINIMO_NO_IMPONIBLE;
        excedente *= 0.09; // Se multiplica el excedente por el porcentaje correspondiente a cada segmento
        imp_ganancias = (SEG_1 + excedente) * 12; // anualizamos el total
      } else if (ganancias_mensuales > 194404 && ganancias_mensuales <= 291606) {
        excedente = ganancias_mensuales - 194404;
        excedente *= 0.12;
        imp_ganancias = (SEG_2 + excedente) * 12;
      } else if (ganancias_mensuales > 291606 && ganancias_mensuales <= 777616) {
        excedente = ganancias_mensuales - 291606;
        excedente *= 0.15;
        imp_ganancias = (SEG_3 + excedente) * 12;
      } else if (ganancias_mensuales > 777616 && ganancias_mensuales <= 1166424) {
        excedente = ganancias_mensuales - 777616;
        excedente *= 0.27;
        imp_ganancias = (SEG_4 + excedente) * 12;
      } else if (ganancias_mensuales > 1166424 ) {
        excedente = ganancias_mensuales - 1166424;
        excedente *= 0.31;
        imp_ganancias = (SEG_5 + excedente) * 12;
      }
    }
    
    return imp_ganancias;
  }

  public static double iva (double precio_bienes_servicios) {
    double IVA = 0.21; // Se declara la constante del precio del iva
    double imp_iva = precio_bienes_servicios * IVA; // se obtiene ese porcentaje
    return imp_iva;
  }

  // Procedimiento para mostrar los resultados
  public static void mostrar_resultados (int trabajo, double ingresos_mensuales, double valor_bienes, double precio_bienes_servicios) {
    double imp_acum = 0.00;
    // Le asignamos a las variables el valor del resultado de la ejecución de las funciones
    // con parámetros que nos van a venir del menu
    double imp_bienes = imp_bienes_personales(valor_bienes);
    double imp_ganancias = imp_ganancias(ingresos_mensuales);
    double imp_iva = iva(precio_bienes_servicios);
    
    if (trabajo == 1) { // Significa que tenemos que seguir un procedimiento para autonomos
      double imp_a_autonomos = imp_a_autonomos(ingresos_mensuales);
      System.out.println("El impuesto por autonomo es $" + imp_a_autonomos);
      imp_acum += imp_a_autonomos;
    } else if (trabajo == 2) {
      double retenciones = retenciones(ingresos_mensuales);
      System.out.println("Las retenciones cobradas son $" + retenciones);
      imp_acum += retenciones;
    }
    System.out.println("El impuesto sobre bienes personales es $" + imp_bienes);
    imp_acum += imp_bienes; // Aumento el acumulador de impuestos
    System.out.println("El impuesto a las ganancias es $" + imp_ganancias);
    imp_acum += imp_ganancias;
    System.out.println("El impuesto al valor agregado es $" + imp_iva);
    imp_acum += imp_iva;
    System.out.println("El monto total de impuestos a pagar es $" + imp_acum);
    
  }
  
  public static void menu () {
    Scanner in = new Scanner(System.in);
    int trabajo = -1; // vale 1 si es autonomo y 2 si es empleado
    String menu = "S";
    double valor_bienes = 0.00; 
    double ingresos_mensuales = 0.00;
    double precio_bienes_servicios = 0.00;
    System.out.println("Calculadora de impuestos nacionales");
    System.out.println("**************************************");
    while(menu.equals("S")) {
      System.out.println("Primero debemos saber si sos autonomo o empleado: ");
      // Entramos al while para saber si es empleado o autonomo
      while (trabajo != 1 && trabajo != 2) {
        System.out.println("1. Autonomo \n2. Empleado en relación de depencia");
        trabajo = in.nextInt();
        if (trabajo != 1 && trabajo != 2) {
          System.out.println("El valor ingresado es invalido, ingrese uno correcto");
        }
      }
      // Salimos del while, pedimos el ingreso mensual
      while (ingresos_mensuales <= 0) {
        System.out.println("Introduzca sus ingresos mensuales ya sea salario o ingresos autonomos");
        ingresos_mensuales = in.nextDouble();
        if (ingresos_mensuales < 0) {
          System.out.println("Los ingresos no pueden ser menores a 0, vuelva a introucirlos");
        }
      }

      // Salimos del while de ingresos y entramos al ingreso de valores de bienes
      while (valor_bienes <= 0) {
        System.out.println("Introduzca el valor de sus bienes");
        valor_bienes = in.nextDouble();
        if(valor_bienes < 0) {
          System.out.println("El valor de sus bienes no puede ser menor a 0, vuelva a ingresarlo");
        }
      }
      // Salimos del while de bienes y entramos al ultimo ingreso
      while (precio_bienes_servicios <= 0) {
        System.out.println("Ingrese el valor de los bienes y servicios adquiridos en el año");
        precio_bienes_servicios = in.nextDouble();
        if (precio_bienes_servicios < 0) {
          System.out.println("El valor ingresado no puede ser 0 o menor, ingrese un valor valido");
        }
      }

      // Ejecutamos el procedimiento de mostrar_resultados para visualizar los impuestos
      // Le pasamos los resultados de la ejecución de las funciones como parámetros
      mostrar_resultados(trabajo, ingresos_mensuales, valor_bienes, precio_bienes_servicios);
      menu = "A"; // establecemos el valor en A para que entre al while
      while(!(menu.equals("S")) && !(menu.equals("N"))) {
        System.out.println("Desea realizar otro calculo? S/N");
        menu = in.next();
        if (menu.equals("S")){ // si se desea continuar se resetean las variables
          trabajo = -1; 
          menu = "S";
          valor_bienes = 0.00; 
          ingresos_mensuales = 0.00;
          precio_bienes_servicios = 0.00;
        }
        if(!(menu.equals("S")) && !(menu.equals("N"))) {
          System.out.println("El valor ingresado es invalido, ingrese 'S' si desa continuar o 'N' si no");
        }
      }


    }

  }
  public static void main (String[]args) {
    // Ejecutamos el procedimiento de menu
    menu();

  }
}