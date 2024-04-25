package com.co.exito.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaExitoObjetos {
    public static Target getSubCategory(String subcategory) {
        return Target.the("subcategoria boton").located(By.xpath("//a[contains(text(),'" + subcategory + "')]"));
    }
    public static final Target BTN_MENU = Target.the("opcion de menu")
            .located(By.xpath("//button[@aria-label='Collapse menu']"));
    public static final Target CONTENEDOR_SELECCIONAR_CATEGORIA = Target.the("contenedor para seleccionar categoria")
            .located(By.xpath("//*[@id='__next']/header/aside/ul/section[2]/div"));
    public static final Target TXT_ELEMENTO = Target.the("elemento para esperar titulo subcategoria")
            .locatedBy("(//*[contains(text(), 'Cabeceros')])[8]");
    public static final Target BTN_PRODUCTOS = Target.the("lista de botones")
            .locatedBy("//div/button[@class='DefaultStyle_default__vCozi ']");
    public static final Target TXT_NOMBRE_PRODUCTO = Target.the("nombre producto")
            .locatedBy("//h3[@data-fs-product-card-title='true']/a");
    public static final Target TXT_PRECIO_PRODUCTO = Target.the("precio producto")
            .locatedBy("//div[@data-fs-container-price-otros-geral='true']/p[@data-fs-container-price-otros='true']");

    public static final Target BTN_CARRITO_COMPRAS = Target.the("buton para ir a carrito")
            .locatedBy("//span[@data-fs-cart-title='true']");

    public static final Target LBL_TITULO = Target.the("elemento para scroll")
            .locatedBy("//h1[@data-fs-title-seo='true' and text()='Cabeceros de cama']");

    public static final Target LBL_TOTAL = Target.the("total de carrito")
            .locatedBy("//span[@data-molecule-summary-item-value='true']");

    public static final Target CONTENEDOR_DE_PRODUCTOS = Target.the("Contenedor de productos en el carrito")
            .locatedBy("//div[@class='exito-checkout-io-0-x-itemCartContent']");

}
