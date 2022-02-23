package by.nikita.candies.entity;

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

        if (Double.compare(that.protein, protein) != 0) return false;
        if (Double.compare(that.fat, fat) != 0) return false;
        return Double.compare(that.carbohydrate, carbohydrate) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(protein);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(carbohydrate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CandyValue{");
        sb.append("protein=").append(protein);
        sb.append(", fat=").append(fat);
        sb.append(", carbohydrate=").append(carbohydrate);
        sb.append('}');
        return sb.toString();
    }
}


