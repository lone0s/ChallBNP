package main.communication;

import main.control.Message;
import main.space.Position;
import main.space.enums.Orientation;

// Le Rover en question !
public class Receiver {

    private Orientation orientation;
    private Position position;
    private Position oldPosition;

    public Receiver(Orientation orientation, Position position) {
        this.orientation = orientation;
        this.position = position;
        this.oldPosition = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void revertToOldPosition() {
        this.position = oldPosition;
    }
    public void moveForward() {
        Position newPosition = this.orientation.goForward(position);
        this.oldPosition = this.position;
        this.position = newPosition;

    }
    public void updateDirectionRight() {
        // Peut se résumer en une ligne, mais l'alternance m'a appris que c'est plus pratique pour le débug comme ça
        Orientation newOrientation = this.orientation.rotateRight();
        this.orientation = newOrientation;
    }

    public void updateDirectionLeft() {
        Orientation newOrientation = this.orientation.rotateLeft();
        this.orientation = newOrientation;
    }

    public void receiveMessage(Message message) {
        message.updateRover(this);
    }

    @Override
    public String toString() {
        return position + " " + orientation;
    }

}
