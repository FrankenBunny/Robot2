/**
 * Class: RobotClasses.Maze.
 *
 * Knows information regarding the Mazes structure, location of
 * start and goal as well as length of rows and columns. Can give
 * information whether it is possible or not to move to a given
 * RobotClasses.Position.
 */
package src.RobotClasses;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import static java.util.Collections.frequency;

public class Maze {
    private int maxColumn;
    private int maxRow;
    private HashMap<Position, Character> maze;
    private Position start;
    private Position goal;

    /**
     * Constructor for a RobotClasses.Maze using a Scanner reading from an input-file.
     * Every RobotClasses.Maze must have a start- and goal-RobotClasses.Position, otherwise a RobotClasses.Maze
     * will not be constructed. The Mazes row numbers as well as the maximum
     * amount of columns on a row is stored.
     * @param s A scanner using an input-file.
     */
    public Maze(Scanner s) throws IOException {
        try {
            int row = 0;
            int length;
            String nextLine;

            HashMap<Position, Character> h = new HashMap<>();

            while (s.hasNextLine()) {
                nextLine = s.nextLine();
                length = nextLine.length();
                if (length > this.maxColumn) {
                    this.maxColumn = length;
                }

                for (int i = 0; i < length; i++) {
                    char c = nextLine.charAt(i);
                    Position p = new Position(i, row);
                    h.put(p, c);

                    if (c == 'S') this.start = p;
                    if (c == 'G') this.goal = p;
                }

                ++row;
            }
            s.close();
            this.maxRow = row;
            this.maze = h;

            if (getStart() == null || getGoal() == null) {
                throw new NullPointerException();
            }
            if (frequency(maze.values(), 'S') > 1) {
                System.out.println("To many start-positions in the RobotClasses.Maze, only 1 is allowed.");
                throw new IOException();
            }
            if (frequency(maze.values(), 'G') > 1) {
                System.out.println("To many goal-positions in the RobotClasses.Maze, only 1 is allowed.");
                throw new IOException();
            }

        } catch (NullPointerException | IOException mazeConditions) {
            throw new IOException();
        }
    }

    /**
     * Method to check if it is possible to move to given RobotClasses.Position. The RobotClasses.Position
     * must exist within the bounds of the RobotClasses.Maze and cannot be a wall.
     * @param p The given RobotClasses.Position.
     * @return True if it is possible to move to the RobotClasses.Position, otherwise false.
     */
    public boolean isMovable (Position p) {
        if (this.maze.containsKey(p)) {
            char c = this.maze.get(p);

            return switch (c) {
                case ' ', 'G', 'S' -> true;
                default -> false;
            };
        }
        return false;
    }

    /**
     * Method for checking if a given RobotClasses.Position is the goal-RobotClasses.Position
     * of the RobotClasses.Maze.
     * @param p The given RobotClasses.Position
     * @return True if the RobotClasses.Position is the goal-RobotClasses.Position, otherwise false.
     */
    public boolean isGoal (Position p) {
        return p.equals(this.goal);
    }

    /**
     * Method to get the goal-RobotClasses.Position in the RobotClasses.Maze.
     * @return The goal-RobotClasses.Position in the RobotClasses.Maze.
     */
    public Position getGoal () throws NullPointerException {
        try {
            if (goal == null) {
                throw new NullPointerException();
            } else {
                return goal;
            }
        } catch (NullPointerException noGoal) {
            System.out.println("Missing goal-position in RobotClasses.Maze.");
            return null;
        }
    }

    /**
     * Method to get the start-RobotClasses.Position in the RobotClasses.Maze.
     * @return The start-RobotClasses.Position in the RobotClasses.Maze.
     */
    public Position getStart () {
        try {
            if (start == null) {
                throw new NullPointerException();
            } else {
                return start;
            }
        } catch (NullPointerException noStart) {
            System.out.println("Missing start-position in RobotClasses.Maze.");
            return null;
        }
    }

    /**
     * Method for getting the maximum number of columns in the RobotClasses.Maze.
     * @return An integer value representing the number of columns.
     */
    public int getNumColumns () {
        return this.maxColumn;
    }

    /**
     * Method for getting the number of rows in the RobotClasses.Maze.
     * @return An integer value representing the number of rows.
     */
    public int getNumRows () {
        return this.maxRow;
    }


    /* --- Methods used for debugging --- */
    public char getC (Position p) {
        return maze.get(p);
    }

    /*
     * Checks if iteration to the right from specific RobotClasses.Position is possible.
     * @param p The given RobotClasses.Position.
     * @return True if iteration to the right is possible, false if otherwise.
     */
    public boolean iterateRight (Position p) {
        return maze.containsKey(p);
    }

    /*
     * Help function used to print the maze.
     */
    public void printMaze () {
        int r = 0, c = 0;

        while (r < maxRow) {
            Position p = new Position(c, r);
            System.out.print(maze.get(p));

            while (iterateRight(p.getPosToEast())) {
                p = p.getPosToEast();
                System.out.print(maze.get(p));
            }

            System.out.print('\n');
            r++;
        }
    }

}