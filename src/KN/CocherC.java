package KN;
import javax.swing.* ;
import java.awt.* ;     
import java.awt.event.* ;
import java.util.*;

public class CocherC {
    public static void main(String [] args) {
    	System.out.println("Le nombre : ");
    	Scanner scan = new Scanner(System.in);
    	int x = scan.nextInt();
    	String []nm = new String[x];
    	for(int i=0; i<x; i++) {
    		nm[i]=scan.next();
    	}
    	fen f = new fen(nm);
    	f.setVisible(true);
    }
}


class fen extends JFrame implements ItemListener, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public fen(String[] names) {
		this.names = names;
		cases = new JCheckBox[names.length];
		setTitle("Cases à cocher");
		setBounds(150, 150, 300, 300);
		korzinka = getContentPane();
		state = new JLabel();
		state.setForeground(Color.white);
		raz = new JButton("Delete selection");
		raz.setBackground(Color.white);
		raz.setForeground(Color.pink.darker());
		raz.addActionListener(this);
		korzinka.add(raz, "North");
		etat = new JButton("Etat");
		etat.setBackground(Color.white);
		etat.setForeground(Color.pink.darker());
		etat.addActionListener(this);
		korzinka.add(etat, "South");
		jp = new JPanel();
		jp.setBackground(Color.pink);
		add(jp);
		for(int i=0; i<names.length; i++) {
			cases[i] = new JCheckBox(names[i]);
			cases[i].setBackground(Color.pink);
			cases[i].setForeground(Color.white);
			cases[i].addActionListener(this);
			cases[i].addItemListener(this);
		    jp.add(cases[i]);
		}
		jp.add(state);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==raz) {
			for(int i=0; i<names.length; i++) {
				cases[i].setSelected(false);
		}
		}
		else if(e.getSource()==etat) {
			String st = " ";
			for(int i=0; i<names.length; i++) {
				
			if(cases[i].isSelected()) st+=names[i]+" ";
			}
			if(!st.equals(" "))state.setText("Les cases cochees : "+st);
			else state.setText("Aucune case n'est choisie");
		}
		else System.out.println("Action "+((JCheckBox)e.getSource()).getText());
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println("Changement "+((JCheckBox)e.getSource()).getText());
		
	}
	Container korzinka;
	JButton raz, etat;
	JPanel jp;
	JCheckBox []cases;
	JLabel state;
	String []names;
}
