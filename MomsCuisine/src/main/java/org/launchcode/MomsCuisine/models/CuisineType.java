package org.launchcode.MomsCuisine.models;

public enum CuisineType {

    AMERICAN("American"),
    MEXICAN("Mexican"),
    ITALIAN("Italian"),
    THAI("Thai"),
    INDIAN("Indian"),
    JAPANESE("Japanese"),
    KOREAN("Korean"),
    OTHER("Other");

    private final String displayCuisine;

    CuisineType(String displayCuisine) {
        this.displayCuisine = displayCuisine;
    }

    public String getDisplayCuisine() {
        return displayCuisine;
    }
}
