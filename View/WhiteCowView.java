package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class WhiteCowView extends JFrame {
    // ปุ่มสำหรับรีดนมและเติมมะนาวเฉพาะวัวสีขาว
    private JButton milkButton = new JButton("Give Me Your Milk!");
    private JButton lemonButton = new JButton("Add More Lemon!");

    // GUI ของวัวสีขาว
    public WhiteCowView() {
        this.setTitle("White Cow");
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(milkButton);
        panel.add(lemonButton);
        this.add(panel);
    }

    public void addMilkButtonListener(ActionListener listener) {
        milkButton.addActionListener(listener);
    }

    public void addLemonButtonListener(ActionListener listener) {
        lemonButton.addActionListener(listener);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
