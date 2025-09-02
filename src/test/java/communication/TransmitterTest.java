package test.java.communication;

import main.board.Grid;
import main.communication.Receiver;
import main.communication.Transmitter;
import main.control.Message;
import main.control.movements.MoveForward;
import main.control.movements.RotateLeft;
import main.control.movements.RotateRight;
import main.space.Position;
import main.space.enums.Orientation;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransmitterTest {
    private final Grid grid = new Grid (1,1);
    private final Transmitter transmitter = new Transmitter(grid);
    private final Receiver rover = new Receiver(Orientation.N, new Position(0,0));
    private List<Message> messages = new ArrayList<>() ;

    @BeforeEach
    public void setup() {
        this.messages = new ArrayList<>();
    }

    @Test
    public void testUnvalidMessageSequence() {
        Message rotateLeft = new RotateLeft();
        Message goLeft = new MoveForward();
        messages.add(rotateLeft);
        messages.add(goLeft);
        transmitter.sendMessages(rover, messages);
        assertEquals(rover.getPosition().x,0);
        assertEquals(rover.getPosition().y,0);
        assertEquals(rover.getOrientation(),Orientation.W);
    }

    @Test
    public void testValidMessageSequence() {
        Message rotateLeft = new RotateRight();
        Message goLeft = new MoveForward();
        messages.add(rotateLeft);
        messages.add(goLeft);
        transmitter.sendMessages(rover, messages);
        assertEquals(rover.getPosition().x,1);
        assertEquals(rover.getPosition().y,0);
        assertEquals(rover.getOrientation(),Orientation.E);
    }
}
