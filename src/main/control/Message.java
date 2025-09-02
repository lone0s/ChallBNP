package main.control;

import main.communication.Receiver;

public interface Message {
    void updateRover(Receiver receiver);
}
