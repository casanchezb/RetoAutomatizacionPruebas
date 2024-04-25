package com.co.exito.interactions;

import com.co.exito.utils.CantidadesAleatorias;
import com.co.exito.utils.EscribirExcel;
import com.co.exito.utils.LimpiarNumero;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Scroll;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.co.exito.userinterfaces.PaginaExitoObjetos.*;

public class AgregarProducto implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {

        Map<String, Object[]> datos = new TreeMap<String, Object[]>();
        List<WebElementFacade> listButton = BTN_PRODUCTOS.resolveAllFor(actor);
        List<WebElementFacade> NameProduct = TXT_NOMBRE_PRODUCTO.resolveAllFor(actor);
        List<WebElementFacade> Price = TXT_PRECIO_PRODUCTO.resolveAllFor(actor);
        final List<Integer> arreglo = CantidadesAleatorias.cantidadesAleatorias(listButton);

        for (int i = 0; i < 5; i++) {
            actor.attemptsTo(
                    Espera.por(4)
            );
            listButton.get(arreglo.get(i)).click();
            actor.attemptsTo(
                    Scroll.to(LBL_TITULO)
            );

            //se optienen los valores de la interface
            String Name = NameProduct.get(arreglo.get(i)).getText();
            String PriceProducto = Price.get(arreglo.get(i)).getText();
            String valor = LimpiarNumero.LimpiarNumero(PriceProducto);

            //se crea el objeto Map para enviar a la clase escribir excel
            Object[] product = new Object[]{Name, valor};
            datos.put(String.valueOf(i + 1), product);
            EscribirExcel.EscribirExcel(datos);

        }
    }
    public static AgregarProducto enWeb() {
        return Instrumented.instanceOf(AgregarProducto.class).withProperties();
    }
}
