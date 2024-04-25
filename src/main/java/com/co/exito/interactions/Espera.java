package com.co.exito.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class Espera implements Interaction {

    protected int secs;

    public Espera(int secs) {
        this.secs = secs;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(secs * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Espera por(int secs) {
        return Instrumented.instanceOf(Espera.class).withProperties(secs);
    }
}
