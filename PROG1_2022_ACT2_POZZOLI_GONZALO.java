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
  constantes de segmento -> base_seg_1,base_seg_n
  excedente = ganancias_mensuales - minimo_imponible
  excedente *= porcen_por_seg_n
  imp_ganancias = (base_seg_n  + excedente) * 12

  iva:
  iva = POCEN_IVA * precio_bienes_servicios

salida: imp_ganancias, retencion_aportes, aporte_autonomos, imp_bienes_personales, imp_iva

*/

import java.util.Scanner;

class PROG1_2022_ACT2_POZZOLI_GONZALO {
  public static void main (String[]args) {

  }
}