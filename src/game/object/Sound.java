package game.object;


import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	public static final AudioClip DIE = Applet.newAudioClip(Sound.class.getResource("SoundFile/scream-dead.wav"));
	public static final AudioClip SHOOT = Applet.newAudioClip(Sound.class.getResource("SoundFile/laser-shoot.wav"));
    public static final AudioClip BACKGROUND = Applet.newAudioClip(Sound.class.getResource("SoundFile/y2mate.wav"));
    public static final AudioClip SWORD = Applet.newAudioClip(Sound.class.getResource("SoundFile/Sword.wav"));
}