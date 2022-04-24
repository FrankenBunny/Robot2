package src.RobotClasses;
/**
 * Interface: Robot
 *
 * The interface Robot holds basic information regarding a Robot
 * attributes and methods.
 *
 *
 * @see Maze
 * @author Julia Johansson DV21JJN
 */

public interface Robot {

    /**
     * The method used for making the Robot move within its
     * maze.
     */
    void move();

    /**
     * The method used for setting the Robots current and
     * new position.
     */
    void setPosition(Position newPos);

    /**
     * The method used for getting the Robots current Position.
     * @return The current Position of the Robot.
     */
    Position getPosition();

    /**
     * The method used for checking if the Robot has reached the
     * goal within the Maze.
     * @return Returns true if the goal has been reached, otherwise false.
     */
    boolean hasReachedGoal();

}
