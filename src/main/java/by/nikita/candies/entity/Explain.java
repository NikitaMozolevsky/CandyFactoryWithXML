package by.nikita.candies.entity;

public class Explain {
    public String string = "1";
    private Package aPackage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Explain explain = (Explain) o;

        return string != null ? string.equals(explain.string) : explain.string == null;
    }

    @Override
    public int hashCode() {
        return string != null ? string.hashCode() : 0;
    }
}
