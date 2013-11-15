import se.lth.cs.ptdc.cardGames.*;

public class Main {

    public static void main(String[] args) {
        Lay123.main(100000);
    }
}

class CardDeck {
    

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
                break;
            }
            n++;
            if (n > 3) {
                n = 1;
            }
        }
        return (deck.moreCards() ? false : true);
    }
}