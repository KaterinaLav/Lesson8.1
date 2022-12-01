package Less8.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private JTextField inputFild;

    public ButtonListener(JTextField inputFild) {
        this.inputFild = inputFild;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        inputFild.setText(inputFild.getText() + btn.getText());

    }
}
