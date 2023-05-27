import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener{
    Score(String name, int score){

        getContentPane().setBackground(Color.WHITE);
        setBounds(400, 150, 750, 550);
        setLayout(null);

        // Image
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));  
        Image i3 = i2.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);   // scaling image 
        ImageIcon i4 = new ImageIcon(i3);
        JLabel image = new JLabel(i4);
        image.setBounds(0, 200,  300, 250); // puting image for our layout
        add(image); // to add image to the frame, but we can't add directly, we need to make JLabel

         
        JLabel heading = new JLabel("Thank-You " + name + " for playing Modern Games");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);

        JLabel scoree = new JLabel("Your score is :  " + score);
        scoree.setBounds(350, 200, 300, 30);
        scoree.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(scoree);


        JButton next = new JButton("Play Again");
        next.setBounds(380, 270, 120, 30); // values choosing through hit and trial
        next.setBackground(new Color(30, 144, 254));
        next.setFont(new Font("", Font.PLAIN, 16));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {
        new Score("user", 0);
    }
}
