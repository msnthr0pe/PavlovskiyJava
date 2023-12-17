package Pr22;

import javax.swing.*;
import java.awt.*;

public class CalculatorView {
    private JPanel mainPanel;
    private JTextField display;
    private JButton[] buttons;

    private CalculatorController controller;

    public CalculatorView() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        display = new JTextField(10);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 50));
        mainPanel.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        buttons = new JButton[16];
        String[] buttonLabels = {"7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"};

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            buttonPanel.add(buttons[i]);
        }

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
    }

    public void setController(CalculatorController controller) {
        this.controller = controller;
        for (JButton button : buttons) {
            button.addActionListener(controller);
        }
    }

    public void updateDisplay(String text) {
        display.setText(text);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}