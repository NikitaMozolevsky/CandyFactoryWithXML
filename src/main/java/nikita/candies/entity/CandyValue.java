package nikita.candies.entity;

import java.util.Objects;

public class CandyValue {
    private double protein;
    private double fat;
    private double carbohydrate;

    public CandyValue() {
    }

    public CandyValue(double protein, double fat, double carbohydrate) {
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandyValue that = (CandyValue) o;
        return Double.compare(that.protein, protein) == 0 &&
                Double.compare(that.fat, fat) == 0 &&
                Double.compare(that.carbohydrate, carbohydrate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(protein, fat, carbohydrate);
    }
}
