package org.academiadecodigo.bootcamp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
    private Clip clip;
    private URL soundURL;

    public Sound(String var1) {
        this.initClip(var1);
    }

    public void play(boolean var1) {
        if (var1) {
            this.clip.setFramePosition(0);
        }

        this.clip.start();
    }

    public void stop() {
        this.clip.stop();
    }

    public void setLoop(int var1) {
        this.clip.loop(var1);
    }

    private void initClip(String var1) {
        this.soundURL = Sound.class.getResource(var1);
        AudioInputStream var2 = null;

        try {
            if (this.soundURL == null) {
                var1 = var1.substring(1);
                File var3 = new File(var1);
                this.soundURL = var3.toURI().toURL();
            }

            var2 = AudioSystem.getAudioInputStream(this.soundURL);
            this.clip = AudioSystem.getClip();
            this.clip.open(var2);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException var4) {
            System.out.println(var4.getMessage());
        }
    }

}
