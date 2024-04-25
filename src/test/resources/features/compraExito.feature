# language: es
#camilo.sanchez
Característica: Validar elementos de carrito de ventas
  COMO usuario final
  QUIERO poder visualizar carcteristicas especificas del carrito de ventas
  PARA poder garantizar la compra en la pagina exito

  @CompraCarrito
  Esquema del escenario:Verificar compra en el carrito de ventas
    Dado el usuario ingresa a la <url> exito
    Cuando selecciona la categoria y subcategoria
      | categoria   | subcategoria   |
      | <categoria> | <subcategoria> |
    Entonces selecciona productos aleatoriamente
    Entonces realiza validaciones de los productos agregados
    Entonces valida la cantidad de productos
    Ejemplos:
      | url                    | categoria  | subcategoria |
      | https://www.exito.com/ | Dormitorio | Cabeceras    |