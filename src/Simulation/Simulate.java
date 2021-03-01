package Simulation;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Simulate {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        ProjectSimulation projectSimulation = new ProjectSimulation();
        projectSimulation.simulateProject();
    }
}
