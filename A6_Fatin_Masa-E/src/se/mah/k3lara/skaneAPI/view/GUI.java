package se.mah.k3lara.skaneAPI.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import se.mah.k3lara.skaneAPI.xmlparser.Parser;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	JTextField fieldSearch;
	JTextField fieldFrom;
	JTextField fieldTo;

	JTextArea areaResult1 = new JTextArea();
	JTextArea areaResult2 = new JTextArea();
	
	GUI g = this;
	
	private Parser p = new Parser();
	
	Thread t1 = new JourneysThread(p, this);
	Thread t2 = new StationsThread(p, this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setTitle("Sk\u00E5netrafiken");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 306, 490);
		contentPane.add(panel);
		panel.setLayout(null);

		fieldSearch = new JTextField();
		fieldSearch.setBounds(14, 84, 131, 20);
		panel.add(fieldSearch);
		fieldSearch.setColumns(10);

		JLabel lblSkStation = new JLabel("S\u00F6k h\u00E5llplats");
		lblSkStation.setBounds(14, 70, 131, 14);
		panel.add(lblSkStation);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 173, 302, 317);
		panel.add(scrollPane);
		scrollPane.setViewportView(areaResult1);
		
				JButton btn1 = new JButton("S\u00F6k");
				btn1.setBounds(160, 69, 131, 51);
				panel.add(btn1);
				btn1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Thread t2 = new StationsThread(p, g);
						t2.start();
					}
				});

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(378, 0, 297, 490);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		fieldFrom = new JTextField();
		fieldFrom.setBounds(10, 54, 86, 20);
		panel_1.add(fieldFrom);
		fieldFrom.setColumns(10);

		fieldTo = new JTextField();
		fieldTo.setText("");
		fieldTo.setBounds(10, 104, 86, 20);
		panel_1.add(fieldTo);
		fieldTo.setColumns(10);

		JLabel lblFrn = new JLabel("Fr\u00E5n");
		lblFrn.setBounds(10, 38, 46, 14);
		panel_1.add(lblFrn);

		JLabel lblTill = new JLabel("Till");
		lblTill.setBounds(10, 90, 46, 14);
		panel_1.add(lblTill);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 173, 297, 317);
		panel_1.add(scrollPane_1);
		scrollPane_1.setViewportView(areaResult2);
				
						JButton btn2 = new JButton("S\u00F6k resa");
						btn2.setBounds(111, 72, 131, 51);
						panel_1.add(btn2);
						btn2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Thread t1 = new JourneysThread(p, g);
								t1.start();
							}
						});
	}
}