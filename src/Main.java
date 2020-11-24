import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

public class Main
{

    public static void main(String[] args) throws InterruptedException
    {
        //MyWindow window = new MyWindow();
        JFrame form = new JFrame("Наша форма");
        form.setSize(700,500);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLocationRelativeTo(null);
        form.setLayout(new BorderLayout());

        JPanel panel = getPanel1();

        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(Color.ORANGE);
        panel2.add(panel);

        JButton btn3 = new JButton("Авторизация");
        btn3.setToolTipText("Открыть форму авторизации (тест)");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //откроем форму регистрации
                openAutorizationForm(form);
            }
        });
        panel2.add(btn3);



        form.add(panel2,BorderLayout.NORTH);

        JPanel panel3 = getPanel3();
        form.add(panel3,BorderLayout.SOUTH);

        JPanel panel5 = getPanel5(form);
        form.add(panel5,BorderLayout.CENTER);

        form.setJMenuBar(getMenuBar());

        form.setVisible(true);
        form.pack();

        JProgressBar progressBar= (JProgressBar) panel.getComponent(4);
        for (int i=progressBar.getMinimum();i<=progressBar.getMaximum();i++) {
            Thread.sleep(100);
            progressBar.setValue(i);
        }

    }

    public static void openAutorizationForm(JFrame parentsForm)
    {
        JFrame form = new JFrame("Окно авторизации");
        form.setSize(300,200);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        form.setLocationRelativeTo(parentsForm);
        form.setLayout(new GridBagLayout());

        JLabel loginLabel = new JLabel("Введите логин:       ");
        JLabel paswordLabel = new JLabel("Введите \"пароль\":");
        JTextField loginField = new JTextField(20);
        JPasswordField paswordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(paswordField.getPassword());

                if (password.equalsIgnoreCase("пароль"))
                    openInformForm("Пароль верный",form);
                else
                    openInformForm("Пароль не верный",form);
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
                                           @Override
                                           public void actionPerformed(ActionEvent e) {
                                               form.dispose();
                                           }
                                       });



        form.add(loginLabel,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(5,1,1,1),0,0));
        form.add(paswordLabel,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
        form.add(loginField,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
        form.add(paswordField,new GridBagConstraints(1,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));

        form.add(loginButton,new GridBagConstraints(0,2,2,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(3,1,1,1),0,0));
        form.add(cancelButton,new GridBagConstraints(0,3,2,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));

        form.setResizable(false);
        form.setVisible(true);
        form.pack();

    }

    public static void openInformForm(String Information,JFrame parentsForm)
    {
        JFrame form = new JFrame();
        form.setSize(250,100);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        form.setLocationRelativeTo(parentsForm);
        form.setLayout(new FlowLayout());

        JLabel label = new JLabel(Information);
        Font font = new Font("Verdana",Font.ITALIC,20);
        label.setFont(font);
        form.add(label);


        form.setResizable(false);
        form.setVisible(true);
        form.pack();

    }

    public static JPanel getPanel5(JFrame parentsForm)
    {
        JPanel panel = new JPanel(new GridBagLayout());


        JRadioButton radio1 = new JRadioButton("Первый переключатель");
        JRadioButton radio2 = new JRadioButton("Второй переключатель");
        radio1.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        panel.add(radio1,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(5,1,1,1),0,0));
        panel.add(radio2,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(5,1,1,1),0,0));



        JCheckBox checkBox = new JCheckBox("Флажек");
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected())
                    panel.setBackground(Color.CYAN);
                else
                    panel.setBackground(Color.WHITE);
            }
        });
        panel.add(checkBox,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(5,1,1,1),0,0));


        TableModel tableModel = new TableModel();
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(100,200));
        setRenderForTable(tableModel, table);

        String[] raw = {"11","222","333","444","555"};

        tableModel.addDate(raw,parentsForm);
        //tableModel.fireTableDataChanged();


        JButton addInTableButton = new JButton("Добавить в таблицу");
        addInTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getaddInTableForm(tableModel,parentsForm,table);

            }
        });
        panel.add(addInTableButton,new GridBagConstraints(0,2,2,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(5,1,1,1),0,0));

        panel.add(scrollPane,new GridBagConstraints(0,3,2,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(5,1,1,1),0,0));

        return panel;
    }

    public static void getaddInTableForm(TableModel tableModel,JFrame parentsForm,JTable table ){
        JFrame form = new JFrame();
        form.setSize(300,100);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        form.setLocationRelativeTo(parentsForm);
        form.setLayout(new FlowLayout());

        JTextField f1 = new JTextField(10);
        JTextField f2 = new JTextField(10);
        JTextField f3 = new JTextField(10);
        JTextField f4 = new JTextField(10);
        JTextField f5 = new JTextField(10);

        form.add(f1);
        form.add(f2);
        form.add(f3);
        form.add(f4);
        form.add(f5);

        JButton addButton = new JButton("Добвить в таблицу");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] raw = {f1.getText(),f2.getText(),f3.getText(),f4.getText(),f5.getText()};

                tableModel.addDate(raw,parentsForm);
                tableModel.fireTableStructureChanged();
                setRenderForTable(tableModel, table);

            }
        });
        form.add(addButton);

        form.setResizable(false);
        form.setVisible(true);
        form.pack();

    }

    public static JPanel getPanel1()
    {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBackground(Color.YELLOW);
        panel.setPreferredSize(new Dimension(300,70));

        JButton btn1 = new JButton("Кнопка 1");
        btn1.setToolTipText("подсказка");
        btn1.setBackground(Color.CYAN);
        Cursor cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
        btn1.setCursor(cursor);
        panel.add(btn1);

        JButton btn2 = new JButton("Кнопка 2");
        btn2.setToolTipText("подсказка2");
        btn2.setForeground(Color.MAGENTA);
        panel.add(btn2);

        JTextField textField =new JTextField(10);
        panel.add(textField);

        JLabel label = new JLabel("Метка");
        Font font = new Font("Verdana",Font.ITALIC,15);
        label.setFont(font);
        panel.add(label);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setStringPainted(true);
        panel.add(progressBar);
        return panel;
    }

    public static JPanel getPanel3()
    {
        JPanel panel = new JPanel(new GridLayout(3,3));
        panel.setBackground(Color.magenta);

        JButton[] Buttons = new JButton[6];
        for (int i=0;i<Buttons.length;i++) {
            Buttons[i] = new JButton("Кнопка "+i);
            panel.add(Buttons[i]);
        }
        return panel;
    }

    public static void setRenderForTable(TableModel tableModel, JTable table){
        for (int i=0; i<tableModel.getColumnCount();i++)
            table.getColumnModel().getColumn(i).setCellRenderer(new Render());
    }

    public static JMenuBar getMenuBar()
    {

        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Меню 1");
        JMenu menu2 = new JMenu("Меню 2");
        JMenu menu3 = new JMenu("Подменю");



        menuBar.add(menu1);
        menuBar.add(menu2);

        JMenuItem menuItem0 = new JMenuItem("Выход");
        JMenuItem menuItem1 = new JMenuItem("Что");
        JMenuItem menuItem2 = new JMenuItem("Где");
        JMenuItem menuItem3 = new JMenuItem("Когда");
        JMenuItem menuItem4 = new JMenuItem("Почему");
        menu1.add(menuItem0);
        menu1.add(menu3);
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu3.add(menuItem3);
        menu3.add(menuItem4);

        menuItem0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem("чекбокс");
        JRadioButtonMenuItem radioButtonMenuItem1 = new JRadioButtonMenuItem("радио 1");
        JRadioButtonMenuItem radioButtonMenuItem2 = new JRadioButtonMenuItem("радио 2");

        ButtonGroup group = new ButtonGroup();
        group.add(radioButtonMenuItem1);
        group.add(radioButtonMenuItem2);

        menu2.add(checkBoxMenuItem);
        menu2.addSeparator();
        menu2.add(radioButtonMenuItem1);
        menu2.add(radioButtonMenuItem2);

          return menuBar;
    }


}