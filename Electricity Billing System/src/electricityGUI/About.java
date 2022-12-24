/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricityGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author lenanguelo
 */
public class About extends JFrame implements ActionListener{
    JButton exitButton;
    JLabel aboutLabel;
    TextArea aboutDescriptionTF;
    String aboutDescription;

    public About() {
        this.setLayout(null);
        exitButton = new JButton("Exit");
        add(exitButton);
        exitButton.setBounds(180, 430, 120, 20);
        exitButton.addActionListener(this);
        Font f = new Font("RALEWAY", Font.BOLD, 180);
        setFont(f);
        
        aboutDescription = "                                    About Projects          \n  "
        + "\nElectricity Billing System is a software-based application "
        + "developed in Java programming language. The project aims at serving"
        + "the department of electricity by computerizing the billing system. "
        + "It mainly focuses on the calculation of Units consumed during the "
        + "specified time and the money to be paid to electricity offices. "
        + "This computerized system will make the overall billing system easy, "
        + "accessible, comfortable and effective for consumers.\n\n"
        ;
        
        TextArea t1 = new TextArea(aboutDescription, 10, 40, Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(20, 100, 450, 300);
        add(t1);
        Font f1 = new Font("RALEWAY", Font.BOLD, 16);
        t1.setFont(f1);
        JLabel l1 = new JLabel("About Project");
        add(l1);
        l1.setBounds(170, 10, 180, 80);
        l1.setForeground(Color.red);
        Font f2 = new Font("RALEWAY", Font.BOLD, 20);
        l1.setFont(f2);
        
        setBounds(500, 120, 500, 550);
        
        setLayout(null);
        setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }
    
    public static void main(String args[]) {
        new About().setVisible(true);
    }
    
}
