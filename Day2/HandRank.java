public abstract class HandRank
{
    BragHand hand;
    abstract public String name();
    abstract public int numericRank();
    abstract public boolean isValid();
    
    public HandRank(BragHand newHand){
        hand = newHand;
    };
}

class ThreeThrees extends HandRank {
    public String name() {return "Three Threes";}
    public int numericRank() {return 6;}
    
    public ThreeThrees(BragHand newHand) { super(newHand); }
    
    public boolean isValid(){
        return hand.cards[0].rank == 3
            && hand.cards[1].rank == 3
            && hand.cards[2].rank == 3;
    }
}

class ThreeOfAKind extends HandRank {
    public String name() {return "Three of a kind";}
    public int numericRank() {return 5;}
    
   public ThreeOfAKind(BragHand newHand) {super(newHand);}
   
   public boolean isValid(){
        return hand.cards[0].rank == hand.cards[1].rank 
            && hand.cards[1].rank == hand.cards[2].rank;
    }
   
}

class StraightFlush extends HandRank {
   public String name() {return "Straight Flush";}
   public int numericRank() {return 4;}
    
  public StraightFlush(BragHand newHand) {super(newHand);}
   
   public boolean isValid(){
        return hand.cards[1].rank == hand.cards[0].rank + 1
            && hand.cards[2].rank == hand.cards[1].rank + 1
            && hand.cards[0].suit == hand.cards[1].suit
            && hand.cards[1].suit == hand.cards[2].suit;
    }
   
}

class Straight extends HandRank {
   public String name() {return "Straight";}
   public int numericRank() {return 3;}
    
   public Straight(BragHand newHand) {super(newHand);}
   
   public boolean isValid(){
        return hand.cards[1].rank == hand.cards[0].rank + 1
            && hand.cards[2].rank == hand.cards[1].rank + 1;
    }
   
}

class Flush extends HandRank {
   public String name() {return "Flush";}
   public int numericRank() {return 2;}
    
   public Flush(BragHand newHand) {super(newHand);}
   
   public boolean isValid(){
        return hand.cards[0].suit == hand.cards[1].suit
            && hand.cards[1].suit == hand.cards[2].suit;
    }
   
}

class Pair extends HandRank {
   public String name() {return "Pair";}
   public int numericRank() {return 1;}
    
   public Pair(BragHand newHand) {super(newHand);}
   
   public boolean isValid(){
        return hand.cards[0].rank == hand.cards[1].rank
            || hand.cards[1].rank == hand.cards[2].rank;
    }
   
}
