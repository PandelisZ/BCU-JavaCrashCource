public class Card
{
    char suit;
    int rank;
    
    public Card(char suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }
    
    boolean isAce(){
        return this.rank == 14;
    }
    
    @Override
    public String toString(){
        String out;
        String tmp = "";
        
        if(this.rank == 10){
            tmp = "T";
        }else if (this.rank == 11){
            tmp = "J";
        }else if (this.rank == 12){
            tmp = "Q";
        }else if (this.rank == 13){
            tmp = "K";
        }else if (this.rank == 14){
            tmp = "A";
        }else if (this.rank < 10){
            tmp = Integer.toString(this.rank);
        }
        
        out = tmp + this.suit;
        
        return out;
    }
    
    @Override
    public boolean equals(Object other){
        if(other instanceof Card){
            Card otherCard = (Card) other;
            return rank == otherCard.rank && suit == otherCard.suit;
        }else {
            return false;
        }
    }
    
    @Override
    public int hashCode(){
        return rank + 100* (int) suit;
    } 
    
    public int compareTo(Card other){
        if(rank < other.rank){
            return -1;
        }else if(rank == other.rank){
            return 0;
        }else {
            return 1;
        }
    }
    
    
    
}
