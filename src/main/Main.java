package main;

import main.board.Grid;
import main.control.Message;
import main.parser.Parser;
import main.communication.Receiver;
import main.communication.Transmitter;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Wrong number of arguments, please provide input filename");
        } else {
            try {
                // On crée le parser à partir du nom de fichier
                String inputPath = args[0];
                Parser parser = new Parser(inputPath);
                // On crée la grille
                int[] gridDimensions = parser.parseGridData();
                Grid grid = new Grid(gridDimensions[0], gridDimensions[1]);
                // On prépare le transmetteur
                Transmitter transmitter = new Transmitter(grid);
                // Maintenant la message loop !
                while (true) {
                    Receiver rover = parser.parseRoverData();
                    if (rover == null) {
                        break;
                    }
                    List<Message> messages = parser.parseRoverMessages();
                    transmitter.sendMessages(rover, messages);
                    System.out.println(rover);
                }
            } catch (IOException exception) {
                System.err.println(exception.getMessage());
            }
        }
    }
}
