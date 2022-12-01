package Less8.listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearFieldButtonListener implements ActionListener {
    private JTextField inputFild;

    public ClearFieldButtonListener(JTextField inputFild) {
        this.inputFild = inputFild;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        inputFild.setText("");

    }
}
