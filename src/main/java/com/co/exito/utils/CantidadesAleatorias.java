package com.co.exito.utils;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CantidadesAleatorias {
    List<WebElementFacade> element;

    public CantidadesAleatorias(List<WebElementFacade> element) {
        this.element = element;
    }

    public static List<Integer> cantidadesAleatorias (List<WebElementFacade> element) {

        Random random = new Random();
        List<Integer> agregados = new ArrayList<>();
        int numero = 5;
        while (numero > agregados.size() ){
            int numRandom = random.nextInt(element.size());
            if(numRandom==0) {
                numRandom = 1;
            }
            if (!agregados.contains(numRandom)){
                agregados.add(numRandom);
            }
        }
        return agregados;
    }
}
