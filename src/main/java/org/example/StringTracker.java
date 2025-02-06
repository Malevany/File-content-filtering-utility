package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringTracker implements Trackable{
    private String min;
    private String max;
    private final List<String> elements = new ArrayList<String>();

    @Override
    public void add(String value) {
        elements.add(value);
        if (min == null || value.length() < min.length()) {
            min = value;
        }
        if (max == null || value.length() > max.length()) {
            max = value;
        }
    }

    @Override
    public List<String> getElements() {
        return elements;
    }

    @Override
    public String getMin() {
        return min;
    }

    @Override
    public String getMax() {
        return max;
    }

    @Override
    public String getSum() {
        return "";
    }
}
