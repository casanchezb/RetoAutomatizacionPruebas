package com.co.exito.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class DataExitoLoombokData {
    String url;
    String categoria;
    String subcategoria;

    public static List<DataExitoLoombokData> setData(DataTable dataTable) {
        List<DataExitoLoombokData> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, DataExitoLoombokData.class));
        }
        return dates;
    }
}
