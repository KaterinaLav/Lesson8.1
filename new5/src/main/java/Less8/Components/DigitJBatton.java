package Less8.Components;

import javax.swing.*;
import java.awt.*;

public class DigitJBatton extends JButton {
    public DigitJBatton(String text){
        super(text);
        setFont(new Font("TimesRoman", Font.PLAIN, 25));
        setBackground(new Color(70,159, 231));
    }
}
