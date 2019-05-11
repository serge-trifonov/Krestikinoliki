package KN;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GraphicsMorpion extends JFrame{
      /**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public GraphicsMorpion() {
    	  setSize(350, 400);
    	  setTitle("Morpion");
          pole = new Panneau();
          pole.setBackground(Color.white);
          start = new JButton("Recommencer");
          getContentPane().add(start, "South");
          getContentPane().add(pole);
          JLabel label = new JLabel("Vous avez gagné!");
          es = new EcouteurSouris(pole, label);
          pole.addMouseListener(es);
          start.addActionListener(new EcouteurBouton(pole, es));
          
  		 
      }
	
	public JPanel getPanneau() {
		
		return pole;
	}
	
	public static void texte(JPanel pole) {
		JLabel label = new JLabel("Vous avez gagné!");
  	  		label.setFont(new Font("Arial", Font.PLAIN, 40));
  	  		pole.add(label);
	}

	private JButton start;
	private JPanel pole;
	EcouteurSouris es;
}


class Panneau extends JPanel{


	private static final long serialVersionUID = 1L;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(110, 10, 110, 310);
		g.drawLine(210, 10, 210, 310);
		g.drawLine(10, 110, 310, 110);
		g.drawLine(10, 210, 310, 210);
	}

}

class EcouteurBouton implements ActionListener {
	public EcouteurBouton(JPanel pole, EcouteurSouris es){
    	this.pole = pole;
    	this.es = es;
    }

    public void actionPerformed(ActionEvent eve) {
    	pole.repaint();
    	es.restart();
    }
    
    private JPanel pole;
    private EcouteurSouris es;
}

