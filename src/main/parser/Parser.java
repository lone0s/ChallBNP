package main.parser;

import main.control.Message;
import main.control.MessageFactory;
import main.exceptions.InvalidGridConfigurationException;
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
    private final BufferedReader bufferedReader;


    public Parser(String inputFile) throws FileNotFoundException {
        FileReader fileReader = new FileReader(inputFile);
        bufferedReader = new BufferedReader(fileReader);
    }

    public int[] parseGridData() {
        // Je controle toujours l'état initial par mesure de précaution
        int[] res = null;
        try {
            // Peut throw une exception
            // On recoit les dimensions de la grille sur la première ligne du fichier sous la forme "X Y"
            String[] gridData = bufferedReader.readLine().split(" ");
            // On verifie qu'on a bien deux données pour représenter la grille
            if (gridData.length == 2) {
                res = new int[2];
                res[0] = Integer.parseInt(gridData[0]);
                res[1] = Integer.parseInt(gridData[1]);
            }
            // Sinon on throw une exception
            else {
                throw new InvalidGridConfigurationException("Input file contains wrong grid dimension values");
            }
        }
        catch (IOException | NumberFormatException | InvalidGridConfigurationException exception) {
            System.err.println(exception.getMessage());
        }
        return res;
    }

    // Dans l'idéal, faire en sorte que le Parser génère un POJO des données du Rover plutôt que le Rover directement
    public Receiver parseRoverData() {
        Receiver res = null;
        try {
            // Les instructions concernant la configuration du rover sont sous la forme "X Y Z"
            String[] roverData = this.bufferedReader.readLine().split(" ");
            if (roverData.length == 3) {
                // Peut générer une exception au parsing mais pris en charge par le catch
                int roverX = Integer.parseInt(roverData[0]);
                int roverY = Integer.parseInt(roverData[1]);
                char roverOrientation = roverData[2].charAt(0);
                // cf. ligne 59
                Orientation orientation = OrientationFactory.createOrientation(roverOrientation);
                Position position = new Position(roverX, roverY);
                res = new Receiver(orientation, position);
            }
        }
        // Il faut donc gérer soit une exception sur le fichier, soit sur les valeurs numériques, soit sur les orientations
        catch (IOException | NumberFormatException | InvalidOrientationException exception) {
            System.err.println(exception.getMessage());
        }
        return res;
    }

    public List<Message> parseRoverMessages() {
        List<Message> res = new ArrayList<>();
        try {
            // Peut générer une exception
            // La ligne contient la suite d'instructions sous la forme de "XYZXZXZXYZ"
            String messages = this.bufferedReader.readLine();
            char[] roverMessages = messages.toCharArray();
            for (char c : roverMessages) {
                // Peut générer une exception
                // On crée un message par instruction reçue
                Message message = MessageFactory.createMessage(c);
                res.add(message);
            }
        }
        // On oublie pas de traiter les exceptions possibles
        catch (IOException | InvalidMessageException exception) {
            System.err.println(exception.getMessage());
        }
        return res;
    }
}
