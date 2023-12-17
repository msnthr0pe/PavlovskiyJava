package Pr17.MVCEmployee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeView extends JFrame{

    JButton promoteButton = new JButton("Increase salary");
    JButton lowerButton = new JButton("Decrease salary");
    JButton displayButton = new JButton("Show data");

    public void GUI(EmployeeController controller){
        JFrame frame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        frame.setLocation(x-200, y-200);
        frame.setSize(550,100);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(promoteButton);
        frame.add(lowerButton);
        frame.add(displayButton);

        promoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.IncreaseSalary();
                controller.UpdateView();
            }
        });

        lowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.ReduceSalary();
                controller.UpdateView();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.UpdateView();
            }
        });
        frame.setVisible(true);
    }

    public void ViewData(String name, String post, double salary){
        JOptionPane.showMessageDialog(null, "Employee Name: " + name + "\nPosition: " + post + "\nSalary: " + salary);
    }
}