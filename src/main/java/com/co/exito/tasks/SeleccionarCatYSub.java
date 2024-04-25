package com.co.exito.tasks;

import com.co.exito.interactions.SeleccionarElementos;
import com.co.exito.models.DataExitoLoombokData;
import com.co.exito.userinterfaces.PaginaExitoObjetos;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.co.exito.userinterfaces.PaginaExitoObjetos.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarCatYSub implements Task {

    private DataExitoLoombokData dataExitoLoombokData;

    public SeleccionarCatYSub(DataExitoLoombokData dataExitoLoombokData) {
        this.dataExitoLoombokData = dataExitoLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_MENU, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_MENU),
                SeleccionarElementos.elemento(CONTENEDOR_SELECCIONAR_CATEGORIA, dataExitoLoombokData.getCategoria()),
                Click.on(PaginaExitoObjetos.getSubCategory(dataExitoLoombokData.getSubcategoria())),
                WaitUntil.the(TXT_ELEMENTO, isVisible()).forNoMoreThan(15).seconds()
        );
    }

    public static SeleccionarCatYSub seleccionarDatos(DataExitoLoombokData dataExitoLoombokData) {
        return Instrumented.instanceOf(SeleccionarCatYSub.class).withProperties(dataExitoLoombokData);
    }
}
