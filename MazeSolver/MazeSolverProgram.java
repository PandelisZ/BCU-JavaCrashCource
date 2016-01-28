import java.awt.*;
import javax.swing.*;
import java.io.*;

/*
 * This is the class with the main method for the program.
 * A maze is loaded from a text file, then it is either solved
 * by a human (using the keyboard) or by a maze solving algorithm.
 * 
 * Keyboard controls:
 * - UP/DOWN/LEFT/RIGHT to move.
 * - SPACE to drop a breadcrumb.
 * - R to resign.
 */
class MazeSolverProgram {
    static JFrame window = null;
    static Maze maze = null;
    static Solver solver = null;
    static MazePanel panel = null;
    
    public static void main(String[] args) {
        // Create a new window
        window = new JFrame("Maze Solver");
        
        // Choose a text file to load the maze from
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("mazes/"));
        if (fc.showOpenDialog(window) != JFileChooser.APPROVE_OPTION) {
            System.out.println("Open command cancelled by user.");
            System.exit(0);
        }
        String filename = fc.getSelectedFile().getPath();
        System.out.println("Opening: " + filename);
        
        // Load the maze from the text file
        try {
            maze = new Maze(filename);
        } catch(FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        } catch(IOException e) {
            System.out.println("Error reading file.");
            System.exit(0);
        }
        
        // Choose the solver
        solver = new HumanSolver(maze);
        // Create the panel
        panel = new MazePanel(maze,solver);
        
        // If it's a HumanSolver, we need to attach the KeyEventListener
        if(solver instanceof HumanSolver) {
            HumanSolver.attach((HumanSolver) solver, panel);
        }

        // Set up the panel and window with the correct size
        panel.setPreferredSize(new Dimension(
            maze.width*GridCell.pixelWidth, maze.height*GridCell.pixelWidth
        ));
        window.setContentPane(panel);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(120,70);
        window.setVisible(true);
        
        // Show the initial setup for 1 second
        wait(1000);

        // Keep going until the solver arrives at the end of the maze
        while(! (maze.cellAt(solver.x, solver.y) instanceof GridCellEnd)) {
            // Ask the solver what move to make
            Move move = solver.move();
            // If they resigned, exit the program.
            if(move instanceof MoveResign) {
                System.out.println("Resigned.");
                System.exit(0);
            }
            // If they made a move, perform that move
            if(move != null) { move.run(maze, solver); }
            // Redraw the maze
            panel.repaint();
            // Wait a bit so the user can see how the solving algorithm does
            wait(100);
        }
        System.out.println("Success!");
        
        // After the loop, the maze is solved - let the user see for a second, then exit
        wait(1000);
        System.exit(0);
    }
    
    // Pause the program for a number of milliseconds
    static void wait(int ms) {
        try { new Thread().sleep(ms); } catch(InterruptedException e) {}
    }
}
