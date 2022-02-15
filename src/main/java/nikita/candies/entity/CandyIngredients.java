package nikita.candies.entity;

import java.util.Objects;

public class CandyIngredients {
    private int water;
    private int sugar;
    private int fructose;
    private String chocolateType;
    private int vanilla;

    public CandyIngredients() {
    }

    public CandyIngredients(int water, int sugar, int fructose, String chocolateType, int vanilla) {
        this.water = water;
        this.sugar = sugar;
        this.fructose = fructose;
        this.chocolateType = chocolateType;
        this.vanilla = vanilla;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getFructose() {
        return fructose;
    }

    public void setFructose(int fructose) {
        this.fructose = fructose;
    }

    public String getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(String chocolateType) {
        this.chocolateType = chocolateType;
    }

    public int getVanilla() {
        return vanilla;
    }

    public void setVanilla(int vanilla) {
        this.vanilla = vanilla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandyIngredients that = (CandyIngredients) o;
        return water == that.water && sugar == that.sugar && fructose == that.fructose && vanilla == that.vanilla && Objects.equals(chocolateType, that.chocolateType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(water, sugar, fructose, chocolateType, vanilla);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CandyIngredients{");
        sb.append("water=").append(water);
        sb.append(", sugar=").append(sugar);
        sb.append(", fructose=").append(fructose);
        sb.append(", chocolateType='").append(chocolateType).append('\'');
        sb.append(", vanilla=").append(vanilla);
        sb.append('}');
        return sb.toString();
    }
}
