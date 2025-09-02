package main.space;

import main.exceptions.InvalidOrientationException;
import main.space.enums.Orientation;

public class OrientationFactory {
    public static Orientation createOrientation(char orientation) {
        return switch (orientation) {
            case 'N' -> Orientation.N;
            case 'S' -> Orientation.S;
            case 'E' -> Orientation.E;
            case 'W' -> Orientation.W;
            default -> throw new InvalidOrientationException(orientation + " is not a valid cardinal compass point.");
        };
    }
}
