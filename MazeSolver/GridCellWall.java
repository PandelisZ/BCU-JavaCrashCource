import java.awt.*;

// An impassable wall
class GridCellWall extends GridCell {
    String symbol;
    
    GridCellWall(String newSymbol) {
        passable = false;
        symbol = newSymbol;
    }
    GridCellWall() { this("X"); }
    
    String symbol() { return symbol; }
    
    void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x,y,pixelWidth,pixelWidth);
    }
}