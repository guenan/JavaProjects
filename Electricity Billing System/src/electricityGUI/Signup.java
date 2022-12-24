package electricityGUI;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import dependancyInjection.DI;
import models.LoginInfo;




public class Signup extends JFrame implements ActionListener{
	
    JPanel mainContentPanel;
    JTextField loginUsernameTextfield, usernameTextfield, passwordTextfield, meterNumberTextfield;
    Choice userTypeChoice;
    JButton createButton, cancelButton;
    Signup(){
        setBounds(600, 250, 700, 400);
        
        mainContentPanel = new JPanel();
        mainContentPanel.setBounds(30, 30, 650, 300);
        mainContentPanel.setLayout( null);
        mainContentPanel.setBackground(Color.WHITE);
        mainContentPanel.setForeground(new Color(34, 139, 34));
        mainContentPanel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
        add(mainContentPanel);
        
        JLabel loginUsernameLabel = new JLabel("Username");
        loginUsernameLabel.setForeground(Color.DARK_GRAY);
        loginUsernameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        loginUsernameLabel.setBounds(100, 50, 100, 20);
        mainContentPanel.add(loginUsernameLabel);
        
        loginUsernameTextfield = new JTextField();
        loginUsernameTextfield.setBounds(260, 50, 150, 20);
        mainContentPanel.add(loginUsernameTextfield);
        
        JLabel usernameLabel = new JLabel("Name");
        usernameLabel.setForeground(Color.DARK_GRAY);
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        usernameLabel.setBounds(100, 90, 100, 20);
        mainContentPanel.add(usernameLabel);
        
        usernameTextfield = new JTextField();
        usernameTextfield.setBounds(260, 90, 150, 20);
        mainContentPanel.add(usernameTextfield);
        
        
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.DARK_GRAY);
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordLabel.setBounds(100, 130, 100, 20);
        mainContentPanel.add(passwordLabel);
        
        passwordTextfield = new JTextField();
        passwordTextfield.setBounds(260, 130, 150, 20);
        mainContentPanel.add(passwordTextfield);
        
        
        JLabel userTypeLabel = new JLabel("Create Account As");
        userTypeLabel.setForeground(Color.DARK_GRAY);
        userTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        userTypeLabel.setBounds(100, 170, 140, 20);
        mainContentPanel.add(userTypeLabel);
        
        
        JLabel meterNumberLabel = new JLabel("Meter Number");
        meterNumberLabel.setForeground(Color.DARK_GRAY);
        meterNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        meterNumberLabel.setBounds(100, 210, 100, 20);
        meterNumberLabel.setVisible(false);
        mainContentPanel.add(meterNumberLabel);
        
        meterNumberTextfield = new JTextField();
        meterNumberTextfield.setBounds(260, 210, 150, 20);
        meterNumberTextfield.setVisible(false);
        mainContentPanel.add(meterNumberTextfield);
        
        userTypeChoice = new Choice();
        userTypeChoice.add("Admin");
        userTypeChoice.add("Customer");
        userTypeChoice.setBounds(260, 170, 150, 20);
        mainContentPanel.add(userTypeChoice);
        
        userTypeChoice.addItemListener(new ItemListener(){
           public void itemStateChanged(ItemEvent ae){
               String user = userTypeChoice.getSelectedItem();
               if(user.equals("Customer")){
                   meterNumberLabel.setVisible(true);
                   meterNumberTextfield.setVisible(true);
               }else{
                   meterNumberLabel.setVisible(false);
                   meterNumberTextfield.setVisible(false);
               }
           } 
        });
        
        
        createButton = new JButton("Create");
        createButton.setBackground(Color.BLACK);
        createButton.setForeground(Color.WHITE);
        createButton.setBounds(140, 290, 120, 30);
        createButton.addActionListener(this);
        mainContentPanel.add(createButton);
        
        cancelButton = new JButton("Back");
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(300, 290, 120, 30);
        cancelButton.addActionListener(this);
        mainContentPanel.add(cancelButton);
        
        ImageIcon avatarIcon = new ImageIcon(getClass().getResource("/images/signupImage.png"));
        Image avatarImage = avatarIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon finalAvatarIcon = new ImageIcon(avatarImage);
        JLabel avatarLabel = new JLabel(finalAvatarIcon);
        avatarLabel.setBounds(450, 30, 250, 250);
        mainContentPanel.add(avatarLabel);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }



	@Override
	public void actionPerformed(ActionEvent ev) {
		
		if(ev.getSource() == createButton) {
			LoginInfo loginInfo = new LoginInfo();
			loginInfo.setMeter(meterNumberTextfield.getText());
			loginInfo.setUserLoginName(loginUsernameTextfield.getText());
			loginInfo.setUserName(usernameTextfield.getText());
			loginInfo.setUserPassword(passwordTextfield.getText());
			loginInfo.setUserType(userTypeChoice.getSelectedItem());
			
            if(loginInfo.getUserType().equals("Admin")){
                DI.getSignupService().createLoginInfo(loginInfo);
            }else{
                DI.getSignupService().updateLoginInfo(loginInfo);
            }
            
            JOptionPane.showMessageDialog(null, "Account Created Successfully");
            this.setVisible(false);
            new Login().setVisible(true);
			
		}else if(ev.getSource() == cancelButton) {
            this.setVisible(false);
            new Login().setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new Signup().setVisible(true);

	}

}
