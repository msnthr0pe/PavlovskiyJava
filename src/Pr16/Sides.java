package Pr16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sides extends JFrame {
    public Sides() throws HeadlessException {
        JFrame frame = new JFrame("The sides");
        setWindow(frame);
        frame.setVisible(true);
    }

    private void setWindow(JFrame frame){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        frame.setLocation(x-200, y-200);
        frame.setSize(500,400);
        frame.setLayout(new BorderLayout());



        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setWidgets(frame);
    }

    private void setWidgets(JFrame frame){
        JLabel label = new JLabel();

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(getWidth(), 70));
        JPanel southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(getWidth(), 70));
        JPanel eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(70, getHeight()));
        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(70, getHeight()));
        JPanel centerPanel = new JPanel();

        centerPanel.add(label);

        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(westPanel, BorderLayout.WEST);
        frame.add(centerPanel, BorderLayout.CENTER);

        northPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                label.setText("Добро пожаловать в САО");
            }
        });

        southPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                label.setText("Добро пожаловать в ЮАО");
            }
        });
        westPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                label.setText("Добро пожаловать в ЗАО");
            }
        });

        eastPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                label.setText("Добро пожаловать в ВАО");
            }
        });

        centerPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                label.setText("Добро пожаловать в ЦАО");
            }
        });
    }

    public static void main(String[] args) {
        new Sides();
    }
}