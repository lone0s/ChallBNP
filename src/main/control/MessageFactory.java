package main.control;

import main.control.movements.MoveForward;
import main.control.movements.RotateLeft;
import main.control.movements.RotateRight;
import main.exceptions.InvalidMessageException;

public class MessageFactory {

    public static Message createMessage(char movement) {
        return switch (movement) {
            case 'L' -> new RotateLeft();
            case 'R' -> new RotateRight();
            case 'M' -> new MoveForward();
            default -> throw new InvalidMessageException(movement + " is not a supported movement");
        };
    }

}