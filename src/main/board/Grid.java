package main.board;

import main.space.Position;

public class Grid {
    private final int width;
    private final int height;

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