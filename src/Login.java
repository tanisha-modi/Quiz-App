import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class Login extends JFrame implements ActionListener{ // JFrame class is under swing package // ActionListener(to change Frames) in awt.events package

    JButton rules, back;   // declaring globally 
    JTextField fname;
    Login() { // constructor // all the features of frame should be written inside it


        getContentPane().setBackground(Color.WHITE);   // for setting background color 

        // swing contains some layouts // to place components on the frame // border-layout, box-Layout, grid-layout : in the form of Table, throw-layout
        setLayout(null); // mean that dev not using inbuilt layouts and building his own 



        // Image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));   // ImageIcon : a class in Jframe, used to take image from the path 
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 500);  // puting image for our layout 
        add(image);  // to add image to the frame, but we can't add directly, we need to make JLabel


        // heading 
        JLabel heading = new JLabel("Modern Games");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITc", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        // name 
        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);

        // input name textfield 
        fname = new JTextField();
        fname.setBounds(735, 200, 300, 25);
        fname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(fname);


        // Buttons
        rules = new JButton("Rules");
        rules.setBounds(735, 270, 120, 25);   // values choosing through hit and trial 
        rules.setBackground(new Color(30, 144, 254));
        rules.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);


        back = new JButton("Back");
        back.setBounds(915, 270, 120, 25);   // values choosing through hit and trial 
        back.setBackground(new Color(30, 144, 254));
        back.setFont(new Font("Times New Roman", Font.BOLD, 20));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        
        
        setSize(1200, 500);
        setLocation(170, 170);
        setVisible(true); // frame is byDefault hidden // that is why we set this true to view it
    }


    public void actionPerformed(ActionEvent ae){   // overridding method the abstract methods for implemetation // for performing action when clicked on buttons 

        if(ae.getSource() == rules){       // check it rules is clicked or back is clicked 
            String name = fname.getText();  // method to get the Text from TextField
            setVisible(false);
            new Rules(name); 
        }
        else if(ae.getSource() == back){
            setVisible(false);   // if back button is pressed, screen will be disappear 
        }
    }

    public static void main(String[] args) {
        new Login(); // anonymous object
    }
}
