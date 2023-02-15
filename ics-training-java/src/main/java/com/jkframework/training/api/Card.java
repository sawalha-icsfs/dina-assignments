package com.jkframework.training.api;

public class Card {

    private int number;
    private CardType type;

    public Card() {
    }

    public Card(int cardNum, CardType cdType) {
        this.number = cardNum;
        this.type = cdType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Card [number=");
        builder.append(number);
        builder.append(", type=");
        builder.append(type);
        builder.append("]");
        return builder.toString();
    }

}
