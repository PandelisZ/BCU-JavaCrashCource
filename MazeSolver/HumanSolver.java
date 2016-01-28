import java.util.*;
import java.awt.event.*;
import javax.swing.JPanel;

/*
 * A human can try to solve the maze using the keyboard to move.
 */
class HumanSolver extends Solver {
    // Keep a queue of keypresses to handle
    Queue<KeyEvent> eventQueue;
    
    // Attach a KeyListener to the maze panel,
    // so that keypresses can be recorded
    static void attach(HumanSolver solver, JPanel panel) {
        class MazeKeyboardListener implements KeyListener {
            HumanSolver solver;
            MazeKeyboardListener(HumanSolver newSolver) { solver = newSolver; }
            
            // When a key is pressed, add the event to the solver's queue
            public void keyPressed(KeyEvent e) { solver.eventQueue.add(e); }
            
            // These are needed to implement the KeyListener interface,
            // but they don't need to do anything
            public void keyReleased(KeyEvent e) { }
            public void keyTyped(KeyEvent e) { }
        }
        
        // Add one of these listeners to the panel
        panel.addKeyListener(new MazeKeyboardListener(solver));
        // The panel needs to be focusable so that it can receive KeyEvents
        panel.setFocusable(true);
    }
    
    HumanSolver(Maze newMaze) {
        super(newMaze);
        eventQueue = new ArrayDeque<KeyEvent>();
    }
    
    Move move() {
        // If there is no keypress yet, make no move
        if(eventQueue.size() == 0) { return null; }
        
        // Get a key code from the front of the queue
        int key = eventQueue.poll().getKeyCode();
        
        if(key == KeyEvent.VK_UP) {
            return new MoveNorth();
        } else if(key == KeyEvent.VK_LEFT) {
            return new MoveWest();
        } else if(key == KeyEvent.VK_DOWN) {
            return new MoveSouth();
        } else if(key == KeyEvent.VK_RIGHT) {
            return new MoveEast();
        } else if(key == KeyEvent.VK_SPACE) {
            return new MoveDropBreadcrumb();
        } else if(key == KeyEvent.VK_R) {
            return new MoveResign();
        }
        
        // If any other key was pressed, make no move
        return null;
    }
}