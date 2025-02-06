package org.example;

import java.util.ArrayList;
import java.util.List;

public class IntegerTracker implements Trackable {
    private Long min;
    private Long max;
    private Long sum = 0L;
    private final List<String> elements = new ArrayList<>();

    @Override
    public void add(String stringValue) {
        elements.add(stringValue);
        long longValue = Long.parseLong(stringValue);
        if (min == null || longValue < min) {
            min = longValue;
        }
        if (max == null || longValue > max) {
            max = longValue;
        }
        sum += longValue;
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
