import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class Rules extends JFrame implements ActionListener{

    String name;
    JButton start, back;
    Rules(String name){

        this.name = name;

         getContentPane().setBackground(Color.WHITE);
         setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " to Modern Games" );
        heading.setBounds(50 , 30, 700, 40);
        heading.setFont(new Font("Viner Hand ITc", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        // rules 
        JLabel rules = new JLabel("Welcome " + name + " to Modern Games" );
        rules.setBounds(20 , 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        // rules.setForeground(new Color(30, 144, 254));
        rules.setText(       // method to set the Text 
            "<html>"+ 
                "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
            "<html>"
        );
        add(rules);

        // Buttons
        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);   // values choosing through hit and trial 
        back.setBackground(new Color(30, 144, 254));
        back.setFont(new Font("Times New Roman", Font.BOLD, 20));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);   // values choosing through hit and trial 
        start.setBackground(new Color(30, 144, 254));
        start.setFont(new Font("Times New Roman", Font.BOLD, 20));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);


         setSize(800, 650);
         setLocation(340, 100);
         setVisible(true); 
    }

    public void actionPerformed(ActionEvent ae){   // overridding method the abstract methods for implemetation // for performing action when clicked on buttons 

        if(ae.getSource() == start){       // check it rules is clicked or back is clicked 
             
        }
        else{
            setVisible(false);   // if back button is pressed, screen will be disappear 
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
