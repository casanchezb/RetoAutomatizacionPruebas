package com.co.exito.tasks;

import com.co.exito.interactions.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ValidarSelecciones implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                IrCarritoCompras.on()
        );
    }
    public static ValidarSelecciones EnCarrito() {
        return Instrumented.instanceOf(ValidarSelecciones.class).withProperties();
    }
}
