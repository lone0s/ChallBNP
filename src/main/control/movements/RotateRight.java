package main.control.movements;

import main.control.Message;
import main.communication.Receiver;

public class RotateRight implements Message {
    @Override
    public void updateRover(Receiver receiver) {
        receiver.updateDirectionRight();
    }
}
