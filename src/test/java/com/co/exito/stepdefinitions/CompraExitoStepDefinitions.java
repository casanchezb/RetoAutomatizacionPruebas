package com.co.exito.stepdefinitions;


import com.co.exito.questions.ValidarCantidadElement;
import com.co.exito.tasks.SeleccionarProductos;
import com.co.exito.tasks.ValidarSelecciones;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import com.co.exito.models.DataExitoLoombokData;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import com.co.exito.tasks.SeleccionarCatYSub;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

public class CompraExitoStepDefinitions {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^el usuario ingresa a la (.*) exito$")
    public void elUsuarioIngresaALaPaginaExito(String url) {
        OnStage.theActorCalled("Actor").wasAbleTo(Open.url(url));
    }

    @Cuando("selecciona la categoria y subcategoria")
    public void seleccionaLaCategoriaYSubcategoria(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarCatYSub.seleccionarDatos(DataExitoLoombokData.setData(table).get(0))
        );
    }

    @Entonces("selecciona productos aleatoriamente")
    public void seleccionaProductosAleatoriamente() {
       OnStage.theActorInTheSpotlight().attemptsTo(
               SeleccionarProductos.deWeb()
       );
    }

    @Entonces("realiza validaciones de los productos agregados")
    public void realizaValidacionesDeLosProductosAgregados() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ValidarSelecciones.EnCarrito()
        );
    }

    @Entonces("valida la cantidad de productos")
    public void validaLaCantidadDeProductos() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarCantidadElement.registros(), Matchers.is(true)));
    }

}
