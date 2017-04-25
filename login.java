package parkinglots;
import javax.swing.*;
import java.awt.*;

public class login {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Login");
		frame.setBounds(300, 150, 450, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.WEST;
		
		JLabel usernameLabel = new JLabel("<html>Username:  <br></html>");
		JLabel passwordLabel = new JLabel("<html>Password:  <br></html>");
		JTextField usernameText = new JTextField(15);
		JTextField passwordText = new JTextField(15);
		JButton submit = new JButton("Log in");
		JButton register = new JButton("Register");
		JButton forgetpw = new JButton("Forget Password");
		add(frame, usernameLabel, c, 0, 2, 1, 1);
		add(frame, passwordLabel, c, 0, 4, 1, 1);
		add(frame, usernameText, c, 2, 2, 1, 1);
		add(frame, passwordText, c, 2, 4, 1, 1);
		add(frame, submit, c, 0, 6, 1, 1);
		add(frame, forgetpw, c, 2, 6, 1, 1);
		add(frame, register, c, 0, 8, 1, 1);
		
        frame.setVisible(true);
	}
	
	public static void add(JFrame frame, Component label, GridBagConstraints c, int x, int y, int w, int h){
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = w;
		c.gridheight = h;
		frame.add(label, c);
	}

}
