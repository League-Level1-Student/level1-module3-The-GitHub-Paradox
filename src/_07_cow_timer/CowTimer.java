package _07_cow_timer;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.applet.AudioClip;
import java.io.IOException;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class CowTimer {

	/*
	 * 1. Make a constructor for the CowTimer class that initializes the minutes
	 * variable
	 */

	/* 4. Complete the main method of the CowTimerRunner class */

	private int minutes;

	public void setTime(int minutes) {
		this.minutes = minutes;
		System.out.println("Cow time set to " + minutes + " minutes.");
	}

	public void start() throws InterruptedException {
		/*
		 * 2. Count down the minutes, print the current minute then sleep for the number
		 * of minutes using Thread.sleep(int milliseconds).
		 */
		for(int t = 0; t < 1000; t++) {
			String s = JOptionPane.showInputDialog("How many minutes do you want your timer to be on?");
			int minutes = Integer.parseInt(s);
			for(int i = minutes*60; i > -1; i--) {
			System.out.print("\n" + i);
			Thread.sleep(1000);
			if(i == 0) {
				playSound("moo.wav");
				speak("Time is up!");
				speak("Do you want to set up another timer?");
				String a = JOptionPane.showInputDialog("Do you want to set up another timer?");
				if(a.equals("No")) {
					t = 1000;
					speak("Good bye!");
				}
				if(a.equals("no")) {
					t = 1000;
					speak("Good bye!");
				}
			}
			}
			}
		/*
		 * 3. When the timer is finished, use the playSound method to play a moo sound.
		 * You can use the .wav file in the default package, or you can download one
		 * from freesound.org, then drag it in to the default package.
		 */

	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

	static void speak(String words) {
		if (System.getProperty("os.name").contains("Windows")) {
			String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
					+ words + "');\"";
			try {
				Runtime.getRuntime().exec(cmd).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				Runtime.getRuntime().exec("say " + words).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
