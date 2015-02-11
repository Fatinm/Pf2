import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;


public class AnimalGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalGUI frame = new AnimalGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AnimalGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
		ArrayList<Animal> listAnimal = new ArrayList<Animal>();
		
		listAnimal.add(new Dog("Canis Stupidus", "DumbDog" , 3, true));
		listAnimal.add(new Dog("Canis Intelegentus","Snoop Dogg", 3, false));
		listAnimal.add(new Cat( "Feles Mortalius", "PhatCat",  5, 4));
		listAnimal.add(new Cat("Feles Deadlius", "Olof",  5, 2));
		listAnimal.add(new Snake("PoSnake","Anguis Poisy", true));
		listAnimal.add(new Snake("NoSnake", "Anguis Nopoisy", false));
		;
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("List of Animals");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel.setBounds(5,-48,236,124);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 153, 102));
		textArea.setBounds(5, 5, 688, 265);
		textArea.setEditable(false);
		contentPane.add(textArea);
		
		for(Animal i: listAnimal){
			textArea.append(i.getInfo() + "\n");
			
		}
		
		
	}
}
