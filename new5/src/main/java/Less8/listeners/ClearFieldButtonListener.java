package Less8.listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearFieldButtonListener implements ActionListener {
    private JTextField inputFild;//принимает текст нажатой кнопки

    public ClearFieldButtonListener(JTextField inputFild) {
        //поле ввода для inputFild
        this.inputFild = inputFild;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //размещает текст введенной кнопки в поле ввода.
        inputFild.setText(" "); // вывод текста в панель. Печать названия текста в панель.

    }
}