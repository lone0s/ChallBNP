package main.rover_stuff;

import main.rover_stuff.space.Direction;
import main.rover_stuff.space.Position;

// Le rover connait sa position et sa localisation
// Donc (x,y) + Z
// Penser a bien séparer les responsabilités
public class Rover {

    private Direction direction;
    private Position position;

    public Rover(Direction direction, Position position) {
        this.direction = direction;
        this.position = position;
    }

    public String getPosition() {
        return position.toString();
    }

    public String getDirection() {
        return direction.toString();
    }

    public void moveForward() {
        Position newPosition = this.direction.getDirection().goForward(position);
        this.position = newPosition;
    }

    // TODO: Voir pour faire en sorte que le message dicte directement l'action finalement
    // TODO: Faire un pattern command probablement ou pareil, overengineered ?
    public void updateDirectionRight() {
        Direction newDirection = this.direction.getDirection().rotateRight();
        this.direction = newDirection;
    }

    public void updateDirectionLeft() {
        Direction newDirection = this.direction.getDirection().rotateLeft();
        this.direction = newDirection;
    }

    //public ReceiveMessage() ==> UpdatePosition
}
