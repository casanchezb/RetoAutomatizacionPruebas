package com.co.exito.utils;

public class LimpiarNumero {
    String Texto;
    public LimpiarNumero(String texto) {
        Texto = texto;
    }
    public static String LimpiarNumero(String Texto) {
        String[] arreglo = Texto.split("\\$");
        String l = arreglo[1];
        String k = l.replaceAll(" ", "");
        String f = k.replaceAll("\\.", ".");

        return f;
    }
    public static String LimpiarNumeroDecimal(String Texto) {
        String arreglar = Texto.replaceAll("\\.",".");

        return arreglar.substring(0,arreglar.length()-1);
    }

}


