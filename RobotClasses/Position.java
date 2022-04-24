package src.RobotClasses;

/**
 * Class: RobotClasses.Position.
 *
 * Knows x- and y-coordinates as well as character value
 * for a specific position. Can return these values as
 * well as give the positions to north, south, east and
 * west.
 */

public class Position {
    private int x;
    private int y;

    /**
     * Constructor for a RobotClasses.Position using two integer values to
     * set the x- and y-coordinate.
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get x-coordinate of a RobotClasses.Position.
     * @return An integer value.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Get y-coordinate of a RobotClasses.Position.
     * @return An integer value.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Get the RobotClasses.Position to the south of given RobotClasses.Position.
     * @return A RobotClasses.Position.
     */
    public Position getPosToSouth() { return new Position(this.x, this.y + 1); }

    /**
     * Get the RobotClasses.Position to the north of given RobotClasses.Position.
     * @return A RobotClasses.Position.
     */
    public Position getPosToNorth() {
        return new Position(this.x, this.y - 1);
    }

    /**
     * Get the RobotClasses.Position to the east of given RobotClasses.Position.
     * @return A RobotClasses.Position.
     */
    public Position getPosToEast() {
        return new Position(this.x + 1, this.y);
    }

    /**
     * Get the RobotClasses.Position to the east of given RobotClasses.Position.
     * @return A RobotClasses.Position.
     */
    public Position getPosToWest() {
        return new Position(this.x - 1, this.y);
    }

    /**
     * Checks if to Positions are equal based on x- and y-coordinates.
     * @param o A RobotClasses.Position.
     * @return True if equal, or false if else.
     */
    public boolean equals(Object o) {
        Position p = (Position) o;
        return this.getX() == p.getX() && this.getY() == p.getY();
    }

    /**
     * Creates a hashcode using the Positions x- and y-coordinates.
     * @return An integer value.
     */
    public int hashCode () {
        return ((x + y) * (x + y + 1) / 2 + x);
    }
}


