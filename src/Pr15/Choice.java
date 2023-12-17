package Pr15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Choice extends JFrame {


    JTextArea jta = new JTextArea(10, 60);


    Choice(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x-200, y-200);
        setSize(400,300);
        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        getContentPane().add(BorderLayout.NORTH, northPanel);

        JComboBox<String> colorBox = new JComboBox<>(new String[]{"Pink", "Gray", "Orange"});
        colorBox.setEditable(true);
        colorBox.setSelectedItem("Select an option");
        colorBox.setEditable(false);
        northPanel.add(colorBox, BorderLayout.NORTH);

        JComboBox<String> infoBox = new JComboBox<>(new String[]{"Austia", "USA", "UK" ,"Canada"});
        infoBox.setEditable(true);
        infoBox.setSelectedItem("Select country");
        infoBox.setEditable(false);
        northPanel.add(infoBox, BorderLayout.NORTH);

        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
        jta.setEditable(false);

        getContentPane().add(BorderLayout.CENTER, jta);
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp);

        colorBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> source = (JComboBox<String>) e.getSource();
                String selectedOption = (String) source.getSelectedItem();
                if (selectedOption == "Pink"){
                    jta.setForeground(Color.PINK);
                } else if (selectedOption == "Gray"){
                    jta.setForeground(Color.GRAY);
                } else if (selectedOption == "Orange"){
                    jta.setForeground(Color.ORANGE);
                }
            }
        });

        infoBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> source = (JComboBox<String>) e.getSource();
                String selectedOption = (String) source.getSelectedItem();
                if (selectedOption == "Austria"){
                    jta.setText("Austria");
                } else if(selectedOption == "USA"){
                    jta.setText("USA");
                } else if(selectedOption == "UK"){
                    jta.setText("UK");
                } else if(selectedOption == "Canada"){
                    jta.setText("Canada");
                }

            }
        });

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Choice();
    }
}