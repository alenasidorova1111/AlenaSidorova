package com.epam.tc.hw7.entities;

import static java.lang.String.format;
import static java.lang.String.join;

import com.epam.jdi.tools.DataClass;
import java.util.ArrayList;
import java.util.List;

public class MetalsAndColorsData extends DataClass<MetalsAndColorsData> {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public List<Integer> getSummary() {
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

    public List<String> getExpectedResultFromMetalsAndColorsData(MetalsAndColorsData data) {
        List<String> expectedResult = new ArrayList<>();

        expectedResult.add(format("Summary: %s", (
            data.getSummary().get(0) + data.getSummary().get(1))));
        expectedResult.add(format("Elements: %s", join(", ", data.getElements())));
        expectedResult.add(format("Color: %s", data.getColor()));
        expectedResult.add(format("Metal: %s", data.getMetals()));
        expectedResult.add(format("Vegetables: %s", join(", ", data.getVegetables())));

        return expectedResult;
    }
}
