import se.lth.cs.ptdc.cardGames.*;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Lay123.main(1000000);
    }
}

class CardDeck {
    private Card[] cards;
    private int current;
    private static Random rand;

    public CardDeck() {
        cards = new Card[52];
        rand = new Random();
        int i = 0;
        for (int suit=Card.SPADES; suit <= Card.CLUBS; suit++) {
            for (int rank=1; rank<14; rank++) {
                cards[i] = new Card(suit, rank);
                i += 1;
            }
        }
        current = 0;
    }

    public Card getCard() {
        current++;
        return cards[current-1];
    }

    public boolean moreCards() {
        return ((current > 51) ? false : true);
    }

    public void shuffle() {
        for (int i=0; i<52; i++) {
            switchPlaces(i, rand.nextInt(52));
        }
    }

    public void switchPlaces(int i1, int i2) {
        Card temp = cards[i1];
        cards[i1] = cards[i2];
        cards[i2] = temp;
    }

}

class Lay123 {
    public static void main(int total) {
        int successes = 0;
        int failures = 0;
        for(int i=0; i<total; i++) {
            if (tryDeck()) {
                successes++;
            } else {
                failures++;
            }
        }
        System.out.println("Successed: " + successes +
                "\nFailures: " + failures +
                "\nRatio: " + (double)successes/total);
    }

    public static boolean tryDeck () {
        CardDeck deck = new CardDeck();
        deck.shuffle();
        int n = 1;
        while (deck.moreCards()) {
            Card c = deck.getCard();
            if (n == c.getRank()) {
                return false;
            } else {
                //System.out.println("n: " + n + "   crank: " + c.getRank());
            }
            n++;
            if (n > 3) {
                n = 1;
            }
        }
        return true;
    }
}