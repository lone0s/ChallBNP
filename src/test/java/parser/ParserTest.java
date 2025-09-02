package test.java.parser;
import main.control.Message;
import main.parser.Parser;
import main.communication.Receiver;
import main.space.enums.Orientation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    private String filePath;
    private Parser parser;
    private File tempFile;

    @Before
    public void setUp() throws IOException {
        tempFile = File.createTempFile("input", ".txt");
        tempFile.deleteOnExit();
        // Il y a 9 chars dans le premier exemple que vous avez fourni
        String content = "5 5\n1 2 N\nLMLMLMLMM";
        Files.write(tempFile.toPath(), content.getBytes());

        filePath = tempFile.getAbsolutePath();
        parser = new Parser(filePath);
    }

    @Test
    public void testParsing() throws IOException {
        // On test la grid
        int[] gridDimensions = parser.parseGridData();
        assertEquals(gridDimensions[0], 5);
        assertEquals(gridDimensions[1], 5);

        // Puis la position et l'orientation du rover
        Receiver rover = parser.parseRoverData();
        assertEquals(rover.getOrientation(), Orientation.N);
        assertEquals(rover.getPosition().x, 1);
        assertEquals(rover.getPosition().y, 2);

        // Puis les messages
        List<Message> messages = parser.parseRoverMessages();
        assertEquals(messages.size(), 9);
    }


}
