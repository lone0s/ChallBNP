package test.java.communication;

import main.communication.Receiver;
import main.control.Message;
import main.control.movements.MoveForward;
import main.space.Position;
import main.space.enums.Orientation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiverTest {
    private Receiver rover;
    @Before
    public void setUp() {
        Position position = new Position(0, 0);
        Orientation orientation = Orientation.N;
        this.rover = new Receiver(orientation, position);
    }

    @Test
    public void testGoodMessage() {
        Message message = new MoveForward();
        rover.receiveMessage(message);
        assertEquals(rover.getPosition().x, 0);
        assertEquals(rover.getPosition().y, 1);
    }
    @Test
    public void testRevert() {
        rover.revertToOldPosition();
        assertEquals(rover.getPosition().x, 0);
        assertEquals(rover.getPosition().y, 0);
    }


}
