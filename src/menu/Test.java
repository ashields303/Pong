package menu;

import game.Game;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Test extends JFrame{
	Game game;
	
  public Test()
  {
    
    
  }
  private void onInit()
  {
    JLayeredPane lp = getLayeredPane();

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(new JTextArea(), BorderLayout.CENTER);
    panel.add(new JButton("Submit"), BorderLayout.SOUTH);
    panel.setSize(300, 150); // Size is needed here, as there is no layout in lp
    

    JPanel glass = new JPanel();
    glass.setOpaque(false); // Set to true to see it
    glass.setBackground(Color.GREEN);
    glass.setSize(300, 150);
    glass.setLocation(10, 10);

    lp.add(panel, Integer.valueOf(1));
    lp.add(glass, Integer.valueOf(2));
  }

  public static void main(String args[])
  {
    // Schedule a job for the event-dispatching thread:
    // creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        new Test();
      }
    });
  }
}