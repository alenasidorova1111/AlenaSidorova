package com.epam.tc.hw7.utils;

import com.epam.tc.hw7.entities.MetalsAndColorsData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class JsonDataParser {

    public static Object[][] jsonMetalsAndColorsParser(String path) throws IOException {
        Object[][] dataObject;
        Gson g = new Gson();
        Type type = new TypeToken<Map<String, MetalsAndColorsData>>() {
        }.getType();
        Map<String, MetalsAndColorsData> myMap = g.fromJson(new JsonReader(new FileReader(path)), type);
        int i = 0;
        dataObject = new Object[myMap.size()][1];
        for (Map.Entry<String, MetalsAndColorsData> entry : myMap.entrySet()) {
            dataObject[i][0] = entry.getValue();
            i++;
        }
        return dataObject;
    }
}
