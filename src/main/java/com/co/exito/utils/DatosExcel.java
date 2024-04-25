package com.co.exito.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class DatosExcel {

    private static HSSFWorkbook book;
    private static FileInputStream file;

    public String leerDatoExcel(String hoja, String ruta, int rowValue, int cellValue) throws IOException {

        String valor = null;
        file = new FileInputStream(new File(ruta));
        book = new HSSFWorkbook(file);
        Sheet sheet = book.getSheet(hoja);
        Row row = sheet.getRow(rowValue);
        Cell cell = row.getCell(cellValue);
        switch (cell.getCellType()){
            case STRING:
                valor = cell.getStringCellValue();
                break;
            case NUMERIC:
                String valor1 = String.valueOf(cell.getNumericCellValue());
                valor = LimpiarNumero.LimpiarNumeroDecimal(valor1);
                break;
        }
        book.close();
        file.close();
        return valor;
    }

}
