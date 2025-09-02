package main.control.movements;

import main.control.Message;
import main.communication.Receiver;

public class MoveForward implements Message {

    @Override
    public void updateRover(Receiver receiver) {
        receiver.moveForward();
    }
}
