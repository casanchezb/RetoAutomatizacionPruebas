package com.co.exito.tasks;


import com.co.exito.interactions.AgregarProducto;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;


public class SeleccionarProductos implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                AgregarProducto.enWeb()
        );
    }
    public static SeleccionarProductos deWeb() {
        return Instrumented.instanceOf(SeleccionarProductos.class).withProperties();
    }
}


