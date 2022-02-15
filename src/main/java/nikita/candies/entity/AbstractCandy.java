package nikita.candies.entity;

import java.time.Year;
import java.util.Objects;

public abstract class AbstractCandy {
    private String candyId;
    private String name;
    private Year year;
    private int energy;
    private String type;
    private CandyIngredients candyIngredients;
    private CandyValue candyValue;
    private String production;

    public AbstractCandy() {
        candyIngredients = new CandyIngredients();
        candyValue = new CandyValue();
    }

    public String getCandyId() {
        return candyId;
    }

    public void setCandyId(String candyId) {
        this.candyId = candyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CandyIngredients getCandyIngredients() {
        return candyIngredients;
    }

    public CandyValue getCandyValue() {
        return candyValue;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public void setCandyIngredients(CandyIngredients candyIngredients) {
        this.candyIngredients = new CandyIngredients(candyIngredients.getWater(), candyIngredients.getSugar(),
                candyIngredients.getFructose(), candyIngredients.getChocolateType(), candyIngredients.getVanilla());
    }

    public void setCandyValue(CandyValue candyValue) {
        this.candyValue = new CandyValue(candyValue.getProtein(), candyValue.getFat(), candyValue.getCarbohydrate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCandy that = (AbstractCandy) o;
        return energy == that.energy && Objects.equals(candyId, that.candyId)
                && Objects.equals(name, that.name)
                && Objects.equals(year, that.year)
                && Objects.equals(type, that.type)
                && Objects.equals(candyIngredients, that.candyIngredients)
                && Objects.equals(candyValue, that.candyValue)
                && Objects.equals(production, that.production);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candyId, name, year, energy, type, candyIngredients, candyValue, production);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AbstractCandy{");
        sb.append("candyId='").append(candyId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", year=").append(year);
        sb.append(", energy=").append(energy);
        sb.append(", type='").append(type).append('\'');
        sb.append(", candyIngredients=").append(candyIngredients);
        sb.append(", candyValue=").append(candyValue);
        sb.append(", production='").append(production).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
