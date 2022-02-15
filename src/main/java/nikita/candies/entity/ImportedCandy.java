package nikita.candies.entity;

import java.util.Objects;

public class ImportedCandy extends AbstractCandy {
    private String importedCandyProperties;

    public ImportedCandy() {
        super();
    }

    public String getImportedCandyProperties() {
        return importedCandyProperties;
    }

    public void setImportedCandyProperties(String importedCandyProperties) {
        this.importedCandyProperties = importedCandyProperties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ImportedCandy that = (ImportedCandy) o;
        return Objects.equals(importedCandyProperties, that.importedCandyProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), importedCandyProperties);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ImportedCandy{");
        sb.append("importedCandyProperties='").append(importedCandyProperties).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
