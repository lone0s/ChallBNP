package test.java.space;

import main.space.Position;
import main.space.enums.Orientation;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrientationTest {
    private final static Position testPosition = new Position(0, 0);
    @Test
    public void testValidRotationsOfOrientations() throws IOException
    {
        //Rotations a gauche
        assertEquals(Orientation.N.rotateLeft(), Orientation.W);
        assertEquals(Orientation.S.rotateLeft(), Orientation.E);
        assertEquals(Orientation.E.rotateLeft(), Orientation.N);
        assertEquals(Orientation.W.rotateLeft(), Orientation.S);

        //Rotations à droite
        assertEquals(Orientation.N.rotateRight(), Orientation.E);
        assertEquals(Orientation.S.rotateRight(), Orientation.W);
        assertEquals(Orientation.E.rotateRight(), Orientation.S);
        assertEquals(Orientation.W.rotateRight(), Orientation.N);

        //Avancer
        assertEquals(Orientation.N.goForward(testPosition).y, 1);
        assertEquals(Orientation.S.goForward(testPosition).y,  -1);
        assertEquals(Orientation.E.goForward(testPosition).x, 1);
        assertEquals(Orientation.W.goForward(testPosition).x,-1);
    }
}
