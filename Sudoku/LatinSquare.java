import java.util.*;
import java.lang.*;
public class LatinSquare
{
    public int size;
    private int[][] known;
    private int[][] possible;
    
    LatinSquare(int newSize){
       size = newSize;
       int mask;
       
       //Fill Known with 0
       this.known = new int[size][size];
       for (int[] row:known){
           Arrays.fill(row, 0);
        }
        
        //Set length of possible
        mask = (1<<size) - 1; // doesnt work for grid of 32
        if(size == 32){mask = ~ 0;}
        
        /*
        for (int s = 0; s < size; s ++){
            mask |= (1<<5);
        }*/
       
        //Fill possible with 1 of the correct length
       this.possible = new int[size][size];
       for (int[] row:possible){
           Arrays.fill(row, mask);//convert string to int
        }
    }
    
    static int symbolToPossibility(int symbol){
        return 1 <<(symbol-1);
    }
    
    static int possibilityToSymbol(int x){
        if (x == 0){return 0;}
        return Integer.numberOfTrailingZeros(x) + 1;
        
        
    }
    
    public int symbolAt(int x, int y){
        return known[x][y];
    }
    
    public boolean isKnown(int x, int y){
        return symbolAt(x,y) !=0;
    }
   
    public void print(){
    
        for (int x = 0; x < size; x ++){
            for(int y = 0; y < size; y++){
                
                if (isKnown(x,y)){
                System.out.print("[ ]");
                }else{
                System.out.print("[.]");
                }
                
            }
            System.out.print("\n");
        }
    
    }
    
    public boolean isPossible(int symbol, int x, int y){

        int p = possible[x][y];
        return (p & ~ symbolToPossibility(symbol)) != 0;
      
    }
    
    public void markImpossible(int symbol, int x, int y){
        if (!isKnown(x,y)){
            possible[x][y] &= ~symbolToPossibility(symbol);
        }
    }
    
    public int numberOfPossibilities(int x, int y){
        /*
        int count =0;
        
        for (int i = 0; i < size; i++){
        
            if(isPossible(i,x,y)){
                count++;
            }
        
        }
        
       return count;*/
       
       return Integer.bitCount(possible[x][y]);
       
       
       
    }
    
    public void insertSymbol(int x, int y, int s){
        if(isKnown(x,y)){
            throw new IllegalArgumentException("Tried to insert " + x + "," + y + " but" + " the symbol " + symbolAt(x,y) + "was already there");
        }
        known[x][y] = s;
        for (int i = 0; i < size; i++){
            if(i != x) {markImpossible(s,i,y);}
            if(i != y) {markImpossible(s,x,i);}
        }
    }
    
}
