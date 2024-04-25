package com.co.exito.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import java.util.List;
import static com.co.exito.userinterfaces.PaginaExitoObjetos.*;

public class ValidarCantidadElement implements Question<Boolean> {

    public static ValidarCantidadElement registros() {
        return new ValidarCantidadElement();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean resultado;
        int elementosEsperados = 5;
        // Encontrar todos los elementos que coinciden con el selector
        List<WebElementFacade> listButton = CONTENEDOR_DE_PRODUCTOS.resolveAllFor(actor);
        // Contar la cantidad de elementos encontrados
        int cantidadElementos = listButton.size();
        System.out.println("cantidad de elementos en carrito: " + cantidadElementos);
        System.out.println("cantidad de elementos esperados: " + elementosEsperados);
        if (cantidadElementos == elementosEsperados){
            resultado = true;
        } else {
            resultado = false;
        }
        return resultado;
    }
}
