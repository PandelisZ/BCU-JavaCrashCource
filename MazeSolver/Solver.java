import java.awt.*;

/*
 * A Solver is an object with a move() method; a maze is solved
 * by repeatedly calling move() to decide which move to make in
 * the maze. Different solvers have different ways of deciding
 * which move to make.
 */
abstract class Solver {
    int x,y;
    Maze maze;
    
    Solver(Maze newMaze) {
        maze = newMaze;
        x = maze.startX;
        y = maze.startY;
    }
    
    String symbol() { return "@"; }
    
    abstract Move move();
    
    // Draw the solver onto the panel
    void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.drawString(symbol(), x + 4, y + GridCell.pixelWidth - 4);
    }
}