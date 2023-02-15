package com.jkframework.training.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {

    private String name;
    private List<Player> players = new ArrayList<Player>();

    public Game() {
    }

    public Game(String gameName, List<Player> player) {

        this.name = gameName;
        this.players = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Game [name=");
        builder.append(name);
        builder.append(", players=");
        builder.append(players);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, players);
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
        Game other = (Game) obj;
        return Objects.equals(name, other.name) && Objects.equals(players, other.players);
    }

}
