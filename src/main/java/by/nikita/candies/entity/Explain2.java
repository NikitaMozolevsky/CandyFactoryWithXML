package by.nikita.candies.entity;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Explain2 {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder("123");

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Explain2 explain2 = (Explain2) o;

        return stringBuilder != null ? stringBuilder.equals(explain2.stringBuilder) : explain2.stringBuilder == null;
    }

    @Override
    public int hashCode() {
        return stringBuilder != null ? stringBuilder.hashCode() : 0;
    }
}
