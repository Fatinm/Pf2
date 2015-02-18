
import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.util.Random; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;


public class DigitalClockGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldHour;
	private JTextField textFieldMinutes;
	private ClockLogic clockLogic; 
	
	JLabel lblAlarmClock = new JLabel("00:00:00");
	JLabel lblAlarmSet = new JLabel("Alarm is not set");
	JButton btnClearAlarm = new JButton("Clear Alarm");
	JLabel lblErrorMsg = new JLabel("");
	JLabel lblAlarmMsg = new JLabel("");

	
	Random rand = new Random();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
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
	public DigitalClockGUI() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(DigitalClockGUI.class.getResource("/images/clock.png")));
		setFont(new Font("Arial Unicode MS", Font.BOLD, 25));
		setForeground(new Color(128, 0, 128));
		setTitle("Alarm Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 588);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAlarmClock.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlarmClock.setFont(new Font("Arial", Font.BOLD, 32));
		lblAlarmClock.setForeground(Color.WHITE);
		lblAlarmClock.setBackground(Color.WHITE);
		lblAlarmClock.setBounds(164, 11, 237, 45);
		contentPane.add(lblAlarmClock);
		
		textFieldHour = new JTextField();
		textFieldHour.setBounds(164, 375, 70, 40);
		contentPane.add(textFieldHour);
		textFieldHour.setColumns(10);
		
		textFieldMinutes = new JTextField();
		textFieldMinutes.setColumns(10);
		textFieldMinutes.setBounds(164, 457, 70, 40);
		contentPane.add(textFieldMinutes);
		
		JLabel lblHour = new JLabel("Hour:");
		lblHour.setFont(new Font("Cambria", Font.BOLD, 24));
		lblHour.setForeground(Color.WHITE);
		lblHour.setBounds(71, 375, 63, 40);
		contentPane.add(lblHour);

		JLabel lblMinutes = new JLabel("Minutes:");
		lblMinutes.setForeground(Color.WHITE);
		lblMinutes.setFont(new Font("Cambria", Font.BOLD, 24));
		lblMinutes.setBounds(36, 451, 98, 45);
		contentPane.add(lblMinutes);

		JButton btnSetAlarm = new JButton("Set Alarm");
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			    int hourCheck = Integer.parseInt(textFieldHour.getText());
			    int minuteCheck = Integer.parseInt(textFieldMinutes.getText());

			    if (hourCheck < 0 || hourCheck > 23 || minuteCheck < 0
			      || minuteCheck > 59) {
			     lblErrorMsg.setText("Please input a real time");
			    } else {
			     String noll4 = "";
			     String noll5 = "";
			     
			     if (hourCheck < 10){
			      noll4 = "0";
			     }
			     if (minuteCheck < 10){
			      noll5 = "0";
			     }
			     
			     
			     lblAlarmSet.setText(noll4 + hourCheck + ":" + noll5 + minuteCheck);
			     
			     clockLogic.setAlarm(hourCheck, minuteCheck);

				
				float hue = rand.nextFloat();
				float sat = (rand.nextInt(2000) + 5000) / 10000f;
				float lum = 0.8f;
				Color color = Color.getHSBColor(hue, sat, lum);
				contentPane.setBackground(color); 
				lblAlarmSet.setText("Alarm Set " + textFieldHour.getText() + ":" + textFieldMinutes.getText());
				
				noll4 = "";
			    noll5 = "";
			    
			    lblErrorMsg.setText("");
			    lblAlarmMsg.setText("");
			}
			}
			});
		btnSetAlarm.setForeground(Color.DARK_GRAY);
		btnSetAlarm.setFont(new Font("Cambria", Font.BOLD, 24));
		btnSetAlarm.setBounds(330, 375, 188, 40);
		contentPane.add(btnSetAlarm);
		

		btnClearAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldHour.setText("");
				textFieldMinutes.setText("");
				lblAlarmSet.setText("No Alarm");
				clockLogic.clearAlarm();
			}
		});
		btnClearAlarm.setForeground(Color.DARK_GRAY);
		btnClearAlarm.setFont(new Font("Cambria", Font.BOLD, 24));
		btnClearAlarm.setBounds(330, 457, 188, 40);
		contentPane.add(btnClearAlarm);
		
		lblAlarmSet.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlarmSet.setForeground(Color.DARK_GRAY);
		lblAlarmSet.setFont(new Font("Cambria", Font.BOLD, 22));
		lblAlarmSet.setBackground(Color.DARK_GRAY);
		lblAlarmSet.setBounds(164, 65, 237, 40);
		contentPane.add(lblAlarmSet);
		
		JLabel imageClock = new JLabel("");
		imageClock.setBackground(Color.WHITE);
		imageClock.setBounds(-21, -47, 408, 297);
		contentPane.add(imageClock);
		lblErrorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblErrorMsg.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblErrorMsg.setForeground(Color.DARK_GRAY);
		lblErrorMsg.setBounds(164, 105, 237, 36);
		contentPane.add(lblErrorMsg);
		lblAlarmMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlarmMsg.setFont(new Font("Calibri", Font.BOLD, 24));
		lblAlarmMsg.setForeground(Color.DARK_GRAY);
		
		
		lblAlarmMsg.setBounds(164, 90, 237, 45);
		contentPane.add(lblAlarmMsg);
		
		
		
		clockLogic = new ClockLogic(this);

	}
	public void setTimeOnLabel (String time){
		lblAlarmClock.setText(time);
	}
	
	public void alarm (boolean activate){
		if (true) {
			lblAlarmMsg.setText("Carpe Diem, bruh.");
		}
		
	}
}