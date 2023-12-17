package Pr16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Password extends JFrame {

    private Map<String, Map<String, String>> services = new HashMap<>();
    public Password() throws HeadlessException {
        setHashMap();
        JFrame frame = new JFrame("Проверка Пароля");
        setWindow(frame);
        frame.setVisible(true);
    }

    private void setWindow(JFrame frame){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        frame.setLocation(x-200, y-200);
        frame.setSize(450,200);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setWidgets(frame);
    }

    private void setWidgets(JFrame frame){
        frame.add(new JLabel("      Service: "));

        JTextField serviceText = new JTextField();
        serviceText.setPreferredSize(new Dimension(350, 20));
        frame.add(serviceText);

        frame.add(new JLabel("User name: "));

        JTextField nameText = new JTextField();
        nameText.setPreferredSize(new Dimension(350, 20));
        frame.add(nameText);

        frame.add(new JLabel(" Password: "));

        JTextField passwordText = new JTextField();
        passwordText.setPreferredSize(new Dimension(350, 20));
        frame.add(passwordText);

        passwordText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try{
                        String dataPass = services.get(serviceText.getText()).get(nameText.getText());
                        String enteredPass = passwordText.getText();
                        if (dataPass.equals(enteredPass)){
                            JOptionPane.showMessageDialog(null, "Access granted");
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect data");
                        }
                    } catch (Exception f){
                        JOptionPane.showMessageDialog(null, "Incorrect data");
                    }
                }

            }
        });
    }
    public static void main(String[] args) {
        new Password();
    }
    private void setHashMap(){
        Map<String, String> youtubeMap = new HashMap<>();
        youtubeMap.put("youtube", "123");
        Map<String, String> Googlemap = new HashMap<>();
        Googlemap.put("youtube", "123");
        services.put("Youtube", youtubeMap);
        services.put("Google", Googlemap);
    }
}