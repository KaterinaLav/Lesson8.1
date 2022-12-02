package Less8;

import Less8.Components.DigitJBatton;
import Less8.Components.OperatorJBatton;
import Less8.listeners.ButtonListener;
import Less8.listeners.ClearFieldButtonListener;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class ApplicationForm extends JFrame {
    // JFrame класс который рисует графику
    private JTextField inputField;
    private BigDecimal result;
    private String lastCommand;
    private boolean start;

    public ApplicationForm(String appTitle) {
        super(appTitle);

        setBounds(170, 150, 250, 370); //поменять, размеры окна относительно крана и его расположение.
        setDefaultCloseOperation(EXIT_ON_CLOSE);  // закрывает приложение
        setAlwaysOnTop(true);  // поверх остальных приложений
        setJMenuBar(createMenu()); // название панели сверху и сама панель
        setLayout(new BorderLayout()); //компановщик для всех элементов, сюда можно добавить кнопки указав их расположение

        add(createTopPanel(), BorderLayout.NORTH); // панель с выводами на севере
        add(createCenterPanel(), BorderLayout.CENTER); // указание расположения кнопки на севере

        setVisible(true); // делает графику видимой

        //     add(new Button("Копка"), BorderLayout.WEST);

    }

    private JPanel createCenterPanel() {
        // центральная панель с кнопками
        ActionListener buttonListener = new ButtonListener(inputField); // подтягивание формы из слушателя кнопки ButtonListener.
        // inputField для отправления панели куда вводятся данные
        JPanel centerPanel = new JPanel();  // создание самой панели

        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(createDigitsPanel(buttonListener), BorderLayout.CENTER); // панель с цифрами
        centerPanel.add(createOperatorsPanel(buttonListener), BorderLayout.WEST); // панель с математическими действиями

        return centerPanel; // возврат панели чтобы прикрепить к JFrame
    }

    private JPanel createOperatorsPanel(ActionListener buttonListener) {
        // панель математических символов
        JPanel panel = new JPanel(); // создание панели
        panel.setLayout(new GridLayout(4, 1)); //размещение в 4 строки 1 столбик

        ActionListener command = new CommandAction();

        JButton minus = new OperatorJBatton("-"); //кнопка -
        minus.addActionListener(command);
        panel.add(minus);

        JButton plus = new OperatorJBatton("+"); //кнопка сложить
        plus.addActionListener(command);
        panel.add(plus);

        JButton multiply = new OperatorJBatton("x"); //кнопка умножить
        multiply.addActionListener(command);
        panel.add(multiply);

        JButton divide = new OperatorJBatton("/"); //кнопка делить
        divide.addActionListener(command);
        panel.add(divide);

        return panel; // возврат панели
    }

    private JPanel createDigitsPanel(ActionListener buttonListener) {
        /*панель цифр*/
        JPanel digitsPanel = new JPanel(); //создание самой панели
        digitsPanel.setLayout(new GridLayout(4, 3)); // количество строк и столбцов

        ActionListener insert = new InsertAction();

        for (int i = 0; i < 10; i++) {
            String buttonTitle = (i == 9) ? "0" : String.valueOf(i + 1);
            JButton btn = new DigitJBatton(buttonTitle); // создание кнопки, пока без значения, наследуем свойства из класса DigitJBatton
            btn.addActionListener(insert); // слушатель кнопок, отображение кнопки на панели, подтягивание свойств из названия кнопки в панель
            digitsPanel.add(btn);
        }

        JButton calc = new OperatorJBatton("="); // кнопка равно с наследование свойств из OperatorJBatton.
        ActionListener command = new CommandAction();
        calc.addActionListener(command);
        digitsPanel.add(calc); //возвращаем кнопку на панель с числами
        //   calc.setEnabled(false); // выключить кнопку равно

        JButton clear = new OperatorJBatton("c"); // кнопка очистить с наследование свойств из OperatorJBatton.
        clear.addActionListener(new ClearFieldButtonListener(inputField)); // слушатель очистки, действие кнопки
        digitsPanel.add(clear); //возвращаем кнопку на панель с числами


        return digitsPanel; //возврат панели с числами
    }

    private JPanel createTopPanel() {
        // панель с выводом данных
        result = BigDecimal.ZERO;
        lastCommand = "=";
        start = true;
        JPanel top = new JPanel(); // создание панели вывода
        top.setLayout(new BorderLayout());
        inputField = new JTextField(); //поле для ввода с названием JTextField
        inputField.setEditable(false); // запрет на изменения
        top.add(inputField); // добавление данных

        inputField.setFont(new Font("Arial", Font.PLAIN, 25)); // выбор шрифта
        inputField.setMargin(new Insets(8, 0, 8, 0)); //отступы снаружи сверху, слева, снизу, справа
        inputField.setBackground(new Color(213, 159, 21)); // цвет заднего фона

        //      inputField.setText("(1+2) / 3 = 12"); ввели для отображения чтобы поле было не пустым

        return top; // возврат панели
    }

    private JMenuBar createMenu() {
        //верхняя панель
        JMenuBar menuBar = new JMenuBar(); //элемент меню

        JMenu menuFile = new JMenu("File"); // создание раздела меню файл
        JMenuItem clear = new JMenuItem("Clear"); // вынос класса очистки в панель меню
        clear.addActionListener(new ClearFieldButtonListener(inputField));  //слушатель очистки в меню, логика работы кнопки
        menuFile.add(clear);

        JMenuItem exit = new JMenuItem("Exit");  //создание раздела меню выход
   /*     exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });*/

        exit.addActionListener(e -> System.exit(0)); // лямбдовырожение (коротко указать слушателя для кнопки)
        menuFile.add(exit);
        menuBar.add(menuFile);

        menuBar.add(new JMenuItem("Help")); // создание пунктов меню в верхней панели
        menuBar.add(new JMenuItem("About")); // создание пунктов меню в верхней панели

        return menuBar; //возврат метода меню
    }

    private class InsertAction implements ActionListener { // слушатель формы вывода информации цифр
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                inputField.setText("");
                start = false;
            }
            inputField.setText(inputField.getText() + input); // выводим текст, пока не получим оператор
        }
    }

    private class CommandAction implements ActionListener { // слушатель формы вывода информации операторов
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            // if (start) {
//                if (command.equals("-")) {
//                    inputField.setText(command);
//                    start = false;
//                } else lastCommand = command;
            //           } else {
            calculate(new BigDecimal(inputField.getText()));
            lastCommand = command;
            start = true;
            //           }
        }
    }

    public void calculate(BigDecimal x) { //математические операции (подсмотрела в интернете)
        if (lastCommand.equals("+")) result = result.add(x);
        else if (lastCommand.equals("-")) result = result.subtract(x);
        else if (lastCommand.equals("*")) result = result.multiply(x);
        else if (lastCommand.equals("/")) result = result.divide(x);
        else if (lastCommand.equals("=")) result = x;
        if (result.compareTo(BigDecimal.ZERO) == 0) {
            result = BigDecimal.ZERO;
        }
        inputField.setText(result.toString());
    }
}