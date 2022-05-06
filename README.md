# PROGI-1C2022 - Guia 1

## CONTROL DE FLUJO, CONTADORES, ACUMULADORES, MÁXIMOS Y MÍNIMOS

### Ejercicio 1
Crear un programa que permita realizar el login a una aplicación mediante usuario y
contraseña. En el caso de que el usuario y la contraseña sean correctos, el programa
indicará “Acceso correcto” y finalizará. Sin embargo, si el usuario o la contraseña son
incorrectos el programa mostrará un mensaje de error.
Aclaraciones:

- El nombre de usuario correcto es “usuario1” y la contraseña es “asdasd”
- Solamente tenemos tres oportunidades para intentar el acceso al sistema

### Ejercicio 2
Una empresa de turismo realiza excursiones a las siguientes regiones del mundo:
| region |nombre  | costo x persona|
|--|--|--| 
|  1| América |  $100.000,00|
|  2|  Europa|  $250.000,00|
|  3|  Asia|  $180.000,99|

Cada vez que se recibe un pedido tomado por alguna de sus 2 agencias, se tiene la siguiente información, finalizando con el número de pedido 0:
- Número de pedido.
- Agencia. (1 o 2)
- Mes (1 a 12).
- Destino (1,2 o 3)
- Cantidad de personas mayores.
- Cantidad de personas menores.

Se sabe que los menores pagan un 75% del valor del tour

El programa deberá calcular e informar:
1. Al finalizar la carga de un pedido el monto total del pedido.
2. Cantidad total de pedidos por agencia.
3. De cada destino se desea saber el desagregado por agencia.
4. Monto total facturado por destino
5. Monto total facturado por agencia
