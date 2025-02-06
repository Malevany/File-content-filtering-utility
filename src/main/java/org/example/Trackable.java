package org.example;

import java.util.List;

public interface Trackable {
    void add(String value);
    List<String> getElements();
    String getMin();
    String getMax();
    String getSum();
}
