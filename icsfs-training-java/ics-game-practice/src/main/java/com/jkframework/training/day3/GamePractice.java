package com.jkframework.training.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.jkframework.training.api.Card;
import com.jkframework.training.api.CardType;
import com.jkframework.training.api.Game;
import com.jkframework.training.api.Player;

public class GamePractice {

    Card[] card = new Card[13];
    Game game = new Game();
    Scanner scanner = new Scanner(System.in);
    private static int numberOfPlayers = 4;
    public Player[] players = new Player[numberOfPlayers];
    public static List<Card> cardList = new ArrayList<Card>();
    Player player = new Player();

    public void playGame() {

        System.out.println("enter your Game Name : ");
        final String inputGameName = scanner.nextLine(); // input Game Name from user
        System.out.println("entered Game Name is : " + inputGameName);
        game.setName(inputGameName);
        System.out.println("enter your Players Name : ");

        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player(scanner.nextLine());// input Player Name from user
            player.setName(players[i].getName());
        }
        for (int i = 0; i < players.length; i++) {
            System.out.println("entered Player Name number " + (i + 1) + " : " + players[i].getName());
        }
        // Stream<Card> stream = Arrays.stream(card);
        // stream.forEach(str -> System.out.print(str + " "));

    }

    public List<Card> shuffle() {

        for (CardType types : CardType.values()) {

            for (int i = 1; i < 14; i++) {
                Card card = new Card();
                card.setNumber(i);
                card.setType(types);
                cardList.add(card);
            }

        }
        System.out.println("Cards Before Shuffling -->> " + cardList);

        Collections.shuffle(cardList);
        System.out.println("Cards after Shuffling " + cardList);

        return cardList;

    }

    public Player[] distribute() {

        for (int i = 0; i < 4; i++) {
            List<Player> p = new ArrayList<Player>();
            List<Card> cards = new ArrayList<Card>();
            for (int j = 0; j < 13; j++) {
                cards.add(cardList.get(0));
                cardList.remove(0);
                player.setName(players[i].getName());
                player.setScore(i);
                player.setCards(cards);

            }
            p.add(player);
            player.setCards(cards);
            game.setPlayers(p);

            System.out.println("Game Name is : " + game.getName() + " - Player is : " + game.getPlayers());
        }
        // System.out.println("player " + player);
        return players;

    }

    public static void main(String[] args) {
        GamePractice gamePractice = new GamePractice();
        gamePractice.playGame();
        gamePractice.shuffle();
        gamePractice.distribute();
    }
}
