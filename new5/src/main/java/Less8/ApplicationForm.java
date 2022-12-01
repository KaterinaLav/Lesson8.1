package Less8;

import Less8.Components.DigitJBatton;
import Less8.Components.OperatorJBatton;
import Less8.listeners.ButtonListener;
import Less8.listeners.ClearFieldButtonListener;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {
    private final String appTitle;
    private JTextField inputField;

    public ApplicationForm(String appTitle) {
        super(appTitle);
        this.appTitle = appTitle;
        //      setBounds(1700, 1500, 450, 870); //поменять
        setDefaultCloseOperation(EXIT_ON_CLOSE);  // закрывает приложение
        setAlwaysOnTop(true);  // поверх остальных приложений

        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);

        setJMenuBar(createMenu());

        add(createCenterPanel(), BorderLayout.CENTER);


        //     add(new Button("Копка"), BorderLayout.WEST);

        setVisible(true);
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        ActionListener buttonListener = new ButtonListener(inputField);

        centerPanel.add(createDigitsPanel(buttonListener), BorderLayout.CENTER);
        centerPanel.add(createOperatorsPanel(buttonListener), BorderLayout.WEST);

        return centerPanel;
    }

    private JPanel createTopPanel() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField);

        inputField.setFont(new Font("Arial", Font.PLAIN, 25));
        inputField.setMargin(new Insets(8,0, 8, 0));
        inputField.setBackground(new Color(123,213,59));

        //      inputField.setText("(1+2) / 3 = 12");

        return top;
    }

    private JPanel createDigitsPanel(ActionListener buttonListener) {
        JPanel digitsPanel = new JPanel();

        digitsPanel.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 10; i++){
            String buttonTitle = (i == 9) ? "0" : String.valueOf(i + 1);
            JButton btn = new DigitJBatton(buttonTitle);
            btn.addActionListener(buttonListener); // слушатель кнопок
            digitsPanel.add(btn);
        }

        JButton calc = new OperatorJBatton("=");
        digitsPanel.add(calc);
        calc.setEnabled(false);

        JButton clear = new OperatorJBatton("c");
        clear.addActionListener(new ClearFieldButtonListener(inputField)); // слушатель очистки
        digitsPanel.add(clear);


        return digitsPanel;
    }

    private JPanel createOperatorsPanel(ActionListener buttonListener) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton minus = new OperatorJBatton("-");
        minus.addActionListener(buttonListener);
        panel.add(minus);

        JButton plus = new OperatorJBatton("+");
        plus.addActionListener(buttonListener);
        panel.add(plus);

        JButton multiply = new OperatorJBatton("x");
        multiply.addActionListener(buttonListener);
        panel.add(multiply);

        JButton devide = new OperatorJBatton("/");
        devide.addActionListener(buttonListener);
        panel.add(devide);

        return  panel;
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        JMenuItem clear = new JMenuItem("Clear"); // вынос класса очистки
        clear.addActionListener(new ClearFieldButtonListener(inputField));  //слушатель очистки в меню
        menuFile.add(clear);

        JMenuItem exit = new JMenuItem("Exit");
   /*     exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });*/

        exit.addActionListener(e -> System.exit(0)); // лямбдовырожение (коротко указать слушателя для кнопки)
        menuFile.add(exit);
        menuBar.add(menuFile);

        menuBar.add(new JMenuItem("Help"));
        menuBar.add(new JMenuItem("About"));

        return menuBar;
    }
}
