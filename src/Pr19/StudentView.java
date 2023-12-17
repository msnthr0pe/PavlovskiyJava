package Pr19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentView extends JFrame {

    JButton SortByGPAButton = new JButton("Sort");
    JButton FindButton = new JButton("Find");
    JTextField NameTF = new JTextField();
    JTextField SurnameTF = new JTextField();
    JLabel NameLabel = new JLabel("Name");
    JLabel SurnameLabel = new JLabel("Surname");

    JLabel AllStudentsLabel = new JLabel("");
    public void GUI(StudentController controller){
        JFrame frame = new JFrame("Students");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        frame.setLocation(x-200, y-200);
        frame.setSize(550,500);
        frame.setLayout(new GridBagLayout());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NameTF.setPreferredSize(new Dimension(100, 20));
        SurnameTF.setPreferredSize(new Dimension(100, 20));
        AllStudentsLabel.setPreferredSize(new Dimension(500, 400));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = gbc.weightx = 1;

        gbc.gridy = 0;
        gbc.gridx = 0;

        frame.add(NameLabel, gbc);

        gbc.gridy = 1;

        frame.add(SurnameLabel, gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;

        frame.add(NameTF, gbc);

        gbc.gridy = 1;

        frame.add(SurnameTF, gbc);

        gbc.gridheight = 2;
        gbc.gridy = 0;
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        frame.add(FindButton, gbc);

        gbc.gridx = 3;

        frame.add(SortByGPAButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 4;
        gbc.gridwidth = 4;

        frame.add(AllStudentsLabel, gbc);


        SortByGPAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllStudentsLabel.setText("");
                controller.quickSort(0, controller.models.size()-1);
                controller.UpdateView();
            }
        });

        controller.UpdateView();

        FindButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Student foundStudent = controller.FindStudent(NameTF.getText(), SurnameTF.getText());
                    if (foundStudent == null){
                        throw new NotFoundStudentException("Student not found");
                    }
                    JOptionPane.showMessageDialog(null, foundStudent.getName() + " " + foundStudent.getSurname() + " " + foundStudent.getGPA(), "Student found", JOptionPane.INFORMATION_MESSAGE);
                } catch (EmptyStringException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (NotFoundStudentException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
        frame.setVisible(true);
    }

    public void ShowData(String name, String surname, double GPA){
        AllStudentsLabel.setText("<html>" + AllStudentsLabel.getText() + "<br/>" + name + " " + surname + "--" + GPA);
    }

}