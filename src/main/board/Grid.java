package main.board;

import main.space.Position;

public class Grid {
    private int width;
    private int height;
    //J'suis pas sur du coup du rover
    // TODO: Transmitter + Grid + Rover existent séparément
    //  Transmitter communique message a Rover
    //  Rover.apply()
    //  si Grid.isNotValidPosition(Rover.position)
    //  Rover.revertToOldPosition()
    //  Loop jusqu'a fin des messages


    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }


    public boolean isNotValidPosition(Position position) {
        return position.x < 0 ||
                position.y < 0 ||
                position.x > this.width ||
                position.y > this.height;
    }

}