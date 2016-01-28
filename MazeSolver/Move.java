/*
 * A Move is a possible move to make in the maze.
 * Moves are North, South, West, East or Resign.
 * The Solver may also drop breadcrumbs *before* the Move is made.
 */
abstract class Move {
    int dx=0,dy=0;
    int breadcrumbs = 0;
    
    // Perform the move
    void run(Maze m, Solver s) {
        // Drop breadcrumbs in current cell
        m.cellAt(s.x, s.y).dropBreadcrumbs(breadcrumbs);
        
        // Find new position
        int newX = s.x + dx;
        int newY = s.y + dy;
        // Move there if it is possible to do so
        if(m.cellAt(newX, newY).passable
                && newX >= 0 && newX < m.width
                && newY >= 0 && newY < m.height) {
            s.x = newX; s.y = newY;
        }
    }
}

class MoveNorth extends Move {
    MoveNorth() { dy = -1; }
}
class MoveSouth extends Move {
    MoveSouth() { dy = 1; }
}
class MoveWest extends Move {
    MoveWest() { dx = -1; }
}
class MoveEast extends Move {
    MoveEast() { dx = 1; }
}
class MoveDropBreadcrumb extends Move {
    MoveDropBreadcrumb() { breadcrumbs = 1; }
}
class MoveResign extends Move {}