import java.awt.*;
import javax.swing.JPanel;

/*
 * This class handles the drawing of the maze.
 */
class MazePanel extends JPanel {
    Maze maze;
    Solver solver;
    Font font;
    
    MazePanel(Maze newMaze, Solver newSolver) {
        maze = newMaze;
        solver = newSolver;
        font = new Font("Serif",Font.BOLD,14);
        setBackground(Color.WHITE);
    }
    
    public void paintComponent(Graphics g) {
        // Redraw the background
        super.paintComponent(g);
        
        // Use anti-aliasing to make text look a bit nicer
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(font);
        
        // Draw each cell
        for(int x = 0; x < maze.width; x++) {
            for(int y = 0; y < maze.height; y++) {
                maze.cellAt(x,y).draw(
                    g,
                    x*GridCell.pixelWidth,
                    y*GridCell.pixelWidth
                );
            }
        }
        
        // Draw the solver
        solver.draw(
            g,
            solver.x*GridCell.pixelWidth,
            solver.y*GridCell.pixelWidth
        );
    }
}