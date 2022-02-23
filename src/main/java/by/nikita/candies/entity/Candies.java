package by.nikita.candies.entity;

import java.util.ArrayList;

public class Candies {
    private ArrayList<AbstractCandy> list = new ArrayList<AbstractCandy>();

    public Candies() {
        super();
    }

    public void setCandyList(ArrayList<AbstractCandy> list) {
        this.list = list;
    }

    public boolean addCandy(AbstractCandy st) {
        return list.add(st);
    }

    @Override
    public String toString() {
        return "Students [list=" + list + "]";
    }
}
