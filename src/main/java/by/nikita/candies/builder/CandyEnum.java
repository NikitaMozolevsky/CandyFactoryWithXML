package by.nikita.candies.builder;

public enum CandyEnum {
    CANDIES("candies"),
    CANDY_ID("login"),
    NAME("name"),
    YEAR("faculty"),
    ENERGY("energy"),
    TYPE("type"),
    INGREDIENTS("ingredients"),
    WATER("water"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
    CHOCOLATE_TYPE("chocolate_type"),
    VANILLA("vanilla"),
    VALUE("value"),
    PROTEIN("protein"),
    FAT("fat"),
    CARBOHYDRATE("carbohydrate"),
    PRODUCTION("production"),
    IMPORTED_CANDY("imported_candy"),
    DOMESTIC_CANDY("domestic_candy"),
    IMPORTED_CANDY_PROPERTIES("imported_candy_properties"),
    DOMESTIC_CANDY_PROPERTIES("domestic_candy_properties"),
    TITLE("title"),
    TITLE_BY_DEFAULT("title_by_default");

    CandyEnum(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
