package Pr15;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Calculator extends JFrame{
    JTextField jta1 = new JTextField(10);
    JTextField jta2 = new JTextField(10);
    JButton buttonSum = new JButton("Add");
    JButton buttonDiff = new JButton("Subtract");
    JButton buttonDiv = new JButton("Divide");
    JButton buttonMult = new JButton("Multiply");

    Font fnt = new Font("Times new roman",Font.BOLD,20);
    //начало конструктора класса LabExample
    Calculator(){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x-200, y-200);

        setLayout(new FlowLayout());
        setSize(250,200);

        add(new JLabel("1st Number"));
        add(jta1);

        add(new JLabel("2nd Number"));
        add(jta2);

        add(buttonSum);
        add(buttonDiff);
        add(buttonDiv);
        add(buttonMult);


        buttonSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double x1 = Double.parseDouble(jta1.getText().trim());
                    double x2 = Double.parseDouble(jta2.getText().trim());
                    JOptionPane.showMessageDialog(null, "Result = "+(x1+x2),"Alert",JOptionPane.INFORMATION_MESSAGE);
                    jta1.setText(Double.toString(x1+x2));
                    jta2.setText("");
                }catch(Exception f){
                    JOptionPane.showMessageDialog( null, "Error in Numbers !","alert" , JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonDiff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double x1 = Double.parseDouble(jta1.getText().trim());
                    double x2 = Double.parseDouble(jta2.getText().trim());
                    JOptionPane.showMessageDialog(null, "Result = "+(x1-x2),"Alert",JOptionPane.INFORMATION_MESSAGE);
                    jta1.setText(Double.toString(x1-x2));
                    jta2.setText("");
                }catch(Exception f){
                    JOptionPane.showMessageDialog( null, "Error in Numbers !","alert" , JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double x1 = Double.parseDouble(jta1.getText().trim());
                    double x2 = Double.parseDouble(jta2.getText().trim());
                    if (x2 == 0){
                        throw new Exception("Division by zero");
                    }
                    JOptionPane.showMessageDialog(null, "Result = "+(x1/x2),"Alert",JOptionPane.INFORMATION_MESSAGE);
                    jta1.setText(Double.toString(x1/x2));
                    jta2.setText("");
                }catch(Exception f){
                    if (f.getMessage() == "Division by zero"){
                        JOptionPane.showMessageDialog( null, "Division by zero","alert" , JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog( null, "Error in Numbers !","alert" , JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

        buttonMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double x1 = Double.parseDouble(jta1.getText().trim());
                    double x2 = Double.parseDouble(jta2.getText().trim());
                    JOptionPane.showMessageDialog(null, "Result = "+(x1*x2),"Alert",JOptionPane.INFORMATION_MESSAGE);
                    jta1.setText(Double.toString(x1*x2));
                    jta2.setText("");
                }catch(Exception f){
                    JOptionPane.showMessageDialog( null, "Error in Numbers !","alert" , JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public static void main(String[]args){
        new Calculator();
    }
}