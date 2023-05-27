import java.awt.Color;
// import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {  // ActionListener is interface that is being implemented 
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String userAns[][] = new String[10][1];

    JLabel qno, question;
    ButtonGroup groupOptions;
    JRadioButton opt1, opt2, opt3, opt4;
    JButton submit, next, lifeline;

    public static int timer = 5;
    public static int ans_given = 0; // var to check whether the ans is given or not
    public static int count = 0;
    public static int score = 0;
    static String name;

    Quiz(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setBounds(50, 0, 1440, 850);
        setLayout(null);

        // Image
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg")); // ImageIcon : a class in Jframe,
                                                                                       // used to take image from the
                                                                                       // path
        JLabel image = new JLabel(i2);
        image.setBounds(0, 0, 1440, 392); // puting image for our layout
        add(image); // to add image to the frame, but we can't add directly, we need to make JLabel

        // ques no
        qno = new JLabel(" ");
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        // question
        question = new JLabel(" ");
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        // questions
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        // answers
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        // option 1
        opt1 = new JRadioButton(" ");
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        // option 2
        opt2 = new JRadioButton(" ");
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        // option 3
        opt3 = new JRadioButton(" ");
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        // option 4
        opt4 = new JRadioButton(" ");
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupOptions = new ButtonGroup(); // group the radio buttons so that if one button is selected all other buttons
                                          // got deselected
        groupOptions.add(opt1);
        groupOptions.add(opt2);
        groupOptions.add(opt3);
        groupOptions.add(opt4);

        // Buttons
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40); // values choosing through hit and trial
        next.setBackground(new Color(30, 144, 254));
        next.setFont(new Font("", Font.PLAIN, 22));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40); // values choosing through hit and trial
        lifeline.setBackground(new Color(30, 144, 254));
        lifeline.setFont(new Font("", Font.PLAIN, 22));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40); // values choosing through hit and trial
        submit.setBackground(new Color(30, 144, 254));
        submit.setFont(new Font("", Font.PLAIN, 22));
        submit.setForeground(Color.WHITE);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        start(count);

        // for timer we need to use graphic class

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) { // user clicked on next button
            repaint();
            opt1.setEnabled(true); // due to disabling of some options for lifeline, they needed to be enable again
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;

            if (groupOptions.getSelection() == null) { // if the user has not selected the ans
                userAns[count][0] = "";
            } else {
                userAns[count][0] = groupOptions.getSelection().getActionCommand();
            }

            if (count == 8) { // disabling the next button and enabling submit button at last ques
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);

        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else {
            ans_given = 1;
            if (groupOptions.getSelection() == null) { // if the user has not selected the ans
                userAns[count][0] = "";
            } else {
                userAns[count][0] = groupOptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < userAns.length; i++) {
                if (userAns[i][0].equals(answers[i][1])) {
                    score += 10;
                }
            }
            setVisible(false);
            count = 0;
            new Score(name, score);
            // score class visible hogi
        }
    }

    // to change the time every second
    // we dont need to call paint method // it is called automatically when object
    // is created
    public void paint(Graphics g) { // it is used to reframe // to change something on frame in particular time
                                    // interval // using graphic class
        super.paint(g); // paint method from its super class

        String time = "Time left - " + timer + " sec"; // change the time every second
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1100, 500); // show on Frame
        } else {
            g.drawString("Times Up!!", 1100, 500);
        }

        timer--; // decrement the timer by 1, initially which was 15

        try {
            Thread.sleep(1000); // using thread class we can delay the execution of code by some sec // takes
                                // value in milisec
            repaint();
        } catch (Exception e) {
            e.printStackTrace(); // in these code, there is the chance of exception occuring
        }

        if (ans_given == 1) { // if(ques is answered)
            ans_given = 0; // keeping it 0 for next question
            timer = 12; // again timer will be set to its initial value for next question

        } else if (timer < 0) { // if(time is up )
            timer = 8;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) { // disabling the next button and enabling submit button at last ques
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            if (count == 9) { 
                if (groupOptions.getSelection() == null) { // if the user has not selected the ans
                    userAns[count][0] = "";
                } else {
                    userAns[count][0] = groupOptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < userAns.length; i++) {
                    if (userAns[i][0].equals(answers[i][1])) {
                        score += 10;
                    }
                }
                setVisible(false);
                count = 0;
                new Score(name, score);
                // score class visible hogi
            } else {

                if (groupOptions.getSelection() == null) { // if the user has not selected the ans
                    userAns[count][0] = "";
                } else {
                    userAns[count][0] = groupOptions.getSelection().getActionCommand(); // returns the option value that
                                                                                        // is
                                                                                        // being selected
                    // groupOption gives option // getSelection gives the option that is selected
                    // and // getActioncommand
                    // gives the value of that selected option
                }

                count++;
                start(count); // to call the start for next question
            }
        }
    }

    public void start(int countx) {

        qno.setText("" + (countx + 1) + ". ");
        question.setText(questions[countx][0]);

        opt1.setText(questions[countx][1]);
        opt1.setActionCommand(questions[countx][1]); 

        opt2.setText(questions[countx][2]);
        opt2.setActionCommand(questions[countx][2]);

        opt3.setText(questions[countx][3]);
        opt3.setActionCommand(questions[countx][3]);

        opt4.setText(questions[countx][4]);
        opt4.setActionCommand(questions[countx][4]);

        groupOptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("user");
    }
}
