package by.nikita.candies.entity;

import java.time.Year;

public abstract class AbstractCandy {
    private String title;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCandyId() {
        return candyId;
    }

    public void setCandyId(String candyId) {
        this.candyId = candyId;
    }

    public void setTitleId(String candyTitle) {
        this.title = candyTitle;
    }

    public String getCandyName() {
        return name;
    }

    public void setCandyName(String name) {
        this.name = name;
    }

    public Year getCandyYear() {
        return year;
    }

    public void setCandyYear(Year year) {
        this.year = year;
    }

    public int getCandyEnergy() {
        return energy;
    }

    public void setCandyEnergy(int energy) {
        this.energy = energy;
    }

    public String getCandyType() {
        return type;
    }

    public void setCandyType(String type) {
        this.type = type;
    }

    public CandyIngredients getCandyIngredients() {
        return candyIngredients;
    }

    public void setCandyIngredients(CandyIngredients candyIngredients) {
        this.candyIngredients = candyIngredients;
    }

    public CandyValue getCandyValue() {
        return candyValue;
    }

    public void setCandyValue(CandyValue candyValue) {
        this.candyValue = candyValue;
    }

    public String getCandyProduction() {
        return production;
    }

    public void setCandyProduction(String production) {
        this.production = production;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractCandy that = (AbstractCandy) o;

        if (energy != that.energy) return false;
        if (candyId != null ? !candyId.equals(that.candyId) : that.candyId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (candyIngredients != null ? !candyIngredients.equals(that.candyIngredients) : that.candyIngredients != null)
            return false;
        if (candyValue != null ? !candyValue.equals(that.candyValue) : that.candyValue != null) return false;
        return production != null ? production.equals(that.production) : that.production == null;
    }

    @Override
    public int hashCode() {
        int result = candyId != null ? candyId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + energy;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (candyIngredients != null ? candyIngredients.hashCode() : 0);
        result = 31 * result + (candyValue != null ? candyValue.hashCode() : 0);
        result = 31 * result + (production != null ? production.hashCode() : 0);
        return result;
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
