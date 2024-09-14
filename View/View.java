package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JTextField cowIdField = new JTextField(10);
    private JButton submitButton = new JButton("Submit");

    public View() {
        // สร้าง GUI เบื้องต้น
        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 100);

        panel.add(new JLabel("input cow id:"));
        panel.add(cowIdField);
        panel.add(submitButton);

        this.add(panel);
    }

    public String getCowId() {
        return cowIdField.getText();
    }

    // ฟังก์ชันสำหรับการรับฟังการกดปุ่มยืนยัน
    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
