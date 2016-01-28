import java.util.*;
import java.io.*;

/*
 * A maze has a 2-dimensional list of GridCells, and knows where
 * the Solver should start.
 */
class Maze {
    private List<List<GridCell>> grid;
    int width,height;
    int startX,startY;
    
    // Constructor: load a maze from a text file
    Maze(String filename) throws FileNotFoundException, IOException {
        grid = new ArrayList<List<GridCell>>();
        
        height = 0; width = 0;
        String rowString;
        
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        // Read one row at a time
        while((rowString = br.readLine()) != null) {
            // Prepare a list of GridCells for this row
            List<GridCell> rowList = new ArrayList<GridCell>();
            for(int x=0; x<rowString.length(); x++) {
                // Read one character
                char symbol = rowString.charAt(x);
                GridCell cell;
                // Determine what type of GridCell to insert
                if(symbol == ' ') {
                    // Empty cell
                    cell = new GridCellEmpty();
                } else if(symbol == '.') {
                    // Empty cell with one breadcrumb
                    cell = new GridCellEmpty();
                    cell.dropBreadcrumbs(1);
                } else if(symbol == ':') {
                    // Empty cell with two breadcrumbs
                    cell = new GridCellEmpty();
                    cell.dropBreadcrumbs(2);
                } else if(symbol == 'E') {
                    // End position
                    cell = new GridCellEnd();
                } else if(symbol == 'S') {
                    // Start position
                    cell = new GridCellEmpty();
                    startX = x; startY = height;
                } else {
                    // Wall
                    cell = new GridCellWall("" + symbol);
                }
                // Put this cell into the row
                rowList.add(cell);
            }
            // Put this row into the grid
            grid.add(rowList);
            height++;
            // Keep track of the width of the widest row
            if(rowList.size() > width) { width = rowList.size(); }
        }
        fr.close();
    }
    
    // Return the cell at a particular position
    GridCell cellAt(int x, int y) {
        // If the cell is out of bounds, it is impassable
        if(y < 0 || y >= height || x < 0 || x >= grid.get(y).size()) {
            return new GridCellWall();
        }
        // Otherwise return the cell at that position
        return grid.get(y).get(x);
    }
}