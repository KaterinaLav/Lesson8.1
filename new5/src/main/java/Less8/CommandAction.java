package Less8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class CommandAction implements ActionListener {
    private JButton display;
    private BigDecimal result;
    private String lastCommand;
    private boolean start;

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (start) {
            if (command.equals("-")) {
                display.setText(command);
                start = false;
            } else lastCommand = command;
        } else {
            calculate(new BigDecimal(display.getText()));
            lastCommand = command;
            start = true;
        }
    }

    private void calculate(BigDecimal x) {
        if (lastCommand.equals("+")) result = result.add(x);
        else if (lastCommand.equals("-")) result = result.subtract(x);
        else if (lastCommand.equals("*")) result = result.multiply(x);
        else if (lastCommand.equals("/")) result = result.divide(x);
        else if (lastCommand.equals("=")) result = x;
        if (result.compareTo(BigDecimal.ZERO) == 0) {
            result = BigDecimal.ZERO;
        }
        display.setText(result.toString());
    }
}