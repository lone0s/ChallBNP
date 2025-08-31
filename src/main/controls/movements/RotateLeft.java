package main.controls.movements;

import main.controls.Message;
import main.rover_stuff.Rover;

public class RotateLeft implements Message {

    @Override
    public void updateRover(Rover rover) {
        rover.updateDirectionLeft();
    }
}
