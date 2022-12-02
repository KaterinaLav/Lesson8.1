package Less8.Components;

import javax.swing.*;
import java.awt.*;

public class DigitJBatton extends JButton {
    //кнопка наследуется от JButton для различных свойств кнопки


    public DigitJBatton(String text){
        super(text); // создание кнопки
        setFont(new Font("TimesRoman", Font.PLAIN, 25)); // шрифт кнопки
        setBackground(new Color(70,159, 231)); //цвет кнопки
    }
}
