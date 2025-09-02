package test.java.space;

import main.exceptions.InvalidOrientationException;
import main.space.OrientationFactory;
import main.space.enums.Orientation;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class OrientationFactoryTest {
    @Test
    public void testGoodOrientation() throws IOException
    {
        assertEquals(OrientationFactory.createOrientation('N'), Orientation.N);
        assertEquals(OrientationFactory.createOrientation('S'), Orientation.S);
        assertEquals(OrientationFactory.createOrientation('E'), Orientation.E);
        assertEquals(OrientationFactory.createOrientation('W'), Orientation.W);
    }

    @Test
    public void testBadOrientation() throws IOException
    {
        assertThrowsExactly(InvalidOrientationException.class, () -> OrientationFactory.createOrientation('/'));
    }
}
