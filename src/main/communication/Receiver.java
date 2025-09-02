package main.communication;

import main.control.Message;
import main.space.Position;
import main.space.enums.Orientation;

// L'équivalent du Rover
public class Receiver {

    // Le transmetteur va gérer si oui ou non le rover continue dans la bonne direction
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

    // TODO: Voir pour faire en sorte que le message dicte directement l'action finalement
    //  Trouver une facon pour que message.apply() applique la transformation
    //  ==> Creer un "transmitter" qui va envoyer des messages aux rovers
    //  ==> Avoir une méthode "void receiveMessage(Message message) qui applique la transformation

    public void revertToOldPosition() {
        this.position = oldPosition;
    }
    public void moveForward() {
        Position newPosition = this.orientation.goForward(position);
        this.oldPosition = this.position;
        this.position = newPosition;

    }
    public void updateDirectionRight() {
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
