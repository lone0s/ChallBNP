package main.rover_stuff.space;

/*
* A rover's position and location is represented by a combination of x and y
* co-ordinates and a letter representing one of the four cardinal compass
* points.
*/

public class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    public void updateX(int value) {
//        this.x += value;
//    }
//
//    public void updateY(int value) {
//        this.y += value;
//    }
}
