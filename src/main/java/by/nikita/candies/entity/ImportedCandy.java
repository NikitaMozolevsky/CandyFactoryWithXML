package by.nikita.candies.entity;

import java.time.Year;

public class ImportedCandy extends AbstractCandy {
    private String importedCandyProperties;

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

        return importedCandyProperties != null ?
                importedCandyProperties.equals(that.importedCandyProperties) :
                that.importedCandyProperties == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (importedCandyProperties != null ? importedCandyProperties.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ImportedCandy{");
        sb.append(super.toString());
        sb.append("importedCandyProperties='").append(importedCandyProperties).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
