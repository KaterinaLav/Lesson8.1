package Less8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertAction implements ActionListener {
    private boolean start;
    private JButton display;
    public void actionPerformed(ActionEvent event) {
        String input = event.getActionCommand();
        if (start) {
            display.setText("");
            start = false;
        }
        display.setText(display.getText() + input);
    }
}
