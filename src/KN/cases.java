package KN;
import javax.swing.* ;
import java.awt.* ;     
import java.awt.event.* ;


public class cases {
    public static void main(String [] args) {
    	fe f = new fe();
    	f.setVisible(true);
    }
}


class fe extends JFrame implements ItemListener, ActionListener{
	public fe() {
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
		cercle = new JCheckBox("Cercle");
		cercle.setBackground(Color.pink);
		cercle.setForeground(Color.white);
		cercle.addActionListener(this);
		cercle.addItemListener(this);
		rect =  new JCheckBox("Rectangle");
		rect.setBackground(Color.pink);
		rect.setForeground(Color.white);
		rect.addActionListener(this);
		rect.addItemListener(this);
		tri =  new JCheckBox("Triangle");
		tri.setBackground(Color.pink);
		tri.setForeground(Color.white);
		tri.addActionListener(this);
		tri.addItemListener(this);
		jp.setLayout(new FlowLayout());
		jp.add(cercle);
		jp.add(rect);
		jp.add(tri);
		jp.add(state);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==raz) {
			cercle.setSelected(false);
			rect.setSelected(false);
			tri.setSelected(false);
		}
		else if(e.getSource()==etat) {
			state.setText("cercle : "+cercle.isSelected()+", rectangle "+rect.isSelected()+", triangle : "+tri.isSelected());
		}
		else if(e.getSource()==cercle) System.out.println("Action cercle");
		else if(e.getSource()==rect) System.out.println("Action rectangle");
		else if(e.getSource()==tri) System.out.println("Action triangle");
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==cercle) System.out.println("Changement cercle");
		else if(e.getSource()==rect) System.out.println("Changement rectangle");
		else if(e.getSource()==tri) System.out.println("Changement triangle");
		
	}
	Container korzinka;
	JButton raz, etat;
	JPanel jp;
	JCheckBox cercle, rect, tri;
	JLabel state;
	String []names;
}
