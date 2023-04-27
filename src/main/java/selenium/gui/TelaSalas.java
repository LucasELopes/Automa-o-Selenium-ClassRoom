package selenium.gui;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class TelaSalas extends JFrame {
    private JPanel header;
    private JPanel main;

    public TelaSalas() {
        setTitle("Salas");
        setSize(920, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setIconImage(new ImageIcon("src/main/java/selenium/gui/img/room/logo.jpg").getImage());
        setFocusable(true);

        header();
        main();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void header() {
        header = new JPanel(new GridBagLayout());
        JLabel textHeader = new JLabel("Salas");

        header.setBackground(Color.decode("#5faad5"));
        header.setBounds(0, 0, 920, 100);
        header.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

        textHeader.setFont(new Font(Font.SERIF, Font.BOLD | Font.ITALIC, 34));
        
        header.add(textHeader);
        add(header);
    }

    private void main() {
        main = new JPanel(new GridBagLayout());

        main.setBounds(0, 100, 920, 500);
        main.setBackground(Color.decode("#ffffff"));
        main.setBorder(BorderFactory.createMatteBorder(0, 4, 4, 4, Color.BLACK));

        add(main);
    }

    public static void main(String[] args) {
        new TelaSalas();
    }
}
