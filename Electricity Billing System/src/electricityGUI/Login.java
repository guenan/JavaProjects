/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricityGUI;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.javafx.embed.swing.Disposer;

import contract.IAuthenticationService;
import dependancyInjection.DI;
import models.LoginInfo;
import service.AuthenticationService;

/**
 *
 * @author lenanguelo
 */
public class Login extends JFrame implements ActionListener{

    JLabel usernameLabel,passwordLabel,avatarLabel, logginfAsLabel;
    JTextField usernameTextField;
    JPasswordField passwordTextField;
    JButton loginButton,cancelButton, signupButton;
    Choice loggingAsChoice;
    

    public Login() throws HeadlessException {
        super("Login Page");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
       
        
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(300, 20, 100, 20);
        add(usernameLabel);
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(300, 60, 100, 20);
        add(passwordLabel);
        
        usernameTextField = new JTextField(15);
        usernameTextField.setBounds(400, 20, 150, 20);
        add(usernameTextField);
        passwordTextField = new JPasswordField(15);
        passwordTextField.setBounds(400, 60, 150, 20);
        add(passwordTextField);
        
        logginfAsLabel = new JLabel("Logging in as");
        logginfAsLabel.setBounds(300, 100, 100, 20);
        add(logginfAsLabel);
        
        loggingAsChoice = new Choice();
        loggingAsChoice.add("Admin");
        loggingAsChoice.add("Customer");
        loggingAsChoice.setBounds(400, 100, 150, 20);
        add(loggingAsChoice);
        
        ImageIcon loginImageIcon;
        Image loginImage;
        
        URL urlResource = getClass().getResource("/images/login.png");
        loginImageIcon = new ImageIcon(urlResource);
        loginImage = loginImageIcon.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);            
        loginButton = new JButton("Login", new ImageIcon(loginImage));
        loginButton.setBounds(330, 160, 100, 20);
        add(loginButton);


        
        ImageIcon cancelImageIcon = new ImageIcon(getClass().getResource("/images/cancel.jpg"));
        Image cancelImage = cancelImageIcon.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        cancelButton = new JButton("Cancel",new ImageIcon(cancelImage));
        cancelButton.setBounds(450, 160, 100, 20);
        add(cancelButton);        
        
        
        ImageIcon signupImageIcon = new ImageIcon(getClass().getResource("/images/signup.png"));
        Image signupImage = signupImageIcon.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        signupButton = new JButton("Signup",new ImageIcon(signupImage));
        signupButton.setBounds(380, 200, 130, 20);
        add(signupButton);
        
        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);
        signupButton.addActionListener(this);
        
        ImageIcon avaterImageIcon = new ImageIcon(getClass().getResource("/images/second.jpg"));
        Image avatarImage = avaterImageIcon.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon avatarImageIcon2 = new ImageIcon(avatarImage);
        avatarLabel = new JLabel(avatarImageIcon2);
        avatarLabel.setBounds(0, 0, 250, 250);
        add(avatarLabel);
        
        setLayout(new BorderLayout());
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
     
        setSize(640,300);
        setLocation(600,300);
        setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
        	LoginInfo loginInfo = new LoginInfo();
        	
            String userLoginName  = usernameTextField.getText();
            String password  = String.valueOf(passwordTextField.getPassword());
            String loginAs = loggingAsChoice.getSelectedItem();
            
            loginInfo.setUserLoginName(userLoginName);
            loginInfo.setUserPassword(password);
            loginInfo.setUserType(loginAs);
            LoginInfo loginInfoResult = null;
            loginInfoResult = DI.getAuthenticationService().authenticateUser(loginInfo);
            
            if(loginInfoResult != null) {
            	System.out.println("authentication successful");
            	// new Project(meter, user).setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null, "Invalid login");
                usernameTextField.setText("");
                passwordTextField.setText("");
            }
            
        }else if(e.getSource() == cancelButton) {
        	setVisible(false);
        }else if(e.getSource() == signupButton) {
        	// launch signup window
        	this.setVisible(false);
            new Signup().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
    	new Login().setVisible(true);
    }
    
}
