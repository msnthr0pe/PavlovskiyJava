package Pr16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;

public class Guess extends JFrame {

    private int guessedNum = new Random().nextInt(21);
    private int att = 3;
    public Guess() {
        JFrame frame = new JFrame("Guess game");
        setWindow(frame);
        frame.setVisible(true);
    }

    private void setWindow(JFrame frame){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        frame.setLocation(x-200, y-200);
        frame.setSize(500,500);
        frame.setLayout(new GridBagLayout());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setWidgets(frame);
    }

    private void setWidgets(JFrame frame){
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets.set(50,0,0, 0);

        gbc.gridx = 1;
        gbc.gridy = 1;

        JLabel label = new JLabel("УGuess the number from 1 to 20");
        Font font = label.getFont();
        Font newFont = font.deriveFont(font.getSize() + 7f);
        label.setFont(newFont);
        frame.add(label, gbc);

        JLabel countAtt = new JLabel("Attempts left: " + att);
        gbc.weighty = 5;
        gbc.insets.set(0,0,0, 0);
        gbc.gridy = 2;
        frame.add(countAtt, gbc);

        JTextField textField = new JTextField("Write a number");
        textField.setPreferredSize(new Dimension(100, 20));

        Color defaultTextColor = textField.getForeground();
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("Write a number")) {
                    textField.setText("");
                    textField.setForeground(defaultTextColor);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("Write a number");
                    textField.setForeground(defaultTextColor);
                }
            }
        });

        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets.set(10,0,10, 0);
        frame.add(textField, gbc);

        JButton send = new JButton("Check");
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridy = 4;
        frame.add(send, gbc);

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String numTxt = textField.getText();
                    int num = Integer.parseInt(numTxt);
                    if (num == guessedNum){
                        JOptionPane.showMessageDialog( null, "You won!");
                        frame.dispose();
                    } else if (num > guessedNum){
                        label.setText("Is less " + num);
                        att--;
                        countAtt.setText("Attempts left: " + att);
                    } else if (num < guessedNum){
                        label.setText("Is more " + num);
                        att--;
                        countAtt.setText("Attempts left: " + att);
                    }
                    textField.setText("");
                } catch (Exception f){
                    JOptionPane.showMessageDialog( null, "Error in data","Warning" , JOptionPane.ERROR_MESSAGE);
                    textField.setText("");
                }
                if (att == 0){
                    JOptionPane.showMessageDialog( null, "You've lost, the number was " + guessedNum);
                    frame.dispose();
                }
            }
        });


    }

    public static void main(String[] args) {
        new Guess();
    }
}