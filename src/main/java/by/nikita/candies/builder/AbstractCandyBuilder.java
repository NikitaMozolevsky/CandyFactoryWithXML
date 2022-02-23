package by.nikita.candies.builder;

import by.nikita.candies.entity.AbstractCandy;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractCandyBuilder {
    public static final String CANDIES = "candies";
    public static final String CANDY_ID = "candy_id";
    public static final String NAME = "name";
    public static final String YEAR = "year";
    public static final String ENERGY = "energy";
    public static final String TYPE = "type";
    public static final String INGREDIENTS = "ingredients";
    public static final String WATER = "water";
    public static final String SUGAR = "sugar";
    public static final String FRUCTOSE = "fructose";
    public static final String CHOCOLATE_TYPE = "chocolate_type";
    public static final String VANILLA = "vanilla";
    public static final String VALUE = "value";
    public static final String PROTEIN = "protein";
    public static final String FAT = "fat";
    public static final String CARBOHYDRATE = "carbohydrate";
    public static final String PRODUCTION = "production";
    public static final String IMPORTED_CANDY = "imported_candy";
    public static final String DOMESTIC_CANDY = "domestic_candy";
    public static final String IMPORTED_CANDY_PROPERTIES = "imported_candy_properties";
    public static final String DOMESTIC_CANDY_PROPERTIES = "domestic_candy_properties";
    public static final String TITLE = "title";


    protected Set<AbstractCandy> candySet;
    /*protected CustomFileUtil customFileUtil;*/

    protected AbstractCandyBuilder() {
        candySet = new HashSet<>();
    }

    protected AbstractCandyBuilder(Set<AbstractCandy> candies) {
        this.candySet = new HashSet<>(candies);
    }

    public Set<AbstractCandy> getCandies() {
        return new HashSet<>(candySet);
    }

    public abstract void buildCandies(String fileName) throws /*CustomException, JAXBException,*/ FileNotFoundException;
}
