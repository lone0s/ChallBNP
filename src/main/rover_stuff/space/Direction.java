package main.rover_stuff.space;

/*
* A rover's position and location is represented by a combination of x and y
* co-ordinates and a letter representing one of the four cardinal compass
* points.
*/

public class Direction {
    private CardinalPoint direction;

    public Direction(CardinalPoint direction) {
        this.direction = direction;
    }

    public CardinalPoint getDirection() {
        return direction;
    }
}
