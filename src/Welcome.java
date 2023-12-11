import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Welcome extends JFrame {

	private JPanel contentPane;
	private static JProgressBar progressBar;
	private static JLabel lblNewLabel_1;
	private JLabel lblLoading;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		Welcome frame = new Welcome();
		
		//remove border of the frame
		frame.setUndecorated(true);
		
		frame.setVisible(true);
				
		
				try {
					for(int x=0; x<=100; x++ ) {
						Welcome.progressBar.setValue(x);
						Thread.sleep(50);
						Welcome.lblNewLabel_1.setText(Integer.toString(x)+" %");
						if(x == 100) {
							
							//Disappearing the welcome frame
							frame.dispose();
							//open the Login frame
							Login log = new Login();
							log.setVisible(true);
						}
					}
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 438);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/Loading-Gears-Animation-Cool-Nice-Hot.gif"));
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(197, 85, 442, 241);
		contentPane.add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(179, 363, 275, 14);
		contentPane.add(progressBar);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(294, 378, 80, 21);
		contentPane.add(lblNewLabel_1);
		
		lblLoading = new JLabel("Loading...");
		lblLoading.setForeground(Color.WHITE);
		lblLoading.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblLoading.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoading.setBounds(179, 317, 275, 40);
		contentPane.add(lblLoading);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Welcome.class.getResource("/Bimages/abstract-blue-violet-light-line-slash-dark-grey-blank-space-design-modern-futuristic-background_104237-144.jpg")));
		label.setBounds(0, 0, 649, 399);
		contentPane.add(label);
	}
}
