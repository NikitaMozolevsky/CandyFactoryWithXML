package by.nikita.candies.entity;

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

        if (water != that.water) return false;
        if (sugar != that.sugar) return false;
        if (fructose != that.fructose) return false;
        if (vanilla != that.vanilla) return false;
        return chocolateType != null ? chocolateType.equals(that.chocolateType) : that.chocolateType == null;
    }

    @Override
    public int hashCode() {
        int result = water;
        result = 31 * result + sugar;
        result = 31 * result + fructose;
        result = 31 * result + (chocolateType != null ? chocolateType.hashCode() : 0);
        result = 31 * result + vanilla;
        return result;
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
