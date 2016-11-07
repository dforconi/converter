package converter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main extends JFrame implements ActionListener, ListSelectionListener {

	String [] listEntries = {"Fahrenheit to Celcius", "Celcius to Fahrenheit", "Miles to Kilometers", 
			"Kilometers to Miles", "Miles per hour to Kilometers per hour", "Kilometers per hour to Miles per hour", 
			"Pounds to Kilograms", "Kilograms to Pounds"};
	JLabel label = new JLabel("Enter a number to convert");
	JTextField field = new JTextField(25);
	JList list = new JList(listEntries);
	JLabel convertLabel = new JLabel("Convert");
	JLabel answer = new JLabel("Answer");
	JTextField answerField = new JTextField(25);
	JScrollPane scroller = new JScrollPane(list);
	JButton button = new JButton("Convert");
	JButton clearButton = new JButton("Clear");
	
	int numToConvert;
	String conversion;
	
	public static void main(String args[]) {
		
		Main main = new Main();
		main.go();
		
	}
	
	public void go() {
		
		JFrame frame = new JFrame("Converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		field.addActionListener(this);
		field.setText("0");
	
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		list.addListSelectionListener(this);
		list.setVisibleRowCount(5);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		button.addActionListener(this);
		clearButton.addActionListener(new ClearListener());
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		panel.add(label);
		panel.add(field);
		panel.add(convertLabel);
		panel.add(scroller);
		panel.add(button);
		panel.add(answer);
		panel.add(answerField);
		panel.add(clearButton);
		
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.pack();
		
	}
	
	public void actionPerformed(ActionEvent ev) {
	//	System.out.println("clicked convert");
	//	System.out.println(field.getText());
		
		numToConvert = Integer.parseInt(field.getText());
		
	//	System.out.println("Temperature = " + numToConvert);
		System.out.println("conversion on convert click = " + conversion);
		
		if (list.isSelectionEmpty()) {
			answerField.setText("Please select conversion unit");
		}
		
		switch(conversion) {   // on convert click get from scroller
		case "Fahrenheit to Celcius":
		//	System.out.println(temperature + " in Celcius is " + toCelcius(temperature)); // on convert click pass in temperature and send to answer field
			answerField.setText(Integer.toString(numToConvert) + " degrees Fahrenheit is " + Integer.toString(toCelcius(numToConvert))+ " degrees Celcius");
			break;
			
		case "Celcius to Fahrenheit":
		//	System.out.println(temperature + " in Fahrenheit is " + toFahrenheit(temperature)); // send to answer field
			answerField.setText(Integer.toString(numToConvert) + " degrees Celcius is " + Integer.toString(toFahrenheit(numToConvert)) + " degrees Fahrenheit");
			break;
			
		case "Miles to Kilometers":
			answerField.setText(Double.toString(numToConvert) + " miles is " + Double.toString(toKilometers(numToConvert)) + " kilometers");
			break;
			
		case "Kilometers to Miles":
			answerField.setText(Double.toString(numToConvert) + " kilometers is " + Double.toString(toMiles(numToConvert)) + " miles");
			break;
			
		case "Miles per hour to Kilometers per hour":
			answerField.setText(Double.toString(numToConvert) + " mph is " + Double.toString(toKPH(numToConvert)) + " kph");
			break;
			
		case "Kilometers per hour to Miles per hour":
			answerField.setText(Double.toString(numToConvert) + " kph is " + Double.toString(toMPH(numToConvert)) + " mph");
			break;
			
		case "Pounds to Kilograms":
			answerField.setText(Double.toString(numToConvert) + " pounds is " + Double.toString(toKilograms(numToConvert)) + " kilograms");
			break;
			
		case "Kilograms to Pounds":
			answerField.setText(Double.toString(numToConvert) + " kilograms is " + Double.toString(toPounds(numToConvert)) + " pounds");
			break;
			
		default:
			System.out.println("Choose again");
		}
		
	}
	
	public void valueChanged(ListSelectionEvent lse) {
		if ( !lse.getValueIsAdjusting() ) {
				String selection = (String) list.getSelectedValue();
				System.out.println(selection);
				conversion = selection;
	//			System.out.println("Conversion = " + conversion);
		}
	}
	
	class ClearListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
	//		System.out.println("clear pressed");
			
			field.setText("0");
			field.requestFocus();
			answerField.setText("");			
		}	
	}
	
	
	public static int toCelcius(int fahrenheit) {
		
		int celcius = (fahrenheit - 32) * 5/9;
		
		return celcius;	
	}
	
	public static int toFahrenheit(int celcius) {
		
		int fahrenheit = celcius * 9/5 + 32;
		
		return fahrenheit;
	}
	
	public static double toKilometers(double miles) {
		
		double kilometers = miles / .62137;
		
		return kilometers;		
	}
	
	public static double toMiles(double kilometers) {
		
		double miles = kilometers * .62137;
		
		return miles;
	}
	
	public static double toKPH(double mph) {
		
		double kph = mph * 1.609344;
		
		return kph;
	}
	
	public static double toMPH(double kph) {
		
		double mph = kph / 1.609344;
		
		return mph;
	}
	
	public static double toKilograms(double pounds) {
		
		double kg = pounds / 2.2046;
		
		return kg;
	}
	
	public static double toPounds(double kilograms) {
		
		double pounds = kilograms * 2.2046;
		
		return pounds;
	}
}
