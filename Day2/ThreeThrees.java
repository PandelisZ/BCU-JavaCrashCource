class ThreeThrees extends HandRank {
    String name() {return "Three Threes";}
    int numericRank() {return 6;}
    
    ThreeThrees(Hand newHand) { super(newHand); }
}