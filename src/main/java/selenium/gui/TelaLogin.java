package selenium.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import selenium.Login;
import selenium.driver.Driver;

public class TelaLogin extends JFrame implements ActionListener{

    private JTextField inputEmail;
    private JPasswordField inputPassword;
    private JPanel submitField;
    private JButton submit;

    public TelaLogin() {
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 435);
        setLayout(null);
        setIconImage(new ImageIcon("src/main/java/selenium/gui/img/logotipo/logo.png").getImage());
        setTitle("Login");
        setFocusable(true);

        header();
        inputEmailPassword();
        submit();

        setVisible(true);
    }

    private void header() {
        JPanel header = new JPanel(new GridBagLayout());
        ImageIcon imageIcon = new ImageIcon("src/main/java/selenium/gui/img/login/userMain.png");
        JLabel jLabel = new JLabel();

        imageIcon.setImage(imageIcon.getImage().getScaledInstance(160, 140, Image.SCALE_DEFAULT));
        jLabel.setIcon(imageIcon);
        jLabel.setOpaque(false);

        header.setBounds(0, 0, 400, 160);
        header.setBackground(Color.decode("#5faad5"));
        header.add(jLabel);

        add(header);
    }

    private void inputEmailPassword() {
        JPanel inputsField = new JPanel(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        ImageIcon iconLogin = new ImageIcon("src/main/java/selenium/gui/img/login/loginUser.png");
        ImageIcon iconPassword = new ImageIcon("src/main/java/selenium/gui/img/login/loginPass.png");
        JLabel imgUser = new JLabel();
        JLabel imgPassword = new JLabel();
        inputEmail = new JTextField("Usuário");
        inputPassword = new JPasswordField("password");

        inputsField.setBounds(0, 160, 400, 150);
        inputsField.setBackground(Color.decode("#5faad5"));

        cons.gridx = 0;
        cons.insets = new Insets(0, 0, 20, 5);
        cons.ipady = 2;

        iconLogin.setImage(iconLogin.getImage().getScaledInstance(30, 25, Image.SCALE_DEFAULT));
        imgUser.setIcon(iconLogin);
        inputsField.add(imgUser, cons);

        cons.gridx++;
        cons.gridy = 0;
        inputEmail.setPreferredSize(new Dimension(300, 25));
        inputEmail.setBorder(null);
        inputEmail.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        inputEmail.setFont(new Font(Font.SERIF, Font.BOLD | Font.ITALIC, 13));
        inputEmail.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (inputEmail.getText().equals("Usuário")) {
                    inputEmail.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (inputEmail.getText().equals("")) {
                    inputEmail.setText("Usuário");
                }
            }

        });
        inputEmail.addActionListener(this);
        inputsField.add(inputEmail, cons);

        cons.gridx = 0;
        cons.gridy++;
        iconPassword.setImage(iconPassword.getImage().getScaledInstance(35, 25, Image.SCALE_DEFAULT));
        imgPassword.setIcon(iconPassword);
        inputsField.add(imgPassword, cons);

        cons.gridx++;
        inputPassword.setPreferredSize(new Dimension(300, 25));
        inputPassword.setBorder(null);
        inputPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        inputPassword.setFont(new Font(Font.SERIF, Font.BOLD | Font.ITALIC, 13));
        inputPassword.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (new String(inputPassword.getPassword()).equals("password")) {
                    inputPassword.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (new String(inputPassword.getPassword()).equals("")) {
                    inputPassword.setText("password");
                }
            }

        });
        inputPassword.addActionListener(this);
        inputsField.add(inputPassword, cons);
        add(inputsField);
    }

    private void submit() {
        submitField = new JPanel(new GridBagLayout());
        submit = new JButton("Logar");
        GridBagConstraints cons = new GridBagConstraints();

        submitField.setBounds(0, 310, 400, 90);
        submitField.setBackground(Color.decode("#5faad5"));

        submit.setBackground(Color.decode("#ffffff"));
        submit.setForeground(Color.decode("#5faad5"));
        submit.setPreferredSize(new Dimension(100, 30));
        submit.setFont(new Font(Font.SERIF, Font.BOLD | Font.ITALIC, 13));
        submit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cons.insets = new Insets(-50, 0, 0, -200);

        submit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (submit.getBackground().equals(Color.decode("#ffffff"))) {
                    submit.setBackground(Color.decode("#5faad5"));
                    submit.setForeground(Color.decode("#ffffff"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (submit.getBackground().equals(Color.decode("#5faad5"))) {
                    submit.setBackground(Color.decode("#ffffff"));
                    submit.setForeground(Color.decode("#5faad5"));
                }
            }
        });

        submit.addActionListener(this);
        submitField.add(submit, cons);

        add(submitField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            String password = new String(new String(inputPassword.getPassword()));

            if(inputEmail.getText().equals("Usuário") || inputEmail.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Usuário inválido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                inputEmail.setText("Usuário");
                
            }
            else if(password.equals("password") || password.equals("")) {
                JOptionPane.showMessageDialog(this, "Senha inválida", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                inputPassword.setText("password");
            }
            else { 
                if(inputEmail.getText().indexOf("@edu.ufes.br") == -1) {
                    inputEmail.setText(inputEmail.getText() + "@edu.ufes.br");
                }
                try {
                    new Login(inputEmail.getText(), password);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(this, e1.getMessage(), "Login recusado", JOptionPane.ERROR_MESSAGE);
                    inputEmail.setText("Usuário");
                    inputPassword.setText("password");
                    System.out.println(e1.getMessage());
                    new Driver().quit();
                }
            }
        }
    }

    public static void main(String[] args) {
        new TelaLogin();
    }
}
