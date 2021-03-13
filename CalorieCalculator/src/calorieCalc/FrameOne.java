package calorieCalc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FrameOne {

	private JFrame answer;
	private JTextField weightBox;
	private JTextField goalBox;
	private JTextField weekBox;
	private JTextField calorieOutput;
	private JTextField proteinOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameOne window = new FrameOne();
					window.answer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameOne() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		answer = new JFrame();
		answer.setTitle("Calorie Calculator");
		answer.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		answer.setBounds(100, 100, 635, 446);
		answer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		answer.getContentPane().setLayout(null);
		
		JButton goalWeight = new JButton("Calculate!");
		goalWeight.setFont(new Font("Tahoma", Font.BOLD, 11));
		goalWeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int weight, weightGoal, weeks, weightDifference, calorieDifference, totalProtein;
				
				try {
					weight = Integer.parseInt(weightBox.getText());
					weightGoal = Integer.parseInt(goalBox.getText());
					weeks = Integer.parseInt(weekBox.getText());
					
					
					totalProtein = weight;
					
					if (weight < weightGoal) {
						weightDifference = weightGoal - weight;
						calorieDifference =  500 * (weightDifference / weeks);
						calorieOutput.setText(calorieDifference + " Calorie Surplus per day");
					}else {
						weightDifference = weight - weightGoal;
						calorieDifference = 500 * weightDifference;
						calorieOutput.setText(calorieDifference + " Calorie Deficit per day");
					}
					
					proteinOutput.setText("at least "+ totalProtein + " grams per day");
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Please enter an integer number!");
				}
			}
		});
		goalWeight.setBounds(176, 253, 179, 29);
		answer.getContentPane().add(goalWeight);
		
		weightBox = new JTextField();
		weightBox.setText("Enter weight here");
		weightBox.setBounds(108, 52, 353, 29);
		answer.getContentPane().add(weightBox);
		weightBox.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter your body weight in pounds below:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(73, 25, 388, 14);
		answer.getContentPane().add(lblNewLabel);
		
		JLabel lbs = new JLabel("lbs");
		lbs.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbs.setBounds(484, 51, 64, 29);
		answer.getContentPane().add(lbs);
		
		goalBox = new JTextField();
		goalBox.setText("Enter weight here");
		goalBox.setColumns(10);
		goalBox.setBounds(108, 127, 353, 29);
		answer.getContentPane().add(goalBox);
		
		JLabel lblEnterYourGoal = new JLabel("Enter your goal weight in pounds below:");
		lblEnterYourGoal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblEnterYourGoal.setBounds(73, 102, 388, 14);
		answer.getContentPane().add(lblEnterYourGoal);
		
		JLabel label = new JLabel("lbs");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(484, 136, 64, 29);
		answer.getContentPane().add(label);
		
		JLabel lblEnterNumberOf = new JLabel("Enter number of weeks:");
		lblEnterNumberOf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblEnterNumberOf.setBounds(73, 179, 388, 14);
		answer.getContentPane().add(lblEnterNumberOf);
		
		weekBox = new JTextField();
		weekBox.setText("Enter weeks here");
		weekBox.setColumns(10);
		weekBox.setBounds(108, 204, 353, 29);
		answer.getContentPane().add(weekBox);
		
		JLabel lblWeeks = new JLabel("Weeks");
		lblWeeks.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWeeks.setBounds(484, 203, 64, 29);
		answer.getContentPane().add(lblWeeks);
		
		calorieOutput = new JTextField();
		calorieOutput.setBounds(128, 293, 227, 29);
		answer.getContentPane().add(calorieOutput);
		calorieOutput.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Calorie difference:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 297, 108, 21);
		answer.getContentPane().add(lblNewLabel_1);
		
		proteinOutput = new JTextField();
		proteinOutput.setColumns(10);
		proteinOutput.setBounds(128, 333, 227, 29);
		answer.getContentPane().add(proteinOutput);
		
		JLabel lblProteinNeeded = new JLabel("Protein needed:");
		lblProteinNeeded.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProteinNeeded.setBounds(10, 340, 108, 21);
		answer.getContentPane().add(lblProteinNeeded);
	}
}
