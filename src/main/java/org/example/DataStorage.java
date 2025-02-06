package org.example;

public class DataStorage {
    private final Trackable stringTracker;
    private final Trackable integerTracker;
    private final Trackable floatTracker;

    public DataStorage(Trackable stringTracker, Trackable integerTracker, Trackable floatTracker) {
        this.stringTracker = stringTracker;
        this.integerTracker = integerTracker;
        this.floatTracker = floatTracker;
    }

    public void add(String value) {
        if (Parser.isInteger(value)) {
            integerTracker.add(value);
        } else if (Parser.isFloat(value)) {
            floatTracker.add(value);
        } else {
            stringTracker.add(value);
        }
    }
    public Trackable getStringTracker() {
        return stringTracker;
    }
    public Trackable getIntegerTracker() {
        return integerTracker;
    }
    public Trackable getFloatTracker() {
        return floatTracker;
    }
}
