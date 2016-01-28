class GreedyBreadcrumbSolver extends Solver
{
    GreedyBreadcrumbSolver(Maze newMaze){ super(newMaze); }
    Move move(){
        Move nextMove;
        int northBreadcrumbs
        
        if((nextMove == null || northBreadcrumbs < bestBreadcrumbs) && northPassable){
            nextMove = new MoveNorth();
            bestBreadcrumbs = northBreadcrumbs;
        }
        if((nextMove == null || eastBreadcrumbs < bestBreadcrumbs) && northPassable){
            nextMove = new MoveNorth();
            bestBreadcrumbs = northBreadcrumbs;
        }
        if((nextMove == null || southBreadcrumbs < bestBreadcrumbs) && northPassable){
            nextMove = new MoveNorth();
            bestBreadcrumbs = northBreadcrumbs;
        }
        if((nextMove == null || westBreadcrumbs < bestBreadcrumbs) && northPassable){
            nextMove = new MoveNorth();
            bestBreadcrumbs = northBreadcrumbs;
        }
        if(nextMove == null){
            nextMove = new MoveResign();
        }
        
        nextMove.breadcrumbs = 1;
        return nextMove;
        
    }
}
