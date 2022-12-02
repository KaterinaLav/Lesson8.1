package Less8.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
// подтягивание интерфейса
    private JTextField inputFild;//принимает текст нажатой кнопки

    public ButtonListener(JTextField inputFild) {
        //поле ввода для inputFild
        this.inputFild = inputFild;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //размещает текст введенной кнопки в поле ввода.
        JButton btn = (JButton) e.getSource(); // e.getSource() - источник события; //перехватывание информации от нажатой кнопки и конвертирование этой информаии в текст
        inputFild.setText(inputFild.getText() + " " + btn.getText()); // вывод текста в панель. Печать названия текста в панель.
        //inputFild.getText() - текущее содержимое кнопки, + пробел + btn.getText() - название кнопки

    }
}
