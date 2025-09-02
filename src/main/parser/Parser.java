package main.parser;

import main.control.Message;
import main.control.MessageFactory;
import main.exceptions.InvalidMessageException;
import main.exceptions.InvalidOrientationException;
import main.communication.Receiver;
import main.space.OrientationFactory;
import main.space.Position;
import main.space.enums.Orientation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final String inputFilePath;
    private final FileReader fileReader;
    private final BufferedReader bufferedReader;


    public Parser(String inputFile) throws FileNotFoundException {
        this.inputFilePath = inputFile;
        fileReader = new FileReader(inputFile);
        bufferedReader = new BufferedReader(fileReader);
    }

    public int[] parseGridData() {
        // On controle l'état de départ
        int[] res = null;
        try {
            String[] gridData = bufferedReader.readLine().split(" ");
            // On verifie qu'on a bien deux données pour représenter la grille
            if (gridData.length == 2) {
                res = new int[2];
                res[0] = Integer.parseInt(gridData[0]);
                res[1] = Integer.parseInt(gridData[1]);
            }
            else {
                throw new IllegalArgumentException("Incorrect input file format");
            }
        }
        catch (Exception e) {
            System.err.println("Caught exception : " + e.getMessage());
        }
        return res;
    }

    // TODO: Update pour retourner un POJO avec le RoverData
    //  Parce que j'ai pas envie que le Parser soit apte a générer un Rover <=> séparation des responsabilités
    public Receiver parseRoverData() {
        Receiver res = null;
        try {
            String[] roverData = this.bufferedReader.readLine().split(" ");
            if (roverData.length == 3) {
                // Peut générer une exception au parsing
                int roverX = Integer.parseInt(roverData[0]);
                int roverY = Integer.parseInt(roverData[1]);
                char roverOrientation = roverData[2].charAt(0);
                // Peut générer une exception aussi
                Orientation orientation = OrientationFactory.createOrientation(roverOrientation);
                Position position = new Position(roverX, roverY);
                res = new Receiver(orientation, position);
            }
        }
        // Soit exception sur le fichier, soit sur les valeurs numériques, soit sur les orientations
        catch (IOException | NumberFormatException | InvalidOrientationException exception) {
            System.err.println(exception.getMessage());
        }
        return res;
    }

    public List<Message> parseRoverMessages() {
        List<Message> res = new ArrayList<>();
        try {
            // Peut générer une exception
            String messages = this.bufferedReader.readLine();
            char[] roverMessages = messages.toCharArray();
            for (char c : roverMessages) {
                // Peut générer une exception
                Message message = MessageFactory.createMessage(c);
                res.add(message);
            }
        }
        catch (IOException | InvalidMessageException exception) {
            System.err.println(exception.getMessage());
        }
        return res;
    }
}
