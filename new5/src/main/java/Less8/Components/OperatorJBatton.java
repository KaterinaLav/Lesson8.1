package Less8.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorJBatton extends JButton {
    //свойства кнопок математиеского действия
    public OperatorJBatton(String text){
        super(text);
        setFont(new Font("TimesRoman", Font.PLAIN, 33));
        setBackground(new Color(66, 146, 164));
    }

}
