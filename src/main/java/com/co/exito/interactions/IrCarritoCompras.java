package com.co.exito.interactions;

import com.co.exito.userinterfaces.PaginaExitoObjetos;
import com.co.exito.utils.DatosExcel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import java.io.IOException;
import static com.co.exito.userinterfaces.PaginaExitoObjetos.*;


public class IrCarritoCompras implements Interaction {
    public static Target TXT_NOMBRE_PRUDCITO_CARRITO = null;
    public static Target TXT_VALOR_TOTAL_PRODUCTO_CARRITO = null;


    @Override
    public <T extends Actor> void performAs(T actor) {
        int total = 0;
        DatosExcel datos = new DatosExcel();
        actor.attemptsTo(Click.on(BTN_CARRITO_COMPRAS), Espera.por(5));
        for (int i = 0; i < 5; i++) {
            try {
                String nombreProducto = datos.leerDatoExcel("Hoja de datos", "data.xlsx", i, 0);
                String valorTotalProducto = datos.leerDatoExcel("Hoja de datos", "data.xlsx", i, 1);
                //agregar signo
                String valorTotal = "$ " + valorTotalProducto;

                TXT_NOMBRE_PRUDCITO_CARRITO = Target.the("xpath nombre")
                        .locatedBy("//*[contains(text(), " + "'" + nombreProducto + "')]");
                TXT_VALOR_TOTAL_PRODUCTO_CARRITO = Target.the("xpath total producto")
                        .locatedBy("//*[contains(text(), " + "'" + valorTotalProducto + "')]");

                System.out.println("\nproducto seleccionado a carrito: " + nombreProducto);
                System.out.println("valor seleccionado a carrito: " + valorTotal);
                System.out.println("producto carrito de compras: " + TXT_NOMBRE_PRUDCITO_CARRITO.resolveFor(actor).getText());
                System.out.println("total producto carrito de compras: " + TXT_VALOR_TOTAL_PRODUCTO_CARRITO.resolveFor(actor).getText());

                actor.attemptsTo(
                        Ensure.that(TXT_NOMBRE_PRUDCITO_CARRITO).text().contains(nombreProducto),
                        Ensure.that(TXT_VALOR_TOTAL_PRODUCTO_CARRITO).text().isEqualTo(valorTotal)
                );

                String texto =TXT_VALOR_TOTAL_PRODUCTO_CARRITO.resolveFor(actor).getText();
                String textoNumerico = texto.replaceAll("[^0-9]", "");
                // Convertir el valor a entero
                int SumaTotal = Integer.parseInt(textoNumerico);
                // Sumar el valor al total de los productos
                total += SumaTotal;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        String totalSumaProductosString = String.valueOf(total);
        String totalEnLbl = PaginaExitoObjetos.LBL_TOTAL.resolveFor(actor).getText();
        String textoTotalEnLbl = totalEnLbl.replaceAll("[^0-9]", "");


        // Imprimir totales
        System.out.println("\nEl total de la compra operacion es: " + totalSumaProductosString);
        System.out.println("El total de la compra en la pagina web lbl: " + textoTotalEnLbl);


        actor.attemptsTo(
                //validacion deel total del lbl es igual a la suma de los productos
                Ensure.that(textoTotalEnLbl).isEqualTo(totalSumaProductosString)
        );
    }

    public static IrCarritoCompras on() {
        return Instrumented.instanceOf(IrCarritoCompras.class).withProperties();
    }
}
