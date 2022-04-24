package src.RobotClasses;

/**
 * This is the superclass for all Robots within the package.
 * There are methods for getting their positions, setting their positions
 * and find out if they have reached the goal within their maze.
 *
 * @author Julia Johansson Dv21JJN
 */

public abstract class RobotBase implements Robot {
    protected Position current;
    protected Position previousPosition;
    protected Maze maze;

    /**
     * Method used for getting the current Position of
     * the RandomRobot.
     * @return Returns the current Position of the RandomRobot.
     */
    public Position getPosition () {
        return current;
    }

    /**
     * Method used for checking if the Robot has reached
     * the goal within its Maze.
     * @return Returns true if the goal has been reached, otherwise false.
     */
    public boolean hasReachedGoal() {
        return maze.isGoal(current);
    }

}
