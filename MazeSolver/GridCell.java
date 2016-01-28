import java.awt.Graphics;

/*
 * A GridCell is one space in the grid. Typically it will either be
 * a wall or a passable empty space. Cells can also contain breadcrumbs,
 * which Solvers can use to record where they have been.
 */
abstract class GridCell {
    // Global constant: each cell is drawn this many pixels wide
    static final int pixelWidth = 20;
    
    boolean passable;
    int breadcrumbs = 0;
    
    void dropBreadcrumbs(int newBreadcrumbs) { breadcrumbs += newBreadcrumbs; }
    
    // Each type of GridCell should be drawn in a different way
    abstract void draw(Graphics g, int x, int y);
}