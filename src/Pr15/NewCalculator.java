package Pr15;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewCalculator extends JFrame {

    private String num1 = "";
    private String num2 = "";
    private String oper = "";
    public NewCalculator() throws HeadlessException {
        JFrame frame = new JFrame();
        setWindow(frame);
        frame.setVisible(true);
    }

    private void setWindow(JFrame frame){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        frame.setLocation(x-200, y-200);
        frame.setSize(300,300);
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(4, 4));
        frame.add(panel, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setButtons(frame, panel);
    }

    private void setButtons(JFrame frame, JPanel panel){
        JLabel numbers = new JLabel(num1, SwingConstants.RIGHT);
        numbers.setPreferredSize(new Dimension(getWidth(), 100));
        frame.add(numbers, BorderLayout.NORTH);

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button0 = new JButton("0");
        JButton buttonPlus = new JButton("+");
        JButton buttonMinus = new JButton("-");
        JButton buttonDiv = new JButton("/");
        JButton buttonMult = new JButton("*");
        JButton buttonPoint = new JButton(".");
        JButton buttonEquals = new JButton("=");
        button1.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonDiv);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonMult);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonMinus);
        panel.add(button0);
        panel.add(buttonPoint);
        panel.add(buttonEquals);
        panel.add(buttonPlus);

        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (oper==""){
                    if (num1 != "0"){
                        num1+=button0.getText();
                        numbers.setText(num1);
                    }
                } else {
                    if (num2 != "0"){
                        num2+=button0.getText();
                        numbers.setText(num2);
                    }
                }
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (oper==""){
                    num1+=button1.getText();
                    numbers.setText(num1);
                    System.out.println(num1);
                } else {
                    num2+=button1.getText();
                    numbers.setText(num2);
                    System.out.println(num2);
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (oper==""){
                    num1+=button2.getText();
                    numbers.setText(num1);
                } else {
                    num2+=button2.getText();
                    numbers.setText(num2);
                }
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (oper==""){
                    num1+=button3.getText();
                    numbers.setText(num1);
                } else {
                    num2+=button3.getText();
                    numbers.setText(num2);
                }
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (oper==""){
                    num1+=button4.getText();
                    numbers.setText(num1);
                } else {
                    num2+=button4.getText();
                    numbers.setText(num2);
                }
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (oper==""){
                    num1+=button5.getText();
                    numbers.setText(num1);
                } else {
                    num2+=button5.getText();
                    numbers.setText(num2);
                }
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (oper==""){
                    num1+=button6.getText();
                    numbers.setText(num1);
                } else {
                    num2+=button6.getText();
                    numbers.setText(num2);
                }
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (oper==""){
                    num1+=button7.getText();
                    numbers.setText(num1);
                } else {
                    num2+=button7.getText();
                    numbers.setText(num2);
                }
            }
        });

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (oper==""){
                    num1+=button8.getText();
                    numbers.setText(num1);
                } else {
                    num2+=button8.getText();
                    numbers.setText(num2);
                }
            }
        });

        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (oper==""){
                    num1+=button9.getText();
                    numbers.setText(num1);
                } else {
                    num2+=button9.getText();
                    numbers.setText(num2);
                }
            }
        });
        buttonPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (oper==""){
                    num1+=buttonPoint.getText();
                    numbers.setText(num1);
                } else {
                    num2+=buttonPoint.getText();
                    numbers.setText(num2);
                }
            }
        });

        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oper = "+";
                numbers.setText("");
            }
        });

        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oper = "-";
                numbers.setText("");
            }
        });

        buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oper = "/";
                numbers.setText("");
            }
        });

        buttonMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oper = "*";
                numbers.setText("");
            }
        });

        buttonEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (oper == "+"){
                    Double res = Double.parseDouble(num1) + Double.parseDouble(num2);
                    num1 = res.toString();
                    numbers.setText(num1);
                } else if (oper == "-"){
                    Double res = Double.parseDouble(num1) - Double.parseDouble(num2);
                    num1 = res.toString();
                    numbers.setText(num1);
                }
                else if (oper == "*"){
                    Double res = Double.parseDouble(num1) * Double.parseDouble(num2);
                    num1 = res.toString();
                    numbers.setText(num1);
                } else if (oper == "/"){
                    if (Double.parseDouble(num2) != 0){
                        Double res = Double.parseDouble(num1) - Double.parseDouble(num2);
                        num1 = res.toString();
                        numbers.setText(num1);
                    } else {
                        JOptionPane.showMessageDialog( null, "Division by zero");
                    }

                }
                oper = "";
                num2 = "";
            }
        });
    }
    public static void main(String[] args) {
        new NewCalculator();
    }

}