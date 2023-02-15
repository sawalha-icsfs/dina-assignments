package com.jkframework.training.api;

import java.util.List;
import java.util.Objects;

public class Player {

    private String name;
    private int score;
    private List<Card> cards;

    public Player(String playerName, List<Card> cd) {
        this.name = playerName;
        this.cards = cd;

    }

    public Player(String playerName) {
        this.name = playerName;

    }

    public Player() {
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Player [name=");
        builder.append(name);
        builder.append(", score=");
        builder.append(score);
        builder.append(", cards=");
        builder.append(cards);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards, name, score);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Player other = (Player) obj;
        return Objects.equals(cards, other.cards) && Objects.equals(name, other.name) && score == other.score;
    }

}
