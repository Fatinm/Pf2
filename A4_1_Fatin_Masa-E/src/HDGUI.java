import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HDGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static Human human;
	private JTextArea textArea;
	private JTextArea textArea_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HDGUI frame = new HDGUI();
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
	
	
	public HDGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 440, 334);
		panel.setBackground(new Color(255, 153, 51));
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();			// New Human
		textField.setBounds(18, 60, 96, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();				//Buy Dog
		textField_1.setBounds(18, 90, 96, 28);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JButton btnNewHuman = new JButton("New Human");
		btnNewHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length() < 4){
					textArea_1.setText("Your name has to include atleast 3 letters"); 
				}else{
				human = new Human(textField.getText());
				}
				
			}
			
		});
		btnNewHuman.setBounds(126, 61, 117, 29);
		panel.add(btnNewHuman);
		
		JButton btnBuyDog = new JButton("Buy Dog");
		btnBuyDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(human == null){
			 textArea_1.setText("I wanna know your name before you buy a dog.");
				
				}else{
					Dog Leon = new Dog(textField_1.getText());
					human.buyDog(Leon);
				}
				
			}
		});
		btnBuyDog.setBounds(126, 91, 117, 29);
		panel.add(btnBuyDog);
		
		JButton btnPrintInfo = new JButton("Print info");
		btnPrintInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(human.getInfo());
				
			}
		});
		btnPrintInfo.setBounds(126, 121, 117, 29);
		panel.add(btnPrintInfo);
		
		JLabel lblHumansAndDogs = new JLabel("Humans and Dogs");
		lblHumansAndDogs.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblHumansAndDogs.setBounds(115, 16, 210, 32);
		panel.add(lblHumansAndDogs);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(30, 171, 35, 28);
		panel.add(lblInfo);
		
		textArea = new JTextArea();
		textArea.setBounds(27, 199, 332, 32);
		panel.add(textArea);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(27, 272, 332, 32);
		panel.add(textArea_1);
		
		JLabel lblErrormessage = new JLabel("ErrorMessage");
		lblErrormessage.setBounds(30, 243, 165, 28);
		panel.add(lblErrormessage);
	}
}