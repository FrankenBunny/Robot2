package src.RobotClasses;
import java.util.Stack;
import java.util.ArrayList;

/**
 * This Robot moves through the maze by saving all previous Positions
 * in a queue, it first tries to go to an unvisited Position but if not
 * possible it steps backwards through the Positions its already visited
 * in reversed order.
 *
 * @author Julia Johansson DV21JJN
 */

public class MemoryRobot extends RobotBase {
    private Stack<Position> prevPos;

    public MemoryRobot (Maze m) {
        current = m.getStart();
        maze = m;
        prevPos = new Stack<Position>();
        prevPos.push(current);
    }

    public void setPosition (Position newPos) {
        if (prevPos.search(newPos) == -1) {
            prevPos.push(newPos);
        }
        current = newPos;
    }

    private ArrayList<Position> findPositions () {
        ArrayList<Position> newPos = new ArrayList<>(0);

        if (prevPos.search(current.getPosToNorth()) != -1 && maze.isMovable(current.getPosToNorth())) {
            newPos.add(current.getPosToNorth());
        }
        if (prevPos.search(current.getPosToSouth()) != -1 && maze.isMovable(current.getPosToSouth())) {
            newPos.add(current.getPosToSouth());
        }
        if (prevPos.search(current.getPosToEast()) != -1 && maze.isMovable(current.getPosToEast())) {
            newPos.add(current.getPosToEast());
        }
        if (prevPos.search(current.getPosToWest()) != -1 && maze.isMovable(current.getPosToWest())) {
            newPos.add(current.getPosToWest());
        }

        return newPos;
    }

    public void move() {
        ArrayList<Position> pos = findPositions();

        if (pos.size() == 0) {
            setPosition(prevPos.peek());
        } else {
            setPosition(pos.get(0));
        }
    }
}
