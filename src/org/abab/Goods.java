package org.abab;

public class Goods {
    public final String name;
    public final int quantity;

    public Goods(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return quantity + " " + name;
    }

    public Goods add() {
        return new Goods(name, quantity + 1);
    }
}
