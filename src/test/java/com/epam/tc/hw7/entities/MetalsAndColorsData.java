package com.epam.tc.hw7.entities;

import com.epam.jdi.tools.DataClass;
import java.util.List;

public class MetalsAndColorsData extends DataClass<MetalsAndColorsData> {

    private List<String> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public List<String> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }
}
