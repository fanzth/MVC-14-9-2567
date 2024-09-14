package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BrownCowView extends JFrame {
    // ปุ่มสำหรับรีดนมเฉพาะวัวสีน้ำตาล
    private JButton milkButton = new JButton("Give Me Your Milk!");

    public BrownCowView() {
        this.setTitle("Brown Cow");
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(milkButton);
        this.add(panel);
    }

    public void addMilkButtonListener(ActionListener listener) {
        milkButton.addActionListener(listener);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
