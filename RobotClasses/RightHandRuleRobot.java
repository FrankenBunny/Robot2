package src.RobotClasses;

/**
 * This Robot moves through the maze by always making sure it
 * has its right hand against a wall. If the Robot does not start
 * by a wall, the Robot can not move, and the program will exit.
 *
 * @author Julia Johansson DV21JJN
 */

public class RightHandRuleRobot extends RobotBase{

    public RightHandRuleRobot(Maze m) {
        current = m.getStart();
        maze = m;
    }

    public void setPosition (Position newPos) {

    }

    /**
     * This method allows for the Robot to move to a new Position
     * within its maze. The Robot must always have its right hand against
     * the wall.
     */
    public void move() {

    }
}
