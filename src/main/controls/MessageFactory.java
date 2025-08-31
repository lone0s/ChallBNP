package main.controls;

import main.controls.movements.MoveForward;
import main.controls.enums.Movement;
import main.controls.movements.RotateLeft;
import main.controls.movements.RotateRight;

public class MessageFactory {

    public static Message createMessage(Movement movement) {
        return switch (movement) {
            case L -> new RotateLeft();
            case R -> new RotateRight();
            case M -> new MoveForward();
            default -> throw new IllegalArgumentException("Invalid movement");
        };
    }

}