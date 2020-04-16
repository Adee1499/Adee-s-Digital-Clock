package LayoutManagers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;

import javax.swing.*;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimerTask;

class MyWindowListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}


class ClockFrame extends JFrame {
	
	
	public ClockFrame() {
		
		SimpleDateFormat hours = new SimpleDateFormat("HH", Locale.UK);
		SimpleDateFormat minutes = new SimpleDateFormat("mm", Locale.UK);
		SimpleDateFormat seconds = new SimpleDateFormat("ss", Locale.UK);
		
		this.getContentPane().setBackground(Color.white);
		Container cpane = getContentPane();
		Font t = new Font("Serif", Font.ITALIC, 36);
		Font f = new Font("Serif", Font.ITALIC, 220);
		Font a = new Font("Serif", Font.BOLD, 120);
		
		// TOP TITLE LABEL
		JLabel N = new JLabel("Adee's Digital Clock", JLabel.CENTER);
		N.setForeground(Color.white);
		N.setFont(t);
		N.setBackground(Color.gray);
		cpane.add(N, BorderLayout.NORTH);
		N.setOpaque(true);
		
		// TIME PANEL
		JPanel timePanel = new JPanel();
		cpane.add(timePanel, BorderLayout.CENTER);
		timePanel.setLayout(new GridLayout(1, 3));
		
		// HOUR LABEL
		JLabel HH = new JLabel("", JLabel.CENTER);
		HH.setFont(f);
		timePanel.add(HH);
		HH.setForeground(Color.black);
		HH.setOpaque(true);
		
		// MINUTES LABEL
		JLabel MM = new JLabel("", JLabel.CENTER);
		MM.setFont(f);
		timePanel.add(MM);
		MM.setForeground(Color.black);
		MM.setOpaque(true);
		
		// SECONDS LABEL
		JLabel SS = new JLabel ("", JLabel.CENTER);
		SS.setFont(f);
		timePanel.add(SS);
		SS.setForeground(Color.black);
		SS.setOpaque(true);
		
		// AM/PM LABEL
		JLabel AP = new JLabel ("", JLabel.CENTER);
		AP.setFont(a);
		cpane.add(AP, BorderLayout.SOUTH);
		
		// New timer which works!

		
			Timer SimpleTimer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Calendar rightNow = Calendar.getInstance();
				long time = rightNow.getTimeInMillis();
				String h1 = hours.format(time);
				int i = Integer.parseInt(h1);
				if (i > 12) {
					i = i - 12;		
					AP.setText("PM");
				} else {
					AP.setText("AM");
				}
				String h = Integer.toString(i);
	        	HH.setText(h);
	        	String m = minutes.format(time);
	        	MM.setText(m);
	            String s = seconds.format(time);
	            SS.setText(s);
			}
		});				
		
		SimpleTimer.setRepeats(true);
		SimpleTimer.setCoalesce(true);
		SimpleTimer.start();
		
		}
	
		
	
}

public class TestClock {

	public static void main(String[] args) {
		
		
		ClockFrame frame = new ClockFrame();
		frame.setSize(800, 520);
		frame.setTitle("Adee's Digital Clock");
		frame.setVisible(true);
		frame.addWindowListener(new MyWindowListener());
		
	}

}
