package nikita.candies.entity;

import java.util.Objects;

public class DomesticCandy extends AbstractCandy {

    private String domesticCandyProperties;

    public DomesticCandy() {
        super();
    }

    public String getDomesticCandyProperties() {
        return domesticCandyProperties;
    }

    public void setDomesticCandyProperties(String domesticCandyProperties) {
        this.domesticCandyProperties = domesticCandyProperties;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DomesticCandy{");
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
        return Objects.equals(domesticCandyProperties, that.domesticCandyProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), domesticCandyProperties);
    }
}
