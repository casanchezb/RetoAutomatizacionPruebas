package com.co.exito.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleccionarElementos implements Interaction {
    Target lista;
    String texto;

    public SeleccionarElementos(Target lista, String texto) {
        this.lista = lista;
        this.texto = texto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement elemento = lista.resolveFor(actor);
        List<WebElement> opciones = elemento.findElements(By.tagName("li"));
        for (WebElement i : opciones) {
            if (i.getText().contains(texto)) {
                i.click();
                break;
            }
        }
    }

    public static SeleccionarElementos elemento(Target lista, String texto) {

        return Instrumented.instanceOf(SeleccionarElementos.class).withProperties(lista, texto);
    }
}
