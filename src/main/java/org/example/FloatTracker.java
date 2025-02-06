package org.example;

import java.util.ArrayList;
import java.util.List;

public class FloatTracker implements  Trackable {
    private Double min;
    private Double max;
    private Double sum = 0.0;
    private final List<String> elements = new ArrayList<>();

    @Override
    public void add(String stringValue) {
        elements.add(stringValue);
        double doubleValue = Double.parseDouble(stringValue);
        if (min == null || doubleValue < min) {
            min = doubleValue;
        }
        if (max == null || doubleValue > max) {
            max = doubleValue;
        }
        sum += doubleValue;
    }

    @Override
    public List<String> getElements() {
        return elements;
    }

    @Override
    public String getMin() {
        return min.toString();
    }

    @Override
    public String getMax() {
        return max.toString();
    }

    @Override
    public String getSum() {
        return sum.toString();
    }
}
