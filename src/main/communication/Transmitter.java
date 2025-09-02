package main.communication;

import main.board.Grid;
import main.control.Message;

import java.util.List;

public class Transmitter {
    private final Grid grid;

    public Transmitter(Grid grid) {
        this.grid = grid;
    }

    public void sendMessages(Receiver rover, List<Message> messages) {
        for (Message message : messages) {
            rover.receiveMessage(message);
            if (grid.isNotValidPosition(rover.getPosition())) {
                rover.revertToOldPosition();
            }
        }
    }
}
