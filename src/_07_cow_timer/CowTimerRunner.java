package _07_cow_timer;

import java.applet.AudioClip;

import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class CowTimerRunner {
	public static void main(String[] args) throws InterruptedException {
		/* Make a CowTimer, set its time and start it.
		 * Use a short delay (seconds) when testing, then try with longer delays */
for(int t = 0; t < 1000; t++) {
	String s = JOptionPane.showInputDialog("How many minutes do you want your timer to be on?");
	int minutes = Integer.parseInt(s);
	for(int i = minutes*60; i > -1; i--) {
	System.out.print("\n" + i);
	Thread.sleep(1000);
	if(i == 0) {
		JOptionPane.showInputDialog("Time is up!");
		String a = JOptionPane.showInputDialog("Do you want to set up another timer?");
		if(a.equals("No")) {
			t = 1000;
		}
		if(a.equals("no")) {
			t = 1000;
		}
	}
	}
	}
}
}

