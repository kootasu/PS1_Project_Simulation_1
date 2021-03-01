package Simulation;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {

    /**
     * Simple method that plays an audio source once
     * @throws UnsupportedAudioFileException
     * @throws IOException
     * @throws LineUnavailableException
     */
    public static void play(String pathname) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // Create AudioInputStream object
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(pathname).getAbsoluteFile());
        // Create clip reference
        Clip clip = AudioSystem.getClip();
        // Open audioInputStream to the clip
        clip.open(audioInputStream);
        // Start the clip
        clip.start();
    }
}