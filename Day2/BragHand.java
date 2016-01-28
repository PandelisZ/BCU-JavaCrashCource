import java.util.*;
public class BragHand
{
   Card[] cards;

   BragHand(Card[] newCards){
       cards = newCards;
       if(cards.length != 3){
           throw new IllegalArgumentException("3 Cards are required");
        }
        
        Arrays.sort(cards);
    }
    
    public void print(){
        System.out.println(cards[0] + " " + cards[1] + " " + cards[2] );
    }
}
