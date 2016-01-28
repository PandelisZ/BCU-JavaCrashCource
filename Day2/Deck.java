import java.util.*;
public class Deck
{
    List<Card> cards;
    public Deck(){
        cards = new ArrayList<Card>();
        for(char s : new char[] {'c','d', 's', 'h'}){
           for (int i = 2; i < 15; i++){
                cards.add(new Card(s,i));
           }      
        }
    }
    
    BragHand drawHand(){
        Card[] newCards = new Card[3];
        newCards[0] = cards.remove(0);
        newCards[1] = cards.remove(0);
        newCards[2] = cards.remove(0);
        return new BragHand(newCards);
    }
}
