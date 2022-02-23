package by.nikita.candies.entity;

import java.time.Year;

public class DomesticCandy extends AbstractCandy {

    private String domesticCandyProperties;

    public String getDomesticCandyProperties() {
        return domesticCandyProperties;
    }

    public void setDomesticCandyProperties(String domesticCandyProperties) {
        this.domesticCandyProperties = domesticCandyProperties;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DomesticCandy{");
        sb.append(super.toString());
        sb.append("domesticCandyProperties='").append(domesticCandyProperties).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DomesticCandy that = (DomesticCandy) o;

        return domesticCandyProperties != null
                ? domesticCandyProperties.equals(that.domesticCandyProperties)
                : that.domesticCandyProperties == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (domesticCandyProperties != null ? domesticCandyProperties.hashCode() : 0);
        return result;
    }
}
