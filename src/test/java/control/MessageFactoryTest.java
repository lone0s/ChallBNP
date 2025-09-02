package test.java.control;

import main.control.MessageFactory;
import main.control.movements.MoveForward;
import main.control.movements.RotateLeft;
import main.control.movements.RotateRight;
import main.exceptions.InvalidMessageException;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageFactoryTest {
    @Test
    public void testGoodMessage() {
        assertEquals(MessageFactory.createMessage('L').getClass(), RotateLeft.class);
        assertEquals(MessageFactory.createMessage('R').getClass(), RotateRight.class);
        assertEquals(MessageFactory.createMessage('M').getClass(), MoveForward.class);
    }

    @Test
    public void testBadMessage() {
        assertThrowsExactly(InvalidMessageException.class, () -> MessageFactory.createMessage('H'));
    }
}
