import java.awt.*;

// An empty space in the grid
class GridCellEmpty extends GridCell {
    GridCellEmpty() { passable = true; }
    
    String symbol() {
        if(breadcrumbs == 0) {
            return " ";
        } else if(breadcrumbs == 1) {
            return ".";
        } else {
            return ":";
        }
    }
    
    void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.drawString(symbol(),x+4,y+pixelWidth-4);
    }
}