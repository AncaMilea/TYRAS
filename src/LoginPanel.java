import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginPanel extends JPanel
{
    private JLabel loginLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JButton loginB;
    private JPanel mainP;

    public LoginPanel() throws IOException {
        loginLabel = new JLabel("Enter your JPMChase credentials: ");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        userLabel = new JLabel("ID: ");
        passwordLabel = new JLabel("Pass:");
        loginB = new JButton("Login");
        mainP = new JPanel();
        setLogin();
        this.add(mainP);
    }

    public void setLogin() throws IOException {
        mainP.setLayout(new BorderLayout());

        ImageIcon img = new ImageIcon("src/resource/TYRAS-Logo.png");

        JLabel jl= new JLabel(img);
        jl.setIcon(img);


        JPanel title = new JPanel();
        title.setLayout(new FlowLayout());
        title.add(jl);


        JPanel jP = new JPanel();
        jP.setLayout(new GridLayout(6,1));
        jP.add(userLabel);
        jP.add(usernameField);
        jP.add(passwordLabel);
        jP.add(passwordField);

        JPanel button = new JPanel();
        button.add(loginB);
        jP.add(button);

        mainP.add(title,BorderLayout.NORTH);
        mainP.add(jP,BorderLayout.SOUTH);

    }


}

