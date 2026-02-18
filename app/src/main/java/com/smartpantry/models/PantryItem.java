package com.smartpantry.models;

public class PantryItem {
    private final String name;
    private final int quantity;
    private final String unit;
    private final String location;

    public PantryItem(String name, int quantity, String unit, String location) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public String getLocation() {
        return location;
    }

    public String getSubtitle() {
        String qty = quantity + (unit == null || unit.trim().isEmpty() ? "" : (" " + unit));
        String loc = (location == null || location.trim().isEmpty()) ? "Pantry" : location;
        return qty + " • " + loc;
    }
}

