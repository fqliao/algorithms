package offer.java;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AWTTest extends JFrame{
	
	public AWTTest(){
		JButton helloButton = new JButton("Hello World");
		JButton sleepButton = new JButton("Sleep");
		helloButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.out.println("Hello");
			}
		});
		sleepButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(helloButton);
		getContentPane().add(sleepButton);
		pack();
		show();
	}
	public static void main(String[] args) {
		new AWTTest();
	}
}
