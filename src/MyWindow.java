import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyWindow extends JFrame
{
    MyWindow()
    {
        setVisible(true);
        setLocation(500,500);
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Окошко");


        JPanel panelNorth = new JPanel(new GridLayout(4,4));
        //panelNorth.

        String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
        //JComboBox petList = new JComboBox(petStrings);

        //petList.setSelectedIndex(4);
        //petList.addActionListener(this);

        JRadioButton radio1 = new JRadioButton("Первый переключатель");
        JRadioButton radio2 = new JRadioButton("Второй переключатель");
        radio1.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        panelNorth.add(radio1);
        panelNorth.add(radio2);

        JCheckBox check = new JCheckBox("Check", false);
        panelNorth.add(check);

        add(panelNorth, BorderLayout.NORTH);




        JPanel panelSouth = new JPanel(new GridLayout(3,1));
        JButton bt1 = new JButton("Выход");
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panelSouth.add(bt1);

        JButton bt2 = new JButton("Вторая кнопка");
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //MyWindow window = new MyWindow();
                JOptionPane.showMessageDialog(null,"Нажата вторая кнопка","Предупреждение",JOptionPane.PLAIN_MESSAGE);

            }
        });



        panelSouth.add(bt2);




        panelSouth.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //System.out.println("mouseClicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("mousePressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //System.out.println("mouseReleased");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //System.out.println("mouseEntered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //System.out.println("mouseExited");
            }
        });

        add(panelSouth, BorderLayout.SOUTH);

        //createMenu();
    }

    private void createMenu() {
        JMenuBar menu = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

//        for (String fileItem : new String [] { "New", "Exit" }) {
//            JMenuItem item = new JMenuItem(fileItem);
//            item.setActionCommand(fileItem.toLowerCase());
//            //tem.addActionListener(new NewMenuListener());
//            fileMenu.add(item);
//        }
//        fileMenu.insertSeparator(1);

        menu.add(fileMenu);
        setJMenuBar(menu);
    }

}
